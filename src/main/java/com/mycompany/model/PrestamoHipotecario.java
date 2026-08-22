package com.mycompany.model;

public class PrestamoHipotecario extends Prestamo
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
