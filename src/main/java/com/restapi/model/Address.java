package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,length = 100)
    private String  street;
    @Column(nullable = false,length = 100)
    private String city;
    @Column(nullable = false,length = 100)
    private String State;
    @Column(nullable = false,length = 100)
    private Integer zipcode;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private  AppUser appUser;

    @OneToOne(mappedBy = "address")
    private  Order order;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
