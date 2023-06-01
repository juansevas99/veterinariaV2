/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bullrock
 */
public class Diagnostico {
    // declaracion de variables

    private String resumenConsulta;
    private Date fecha;

    // estas son las clases con las se relaciona.
    private ArrayList<Examen> examenes;

    
    public Diagnostico(String resumen) {
    	this.resumenConsulta=resumen;
    	
    	
    }
    
    public Diagnostico() {
		// TODO Auto-generated constructor stub
	}
    // construcctor vacio
    //construcctor con parametros
//getters and setters
    public String getResumenConsulta() {
        return resumenConsulta;
    }

    public void setResumenConsulta(String resumenConsulta) {
        this.resumenConsulta = resumenConsulta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }
    
    public void solicitarExamen(Examen nuevoExamen){
        examenes.add(nuevoExamen);
    }

    @Override
    public String toString() {
        return "Diagnostico{" + "resumenConsulta=" + resumenConsulta + ", fecha=" + fecha + ", examenes=" + examenes + '}';
    }

}
