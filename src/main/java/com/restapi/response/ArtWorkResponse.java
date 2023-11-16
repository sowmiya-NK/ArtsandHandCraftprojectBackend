package com.restapi.response;

import com.restapi.model.ArtWork;
import com.restapi.request.ArtWorkRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArtWorkResponse {
    private List<ArtWorkRequest> artWorkList;
}
