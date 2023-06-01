/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

/**
 *
 * @author Bullrock
 */
public class Examen {

    // declaracion de variables
    private String nombre;
    private int precio;
    //constructor vacio

    public Examen() {
        this.nombre = "";
        this.precio = 0;
    }
    // construcctor con parametros

    public Examen(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
// getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Examen{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }
}
