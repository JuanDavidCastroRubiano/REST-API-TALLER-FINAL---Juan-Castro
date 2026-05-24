package com.aerolinea.aerolineaapi.service;

import com.aerolinea.aerolineaapi.model.Pasajero;
import com.aerolinea.aerolineaapi.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    @Autowired
    public PasajeroService(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    // GET TODOS
    public List<Pasajero> findAll() {

        return pasajeroRepository.findAll();

    }

    // GET POR ID
    public Pasajero findById(Long id) {

        return pasajeroRepository.findById(id).orElse(null);

    }

    // POST
    public Pasajero save(Pasajero pasajero) {

        return pasajeroRepository.save(pasajero);

    }

    // PUT
    public Pasajero update(Long id, Pasajero datos) {

        Pasajero pasajeroExistente = findById(id);

        if (pasajeroExistente == null) {
            return null;
        }

        pasajeroExistente.setNombre(datos.getNombre());
        pasajeroExistente.setApellido(datos.getApellido());
        pasajeroExistente.setDocumento(datos.getDocumento());
        pasajeroExistente.setEmail(datos.getEmail());

        return pasajeroRepository.save(pasajeroExistente);
    }

    // DELETE
    public void delete(Long id) {

        pasajeroRepository.deleteById(id);

    }
}