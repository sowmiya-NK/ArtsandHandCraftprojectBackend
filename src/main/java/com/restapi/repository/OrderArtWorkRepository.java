package com.restapi.repository;

import com.restapi.model.OrderedArtWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderArtWorkRepository extends JpaRepository<OrderedArtWork,Long> {
}
