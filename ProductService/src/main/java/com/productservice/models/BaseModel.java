package com.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GenericGenerator(name = "generator_name", strategy = "uuid2")
//    @Column(name = "id", columnDefinition = "binary(16", nullable = false, updatable = false)
    @Id
    Long id;
}
