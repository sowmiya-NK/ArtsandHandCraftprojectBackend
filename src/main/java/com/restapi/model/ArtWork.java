package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class ArtWork {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false,length = 100)
    private  String title;
    @Column(nullable = false,length = 100)
    private  String description;
    @Column(nullable = false,length = 100)
    private  Double price;
    //it not show in table
    @Transient
    private  Integer count;
    //lob for image,lombok
    @Lob
    @Column(name="Image",columnDefinition = "BLOB")
    private  byte[] photo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private  Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "artWork")
    private List<Cart> cartList=new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;




}
