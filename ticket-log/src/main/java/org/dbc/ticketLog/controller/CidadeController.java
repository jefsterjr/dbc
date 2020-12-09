package org.dbc.ticketLog.controller;

import org.dbc.ticketLog.controller.service.CidadeService;
import org.dbc.ticketLog.model.dto.CidadeDTO;
import org.dbc.ticketLog.model.dto.CidadeListDTO;
import org.dbc.ticketLog.model.exception.NomeMunicipioException;
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
    public ResponseEntity save(@RequestBody CidadeDTO cidadeDTO) {
        try {
            service.save(cidadeDTO);
        } catch (NomeMunicipioException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity save(@RequestBody List<CidadeDTO> cidadeDTO) {
        try {
            service.save(cidadeDTO);
        } catch (NomeMunicipioException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
