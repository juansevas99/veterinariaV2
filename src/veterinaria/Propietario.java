/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

/**
 *
 * @author Bullrock
 */
public class Propietario {

    //declaracion de variables
    private String nombre;
    private String identificacion;
    private String direccion;
    private String correo;
    private String telefono;

    //contructor vacio
    public Propietario() {
        nombre = "";
        identificacion = "";
        direccion = "";
        correo = "";
        telefono = "";
    }

    //contructor con parametros
    public Propietario(String nombre, String identificacion, String direccion, String correo, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }
// getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Propietario{" + "nombre=" + nombre + ", identificacion=" + identificacion + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + '}';
    }

}
