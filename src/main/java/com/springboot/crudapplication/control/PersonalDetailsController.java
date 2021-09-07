package com.springboot.crudapplication.control;

import com.springboot.crudapplication.model.Personal;
import com.springboot.crudapplication.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/details/")
public class PersonalDetailsController {

    @Autowired
    public PersonalDetailsService service;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Personal> savePersonal(@Valid @RequestBody Personal request){
        return new ResponseEntity<Personal>(service.save(request), HttpStatus.OK);
    }

    @GetMapping(value = "/getDetails",produces = "application/json")
    public ResponseEntity<Set<Personal>> getPersonal(){
        return  new ResponseEntity<Set<Personal>>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/getDetailsById/{id}",produces = "application/json")
    public ResponseEntity<Personal> getPersonalById(@PathVariable("id") int id){
        return  new ResponseEntity<Personal>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getDetailsByOrderId/{id}",produces = "application/json")
    public ResponseEntity<Personal> getByOrderId(@PathVariable("id") long id){
        return  new ResponseEntity<Personal>(service.findByOrderId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getDetails/{fname}/{addr}",produces = "application/json")
    public ResponseEntity<Personal> getPersonalDetails(@PathVariable("fname") String fname,
                                                    @PathVariable("addr") String addr ){
        return  new ResponseEntity<Personal>(service.getDetails(fname,addr), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletePersonalId/{id}",produces = "application/json")
    public void deletePersonal(@PathVariable("id") int id){
        this.service.deletePersonal(id);
    }


}
