package com.mycompany.controller;

import com.mycompany.Services.IPrestamoHipotecarioService;
import com.mycompany.Services.ServicioPrestamoHipotecario;
import com.mycompany.model.PrestamoHipotecario;
import java.util.Collection;

public class PrestamoHipotecarioController {
    private final IPrestamoHipotecarioService servicio;
    private PrestamoHipotecario prestamoEncontrado;

    public PrestamoHipotecarioController() {
        this(new ServicioPrestamoHipotecario());
    }

    public PrestamoHipotecarioController(IPrestamoHipotecarioService servicio) {
        this.servicio = servicio;
    }

    public void agregar(PrestamoHipotecario prestamo) {
        servicio.agregarPrestamoHipotecario(prestamo);
    }

    public PrestamoHipotecario buscar(int id) {
        return servicio.buscarPorId(id);
    }

    public PrestamoHipotecario buscarParaEliminar(int id) {
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

    public Collection<PrestamoHipotecario> listar() {
        return servicio.obtenerPrestamos();
    }

    public double calcularCuota(int id) {
        PrestamoHipotecario prestamo = buscar(id);
        if (prestamo == null) {
            throw new IllegalArgumentException("Préstamo hipotecario no encontrado/registrado");
        }
        return prestamo.calcularCuotaMensual();
    }
}
