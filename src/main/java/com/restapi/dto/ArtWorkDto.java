package com.restapi.dto;

import com.restapi.model.ArtWork;
import com.restapi.request.ArtWorkRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtWorkDto {

    public ArtWork mapToArtWork(ArtWorkRequest artWorkRequest) {
        ArtWork artWork = new ArtWork();
        if (artWorkRequest.getId() != null) {
            artWork.setId(artWorkRequest.getId());
        }//if id is there its set that id or it create a new id
        artWork.setTitle(artWorkRequest.getTitle());
        artWork.setDescription(artWorkRequest.getDescription());
        artWork.setPrice(artWorkRequest.getPrice());
        artWork.setPhoto(artWorkRequest.getPhoto());
        return artWork;

    }
}
