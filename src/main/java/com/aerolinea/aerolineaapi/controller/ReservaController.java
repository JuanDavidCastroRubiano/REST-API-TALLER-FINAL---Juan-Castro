package com.aerolinea.aerolineaapi.controller;

import com.aerolinea.aerolineaapi.dto.ReservaRequestDTO;
import com.aerolinea.aerolineaapi.dto.ReservaResponseDTO;
import com.aerolinea.aerolineaapi.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // GET TODOS
    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> obtenerTodas() {

        return ResponseEntity.ok(reservaService.findAll());

    }

    // GET POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerPorId(@PathVariable Long id) {

        ReservaResponseDTO reserva = reservaService.findById(id);

        if (reserva == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reserva);
    }

    // POST
    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crearReserva(
            @Valid @RequestBody ReservaRequestDTO dto) {

        ReservaResponseDTO nuevaReserva = reservaService.save(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaReserva);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> actualizarReserva(
            @PathVariable Long id,
            @Valid @RequestBody ReservaRequestDTO dto) {

        ReservaResponseDTO reservaActualizada =
                reservaService.update(id, dto);

        if (reservaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reservaActualizada);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {

        reservaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}