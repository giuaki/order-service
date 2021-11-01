package com.example.orderservice.controller;

import com.example.orderservice.entity.Orders;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.vo.ResponseVO;
import com.example.orderservice.vo.Users;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping
    public List<Orders> getAll(){
        return  orderRepository.findAll();
    }

    @GetMapping("/{id}")
    @Retry(name = "basic",fallbackMethod = "getFallBackOrders")
    @RateLimiter(name = "basic")
    public ResponseVO getById(@PathVariable long id){
        Orders o= orderRepository.findById(id).get();
        Users u= restTemplate.getForObject("/"+o.getUserid(), Users.class);

        return new ResponseVO(o,u) ;
    }
    public ResponseVO getFallBackOrders(long id, RuntimeException runtimeException){
        Orders o= orderRepository.findById(id).get();
        ResponseVO v= new ResponseVO();
        v.setOrders(o);
        return  v;
    }
    @PostMapping
    public  Orders add(@RequestBody Orders orders){
        return orderRepository.save(orders);
    }
}
