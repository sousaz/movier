package com.desafio.backend.services;

import com.desafio.backend.Observers.WatchlistObserver;
import com.desafio.backend.dto.ReviewCreationRequestDTO;
import com.desafio.backend.dto.ReviewCreationResponseDTO;
import com.desafio.backend.dto.mapper.ReviewCreationMapper;
import com.desafio.backend.entities.Reviews;
import com.desafio.backend.entities.Users;
import com.desafio.backend.entities.Watchlist;
import com.desafio.backend.interfaces.Subject;
import com.desafio.backend.repositories.ReviewsRepository;
import com.desafio.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.lang.Long;

@Service
public class ReviewService implements Subject {
    private final ReviewsRepository reviewRepository;
    private final UserService userService;
    private final ReviewCreationMapper reviewMapper;
    private final WatchlistService watchlistService;
    private final ApplicationContext applicationContext;

    public ReviewService(ReviewsRepository reviewRepository, ReviewCreationMapper reviewCreationMapper, UserService userService, @Lazy WatchlistService watchlistService, ApplicationContext applicationContext){
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewCreationMapper;
        this.userService = userService;
        this.watchlistService = watchlistService;
        this.applicationContext = applicationContext;
    }

    public ReviewCreationResponseDTO createReview(ReviewCreationRequestDTO review){
        System.out.println(review.userId());
        Users user = this.userService.findById(review.userId());
        System.out.println(user);
        Reviews foundReview = this.reviewRepository.findByMovieIdAndUserId(review.movieId(), user.getId());
        Reviews newReview = this.reviewMapper.toEntity(review, user);
        if(foundReview != null){
            foundReview.setRating(newReview.getRating());
            foundReview.setText(newReview.getText());
            foundReview.setWatchedAt(newReview.getWatchedAt());
            foundReview.setMovieId(newReview.getMovieId());
            foundReview.setRating(newReview.getRating());
            foundReview.setUser(user);
            foundReview.setPoster_Path(newReview.getPoster_Path());
            foundReview.setRelease_date(newReview.getRelease_date());
            return reviewMapper.toDTO(reviewRepository.save(foundReview));
        }
        return reviewMapper.toDTO(reviewRepository.save(newReview));
    }

    public List<Reviews> listAllReviews(){
        return reviewRepository.findAll();
    }

    public List<ReviewCreationResponseDTO> listAllReviewsByMovieId(Long movieId){
        List<ReviewCreationResponseDTO> reviews = reviewMapper.toDTOs(reviewRepository.findByMovieId(movieId));
        if(reviews.isEmpty())
            return null;
        return reviews;
    }

    public List<Reviews> watchedMovies(Long userId){
        return reviewRepository.findByUserIdAndWatchedAtIsNotNull(userId);
    }

    public ReviewCreationResponseDTO updateRating(Long userId, Long movieId, Double rating){
        Users user = userService.findById(userId);
        Reviews foundReview = reviewRepository.findByMovieIdAndUserId(movieId, user.getId());
        if(foundReview != null){
            foundReview.setRating(rating);
            return reviewMapper.toDTO(reviewRepository.save(foundReview));
        }
        return null;
    }


    public double calculateAverageRating(Long movieId) {
        List<Reviews> reviews = reviewRepository.findByMovieId(movieId);
        return reviews.stream().mapToDouble(Reviews::getRating).average().orElse(0.0);
    }

    @Override
    public void notifyAll(Long movieId) {
        List<Watchlist> watchlists = watchlistService.findWatchlistByMovieId(movieId);
        watchlists.forEach(watchlist -> {
            WatchlistObserver wl = applicationContext.getBean(WatchlistObserver.class);
            wl.setUser(watchlist.getUser());
            wl.setTitle(watchlist.getTitle());
            wl.update(wl);
        });
    }

    public Reviews findByMovieIdAndUserId(Long movieId, Long userId){
        return reviewRepository.findByMovieIdAndUserId(movieId, userId);
    }
}
