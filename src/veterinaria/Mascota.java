package veterinaria;

/**
 *
 * @author Bullrock
 */
public class Mascota {
// declaracion de los atributos

    private String nombreMas;
    private int edad;
    private Especie especie;
    private String raza;
    private String genero;
    private float altura;
    private float peso;
    private Propietario propietario;
    private HistorialMedico historialMedico;
    private String fechaUltimaVacunacion;

    enum Especie {
        perro,
        gato,
        otro
    }

    //constructor en vacio
    public Mascota() {
        nombreMas = "";
        edad = 0;
        especie = Especie.otro;
        raza = "";
        genero = "";
        altura = 0;
        peso = 0;
        fechaUltimaVacunacion = "";

        // esta variable es para poder interactuar con la clase propietario
        propietario = new Propietario();
        historialMedico = new HistorialMedico();
    }

    //constructor con parametros
    public Mascota(String nombre, int edad, Especie especie, String raza, String genero, float altura, float peso, Propietario propietario,String fechaUltimaVacunacion) {
        this.nombreMas = nombre;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.propietario = propietario;
        this.fechaUltimaVacunacion = fechaUltimaVacunacion;
    }

    public String getNombreMas() {
        return nombreMas;
    }

    public void setNombreMas(String nombre) {
        this.nombreMas = nombre;

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getFechaUltimaVacunacion() {
        return fechaUltimaVacunacion;
    }

    public void setFechaUltimaVacunacion(String fechaUltimaVacunacion) {
        this.fechaUltimaVacunacion = fechaUltimaVacunacion;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombreMas=" + nombreMas + ", edad=" + edad + ", especie=" + especie + ", raza=" + raza + ", genero=" + genero + ", altura=" + altura + ", peso=" + peso + ", propietario=" + propietario + ", fechaUltimaVacunacion=" + fechaUltimaVacunacion + '}';
    }

}
