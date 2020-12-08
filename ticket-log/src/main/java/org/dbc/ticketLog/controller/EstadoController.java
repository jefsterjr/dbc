package org.dbc.ticketLog.controller;

import org.dbc.ticketLog.controller.service.EstadoService;
import org.dbc.ticketLog.model.dto.EstadoDTO;
import org.dbc.ticketLog.model.dto.EstadoListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "estado")
@RequestMapping("/estado")
public class EstadoController {


    @Autowired
    private EstadoService service;

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> getEstadoById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getEstadoById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EstadoListDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EstadoListDTO>> getAllCustoPopulacional() {
        return new ResponseEntity<>(service.getAllCustoPopulacional(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> save(@RequestBody EstadoDTO estadoDTO) {
        return new ResponseEntity<>(service.save(estadoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
