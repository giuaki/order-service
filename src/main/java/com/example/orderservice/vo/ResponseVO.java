package com.example.orderservice.vo;

import com.example.orderservice.entity.Orders;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {
    private Orders orders;
    private Users users;

}
