/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.util.ArrayList;

/**
 *
 * @author Bullrock
 */
public class Veterinario {

    // declaracion de variables 
    private String nombreVet;
    private String especialidad;
    private int numeroRegistro;
    // es un arraylist porque un veterinario tiene mas de una cita.
    private ArrayList<Cita> citas;

// construcctor vacio 
    public Veterinario() {
        nombreVet = "";
        especialidad = "";
        numeroRegistro = 0;
        //son las citas del veterinario 
        citas = new ArrayList<>();
    }
//constructor con parametros

    public Veterinario(String nombreVet, String especialidad, int numeroRegistro) {
        this.nombreVet = nombreVet;
        this.especialidad = especialidad;
        this.numeroRegistro = numeroRegistro;
        citas = new ArrayList<>();
    }
// getters and setters

    public String getNombre() {
        return nombreVet;
    }

    public void setNombre(String nombre) {
        this.nombreVet = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void verCitas() {
        System.out.println("---CITAS DE " + nombreVet + " --- ");
        for (int i = 0; i < citas.size(); i++) {
            System.out.println(citas.get(i).toString());
        }
    }

    public void verMascotasAtendidas() {
        System.out.println("---MASCOTAS ATENDIDAS POR " + nombreVet + " ---");
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < citas.size(); i++) {
            mascotas.add(citas.get(i).getMascota());
            if (true) {
                
            }
        }
       
        
    }

    @Override
    public String toString() {
        return "Veterinario{" + "nombreVet=" + nombreVet + ", especialidad=" + especialidad + ", numeroRegistro=" + numeroRegistro + '}';
    }

}
