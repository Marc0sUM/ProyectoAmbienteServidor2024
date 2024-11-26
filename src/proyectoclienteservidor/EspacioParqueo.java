/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoclienteservidor;

/**
 *
 * @author Marcos
 */
public class EspacioParqueo {
    private Vehiculo vehiculo;
    private boolean ocupado;
    
    public EspacioParqueo(){   
        this.ocupado = false;
    }
    
    public boolean estaOcupado(){
        return ocupado;
    }
    
    public void asignarVehiculo(Vehiculo vehiculo){
        
        if(ocupado){
            System.out.println("El espacio ya esta ocupado");
        }
        this.vehiculo = vehiculo;
        this.ocupado = true;
    }
    
    public Vehiculo liberarEspacio(){
        if(!ocupado){
            System.out.println("El espacio ya esta vacio");
    }
        Vehiculo vehiculoSaliente = vehiculo;
        vehiculo = null;
        ocupado = false;
        return vehiculoSaliente;
    }
    
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
        
}
