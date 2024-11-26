/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoclienteservidor;

/**
 *
 * @author Marcos
 */
abstract class Vehiculo {
    private String placa;
    private String propietaio;
    
    public Vehiculo(String placa, String propietario){
        
        this.placa = placa;
        this.propietaio = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietaio() {
        return propietaio;
    }

    public void setPropietaio(String propietaio) {
        this.propietaio = propietaio;
    }
    
    public abstract double calcularTarifa(int horas);
}
