package com.formation.app.demo.repository;

import com.formation.app.demo.entity.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

    @Query("select v from VideoGame v where v.name=:name ")
    VideoGame deleteByName (String name);

}
