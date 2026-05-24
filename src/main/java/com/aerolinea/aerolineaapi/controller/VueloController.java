package com.aerolinea.aerolineaapi.controller;

import com.aerolinea.aerolineaapi.model.Vuelo;
import com.aerolinea.aerolineaapi.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    // GET TODOS
    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerTodos() {

        return ResponseEntity.ok(vueloService.findAll());

    }

    // GET POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerPorId(@PathVariable Long id) {

        Vuelo vuelo = vueloService.findById(id);

        if (vuelo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vuelo);
    }

    // POST
    @PostMapping
    public ResponseEntity<Vuelo> crearVuelo(@Valid @RequestBody Vuelo vuelo) {

        Vuelo nuevoVuelo = vueloService.save(vuelo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoVuelo);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizarVuelo(@PathVariable Long id,
                                                 @Valid @RequestBody Vuelo datos) {

        Vuelo vueloActualizado = vueloService.update(id, datos);

        if (vueloActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vueloActualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVuelo(@PathVariable Long id) {

        vueloService.delete(id);

        return ResponseEntity.noContent().build();
    }
}