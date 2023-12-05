// AtaqueHandler.java
package Logica;

public class AtaqueHandler {

    public static void ejecutarAtaque(Entrenador entrenador, Mochila mochila) {
        // Simulate attack logic
        // You can customize this logic based on your game requirements
        System.out.println("Ataque mortal. Monstruo destruido y añadido a la mochila");

        // Assume you have a Monstruo object that represents the defeated Monstruo
        Monstruo monstruo;
        monstruo = new Monstruo("Defeated Monstruo");

        // Add the defeated Monstruo to the mochila
        mochila.agregarMonstruo(monstruo);

        // Move the entrenador back to the mapa principal
        entrenador.setLocation(mochila.MAPA_PRINCIPAL);
    }
}
