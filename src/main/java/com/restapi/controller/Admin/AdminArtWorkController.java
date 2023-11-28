package com.restapi.controller.Admin;

import com.restapi.model.ArtWork;
import com.restapi.model.Role;
import com.restapi.request.ArtWorkRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.ArtWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
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
    @GetMapping("/{id}")
    private ResponseEntity<APIResponse> getArtWorksById(@PathVariable Long id){
        ArtWork artWorkList=artWorkService.findById(id);
        apiResponse.setStatus(HttpStatus.OK.value());//200 VALUE SUCCESS
        apiResponse.setData(artWorkList);//set product in api page
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);//return api response
    }



    @PostMapping
    private ResponseEntity<APIResponse> createArtWork(@Valid @RequestBody ArtWorkRequest artWorkRequest){
        List<ArtWork> artWorkList=artWorkService.createArtWork(artWorkRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(artWorkList);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<APIResponse> updateArtWork(@Valid @RequestBody ArtWorkRequest artWorkRequest){
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> createImage(
            @RequestParam("image") MultipartFile image,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("title") String title,
            @RequestParam("description") String description,

            @RequestParam("price") Double price
    ) throws IOException {

        System.out.println("Image: " + image.getOriginalFilename());

        System.out.println("Category ID: " + categoryId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);

//        ArtWork artWork = new ArtWork();
//        artWork.setPrice(price);
//        artWork.setTitle(title);
//        artWork.setDescription(description);
//
//        artWork.setPhoto(image.getBytes());
//
//        List<ArtWork> artWorkList = artWorkService.createArtWork(artWork, categoryId);
//        apiResponse.setStatus(HttpStatus.OK.value());
//        apiResponse.setData(artWorkList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
