package com.example.twitterbackend.repository;

import com.example.twitterbackend.model.Tweet;
import com.example.twitterbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet,Long> {
    List<Tweet> findAllByIsTweetTrueOrderByCreatedAtDesc();
    List<Tweet> findByReTweetUserContainsOrUser_IdAndIsTweetTrueOrderByCreatedAtDesc(User user,Long userId);
    List<Tweet> findByLikesContainingOrderByCreatedAtDesc(User user);

    @Query("SELECT t FROM Tweet  t JOIN t.likes l where l.user.id=:userId")
    List<Tweet> findByLikesUser_id(Long userId);
}
