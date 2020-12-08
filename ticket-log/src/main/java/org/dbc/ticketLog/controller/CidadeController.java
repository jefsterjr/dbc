package org.dbc.ticketLog.controller;

import org.dbc.ticketLog.controller.service.CidadeService;
import org.dbc.ticketLog.model.dto.CidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "cidade")
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> getCidadeById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getCidadeById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CidadeDTO>> getAll(@RequestParam(required = false) String nome, @RequestParam(required = false) Long idEstado) {
        return new ResponseEntity<>(service.getAll(nome, idEstado), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CidadeDTO> save(@RequestBody CidadeDTO cidadeDTO) {
        return new ResponseEntity<CidadeDTO>(service.save(cidadeDTO), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<CidadeDTO> save(@RequestBody List<CidadeDTO> cidadeDTO) {
        service.save(cidadeDTO);
        return new ResponseEntity<CidadeDTO>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
