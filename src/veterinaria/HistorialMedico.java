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
public class HistorialMedico {
    ArrayList<Consulta> consultas;

    public HistorialMedico() {
        consultas = new ArrayList<Consulta>();
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }
    
    public void VerHistorialMedico(){
        for (int i = 0; i < consultas.size(); i++) {
            System.out.println(consultas.get(i).toString() + "\n");
        }
    }
}
