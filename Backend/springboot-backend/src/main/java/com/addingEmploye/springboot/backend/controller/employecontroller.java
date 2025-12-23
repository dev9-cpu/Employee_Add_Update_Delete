package com.addingEmploye.springboot.backend.controller;

import com.addingEmploye.springboot.backend.exception.ResourceNotFoundException;
import com.addingEmploye.springboot.backend.model.Employemodel;
import com.addingEmploye.springboot.backend.repository.employeereprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
@RestController
@RequestMapping("/api/v1/employee")
public class employecontroller {

    @Autowired
    private employeereprository employeereprository;

    @GetMapping("/allEmployee")
    public List<Employemodel> getAllEmployee() {
        return employeereprository.findAll();
    }

    //build create employee restapi

    @PostMapping("/employeeDetails")
    public Employemodel createEmployee(@RequestBody Employemodel employemodel) {
        return employeereprository.save(employemodel);
    }

    //build get employee by if restapi

    @GetMapping("{id}")
    public ResponseEntity<Employemodel> getEmployeeById(@PathVariable Long id) {
        Employemodel employemodel = employeereprository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not exits with id " + id));

        return ResponseEntity.ok(employemodel);
    }

    //Build update employee Rest API

    @PutMapping("{id}")
    public ResponseEntity<Employemodel> updateEmployee(@PathVariable Long id,@RequestBody Employemodel employeDetails){
        Employemodel employemodel = employeereprository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee Not Found "+ id));

        employemodel.setFirstName(employeDetails.getFirstName());
        employemodel.setLastName(employeDetails.getLastName());
        employemodel.setEmailId(employeDetails.getEmailId());

        employeereprository.save(employemodel);

        return ResponseEntity.ok(employemodel);
    }

    //build delete
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        Employemodel employemodel = employeereprository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("The id is not present "+ id));

        employeereprository.delete(employemodel);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
