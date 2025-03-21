package com.backend.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.application.entities.InstrumentQuote;
import com.backend.application.services.InstrumentQuoteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/instrumentquote")
public class InstrumentQuoteController {

    private final InstrumentQuoteService instrumentQuoteService;


    @GetMapping("/")
    public ResponseEntity<List<InstrumentQuote>> getAll() {
        return ResponseEntity.ok().body(instrumentQuoteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrumentQuote> getById(@PathVariable Long id) {
        Optional<InstrumentQuote> optIO = instrumentQuoteService.getById(id);

        if(optIO.isPresent()){
            return ResponseEntity.ok().body(optIO.get());
        }

        return ResponseEntity.notFound().build();
        
    }
    
}
