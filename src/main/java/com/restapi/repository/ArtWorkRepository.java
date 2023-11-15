package com.restapi.repository;

import com.restapi.model.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtWorkRepository  extends JpaRepository<ArtWork,Long> {
}
