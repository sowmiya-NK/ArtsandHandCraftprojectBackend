package com.restapi.controller;

import com.restapi.model.ArtWork;
import com.restapi.model.Role;
import com.restapi.response.common.APIResponse;
import com.restapi.service.ArtWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/artWork")
public class ArtWorkController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private ArtWorkService artWorkService;

    @GetMapping("/all")
    private ResponseEntity<APIResponse> getAllArtWork() {
        List<ArtWork> artWorkList = artWorkService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(artWorkList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @GetMapping("{id}")
    private ResponseEntity<APIResponse> getProductById(@PathVariable Long id) {

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(artWorkService.findProductId(id));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }


}
