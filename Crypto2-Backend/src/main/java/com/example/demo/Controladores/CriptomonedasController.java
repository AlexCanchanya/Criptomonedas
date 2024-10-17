package com.example.demo.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modelos.Criptomonedas;
import com.example.demo.Servicios.CriptomonedasService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class CriptomonedasController {

    @Autowired
    private CriptomonedasService criptomonedasService;

    @GetMapping("/api/criptomonedas")
    public List<Criptomonedas> obtenerCriptomonedas() {
        return criptomonedasService.obtenerCriptomonedas();
    }
}