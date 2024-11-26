/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoclienteservidor;

import java.util.*;

public class Parqueo implements ReglasParqueo {

    private List<EspacioParqueo> espacios;
    private int capacidad;

    public Parqueo(int capacidad) {
        this.capacidad = capacidad;
        this.espacios = new ArrayList<>();
        for (int i = 0; i < capacidad; i++) {
            espacios.add(new EspacioParqueo());
        }
    }

    @Override
    public boolean puedeParquear(Vehiculo vehiculo) {
        for (EspacioParqueo espacio : espacios) {
            if (!espacio.estaOcupado()) {
                return true;
            }
        }
        return false;
    }

    public void parquearVehiculo(Vehiculo vehiculo) {
        if (!puedeParquear(vehiculo)) {
            throw new IllegalStateException("No hay espacios disponibles");
        }
        for (EspacioParqueo espacio : espacios) {
            if (!espacio.estaOcupado()) {
                espacio.asignarVehiculo(vehiculo);
                System.out.println("Vehiculo" + vehiculo.getPlaca() + "parqueado");
                return;
            }
        }
    }

    public void retirarVehiculo(String placa) {
        for (EspacioParqueo espacio : espacios) {
            if (espacio.estaOcupado() && espacio.getVehiculo().getPlaca().equals(placa)) {
                espacio.liberarEspacio();
                System.out.println("Vehiculo " + placa + "retirado");
                return;
            }
        }
        throw new IllegalArgumentException("El vehículo con placa " + placa + " no está en el parqueadero.");
    }

    public void mostrarEstado() {
        System.out.println("Estado de parqueo");
        for (int i = 0; i < espacios.size(); i++) {
            EspacioParqueo espacio = espacios.get(i);
            if (espacio.estaOcupado()) {
                System.out.println("Espacios " + (i + 1) + " :ocupado por " + espacio.getVehiculo().getPlaca());
            } else {
                System.out.println("Espacio " + (i + 1) + ": Libre");
            }
        }
    }

    public List<EspacioParqueo> getEspacios() {
        return this.espacios; // Donde `espacios` es una lista de EspacioParqueo.
    }

}
