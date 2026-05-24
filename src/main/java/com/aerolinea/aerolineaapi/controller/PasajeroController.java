package com.aerolinea.aerolineaapi.controller;

import com.aerolinea.aerolineaapi.model.Pasajero;
import com.aerolinea.aerolineaapi.service.PasajeroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    @Autowired
    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    // GET TODOS
    @GetMapping
    public ResponseEntity<List<Pasajero>> obtenerTodos() {

        return ResponseEntity.ok(pasajeroService.findAll());

    }

    // GET POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> obtenerPorId(@PathVariable Long id) {

        Pasajero pasajero = pasajeroService.findById(id);

        if (pasajero == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pasajero);
    }

    // POST
    @PostMapping
    public ResponseEntity<Pasajero> crearPasajero(@Valid @RequestBody Pasajero pasajero) {

        Pasajero nuevoPasajero = pasajeroService.save(pasajero);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoPasajero);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> actualizarPasajero(@PathVariable Long id,
                                                       @Valid @RequestBody Pasajero datos) {

        Pasajero pasajeroActualizado = pasajeroService.update(id, datos);

        if (pasajeroActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pasajeroActualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPasajero(@PathVariable Long id) {

        pasajeroService.delete(id);

        return ResponseEntity.noContent().build();
    }
}