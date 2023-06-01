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
    public class Cita {
    static  final int ESTADO_ENCURSO=2;	
    static final int ESTADO_ACTIVO =1;
    static final int ESTADO_INACTIVO =0;
    // declaracion de variables
        
        private static int serial = 1;
    private int numSerial;

    public Cita() {
        this.numSerial = serial;
        serial++;
    }
    
    
    
    
        
        

       	
        private Date fecha;
        private Time hora;
        private Time duracion;
        private int estadoCita;
        // estas son las clases con las se relaciona.
        private Veterinario veterinario;
        private Mascota mascota;
    // constructor vacio 
        // cita necesita tener un numero de serial obligatorio 

        public Cita(int numSerial) {
            this.numSerial = serial;
            this.fecha = null;
            this.hora = null;
            this.duracion = null;
            this.estadoCita = Cita.ESTADO_INACTIVO;
            // son objetos vacios que tiene la cita y una relacion con el veterinario y la mascota
            this.veterinario = new Veterinario();
            this.mascota = new Mascota();
        }
    // construcctor con parametros. 

        public Cita(int numSerial, Date fecha, Time hora, Time duracion, int estadoCita, Veterinario veterinario, Mascota mascota) {
            this.numSerial = numSerial;
            this.fecha = fecha;
            this.hora = hora;
            this.duracion = duracion;
            this.estadoCita = estadoCita;
            this.veterinario = veterinario;
            this.mascota = mascota;
        }

    // getters and setters 
        // no tiene el sett de numero de serial porque este valor no debe ser modificable
        public int getNumSerial() {
            return numSerial;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public Time getHora() {
            return hora;
        }

        public void setHora(Time hora) {
            this.hora = hora;
        }

        public Time getDuracion() {
            return duracion;
        }

        public void setDuracion(Time duracion) {
            this.duracion = duracion;
        }

        public int getEstadoCita() {
            return estadoCita;
        }

        public void setEstadoCita(int estadoCita) {
            this.estadoCita = estadoCita;
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

        @Override
        public String toString() {
            return "Cita{" + "numSerial=" + numSerial + ", fecha=" + fecha + ", hora=" + hora + ", duracion=" + duracion + ", estadoCita=" + estadoCita + ", veterinario=" + veterinario + ", mascota=" + mascota + '}';
        }

    }
