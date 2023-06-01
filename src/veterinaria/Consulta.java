package veterinaria;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bullrock
 */
public class Consulta {

    private Cita citaAsociada;
    private Diagnostico diagnostico;
    private Tratamiento tratamiento;
    private Date fechaConsulta;

    
    
    public Consulta(Cita cita) {
        citaAsociada = cita;
        diagnostico = new Diagnostico();
        tratamiento = new Tratamiento();
        
    }

    public Consulta(Cita citaAsociada, Diagnostico diagnostico) {
        this.citaAsociada = citaAsociada;
    }
       

    public void diagnosticar(String resumenConsulta) {
        this.diagnostico.setResumenConsulta(resumenConsulta);
    }


    public Cita getCitaAsociada() {
        return citaAsociada;
    }

    public void setCitaAsociada(Cita citaAsociada) {
        this.citaAsociada = citaAsociada;
    }


    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
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
		
		
		
		
		return "Consulta [citaAsociada=" + citaAsociada + ", diagnostico=" + ", tratamiento=" + tratamiento + ", fechaConsulta=" + fechaConsulta + "]";

	
		
	
	
	}
    
    
    
    

}
