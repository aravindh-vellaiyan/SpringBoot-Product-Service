package com.productservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@MappedSuperclass
@Component
@Getter
@Setter
public class BaseModel {
    @Id
    Long id;
}
