package com.aerolinea.aerolineaapi.service;

import com.aerolinea.aerolineaapi.model.Vuelo;
import com.aerolinea.aerolineaapi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    // GET TODOS
    public List<Vuelo> findAll() {

        return vueloRepository.findAll();

    }

    // GET POR ID
    public Vuelo findById(Long id) {

        return vueloRepository.findById(id).orElse(null);

    }

    // POST
    public Vuelo save(Vuelo vuelo) {

        return vueloRepository.save(vuelo);

    }

    // PUT
    public Vuelo update(Long id, Vuelo datos) {

        Vuelo vueloExistente = findById(id);

        if (vueloExistente == null) {
            return null;
        }

        vueloExistente.setOrigen(datos.getOrigen());
        vueloExistente.setDestino(datos.getDestino());
        vueloExistente.setFechaHora(datos.getFechaHora());
        vueloExistente.setEstado(datos.getEstado());

        return vueloRepository.save(vueloExistente);
    }

    // DELETE
    public void delete(Long id) {

        vueloRepository.deleteById(id);

    }
}