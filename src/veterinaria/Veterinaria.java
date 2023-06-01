package veterinaria;

import java.lang.module.FindException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import veterinaria.Mascota.Especie;

import java.util.Date;
import java.util.Optional;



public class Veterinaria {

    private static ArrayList<Cita> citasTotales = new ArrayList<Cita>();
    private static ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();
    private static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private static ArrayList<Propietario> propietarios = new ArrayList<Propietario>();
    private static ArrayList<Medicamento> medicamentosDisponibles = new ArrayList<Medicamento>();
    private static ArrayList<Examen> examenesDisponibles = new ArrayList<Examen>();
    private static ArrayList<Consulta> consultasTotales= new ArrayList<Consulta>();
    private static Scanner tc = new Scanner(System.in);
    private static int cantidadCitas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        cantidadCitas = citasTotales.size() + 1;

        Examen examen1 = new Examen("aaa", 100);
        Examen examen2 = new Examen("bbb", 200);
        Examen examen3 = new Examen("ccc", 300);
        examenesDisponibles.add(examen1);
        examenesDisponibles.add(examen2);
        examenesDisponibles.add(examen3);

        Medicamento medicamento1 = new Medicamento("aaa", 100);
        Medicamento medicamento2 = new Medicamento("bbb", 200);
        Medicamento medicamento3 = new Medicamento("ccc", 300);
        medicamentosDisponibles.add(medicamento1);
        medicamentosDisponibles.add(medicamento2);
        medicamentosDisponibles.add(medicamento3);

        Veterinario veterinario1 = new Veterinario("Jose", "General", 0);
        Veterinario veterinario2 = new Veterinario("Alexa", "Esp1", 0);
        veterinarios.add(veterinario1);
        veterinarios.add(veterinario2);

        Propietario propietario1 = new Propietario("Daniel", "123", "CASA", "CORREO", "2");
        Mascota mascota1 = new Mascota("Nani", 5, Especie.perro, "Criolla", "F", 1,30, propietario1,"01/01/2032");
        Mascota mascota2 = new Mascota("Kenya", 5, Especie.perro, "Criolla", "F", 1,30, propietario1,"01/01/2032");
        mascotas.add(mascota1);
        mascotas.add(mascota2);
        System.out.println(mascotas.get(0));
        Cita cita1 = new Cita(1, null, null, null, "VALIDA", veterinario1, mascota1);

        desplegarMenuPrincipal();
    }

    private static void desplegarMenuPrincipal() {
        String opcion = "";

        do {

            System.out.println("-------------------------------------------------\n"
                    + "BIENVENIDO A LA VETERINARIA\n"
                    + "Seleccione una opcion\n"
                    + "1. Registro de datos\n"
                    + "2. Perfil Recepcionista\n"
                    + "3. Perfil Veterinario\n"
                    + "4. Consultar estadisticas\n"
                    + "5. Salir");
            opcion = tc.next();

            switch (opcion) {
                case "1":
                    desplegarMenuRegistroDatos();
                    break;
                case "2":
                    desplegarMenuRecepcionista();
                    break;
                case "3":
                    desplegarMenuVeterinario();
                    break;
                case "4":
                    desplegarMenuEstadisticas();
                    break;
                case "5":
                    System.out.println("SALIDA EXITOSA");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion incorrecta en el menu principal");
                    break;
            }

            desplegarMenuPrincipal();
        } while (!"5".equals(opcion));
    }
    // --------------------------------REGION DATOS
    // BASICOS---------------------------

    private static void desplegarMenuRegistroDatos() {
        System.out.println("-------------------------------------------------\n"
                + "MENU REGISTRO DE DATOS\n"
                + "Seleccione una opcion\n"
                + "1. Examenes\n"
                + "2. Medicamentos\n"
                + "3. Veterinarios\n"
                + "4. Regresar al menu principal\n");
        String opcion = tc.next();

        switch (opcion) {

            case "1":
                gestionarExamenes();
                break;
            case "2":
                gestionarMedicamentos();
                break;
            case "3":
                gestionarVeterinarios();
                break;
            case "4":
                desplegarMenuPrincipal();
                break;
            default:
                System.out.println("Opcion incorrecta en el menu registro datos");
                desplegarMenuRegistroDatos();
                break;
        }

        desplegarMenuRegistroDatos();
    }
//-----------------------------EXAMENES-------------------------------------------------

    private static void gestionarExamenes() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "EXAMENES\n"
                + "Seleccione una opcion\n"
                + "1. Agregar\n"
                + "2. Editar\n"
                + "3. Eliminar\n"
                + "4. Ver\n"
                + "5. Regresar al menu de registro de datos\n"
                + "6. Regresar al menu principal\n");
        String opcion = tc.next();

        switch (opcion) {
            case "1":
                // registro de examnes
                registrarExamen();
                break;
            // edicion de examenes existentes
            case "2":
                editarExamen();
                break;
            //eliminar examenes de la lista
            case "3":
                borrarExamen();
                break;
            // ver los examenes registrados
            case "4":
                verExamenes();
                break;
            case "5":
                desplegarMenuRegistroDatos();
                break;
            case "6":
                desplegarMenuPrincipal();
                break;
            default:
                System.out.println("Opcion incorrecta en el menu examenes");
                gestionarExamenes();
                break;
        }
        gestionarExamenes();

    }

    private static void registrarExamen() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "AGREGAR EXAMEN\n"
                + "Ingrese el nombre del examen");
        try {
            String nombreExamen = tc.next();
            System.out.println("Ingrese el precio");
            int precioExamen = tc.nextInt();
            Examen nuevoExamen = new Examen(nombreExamen, precioExamen);
            examenesDisponibles.add(nuevoExamen);
            System.out.println("El examen " + nombreExamen + " ha sido agregado correctamente");
        } catch (Exception e) {
            System.out.println("El examen ingresado es invalido, ingreselo nuevamente.");
            registrarExamen();
        }
    }

    private static void editarExamen() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "EDITAR EXAMEN\n");
        verExamenes();
        System.out.println("Ingrese el numero del examen a editar");
        String indiceExamenStr = tc.next();
        int indiceExamen = Integer.parseInt(indiceExamenStr) - 1;

        System.out.println("Ingrese el parametro a editar.\n"
                + "1. Nombre\n"
                + "2. Precio");

        String parametroEditable = tc.next();

        switch (parametroEditable) {
            case "1":
                System.out.println("Ingrese el nuevo nombre");
                String nuevoNombre = tc.next();
                examenesDisponibles.get(indiceExamen).setNombre(nuevoNombre);
                break;

            case "2":
                System.out.println("Ingrese el nuevo precio");
                int nuevoPrecio = tc.nextInt();
                examenesDisponibles.get(indiceExamen).setPrecio(nuevoPrecio);
                break;
            default:
                System.out.println("Error al editar examen, intentelo nuevamente");
                editarExamen();
                break;
        }

        System.out.println("El examen " + indiceExamenStr + " ahora es:\n"
                + examenesDisponibles.get(indiceExamen).toString());
    }

    private static void borrarExamen() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "ELIMINAR EXAMEN\n");
        verExamenes();
        System.out.println("Ingrese el numero del examen a eliminar");
        String indiceExamenStr = tc.next();
        int indiceExamen = Integer.parseInt(indiceExamenStr) - 1;
        System.out.println("Esta seguro de eliminar el examen:\n"
                + examenesDisponibles.get(indiceExamen).toString() + "\n"
                + "1. Si\n"
                + "2. No \n");

        String opcion = tc.next();

        switch (opcion) {
            case "1":
                examenesDisponibles.remove(indiceExamen);
                System.out.println("Examen eliminado correctamente");
                break;

            case "2":
                System.out.println("El examen NO fue eliminado");
                break;
            default:
                System.out.println("Error al eliminar examen, intentelo nuevamente");
                borrarExamen();
                break;
        }

        verExamenes();
    }

    private static void verExamenes() {
        System.out.println("\n---EXAMENES---\n");
        for (int i = 0; i < examenesDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + examenesDisponibles.get(i).toString());
        }
        System.out.println("\n");
    }

//---------------------------MEDICAMENTOS---------------------------------------------------
    private static void gestionarMedicamentos() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "MEDICAMENTOS\n"
                + "Seleccione una opcion\n"
                + "1. Agregar\n"
                + "2. Editar\n"
                + "3. Eliminar\n"
                + "4. Ver\n"
                + "5. Regresar al menu de registro de datos\n"
                + "6. Regresar al menu principal\n");
        String opcion = tc.next();

        switch (opcion) {
            case "1":
                // registro de examnes
                registrarMedicamento();
                break;
            // edicion de examenes existentes
            case "2":
                editarMedicamento();
                break;
            //eliminar examenes de la lista
            case "3":
                borrarMedicamento();
                break;
            // ver los examenes registrados
            case "4":
                verMedicamentos();
                break;
            case "5":
                desplegarMenuRegistroDatos();
                break;
            case "6":
                desplegarMenuPrincipal();
                break;
            default:
                System.out.println("Opcion incorrecta en el menu medicina");
                gestionarMedicamentos();
                break;
        }
        gestionarMedicamentos();
    }

    private static void registrarMedicamento() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "AGREGAR MEDICAMENTO\n"
                + "Ingrese el nombre del medicamento");
        try {
            String nombreMedicina = tc.next();
            System.out.println("Ingrese el precio");
            int precioMedicina = tc.nextInt();
            Medicamento nuevoMedicamento = new Medicamento(nombreMedicina, precioMedicina);
            medicamentosDisponibles.add(nuevoMedicamento);
            System.out.println("El medicamento " + nombreMedicina + " ha sido agregado correctamente");
        } catch (Exception e) {
            System.out.println("El medicamento ingresado es invalido, ingreselo nuevamente.");
            registrarMedicamento();
        }
    }

    private static void editarMedicamento() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "EDITAR MEDICAMENTO\n");
        verMedicamentos();
        System.out.println("Ingrese el numero del medicamento a editar");
        String indiceMedicamentoStr = tc.next();
        int indiceMedicamento = Integer.parseInt(indiceMedicamentoStr) - 1;

        System.out.println("Ingrese el parametro a editar.\n"
                + "1. Nombre\n"
                + "2. Precio");

        String parametroEditable = tc.next();

        switch (parametroEditable) {
            case "1":
                System.out.println("Ingrese el nuevo nombre");
                String nuevoNombre = tc.next();
                medicamentosDisponibles.get(indiceMedicamento).setNombre(nuevoNombre);
                break;

            case "2":
                System.out.println("Ingrese el nuevo precio");
                int nuevoPrecio = tc.nextInt();
                medicamentosDisponibles.get(indiceMedicamento).setPrecio(nuevoPrecio);
                break;
            default:
                System.out.println("Error al editar medicamento, intentelo nuevamente");
                editarMedicamento();
                break;
        }

        System.out.println("El medicamento " + indiceMedicamentoStr + " ahora es:\n"
                + medicamentosDisponibles.get(indiceMedicamento).toString());
    }

    private static void borrarMedicamento() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "ELIMINAR MEDICAMENTO\n");
        verMedicamentos();
        System.out.println("Ingrese el numero del medicamento a eliminar");
        String indiceMedicamentoStr = tc.next();
        int indiceMedicamento = Integer.parseInt(indiceMedicamentoStr) - 1;
        System.out.println("Esta seguro de eliminar el medicamento:\n"
                + medicamentosDisponibles.get(indiceMedicamento).toString() + "\n"
                + "1. Si\n"
                + "2. No \n");

        String opcion = tc.next();

        switch (opcion) {
            case "1":
                medicamentosDisponibles.remove(indiceMedicamento);
                System.out.println("Medicamento eliminado correctamente");
                break;

            case "2":
                System.out.println("El medicamento NO fue eliminado");
                break;
            default:
                System.out.println("Error al eliminar medicamento, intentelo nuevamente");
                borrarMedicamento();
                break;
        }

        verMedicamentos();
    }

    private static void verMedicamentos() {
        System.out.println("\n---MEDICAMENTOS---\n");
        for (int i = 0; i < medicamentosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + medicamentosDisponibles.get(i).toString());
        }
        System.out.println("\n");
    }
    
    
    
    
    //----------------------------GESTION DE VETERINARIO------------------------------------------------------------------
    
   private static void gestionarConsultas() {
	   System.out.print("------------------------------------------------\n"
	   		+ "REGISTRO DE CONSULTA\n" // sirve para que el veterinario seleccione una cita y traiga el codigo correspondiente
	   		+ "1. Ver consultas\n"
	   		+ "2. Gestionar consulta\n"
	   		+ "3.  "
	   		+ "");
	   
	   String opcion = tc.next();
	   
	   
       switch (opcion) {
  

       case "1":
    	   gestionarConsulta();
    	   
       break;
           
       default:
           System.out.println("Opcion incorrecta en el menu Consulta ");
           gestionarVeterinarios();
           break;
   }
   }
   
   
   private static void gestionarConsulta() {
	   System.out.println("LISTA DE CONSULTAS");
	   
	  System.out.println("Indique el numero de la cita");
	  int citaAsociada=tc.nextInt();
	  
	  Optional<Consulta> consulta=consultasTotales.stream().filter(e->e.getCitaAsociada().getNumSerial()==citaAsociada).findFirst();
	  
	  // despliega toda la iformacion de la consulta
	  
	  System.out.println(consulta);
	  
	  
	  
	  // Crecion del diagnostico
	  
	 
	  
	  System.out.println("Resuma la consulta \n");
	  
	  String conceptoMedico=tc.nextLine();
	  
	  
	  
	  
	  
	  Diagnostico  diagnostico = new Diagnostico(conceptoMedico);
	  
	  // Seleccion de examenes
	  
	 for (Examen examen : examenesDisponibles) {
		System.out.println(examen);
	}
	 
	 
	 ArrayList<Examen> examenesSeleccionados= new ArrayList<Examen>();
	 boolean resp=true;
	 while (resp) {
		 
		 System.out.println("Coloque el nombre del examen que desea asociar a la consulta");
		 
		  
		 
		 String nombreExamen=tc.nextLine();
		 
		 Optional<Examen> examen=examenesDisponibles.stream().filter(e->e.getNombre().equals(nombreExamen)).findFirst();
		 
		 
		 examenesSeleccionados.add(examen.get());
		 
		 System.out.println("Desea a�adir otro examen?\n"
		 		+ "1. Si\n"
		 		+ "2. No");
		 int opcion=tc.nextInt();
		 if (opcion==2) {
			 resp=false;
		 }
	 }
	 
	 
	 
	  diagnostico.setExamenes(examenesSeleccionados);
	  
	 
	  
	  // creacion tratamiento
	  
	  // seleccion de medicamentos
	  
	  
	  for (Medicamento medicamento: medicamentosDisponibles) {
			System.out.println(medicamento);
		}
		 
		 
		 ArrayList<Medicamento> medicamentosSeleccionados= new ArrayList<Medicamento>();
		 boolean resp1=true;
		 while (resp1) {
			 
			 System.out.println("Coloque el nombre del Medicamento que desea asociar al tratamiento");
	
			 
			 String nombreMedicamento=tc.nextLine();
			 
			 Optional<Medicamento> medicamento=medicamentosDisponibles.stream().filter(e->e.equals(nombreMedicamento)).findFirst();
			 
			 
			 medicamentosSeleccionados.add(medicamento.get());
			 
			 System.out.println("Desea a�adir otro medicamento?\n"
			 		+ "1. Si\n"
			 		+ "2. No");
			 int opcion1=tc.nextInt();
			 if (opcion1==2) {
				 resp1=false;
			 }
		 }
	  
	// Cambiar constructor
	System.out.println("Indique comentarios para el tratamiento");	 
	
	Tratamiento tratamiento= new Tratamiento(medicamentosDisponibles, 0,0,0);
	
	// termiar gestion de consulta
	consulta.get().setDiagnostico(diagnostico);
	consulta.get().setTratamiento(tratamiento);
	
	// creacion de factura
   Factura factura= new Factura(consulta.get());
   
   
   // se mostrara factura aqui con el dise�o que hara Alexandra
   System.out.println(factura);
   
	
	
	  
   }
   

   
   
   
    private static void confirmacionCita() {
    	// Preguntar por codigo Citas
    	
    	System.out.println("REGISTRO DE CONSULTA --- --------------\n"
    			+ "\n"
    			+ "Ingrese el codigo serial de la cita que desea asociar");
    	int codigo=tc.nextInt();
    	
    	// trae la cita asociada
    	Optional<Cita> citaAsociada=citasTotales.stream().filter(e->e.getNumSerial()==codigo).findFirst();
    	// Verificar si cita esta dentro la horas indicadas
    	
    	System.out.println("Cual es el estadoa de la cita?\n"
    			+ "1 En curso\n"
    			+ "2 No se presento\n"
    			+ "3 Llego tarde");
    	
    	int resp=tc.nextInt();
    	
    	
    	if (resp==2) {
    		
    		citaAsociada.get().setEstadoCita(Cita.ESTADO_INACTIVO);
    		return;
    	}
    	if (resp==3) {
    		
    		citaAsociada.get().setEstadoCita(Cita.ESTADO_INACTIVO);
    		return;
    	}
    	
    	
    	citaAsociada.get().setEstadoCita(Cita.ESTADO_ENCURSO);
    	
    	// creacion de consulta
    	Consulta consulta = new Consulta(citaAsociada.get());
    	
    	
    	
    	
    	// Crear diagnosticos
    		// Asignacion de examenes
    	// Creacion de tratamiento
    		// Asginacion de medicamentos
    		// asfginacion de frecuecia y dosis
    	// Se crea la facutura
    		// Generar Id de factura
    		// Desplegar factura
 
    }
    
    
    private static void verCitasPendientes() {
    	
    
    	System.out.println("Ingrese el documento de identificacion del veterinario");
    	String veterinario = tc.nextLine();
    	Cita[] citasDispoibles =(Cita[]) citasTotales.stream().filter(e-> e.getVeterinario().equals(e) && e.getEstadoCita()==Cita.ESTADO_ACTIVO).toArray();
    	
    	System.out.println("Guarde el numero serial de la cita en el portapapeles de manera que pueda crear la consulta");
    	for (Cita cita : citasDispoibles) {
			System.out.println(cita);
		}
    	
    	
    	// Desplegar citas segun veterinario
    	
    }
    
    
    
    
    
    
    
    

    //---------------------------VETERINARIOS---------------------------------------------------
    private static void gestionarVeterinarios() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "VETERINARIOS\n"
                + "Seleccione una opcion\n"
                + "1. Agregar\n"
                + "2. Editar\n"
                + "3. Eliminar\n"
                + "4. Ver\n"
                + "5. Regresar al menu de registro de datos\n"
                + "6. Regresar al menu principal\n");
        String opcion = tc.next();

        switch (opcion) {
            case "1":
                // registro de examnes
                registrarVeterinario();
                break;
            // edicion de examenes existentes
            case "2":
                editarVeterinario();
                break;
            //eliminar examenes de la lista
            case "3":
                borrarVeterinario();
                break;
            // ver los examenes registrados
            case "4":
                verVeterinarios();
                break;
            case "5":
                desplegarMenuRegistroDatos();
                break;
            case "6":
                desplegarMenuPrincipal();
                break;
            default:
                System.out.println("Opcion incorrecta en el menu veterinario");
                gestionarVeterinarios();
                break;
        }
        gestionarVeterinarios();
    }

    private static void registrarVeterinario() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "AGREGAR VETERINARIO\n"
                + "Ingrese el nombre del medico veterinario:");
        try {
            String nombreVet = tc.next();
            tc.nextLine();
            System.out.println("Ingrese la especialidad del medico:");
            String especialidad = tc.next();
            System.out.println("Ingrese el número de registro:");
            int numeroRegistro = tc.nextInt();
            //CREAR METODOS
            //AGREGAR VALIDACION PARA CREAR VETERINARIOS UNICOS
            //AGREGAR ARRAY DE ESPECIALIDADES
            //AGREGAR VALIDACION PARA LOS PARAMETROS DEL VETERINARIO
            Veterinario nuevoVeterinario = new Veterinario(nombreVet, especialidad, numeroRegistro);
            veterinarios.add(nuevoVeterinario);

            System.out.println("El veterinario " + nombreVet + " ha sido agregado correctamente");
        } catch (Exception e) {
            System.out.println("El veterinario ingresado es invalido, ingreselo nuevamente.");
            registrarVeterinario();
        }
    }

    private static void editarVeterinario() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "EDITAR VETERINARIO\n");
        verVeterinarios();
        System.out.println("Ingrese el numero del veterinario a editar");
        String indiceVeterinarioStr = tc.next();
        int indiceVeterinario = Integer.parseInt(indiceVeterinarioStr) - 1;

        System.out.println("Ingrese el parametro a editar.\n"
                + "1. Nombre\n"
                + "2. Especialidad\n"
                + "3. Numero de Registro\n");

        String parametroEditable = tc.next();

        switch (parametroEditable) {
            case "1":
                System.out.println("Ingrese el nuevo nombre");
                String nuevoNombre = tc.next();
                veterinarios.get(indiceVeterinario).setNombre(nuevoNombre);
                break;

            case "2":
                System.out.println("Ingrese la nueva especialidad");
                String nuevaEspecialidad = tc.next();
                veterinarios.get(indiceVeterinario).setEspecialidad(nuevaEspecialidad);
                break;

            case "3":
                System.out.println("Ingrese el nuevo numero de registro");
                int nuevoNumeroRegistro = tc.nextInt();
                veterinarios.get(indiceVeterinario).setNumeroRegistro(nuevoNumeroRegistro);
                break;

            default:
                System.out.println("Error al editar veterinario, intentelo nuevamente");
                editarVeterinario();
                break;
        }

        System.out.println("El veterinario " + indiceVeterinarioStr + " ahora es:\n"
                + veterinarios.get(indiceVeterinario).toString());
    }

    private static void borrarVeterinario() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO DE DATOS\n"
                + "ELIMINAR VETERINARIO\n");
        verVeterinarios();
        System.out.println("Ingrese el numero del veterinario a eliminar");
        String indiceVeterinarioStr = tc.next();
        int indiceVeterinario = Integer.parseInt(indiceVeterinarioStr) - 1;
        System.out.println("Esta seguro de eliminar el veterinario:\n"
                + veterinarios.get(indiceVeterinario).toString() + "\n"
                + "1. Si\n"
                + "2. No \n");

        String opcion = tc.next();

        switch (opcion) {
            case "1":
                veterinarios.remove(indiceVeterinario);
                System.out.println("Veterinario eliminado correctamente");
                break;

            case "2":
                System.out.println("El veterinario NO fue eliminado");
                break;
            default:
                System.out.println("Error al eliminar veterinario, intentelo nuevamente");
                borrarVeterinario();
                break;
        }

        verVeterinarios();
    }

    private static void verVeterinarios() {
        System.out.println("\n---VETERINARIOS---\n");
        for (int i = 0; i < veterinarios.size(); i++) {
            System.out.println((i + 1) + ". " + veterinarios.get(i).toString());
        }
        System.out.println("\n");
    }

//--------------------------------REGION RECEPCIONISTA---------------------------
    private static void desplegarMenuRecepcionista() {

        String opcion = mostrarMenuRecepcionista();

        switch (opcion) {
            case "1":

                crearPropietario();
                break;
            case "2":
                crearMascota();
                break;
            case "3":
                AgendarCita();
                break;
            case "4":
            	mostrarFactura();
            	
            	
            	// Clases : Mascota, propietario, tratamiento, medicamentosSubministrados , consulta, cita, cons
            	// Logica : horageneracion, 

                break;
            case "5":
            	confirmacionCita();

                break;
            case "6":
            	verCitasPendientes();
                break;
            case "7":

                break;

        }

        // private static void agendarCitas() {
        Cita nuevaCita;

        
        
        nuevaCita = new Cita(cantidadCitas);
        citasTotales.add(nuevaCita);
        cantidadCitas++;
    }

    private static void AgendarCita() {
        System.out.println("-----------AGENDAR CITA-----------");

        int numSerial = obtenerSerialNuevaCita();
        System.out.println("El número de serie de la cita es: " + numSerial);

        System.out.println("Ingrese la fecha de la cita (dd/mm/aaaa):");
        String fechaCita = tc.nextLine();

        System.out.println("Ingrese la hora de la cita (hh:mm):");
        String horaCita = tc.nextLine();

        System.out.println("Ingrese la duración de la cita (en minutos):");
        int duracionCita = tc.nextInt();

        verVeterinarios();
        System.out.println("Ingrese el número de Registro del Veterinario");
        int numVetCita = tc.nextInt();

        
        Veterinario veterinarioCita = obtenerVeterinarioPorNumRegistro(numVetCita);

        if (veterinarioCita == null) {
            System.out.println("No hay veterinarios con ese numero de Registro:");
            System.out.println("Por favor verifique los datos");
            desplegarMenuRecepcionista();
            return;
        }
        
        
        System.out.println("Mascotas");
        verMascotas();
        System.out.println("_______________________");
        System.out.println("Ingrese el nombre de la mascota");
        String nombreMascota = tc.nextLine();
        Mascota mascotaCita = obtenerMascotaPorNombre(nombreMascota);

        if (mascotaCita == null) {
            System.out.println("No hay Mascotas con ese Nombre:");
            System.out.println("Por favor verifique los datos");
            desplegarMenuRecepcionista();
            return;
        }

        // Convertir la fecha de la cita de string a Date
        Date _fechaCita = new Date();
        try {
            _fechaCita = new SimpleDateFormat("dd/MM/yyyy").parse(fechaCita);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Convertir la hora de la cita de string a Time
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        try {
            date = dateFormat.parse(horaCita);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        java.sql.Time _horaCita = new java.sql.Time(date.getTime());

        long milliseconds = TimeUnit.MINUTES.toMillis(duracionCita);
        Time _duracionCita = new Time(milliseconds);

        // Estado Cita deberia ser un Enum tambien?

        Cita nuevaCita = new Cita(numSerial, _fechaCita, _horaCita, _duracionCita, Cita.ESTADO_ACTIVO,
                veterinarioCita, mascotaCita);

        citasTotales.add(nuevaCita);
        System.out.println("Cita agendada exitosamente.");
        
        // Devuelve el numero factura
        
        
        
    }
    
    
    private static void mostrarFactura() {    	
    		
    	// Pedir codigo de cita o mostrar todas las citas con codigo
    	
    	// Mostrar factura 
    	Factura factura = newFactura(consulta);
    	
    }

    private static void verMascotas() {
        for(int i = 0; i < mascotas.size();i++){
            System.out.println(mascotas.get(i).toString());
            
        }
    }

    private static void crearMascota() {
        System.out.println("-----------REGISTRO MASCOTA-----------");
        System.out.println("Propietarios");
        for (int i = 0; i < propietarios.size(); i++) {
            Propietario m = propietarios.get(i);
            System.out.println(m);
        }
        System.out.println("_______________________________________");

        System.out.println("Ingrese la identificacion del propietario:");
        String identificacionPropietario = tc.nextLine();

        Propietario propietario = obtenerPropietarioPorIdentificacion(identificacionPropietario);

        if (propietario == null) {
            System.out.println("No hay propietarios con esa Identificacion:");
            System.out.println("Por favor verifique los datos");
            desplegarMenuRecepcionista();
            return;
        }

        System.out.println("Ingrese el nombre de la mascota:");
        String nombreMas;
         int fOt = 0;
        do {
            System.out.println("Ingrese el nombre");
            nombreMas = tc.nextLine();
            fOt = comprobarstring(nombreMas);
            if (fOt==0) {
                System.out.println("Valor invalido");
            }
        } while (fOt == 0);

        System.out.println("Ingrese la edad de la mascota:");
        String edad;
        int edadm = 0;
        do {

            try {
                edad = tc.nextLine();
                edadm = Integer.parseInt(edad);

            } catch (NumberFormatException e) {
                System.out.println("Valor  incorrecto");
                System.out.println("Ingrese la edad");

            }
        } while (edadm == 0);

        System.out.println("Ingrese la raza de la mascota:");
        String raza = tc.nextLine();

        System.out.println("Ingrese el género de la mascota:");
        String genero = tc.nextLine();

        System.out.println("Ingrese la altura del animal:");
        float altura = 0;
         do {
            System.out.println("Ingrese la altura de la mascota");
            String alt = tc.next();
            try {
                altura = Float.parseFloat(alt);
            } catch (NumberFormatException e) {
                System.out.println("Dato invalido");
            }
        } while (altura == 0);

        System.out.println("Ingrese el peso del animal:");
        float peso = 0;
         do {
            System.out.println("Ingrese el peso de la mascota");
            String pes = tc.next();
            try {
                peso = Float.parseFloat(pes);
            } catch (NumberFormatException e) {
                System.out.println("Dato invalido");
            }
        } while (peso==0);
        System.out.println("Ingrese fecha de última vacunación:");
        String fechaUltimaVacunacion = tc.nextLine();

        System.out.println("Seleccione la Especie:\n"
                + "1.Gato\n"
                + "2.Perro\n");

        String selleccionEspecie = tc.nextLine();
        switch (selleccionEspecie) {
            case "1":
                Gato mascotaGato = new Gato(nombreMas, edadm, raza, genero, altura, peso, propietario);
                mascotas.add(mascotaGato);
                break;
            case "2":
                Perro mascPerro = new Perro(nombreMas, edadm, raza, genero, altura, peso, propietario,
                        fechaUltimaVacunacion);
                mascotas.add(mascPerro);
                break;

            default:
                Mascota nuevMascota = new Mascota(nombreMas, edadm, Especie.otro, raza, genero, altura, peso,
                        propietario,
                        fechaUltimaVacunacion);
                mascotas.add(nuevMascota);
                break;
        }

        System.out.println("Mascota: " + nombreMas + " Agregada con Exito");
    }
     private static int comprobarstring(String word) {
        int val = 0;
        int valDos;
        try {
            valDos = Integer.parseInt(word);
        } catch (NumberFormatException e) {
            val = -1;
        }
        return val;
    }

    private static void crearPropietario() {
        // CREAR OBJETO PROPIETARIO

        Propietario nuevoPropietario = new Propietario();

        System.out.println("-----------REGISTRO CLIENTE------------");

        
        String nombre;
        int fOt = 0;
        do {
            System.out.println("Ingrese el nombre del propietario:");
            nombre = tc.nextLine();
            nuevoPropietario.setNombre(nombre);
            fOt = comprobarstring(nombre);
            if (fOt==0) {
                System.out.println("Valor invalido");
            }
            
        } while (fOt == 0);
        

        System.out.println("Ingrese el número de identificación del propietario:");
        String id = "";
        do {
            id = tc.nextLine();
            nuevoPropietario.setIdentificacion(id);
            for (int i = 0; i < propietarios.size(); i++) {
                Propietario m = propietarios.get(i);
                if (m.getIdentificacion().equals(id)) {
                    System.out.println("Ya exise un propietario con este id");
                    id = null;
                }
            }
        } while (id == null);
        

        System.out.println("Ingrese la dirección del propietario:");
        nuevoPropietario.setDireccion(tc.nextLine());

        System.out.println("Ingrese el correo:");
        nuevoPropietario.setCorreo(tc.nextLine());

        System.out.println("Ingrese el número de teléfono:");
        nuevoPropietario.setTelefono(tc.nextLine());

        propietarios.add(nuevoPropietario);

        System.out.println("Propietario: " + nuevoPropietario.getNombre() + " Agregado con Exito");

    }

    private static Propietario obtenerPropietarioPorIdentificacion(String identificaicon) {
        for (int i = 0; i < propietarios.size(); i++) {
            Propietario pro = propietarios.get(i);
            if (pro != null && pro.getIdentificacion().equals(identificaicon)) {
                return pro;
            }
        }
        return null;
    }

    private static Veterinario obtenerVeterinarioPorNumRegistro(int numRegistro) {
        for (int i = 0; i < veterinarios.size(); i++) {
            Veterinario vet = veterinarios.get(i);
            if (vet != null && vet.getNumeroRegistro() == numRegistro) {
                
                return vet;
            }
        }
        return null;
    }

    private static Mascota obtenerMascotaPorNombre(String nombreMascota) {
        for (int i = 0; i < mascotas.size(); i++) {
            Mascota mas = mascotas.get(i);
            if (mas != null && mas.getNombreMas().equals(nombreMascota)) {
                return mas;
            }
        }
        return null;
    }

    private static String mostrarMenuRecepcionista() {
        System.out.println("-------------------------------------------------\n"
                + "REGISTRO INFORMACIÓN CLIENTES\n"
                + "Seleccione una opcion\n"
                + "1. Registro propietario\n"
                + "2. Registro mascota\n"
                + "3. Agendar cita\n"
                + "4. Mostrar factura\n"
                + "5. Regresar al menu principal\n");

        String opcion = tc.next();
        tc.nextLine();
        return opcion;
    }

    private static int obtenerSerialNuevaCita() {
        int nuevaCitaSerial = citasTotales.size() + 1;
        return nuevaCitaSerial;
    }

    private static void consultarCitas() {
        for (int i = 0; i < citasTotales.size(); i++) {
            System.out.println(citasTotales.get(i).toString());
        }
    }

    // --------------------------------REGION VETERINARIO---------------------------
    private static void desplegarMenuVeterinario() {

    }
    // --------------------------------REGION
    // ESTADISTICAS---------------------------

    private static void desplegarMenuEstadisticas() {
        System.out.println(
                "-------------------------------------------------\n"
                + "ESTADISTICAS\n"
                + "Seleccione una opcion\n"
                + "1. Cantidad de mascotas atendidas hasta el momento con "
                + "porcentaje de perros y gatos\n"
                + "2. Cantidad de mascotas atendidas por cada veterinario\n"
                + "3. Medicamento más suministrado y la cantidad de veces suministrada\n"
                + "4. El paciente (mascota) más recurrente\n"
                + "5. Regresar al menu principal\n");
        String opcion = tc.next();

        switch (opcion) {
            case "1":
                verMascotasPorPorcentaje();
                break;
            case "2":
                verMascotasPorVeterinario();
                break;
            case "3":
                verMedicamentoMasFrecuente();
                break;
            case "4":
                verMascotaMasFrecuente();
                break;
            case "5":
                desplegarMenuPrincipal();
                break;
            default:
                System.out.println("Opcion incorrecta en el menu principal");
                break;
        }
        desplegarMenuEstadisticas();
    }

    private static void verMascotasPorPorcentaje() {
        System.out.println("-------------------------------------------------\n"
                + "ESTADISTICAS\n"
                + "Cantidad de mascotas atendidas hasta el momento con "
                + "porcentaje de perros y gatos");
    }

    private static void verMascotasPorVeterinario() {
        System.out.println("-------------------------------------------------\n"
                + "ESTADISTICAS\n"
                + "Cantidad de mascotas atendidas por cada veterinario");
        
        for (int i = 0; i < veterinarios.size(); i++) {
            veterinarios.get(i).toString();
            for (int j = 0; j < veterinarios.get(i).getCitas().size(); j++) {
                
            }
        }
    }

    private static void verMedicamentoMasFrecuente() {
        System.out.println("-------------------------------------------------\n"
                + "ESTADISTICAS\n"
                + "Medicamento más suministrado y la cantidad de veces suministrada");
    }

    private static void verMascotaMasFrecuente() {
        System.out.println("-------------------------------------------------\n"
                + "ESTADISTICAS\n"
                + "El paciente (mascota) más recurrente");
    }

}