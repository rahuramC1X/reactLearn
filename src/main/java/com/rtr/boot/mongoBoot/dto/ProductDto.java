package com.rtr.boot.mongoBoot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDto {

    @Id
    private String id;
    private String name;
    private int qty;
    private double price ;

}
