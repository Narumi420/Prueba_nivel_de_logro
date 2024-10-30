package com.Cabrera.PNL.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/denuncias")
    public String denuncias() {
        return "denuncias";
    }
    
}
