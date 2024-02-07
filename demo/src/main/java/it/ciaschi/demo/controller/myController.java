package it.ciaschi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class myController {
    @Autowired


    @GetMapping("/")
    public String getPersona(@RequestParam(value = "name"))

}
