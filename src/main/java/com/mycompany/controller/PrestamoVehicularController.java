package com.mycompany.controller;

import com.mycompany.Services.IPrestamoVehicularService;
import com.mycompany.Services.ServicioPrestamoVehicular;
import com.mycompany.model.PrestamoVehicular;
import java.util.Collection;

public class PrestamoVehicularController {
    private final IPrestamoVehicularService servicio;
    private PrestamoVehicular prestamoEncontrado;

    public PrestamoVehicularController() {
        this(new ServicioPrestamoVehicular());
    }

    public PrestamoVehicularController(IPrestamoVehicularService servicio) {
        this.servicio = servicio;
    }

    public void agregar(PrestamoVehicular prestamo) {
        servicio.agregarPrestamoVehicular(prestamo);
    }

    public PrestamoVehicular buscar(int id) {
        return servicio.buscarPorId(id);
    }

    public PrestamoVehicular buscarParaEliminar(int id) {
        prestamoEncontrado = buscar(id);
        return prestamoEncontrado;
    }

    public boolean eliminarSeleccionado() {
        if (prestamoEncontrado == null) {
            return false;
        }
        boolean eliminado = servicio.eliminar(prestamoEncontrado.getIdPrestamo());
        prestamoEncontrado = null;
        return eliminado;
    }

    public Collection<PrestamoVehicular> listar() {
        return servicio.obtenerPrestamos();
    }

    public double calcularCuota(int id) {
        PrestamoVehicular prestamo = buscar(id);
        if (prestamo == null) {
            throw new IllegalArgumentException("Préstamo vehicular no encontrado/registrado");
        }
        return prestamo.calcularCuotaMensual();
    }
}
