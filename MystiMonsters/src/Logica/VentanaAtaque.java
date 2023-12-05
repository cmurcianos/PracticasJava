package Logica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAtaque {
    private int ataqueSeleccionado;
    private ActionListener onAtaqueSeleccionadoListener;

    public VentanaAtaque() {
    }

    public void mostrar() {
        // Crear el marco de la ventana
        JFrame ventana = new JFrame("Ventana de Ataque");

        // Crear un panel para agregar componentes
        JPanel panel = new JPanel();

        // Crear etiqueta y botones
        JLabel etiqueta = new JLabel("Selecciona un ataque:");
        JButton ataque1 = new JButton("Ataque 1");
        JButton ataque2 = new JButton("Ataque 2");

        // Agregar componentes al panel
        panel.add(etiqueta);
        panel.add(ataque1);
        panel.add(ataque2);

        // Agregar acción al botón de Ataque 1
        ataque1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ataqueSeleccionado = 1;  // Marcar que se ha seleccionado el Ataque 1
                System.out.println("Ataque 1 seleccionado");
                notificarSeleccion();

                mostrarResultadoAtaque();
                ventana.dispose();  // Cerrar la ventana de ataque después de seleccionar
            }
        });

        // Agregar acción al botón de Ataque 2
        ataque2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ataqueSeleccionado = 2;  // Marcar que se ha seleccionado el Ataque 2
                System.out.println("Ataque 2 seleccionado");
                notificarSeleccion();
                mostrarResultadoAtaque();
                ventana.dispose();  // Cerrar la ventana de ataque después de seleccionar
            }
        });

        // Configurar el marco de la ventana
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(300, 150);
        ventana.setLocationRelativeTo(null);
        ventana.add(panel);
        ventana.setVisible(true);
    }

    public void setOnAtaqueSeleccionadoListener(ActionListener listener) {
        this.onAtaqueSeleccionadoListener = listener;
    }

    private void notificarSeleccion() {
        if (onAtaqueSeleccionadoListener != null) {
            onAtaqueSeleccionadoListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
        }
    }

    private void mostrarResultadoAtaque() {
        // Crear la ventana de resultado de ataque
        Monstruo monstruo = null;
        VentanaResultadoAtaque resultadoAtaque = new VentanaResultadoAtaque(monstruo, ataqueSeleccionado);
        resultadoAtaque.mostrar();
    }

    public int getAtaqueSeleccionado() {
        return ataqueSeleccionado;
    }
}

