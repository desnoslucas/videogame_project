package com.formation.app.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
public class VideoGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private float price;

    private String content;

    private String pictureName;

    @Min(value = 0)
    @Max(value = 5)
    private int starNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "console_fk")
    private Console console;

    public VideoGame() {
    }

    public VideoGame(String name, float price, String content, int starNumber, Console console, String pictureName) {
        this.name = name;
        this.price = price;
        this.content = content;
        this.starNumber = starNumber;
        this.console = console;
        this.pictureName = pictureName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public int getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(int starNumber) {
        this.starNumber = starNumber;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
}
