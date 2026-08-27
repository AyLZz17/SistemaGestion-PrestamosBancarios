package com.mycompany.Services;

import com.mycompany.model.PrestamoHipotecario;
import java.util.Collection;

public interface IPrestamoHipotecarioService {
    void agregarPrestamoHipotecario(PrestamoHipotecario prestamoHipotecario);
    PrestamoHipotecario buscarPorId(int id);
    boolean eliminar(int id);
    Collection<PrestamoHipotecario> obtenerPrestamos();
}
