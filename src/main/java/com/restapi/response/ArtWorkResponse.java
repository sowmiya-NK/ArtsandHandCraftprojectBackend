package com.restapi.response;

import com.restapi.model.ArtWork;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArtWorkResponse {
    private List<ArtWork> artWorkList;
}
