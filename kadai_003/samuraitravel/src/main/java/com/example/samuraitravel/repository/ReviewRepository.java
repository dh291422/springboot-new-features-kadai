package com.example.samuraitravel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.entity.User;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    // 指定されたHouseに紐づく最新の6件のレビューを取得
    List<Review> findTop6ByHouseOrderByCreatedAtDesc(House house);

    // 指定されたHouseとUserに該当するレビューを取得
    Review findByHouseAndUser(House house, User user);

    // 指定されたHouseに紐づくレビュー数をカウント
    long countByHouse(House house);

    // 指定されたHouseに紐づくレビューを作成日時の降順でページネーション付きで取得
    Page<Review> findByHouseOrderByCreatedAtDesc(House house, Pageable pageable);
}
