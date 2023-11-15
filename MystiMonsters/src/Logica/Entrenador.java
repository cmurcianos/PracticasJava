package Logica;

public class Entrenador {
    private String nombre;
    private int salud;
    private int ataque;

    public Entrenador(String nombre, int salud, int ataque) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
    }

    public int atacar() {
        return ataque;
    }

    public void recibirDanio(int danio) {
        salud -= danio;
    }

    public boolean estaKO() {
        return salud <= 0;
    }

    public String getNombre() {
        return nombre;
    }
}
