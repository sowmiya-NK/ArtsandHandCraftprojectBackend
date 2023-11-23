package com.restapi.repository;

import com.restapi.model.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtWorkRepository  extends JpaRepository<ArtWork,Long> {
    @Query("SELECT a FROM ArtWork a  WHERE a.id=?1")

    Optional<List<ArtWork>> findProductById(Long id);
}
