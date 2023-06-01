
package veterinaria;

public class Gato extends Mascota {
    private String raza;

    // constructor
    public Gato(String raza) {

        this.raza = raza;
    }

    @Override
    public String getRaza() {
        return raza;
    }

    @Override
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Gato(String nombre, int edad, String raza, String genero, float altura, float peso,
            Propietario propietario) {

        super(nombre, edad, Especie.gato, raza, genero, altura, peso, propietario, "");
    }

}