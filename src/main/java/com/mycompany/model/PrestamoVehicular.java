package com.mycompany.model;

/**
 *
 * @author AyLZz
 */

public class PrestamoVehicular extends Prestamo
{
    private double valorComercial;
    private String marcaVehiculo;
    private TarjetaPropiedad tarjetaPropiedad;

    public PrestamoVehicular(int idPrestamo, double monto, double tasaIntereses, int plazoMeses, double valorComercial, String marcaVehiculo) 
    {
        this(idPrestamo, monto, tasaIntereses, plazoMeses, valorComercial,
                marcaVehiculo, null);
    }

    public PrestamoVehicular(int idPrestamo, double monto, double tasaIntereses,
            int plazoMeses, double valorComercial, String marcaVehiculo,
            TarjetaPropiedad tarjetaPropiedad)
    {
        super(idPrestamo, monto, tasaIntereses, plazoMeses, null);
        this.valorComercial = valorComercial;
        this.marcaVehiculo = marcaVehiculo;
        this.tarjetaPropiedad = tarjetaPropiedad;
    }

    public double getValorComercial() {
        return valorComercial;
    }
    
    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public TarjetaPropiedad getTarjetaPropiedad() {
        return tarjetaPropiedad;
    }

    public void setTarjetaPropiedad(TarjetaPropiedad tarjetaPropiedad) {
        this.tarjetaPropiedad = tarjetaPropiedad;
    }

    @Override
    public double calcularCuotaMensual() 
    {

        try {
            double tasaMensual = getTasaIntereses() / 12 / 100;
            int plazoMeses = getPlazoMeses();
            double monto = getMonto();
            
            if (tasaMensual == 0) {
                return monto / plazoMeses;
            }
            
            return (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazoMeses));

        } catch (Exception e) {
            System.err.println("Error al calcular la cuota mensual: " + e.getMessage());
            return 0;
        }   
    }
}
