package com.springboot.crudapplication.service.implementation;

import com.springboot.crudapplication.exception.PersonalDetailsNotFoundException;
import com.springboot.crudapplication.model.Personal;
import com.springboot.crudapplication.rabbitmq.model.RabbitMessage;
import com.springboot.crudapplication.rabbitmq.service.Producer;
import com.springboot.crudapplication.repo.DetailsRepository;
import com.springboot.crudapplication.service.PersonalDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class PersonalDetailsServiceImpl implements PersonalDetailsService {
    @Autowired
    private DetailsRepository repo;

    @Autowired
    private Producer producer;

    @Override
    public Personal save(Personal obj) {
        //Send to RabbitMQ before saving to database
        RabbitMessage message = new RabbitMessage("Personal details", obj);
        boolean response = producer.sendToQueue(message);
        log.info("Posted to Queue =",response);
        return this.repo.save(obj);

    }

    @Override
    public Set<Personal> findAll() {
        return new HashSet<>(this.repo.findAll());
    }

    @Override
    public Personal findById(int id) {
        return this.repo.findById(id)
                .orElseThrow(() -> new PersonalDetailsNotFoundException("Details not found"));
    }

    @Override
    public void deletePersonal(int id) {
        this.repo.deleteById(id);
    }

    @Override
    public Personal getDetails(String name, String addr) {
        Personal p = repo.findByFirstnameAndAddress(name,addr);
        System.out.println(p);
        return p;
    }

    @Override
    public Personal findByOrderId(long id) {
        return repo.findByOrderId(id);
    }
}
