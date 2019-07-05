package com.formation.app.demo.rest;

import com.formation.app.demo.entity.VideoGame;
import com.formation.app.demo.service.StorageService;
import com.formation.app.demo.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videogame")
public class RestVideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @Autowired
    private StorageService storageService;


    @GetMapping
    @ResponseBody
    public List<VideoGame> getAllVideosGames() {
        return videoGameService.getAllGames();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getVideoGameById(@PathVariable("id") Long id) {
        VideoGame videoGameToReturn = videoGameService.getSpecificGame(id).orElse(null);

        if (videoGameToReturn != null) {
            return ResponseEntity.ok(videoGameToReturn);
        } else {
            //TODO
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value = "/{id}/picture")
    public ResponseEntity getPicture(@PathVariable("id") Long id) {
        VideoGame videoGameToReturn = videoGameService.getSpecificGame(id).orElse(null);
        String pictureName = videoGameToReturn.getPictureName();
        Resource picture =  storageService.loadAsResource(pictureName);

        return ResponseEntity.ok(picture);
    }


}
