package com.vsk.aopexample.controllers;




import com.vsk.aopexample.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/process/{taskName}")
    public String processTask(@PathVariable String taskName) {
        return businessService.processTask(taskName);
    }
}

