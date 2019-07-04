package com.formation.app.demo.service;

import com.formation.app.demo.StorageFileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {


    private static final String ROOT_FOLDER = "uploads";

    public void store(MultipartFile file) throws FileAlreadyExistsException {
        if(!file.isEmpty()){
            try {
                Path savedPath = getStoragePath(file.getOriginalFilename());
                Files.copy(file.getInputStream(), savedPath);
            } catch (IOException e) {
                e.printStackTrace();
                throw new FileAlreadyExistsException("Le fichier " + file.getOriginalFilename() + " existe déjà.");
            }
        }
    }



    private Path getStoragePath(String fileName) {
        File f = new File(ROOT_FOLDER);
        if (!f.exists()){
            f.mkdir();
        }

        // Deuxieme maniere de faire
//        try {
//            Files.createDirectory(Paths.get(ROOT_FOLDER));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return Paths.get(ROOT_FOLDER, fileName);
    }

    public Path load(String filename) {
        return Paths.get(ROOT_FOLDER).resolve(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);
            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

}
