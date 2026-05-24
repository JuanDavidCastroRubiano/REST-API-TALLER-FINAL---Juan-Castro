package com.aerolinea.aerolineaapi.service;

import com.aerolinea.aerolineaapi.dto.ReservaRequestDTO;
import com.aerolinea.aerolineaapi.dto.ReservaResponseDTO;
import com.aerolinea.aerolineaapi.model.Pasajero;
import com.aerolinea.aerolineaapi.model.Reserva;
import com.aerolinea.aerolineaapi.model.Vuelo;
import com.aerolinea.aerolineaapi.repository.PasajeroRepository;
import com.aerolinea.aerolineaapi.repository.ReservaRepository;
import com.aerolinea.aerolineaapi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository,
                          PasajeroRepository pasajeroRepository,
                          VueloRepository vueloRepository) {

        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }

    // GET TODOS
    public List<ReservaResponseDTO> findAll() {

        return reservaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // GET POR ID
    public ReservaResponseDTO findById(Long id) {

        Reserva reserva = reservaRepository.findById(id).orElse(null);

        if (reserva == null) {
            return null;
        }

        return convertirADTO(reserva);
    }

    // POST
    public ReservaResponseDTO save(ReservaRequestDTO dto) {

        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId())
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));

        Vuelo vuelo = vueloRepository.findById(dto.getVueloId())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        Reserva reserva = new Reserva();

        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setClase(dto.getClase());
        reserva.setPasajero(pasajero);
        reserva.setVuelo(vuelo);

        Reserva reservaGuardada = reservaRepository.save(reserva);

        return convertirADTO(reservaGuardada);
    }

    // PUT
    public ReservaResponseDTO update(Long id, ReservaRequestDTO dto) {

        Reserva reservaExistente = reservaRepository.findById(id).orElse(null);

        if (reservaExistente == null) {
            return null;
        }

        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId())
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));

        Vuelo vuelo = vueloRepository.findById(dto.getVueloId())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        reservaExistente.setFechaReserva(dto.getFechaReserva());
        reservaExistente.setClase(dto.getClase());
        reservaExistente.setPasajero(pasajero);
        reservaExistente.setVuelo(vuelo);

        Reserva reservaActualizada = reservaRepository.save(reservaExistente);

        return convertirADTO(reservaActualizada);
    }

    // DELETE
    public void delete(Long id) {

        reservaRepository.deleteById(id);

    }

    // CONVERTIR ENTIDAD → DTO
    private ReservaResponseDTO convertirADTO(Reserva reserva) {

        ReservaResponseDTO dto = new ReservaResponseDTO();

        dto.setId(reserva.getId());
        dto.setFechaReserva(reserva.getFechaReserva());
        dto.setClase(reserva.getClase());

        dto.setPasajeroId(reserva.getPasajero().getId());

        dto.setPasajeroNombre(
                reserva.getPasajero().getNombre() + " " +
                        reserva.getPasajero().getApellido()
        );

        dto.setVueloId(reserva.getVuelo().getId());

        dto.setVueloOrigen(reserva.getVuelo().getOrigen());
        dto.setVueloDestino(reserva.getVuelo().getDestino());

        return dto;
    }
}