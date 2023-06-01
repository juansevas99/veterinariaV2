/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Bullrock
 */
public class Factura {

    private int costoBasicoObligatorio = 10000;
    private Cita citaAsociada;
    private Consulta consultaAsociada;
    private Date fecha;
    private Time hora;
    private int costo;
    private Mascota mascota;
    private Veterinario veterinario;

    public Factura(Consulta consulta) {
        this.consultaAsociada = consulta;
        this.citaAsociada = consulta.getCitaAsociada();
        fecha = citaAsociada.getFecha();
        hora = citaAsociada.getHora();
        this.costo = FacturarCita();
        mascota = citaAsociada.getMascota();
        veterinario = citaAsociada.getVeterinario();
    }

    public int FacturarCita() {
        int costoExamenes = 0;
        for (int i = 0; i < consultaAsociada.getExamenes().size(); i++) {
            costoExamenes = consultaAsociada.getExamenes().get(i).getPrecio() + costoExamenes;
        }

        int costoMedicamentos = 0;
        for (int i = 0; i < consultaAsociada.getExamenes().size(); i++) {
            costoMedicamentos = consultaAsociada.getExamenes().get(i).getPrecio() + costoMedicamentos;
        }
        
        return costoBasicoObligatorio + costoExamenes + costoMedicamentos;
    }
    
    
    

    @Override
    public String toString() {
        return "Factura{" + "citaAsociada=" + citaAsociada + ", consultaAsociada=" + consultaAsociada + ", fecha=" + fecha + ", hora=" + hora + ", costo=" + costo + ", mascota=" + mascota + ", veterinario=" + veterinario + '}';
    }


}
