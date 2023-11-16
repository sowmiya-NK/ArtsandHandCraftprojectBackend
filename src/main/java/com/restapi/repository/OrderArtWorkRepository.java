package com.restapi.repository;

import com.restapi.model.OrderedArtWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderArtWorkRepository extends JpaRepository<OrderedArtWork, Long> {
    //@Query("SELECT oaw FROM OrderedArtWork oaw WHERE oaw.Id = :Id")
    List<OrderedArtWork> findByOrderId(Long orderId);

}
