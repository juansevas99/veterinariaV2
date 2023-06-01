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
public class Tratamiento {

    private ArrayList<Medicamento> medicamentos;
    //consumase durante 4 8 o los que sea dias
    //tiempo de consumo del medicamento en días
    private int consumoDias;
    //consumase cada 8,4 o lo que sea horas
    //dosis tiempo (cada 4 horas, 8 horas, 12 horas o 24 Horas)
    private int consumoHoras;
    // dosis cantidad (½ dosis, 1 dosis, 2 dosis, 3 dosis)
    private float consumoDosis;

    private String comentarios;
    public Tratamiento() {
        this.medicamentos = new ArrayList<Medicamento>();
        this.consumoDias = 0;
        this.consumoHoras = 0;
        this.consumoDosis = 0;
    }

    public Tratamiento(ArrayList<Medicamento> medicamentos, int consumoDias, int consumoHoras, float consumoDosis) {
        this.medicamentos = medicamentos;
        this.consumoDias = consumoDias;
        this.consumoHoras = consumoHoras;
        this.consumoDosis = consumoDosis;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public int getConsumoDias() {
        return consumoDias;
    }

    public void setConsumoDias(int consumoDias) {
        this.consumoDias = consumoDias;
    }

    public int getConsumoHoras() {
        return consumoHoras;
    }

    public void setConsumoHoras(int consumoHoras) {
        this.consumoHoras = consumoHoras;
    }

    public float getConsumoDosis() {
        return consumoDosis;
    }

    public void setConsumoDosis(float consumoDosis) {
        this.consumoDosis = consumoDosis;
    }

    @Override
    public String toString() {
        return "Tratamiento{" + "medicamentos=" + medicamentos + ", consumoDias=" + consumoDias + ", consumoHoras=" + consumoHoras + ", consumoDosis=" + consumoDosis + '}';
    }
    
    
    
    
}
