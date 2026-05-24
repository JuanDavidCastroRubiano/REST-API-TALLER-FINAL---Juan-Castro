package com.aerolinea.aerolineaapi.dto;

import com.aerolinea.aerolineaapi.model.ClaseAsiento;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReservaRequestDTO {

    @NotNull(message = "La fecha de reserva es obligatoria")
    private LocalDateTime fechaReserva;

    @NotNull(message = "La clase es obligatoria")
    private ClaseAsiento clase;

    @NotNull(message = "El pasajeroId es obligatorio")
    private Long pasajeroId;

    @NotNull(message = "El vueloId es obligatorio")
    private Long vueloId;

    // CONSTRUCTOR VACÍO
    public ReservaRequestDTO() {
    }

    // GETTERS Y SETTERS

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public ClaseAsiento getClase() {
        return clase;
    }

    public void setClase(ClaseAsiento clase) {
        this.clase = clase;
    }

    public Long getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Long pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }
}