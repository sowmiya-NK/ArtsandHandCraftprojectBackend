package com.restapi.response;

import com.restapi.model.ArtWork;
import com.restapi.request.ArtWorkRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class ArtWorkResponse {
    private List<ArtWorkRequest> artWorkList;
    private  Long id;


}
