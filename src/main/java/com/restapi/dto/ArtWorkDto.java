package com.restapi.dto;

import com.restapi.model.ArtWork;
import com.restapi.request.ArtWorkRequest;
import com.restapi.response.ArtWorkResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArtWorkDto {

    public static List<ArtWorkResponse> mapToProduct(List<ArtWork> artWorks) {
        List<ArtWorkResponse> artWorkResponses=new ArrayList<>();
        for(ArtWork artWork:artWorks){
            ArtWorkResponse artWorkResponse=new ArtWorkResponse();

            artWorkResponse.setId(artWork.getId());
            artWorkResponses.add(artWorkResponse);
        }
        return  artWorkResponses;

    }

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
