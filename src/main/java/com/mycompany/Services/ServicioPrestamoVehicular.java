/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Services;

import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

import com.mycompany.model.Prestamo;
import com.mycompany.model.PrestamoVehicular;

/**
 *
 * @author AyLZz
 */
public class ServicioPrestamoVehicular 
{

    private final Map<Integer, PrestamoVehicular> prestamosVehiculares = new LinkedHashMap<>(); 
    

    public void agregarPrestamoVehicular(PrestamoVehicular prestamoVehicular) 
    {

        if (prestamosVehiculares.containsKey(prestamoVehicular.getIdPrestamo())) {
            throw new IllegalArgumentException("El ID ya existe");
        }

        prestamosVehiculares.put(prestamoVehicular.getIdPrestamo(), prestamoVehicular);
    }

    public PrestamoVehicular buscarPorId(int id) 
    {
        return prestamosVehiculares.get(id);
    }

    public boolean eliminar(int id) 
    {
        return prestamosVehiculares.remove(id) != null;
    }

    public Collection<PrestamoVehicular> obtenerPrestamos() 
    {
        return Collections.unmodifiableCollection(prestamosVehiculares.values());
    }
}
