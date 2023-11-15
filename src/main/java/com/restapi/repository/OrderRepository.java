package com.restapi.repository;

import com.restapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT o FROM Order o inner join o.appUser a WHERE a.id=?1")//filter order using userid
    Optional<List<Order>> findUserOrder(Long userId);
}
