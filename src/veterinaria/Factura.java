/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.sql.Time;
import java.util.ArrayList;
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
        for (int i = 0; i < consultaAsociada.getDiagnostico().getExamenes().size(); i++) {
            costoExamenes = consultaAsociada.getDiagnostico().getExamenes().get(i).getPrecio() + costoExamenes;
        }

        int costoMedicamentos = 0;
        for (int i = 0; i < consultaAsociada.getDiagnostico().getExamenes().size(); i++) {
            costoMedicamentos = consultaAsociada.getDiagnostico().getExamenes().get(i).getPrecio() + costoMedicamentos;
        }
        
        return costoBasicoObligatorio + costoExamenes + costoMedicamentos;
    }
    
    
    

    @Override
    public String toString() {
    	
    	System.out.println("FACTURA \n "); 

    	ArrayList<Examen> examanes=this.consultaAsociada.getDiagnostico().getExamenes();
    	String examenesLista="";
    	for (Examen examen : examanes) {
    		examenesLista+=examen.getNombre()+" - "+examen.getPrecio()+"\n";
		}
    	
    	System.out.println(""
    			+ "Empresa: Veterinaria BIGOTES \n"
    			+ "CRA 6 No. 23-70 EDIFICIO VERDE \n"
    			+ "BOGOTÁ, COLOMBIA \n"
    			+ "01 8000 4354: \n"
    			+ "Correo electrónico:vet@bigotes.com"
    			+ "\n"
    			+ "\n"
    			+ "\n"
    			+ "\n"
    			+ "\n"
    			+ "\n"
    			+ "FECHA DE EMISION:"+this.fecha+"\n"
    					+ "\n"
    					+ "\n"
    					+ "\n"
    					+ "INFORMACION DEL PROPIETARIO\n"
    					+ "Nombre:"+citaAsociada.getMascota().getPropietario().getNombre()+"\n"
    					+ "Direccion: "+citaAsociada.getMascota().getPropietario().getDireccion()+"\n"
    					+ "Bogota, Colombia\n"
    					+ "Telefono:"+citaAsociada.getMascota().getPropietario().getTelefono()+"\n"
    					+ "Correo:"+citaAsociada.getMascota().getPropietario().getCorreo()+"\n"
    					+ "\n"
    					+ "\n"
    					+ "\n"
    					+ "\n"
    					+ "PRESTACIÓN DEL SERVICIO"
    					+ "\n"
    					+ "\n"
    					+ "\n"
    					+ "\n"
    					+ "Consulta para  mascota "+citaAsociada.getMascota().getNombreMas()+" realizada el   "+consultaAsociada.getFechaConsulta()+"\n"
    					+ "Vacunación (SI__NO__)"
    					+ "\n"
    					+ "\n"
    					+ "\n"
    					+ "\n"
    					+ ""+examenesLista
    					+ "\n"
    					+ "\n"
    					+ "\n"
    					+ "\n"
    					+ "Consulta Veterinaria:"+consultaAsociada.getDiagnostico().getExamenes().stream().mapToInt(Examen::getPrecio).sum()+"$\n"
    					+ "Vacunacion: o$\n"
    					+ "Subtotal:"+consultaAsociada.getDiagnostico().getExamenes().stream().mapToInt(Examen::getPrecio).sum()+"\n"
    							+ "(Monto minimo)Examen y medicamentos: $10.000 \n"
						+ "Total:" + (consultaAsociada.getDiagnostico().getExamenes().stream().mapToInt(Examen::getPrecio).sum()+10000)+"\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ ""
						+ "METODO DE PAGO\n"
						+ "\n"
						+ "\n"
						+ "Efectivo\n"
						+ "" );
    	
    	
    	     	 




        return "Factura{" + "citaAsociada=" + citaAsociada + ", consultaAsociada=" + consultaAsociada + ", fecha=" + fecha + ", hora=" + hora + ", costo=" + costo + ", mascota=" + mascota + ", veterinario=" + veterinario + '}';
    }


}
