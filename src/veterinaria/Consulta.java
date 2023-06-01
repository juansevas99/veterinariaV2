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
public class Consulta {

    private Cita citaAsociada;
    private Veterinario veterinario;
    private Mascota mascota;
    private Diagnostico diagnostico;
    private ArrayList<Examen> examenes;
    private ArrayList<Medicamento> medicamentos;
    private Tratamiento tratamiento;
    private Date fechaConsulta;

    
    
    public Consulta(Cita cita) {
        citaAsociada = cita;
        veterinario = cita.getVeterinario(); // quitar esto porfavo, si son tan amables
        mascota = cita.getMascota(); // quitar esto porfavo, si son tan amables
        diagnostico = new Diagnostico();
        diagnostico.setFecha(cita.getFecha());  // quitar esto porfavo, si son tan amables
        examenes = diagnostico.getExamenes(); // quitar esto porfavo, si son tan amables
        medicamentos = new ArrayList<Medicamento>(); // quitar esto porfavo, si son tan amables
        tratamiento = new Tratamiento();
        fechaConsulta = cita.getFecha(); // deberia ser a hora en la que se gestiona la consulta
    }

    public Consulta(Cita citaAsociada, Diagnostico diagnostico) {
        this.citaAsociada = citaAsociada;
        veterinario = citaAsociada.getVeterinario();
        mascota = citaAsociada.getMascota();
        this.diagnostico = diagnostico;
        examenes = diagnostico.getExamenes();
        medicamentos = new ArrayList<Medicamento>();
    }

    public void diagnosticar(String resumenConsulta) {
        this.diagnostico.setResumenConsulta(resumenConsulta);
    }

    public void diagnosticarConExamenes(String resumenConsulta, ArrayList<Examen> examenes) {
        this.diagnostico.setResumenConsulta(resumenConsulta);
        this.diagnostico.setExamenes(examenes);
    }

    public void recetarMedicamento(Medicamento medicamento) {
        this.medicamentos.add(medicamento);
    }

    public Cita getCitaAsociada() {
        return citaAsociada;
    }

    public void setCitaAsociada(Cita citaAsociada) {
        this.citaAsociada = citaAsociada;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

	@Override
	public String toString() {
		return "Consulta [citaAsociada=" + citaAsociada + ", veterinario=" + veterinario + ", mascota=" + mascota
				+ ", diagnostico=" + diagnostico + ", examenes=" + examenes + ", medicamentos=" + medicamentos
				+ ", tratamiento=" + tratamiento + ", fechaConsulta=" + fechaConsulta + "]";
	}
    
    
    
    

}
