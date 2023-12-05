
package Logica;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Mapa mapa = new Mapa();
            mapa.getGui().mostrarInterfaz();
        });
    }

}
