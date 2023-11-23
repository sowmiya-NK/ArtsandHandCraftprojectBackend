package com.restapi.service;

import com.restapi.dto.ArtWorkDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.ArtWork;
import com.restapi.model.Category;
import com.restapi.repository.ArtWorkRepository;
import com.restapi.repository.CategoryRepository;
import com.restapi.request.ArtWorkRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ArtWorkService {
    @Autowired
    private ArtWorkRepository artWorkRepository;
    @Autowired
    private ArtWorkDto artWorkDto;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<ArtWork> findAll() {
        return artWorkRepository.findAll();
    }

    @Transactional
    public List<ArtWork> createArtWork(ArtWorkRequest artWorkRequest) {
        ArtWork artWork = artWorkDto.mapToArtWork(artWorkRequest);
        Category category = categoryRepository.findById(artWorkRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId", "CateoryId", artWorkRequest.getCategoryId()));
        artWork.setCategory(category);//it is foreign key to set category id
        artWorkRepository.save(artWork);
        return findAll();
    }

    @Transactional
    public List<ArtWork> updateArtWork(ArtWorkRequest artWorkRequest) {
        ArtWork artWork = artWorkDto.mapToArtWork(artWorkRequest);
        Category category = categoryRepository.findById(artWorkRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId", "CateoryId0", artWorkRequest.getCategoryId()));
        artWork.setCategory(category);//it is foreign key to set category id
        artWorkRepository.save(artWork);
        return findAll();
    }

    public List<ArtWork> deleteById(Integer id) {
        artWorkRepository.deleteById(Long.valueOf(id));
        return findAll();
    }
}
