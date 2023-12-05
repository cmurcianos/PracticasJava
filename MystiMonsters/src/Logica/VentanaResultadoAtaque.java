package Logica;

import javax.swing.*;
import java.awt.*;

public class VentanaResultadoAtaque {
    private Monstruo monstruo;
    private int ataqueSeleccionado;
    private Mapa mapa; // Agrega una instancia de la clase Mapa


    public VentanaResultadoAtaque(Monstruo monstruo, int ataqueSeleccionado) {
        this.monstruo = monstruo;
        this.ataqueSeleccionado = ataqueSeleccionado;

        this.mapa = mapa; // Inicializa la instancia de Mapa
    }

    public void mostrar() {
        // Crear el marco de la ventana de resultado
        JFrame ventanaResultado = new JFrame("Resultado del Ataque");

        // Crear un panel para agregar componentes
        JPanel panelResultado = new JPanel();

        // Crear etiqueta con el resultado del ataque
        JLabel etiquetaResultado = new JLabel("Ataque realizado: " + ataqueSeleccionado);
        JLabel etiquetaMensaje = new JLabel("Monstruo destruido y añadido a la mochila");



        // Agregar componentes al panel de resultado
        panelResultado.add(etiquetaResultado);
        panelResultado.add(etiquetaMensaje);

        // Configurar el marco de la ventana de resultado
        ventanaResultado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaResultado.setSize(300, 150);
        ventanaResultado.setLocationRelativeTo(null);
        ventanaResultado.add(panelResultado);
        ventanaResultado.setVisible(true);


        // Después de mostrar el mensaje, carga el mapa2.png
        if (mapa != null) {
            mapa.cargarNuevoMapa("Imagenes/mapa2.png");
        }
    }
}


	
	
	
}
