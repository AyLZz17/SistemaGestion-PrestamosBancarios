package com.mycompany.Services;

import com.mycompany.model.PrestamoVehicular;
import java.util.Collection;

public interface IPrestamoVehicularService {
    void agregarPrestamoVehicular(PrestamoVehicular prestamoVehicular);
    PrestamoVehicular buscarPorId(int id);
    boolean eliminar(int id);
    Collection<PrestamoVehicular> obtenerPrestamos();
}
