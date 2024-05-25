package com.desafio.backend.repositories;

import com.desafio.backend.entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, UUID> {
}
