package com.example.demo.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Modelos.Criptomonedas;
import com.example.demo.Repositorio.CriptomonedasRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CriptomonedasService {

    @Autowired
    private CriptomonedasRepository criptomonedasRepository;

    private final String API_URL = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd"; 

    public List<Criptomonedas> obtenerCriptomonedas() {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object>[] respuestaApi = restTemplate.getForObject(API_URL, Map[].class);

        List<Criptomonedas> criptomonedasList = new ArrayList<>();

        if (respuestaApi != null) {
            for (Map<String, Object> response : respuestaApi) {
                String simbolo = (String) response.get("symbol");
                
                Optional<Criptomonedas> cryptoExistente = criptomonedasRepository.findBySimbolo(simbolo);

                if (cryptoExistente.isPresent()) {
                    Criptomonedas existente = cryptoExistente.get();
                    existente.setPrecio_actual(BigDecimal.valueOf(Double.parseDouble(response.get("current_price").toString()))); 
                    existente.setCapitalizacion_de_mercado(BigDecimal.valueOf(Double.parseDouble(response.get("market_cap").toString()))); 
                    existente.setCirculacion_actual(BigDecimal.valueOf(Double.parseDouble(response.get("circulating_supply").toString()))); 
                    
                    criptomonedasRepository.save(existente);
                    
                    criptomonedasList.add(existente);
                } else {
                    Criptomonedas nuevaCripto = new Criptomonedas();
                    nuevaCripto.setNombre((String) response.get("name"));
                    nuevaCripto.setSimbolo(simbolo);
                    nuevaCripto.setPrecio_actual(BigDecimal.valueOf(Double.parseDouble(response.get("current_price").toString()))); 
                    nuevaCripto.setCapitalizacion_de_mercado(BigDecimal.valueOf(Double.parseDouble(response.get("market_cap").toString()))); 
                    nuevaCripto.setCirculacion_actual(BigDecimal.valueOf(Double.parseDouble(response.get("circulating_supply").toString()))); 
                    
                    criptomonedasRepository.save(nuevaCripto);
                    
                    criptomonedasList.add(nuevaCripto);
                }
            }
        }

        return criptomonedasList; 
    }
}







