package veterinaria;

public class Perro extends Mascota {

    private String fechaUltimaVacunacion;
//constructor 

    public Perro(String fechaUltimaVacunacion) {

        this.fechaUltimaVacunacion = fechaUltimaVacunacion;
    }

    public String getfechaUltimaVacunacion() {
        return fechaUltimaVacunacion;
    }

    public void setfechaUltimaVacunacion(String fechaUltimaVacunacion) {
        this.fechaUltimaVacunacion = fechaUltimaVacunacion;
    }

    public Perro(String nombre, int edad, String raza, String genero, float altura, float peso,
            Propietario propietario, String fechaUltimaVacunacion) {
        super(nombre, edad, Especie.perro, raza, genero, altura, peso, propietario, fechaUltimaVacunacion);
    }

    

}
