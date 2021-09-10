package com.springboot.crudapplication.service.implementation;

import com.springboot.crudapplication.exception.OrderNotFoundException;
import com.springboot.crudapplication.model.Order;
import com.springboot.crudapplication.model.Personal;
import com.springboot.crudapplication.repo.OrderRepository;
import com.springboot.crudapplication.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repo;

    @Value("${service.url}")
    private String url;

    @Override
    public Order save(Order obj) {
        return this.repo.save(obj);
    }

    @Override
    public Set<Order> findAll() {
        return new HashSet<>(this.repo.findAll());
    }

    @Override
    public Order findById(Long id) {
        return this.repo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }

    @Override
    public void deleteOrder(Long id) {
        this.repo.deleteById(id);
    }

    @Override
    public String findUser(Long id) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("abc","abc");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String requestUrl = url.concat(Long.toString(id));
        System.out.println("url "+requestUrl);
        ResponseEntity<String> details =
                rest.exchange(requestUrl, HttpMethod.GET,entity,String.class);
        System.out.println("details "+details);
        return details.getBody();
    }

}
