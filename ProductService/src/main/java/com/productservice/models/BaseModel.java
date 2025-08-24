package com.productservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.stereotype.Component;

@MappedSuperclass
@Component
public class BaseModel {
    @Id
    Long id;
}
