package com.sros.springboot.controller;

import com.sros.springboot.model.Staff;
import com.sros.springboot.services.IStaffService;
import com.sros.springboot.services.impl.StaffServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {

    private IStaffService staffService;

    public StaffController(StaffServiceImpl staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/find-all")
    public ResponseEntity findAll(){
        return new ResponseEntity<>(this.staffService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity findOne(@PathVariable long id){
        return new ResponseEntity<>(this.staffService.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Staff staff){
        return new ResponseEntity<>(this.staffService.create(staff), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id){
        this.staffService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
