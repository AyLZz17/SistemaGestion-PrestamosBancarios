package com.mycompany.Services;

import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

import com.mycompany.model.PrestamoHipotecario;

/**
 *
 * @author AyLZz
 */
public class ServicioPrestamoHipotecario {

    private final Map<Integer, PrestamoHipotecario> prestamosHipotecarios = new LinkedHashMap<>();

   
    public void agregarPrestamoHipotecario(PrestamoHipotecario prestamoHipotecario) {

        if (prestamosHipotecarios.containsKey(prestamoHipotecario.getIdPrestamo())) {
            throw new IllegalArgumentException("El ID ya existe");
        }

        prestamosHipotecarios.put(
            prestamoHipotecario.getIdPrestamo(),
            prestamoHipotecario
        );
    }

  
    public PrestamoHipotecario buscarPorId(int id) {
        return prestamosHipotecarios.get(id);
    }

  
    public boolean eliminar(int id) {
        return prestamosHipotecarios.remove(id) != null;
    }

    
    public Collection<PrestamoHipotecario> obtenerPrestamos() {
        return Collections.unmodifiableCollection(
            prestamosHipotecarios.values()
        );
    }
}
