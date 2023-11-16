package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @OneToMany(mappedBy = "order")
    private List<OrderedArtWork> orderedArtWorkList = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private OrderStatus orderStatus;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
