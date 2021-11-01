package com.example.orderservice.vo;

import lombok.*;



@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private long id;
    private String name;
    private String password;
}
