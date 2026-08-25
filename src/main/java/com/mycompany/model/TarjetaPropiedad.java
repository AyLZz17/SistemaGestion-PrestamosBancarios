/**
 *
 * @author AyLZz
 */

package com.mycompany.model;

public class TarjetaPropiedad 
{
    private String placaVehiculo;
    private String numeroMotor;

    public TarjetaPropiedad(String placaVehiculo, String numeroMotor) {
        this.placaVehiculo = placaVehiculo;
        this.numeroMotor = numeroMotor;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String mostrarTarjetaPropiedad() {
        return "Tarjeta de Propiedad:\n" +
                "Placa del Vehículo: " + placaVehiculo + "\n" +
                "Número de Motor: " + numeroMotor;
    }
}
