package com.mycompany.model;

public class PrestamoVehicular extends Prestamo
{
    private double valorComercial;
    private String marcaVehiculo;

    public PrestamoVehicular(int idPrestamo, double monto, double tasaIntereses, int plazoMeses, double valorComercial, String marcaVehiculo) 
    {
        super(idPrestamo, monto, tasaIntereses, plazoMeses, null);
        this.valorComercial = valorComercial;
        this.marcaVehiculo = marcaVehiculo;
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
