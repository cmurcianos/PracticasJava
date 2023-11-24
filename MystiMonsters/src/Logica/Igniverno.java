package Logica;


public class Igniverno extends MystiMonstersGeneral implements IFuego {


    public static Object getSalud;
    private Ataque fuegoPrimario;
    private Ataque fuegoSecundario;

    public Igniverno(String nombre, int salud, int ataque, int defensa) {
        super(nombre, salud, ataque, defensa);

        // Inicializa los ataques de Igniverno
        fuegoPrimario = new Ataque("Llamarada", 30);
        fuegoSecundario = new Ataque("Inferno", 40);
    }

    @Override
    public void controlarLlamasNaturaleza() {
        // Implementa la lógica para controlar las llamas de la naturaleza
    }

    @Override
    public void controlarLlamas() {
        // Implementa la lógica para controlar las llamas
    }

    @Override
    public void controlarCalor() {
        // Implementa la lógica para controlar el calor
    }

    public Ataque getFuegoPrimario() {
        return fuegoPrimario;
    }

    public Ataque getFuegoSecundario() {
        return fuegoSecundario;
    }

    public int getSalud() {
        int salud = 0;
        return salud;
    }
}
