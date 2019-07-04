package com.formation.app.demo.service;

import com.formation.app.demo.entity.Console;
import com.formation.app.demo.entity.VideoGame;
import com.formation.app.demo.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {

    @Autowired
    VideoGameRepository videoGameRepository;

    @Autowired
    StorageService storageService;

    public List<VideoGame> getAllGames() {
        List<VideoGame> videoGameList = videoGameRepository.findAll();
        return videoGameList;
    }

    public Optional<VideoGame> getSpecificGame(Long id) {
        return videoGameRepository.findById(id);
    }


    public void addGame(String content, String name, float price, int starNumber, MultipartFile file) {
        VideoGame videogameToAdd = new VideoGame();
        videogameToAdd.setConsole(new Console("Default Console"));
        videogameToAdd.setName(name);
        videogameToAdd.setContent(content);
        videogameToAdd.setPrice(price);
        videogameToAdd.setStarNumber(starNumber);

        if(!file.isEmpty()){
            try {
                storageService.store(file);
            } catch (FileAlreadyExistsException e) {
                e.printStackTrace();
            }
            videogameToAdd.setPictureName(file.getOriginalFilename());
        }
        videoGameRepository.save(videogameToAdd);
    }
}
