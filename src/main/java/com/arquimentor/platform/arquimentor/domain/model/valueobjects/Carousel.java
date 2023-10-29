package com.arquimentor.platform.arquimentor.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Embeddable
public class Carousel{
    private  List<String> images;

    public Carousel(){ this.images=new ArrayList<>(); }

    public void addImage(String image){
        images.add(image);
    }

    public void deleteImage(String image){
        images.remove(image);
    }

}
