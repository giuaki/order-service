package com.example.orderservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int amount;
    private double price;
    private long userid;

}
