package com.restapi.controller.Admin;

import com.restapi.model.ArtWork;
import com.restapi.model.Role;
import com.restapi.request.ArtWorkRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.ArtWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/artWork")
@RolesAllowed(Role.ADMIN)
public class AdminArtWorkController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private ArtWorkService artWorkService;

    //display all product
    //responseEntity<APIResponse>-->generice class ,create entire http response
    @GetMapping("/all")
    private ResponseEntity<APIResponse> getAllArtWorks(){
        List<ArtWork> artWorkList=artWorkService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());//200 VALUE SUCCESS
        apiResponse.setData(artWorkList);//set product in api page
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);//return api response
    }

    @PostMapping
    private ResponseEntity<APIResponse> createArtWork(@RequestBody ArtWorkRequest artWorkRequest){
        List<ArtWork> artWorkList=artWorkService.createArtWork(artWorkRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(artWorkList);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<APIResponse> updateArtWork(@RequestBody ArtWorkRequest artWorkRequest){
        List<ArtWork> artWorkList=artWorkService.updateArtWork(artWorkRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(artWorkList);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<APIResponse> deleteArtWorks(@PathVariable Integer id){
        List<ArtWork> artWorkList=artWorkService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(artWorkList);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);

    }



}
