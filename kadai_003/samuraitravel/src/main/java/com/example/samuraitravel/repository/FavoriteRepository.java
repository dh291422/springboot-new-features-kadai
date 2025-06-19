package com.example.samuraitravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.samuraitravel.entity.Favorite;
import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.User;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

    @Query("SELECT f FROM Favorite f JOIN FETCH f.house WHERE f.user = :user ORDER BY f.createdAt DESC")
    Page<Favorite> findByUserWithHouse(@Param("user") User user, Pageable pageable);

    Favorite findByHouseAndUser(House house, User user);

	Page<Favorite> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
}
