/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoclienteservidor;

/**
 *
 * @author Marcos
 */
public class Moto extends Vehiculo{
    public Moto(String placa, String propietario){
        super(placa, propietario);
    }
    
    @Override
    public double calcularTarifa(int horas){
        return horas*1.0; //1$dolar x hora
    }
}
