package com.mycompany.model;

/**
 *
 * @author AyLZz
 */

public class PrestamoHipotecario extends Prestamo implements IAsegurableHipoteca
{
    
    private String tipoInmueble;
    private String direccionInmueble;

    public PrestamoHipotecario(int idPrestamo, double monto, double tasaIntereses, int plazoMeses, String tipoInmueble, 
        String direccionInmueble) 
    {
        super(idPrestamo, monto, tasaIntereses, plazoMeses, null);
        this.tipoInmueble = tipoInmueble;
        this.direccionInmueble = direccionInmueble;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getDireccionInmueble() {
        return direccionInmueble;
    }

    public void setDireccionInmueble(String direccionInmueble) {
        this.direccionInmueble = direccionInmueble;
    }

    @Override
    public double calcularSeguro() {
        // TODO: Implementación del cálculo del seguro
        return 0;
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
            
            return ((monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazoMeses))) + calcularSeguro();

        } catch (Exception e) {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Error al calcular la cuota mensual: ")
                   .append(e.getMessage());
            System.err.println(mensaje.toString());
            return 0;
        }   
    }




}
