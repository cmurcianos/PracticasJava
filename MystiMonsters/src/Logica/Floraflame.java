package Logica;

public class Floraflame extends MystiMonstersGeneral implements IPlanta, IFuego{


    private int poderFuego;

    public Floraflame(String nombre, int salud, int ataque, int defensa, int poderFuego) {
        super(nombre, salud, ataque, defensa);
        this.poderFuego = poderFuego;
    }

    @Override
    public void controlarLlamasNaturaleza() {
        // Implementación de controlar llamas de la naturaleza
    }

    @Override
    public void controlarLlamas() {
        // Implementación de controlar llamas
    }

    @Override
    public void controlarCalor() {
        // Implementación de controlar calor
    }

   /* public void ataqueFuego(MystiMonsters enemigo) {
        enemigo.recibirAtaque(this.poderFuego);
    }
*/



}
