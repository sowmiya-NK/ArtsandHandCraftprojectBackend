package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedArtWork {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,length = 100)
    @NotEmpty
    @Size(min = 3, message = "title should have at least 3 characters")
    private  String title;

    @Column(nullable = false,length = 100)
    @NotEmpty
    @Size(min = 3, message = "description should have at least 3 characters")
    private  String description;

    @Column(nullable = false,length = 100)
    private  Double price;

    private Integer count=1;


    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private  Order order;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime orderTime;

}
