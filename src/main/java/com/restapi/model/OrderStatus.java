package com.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,length = 100)
    @NotEmpty
    private  String status;

    @OneToMany(mappedBy = "orderStatus")
    private List<Order> orderList;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public OrderStatus(String status) {
        this.status = status;
    }
}
