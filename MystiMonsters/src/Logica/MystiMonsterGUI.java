

package Logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MystiMonsterGUI {
    private Mapa mapa;
    private JFrame frame;
    private boolean mochilaVisible;
    private VentanaBienvenida ventanaBienvenida;
    private Entrenador entrenador;


    public MystiMonsterGUI(Mapa mapa) {
        this.mapa = mapa;
        this.frame = new JFrame("MystiMonsters");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 625);
        this.frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        this.ventanaBienvenida = new VentanaBienvenida(frame);
        this.entrenador = new Entrenador(mapa); // Pasamos la referencia del mapa al entrenador

        // Crear el botón y agregarlo al panel del mapa
        JButton bienvenidaButton = new JButton("Mostrar Bienvenida");
        bienvenidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaBienvenida();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bienvenidaButton);

        // Crear el panel que contendrá la imagen del mapa y el botón
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                mapa.getMapaManager().drawMapSpecificImages(g, mapa.getBackgroundImage());
            }
        }, BorderLayout.CENTER);

        // Agregar el panel principal al frame
        frame.getContentPane().add(mainPanel);

        this.mochilaVisible = false;

    }

    private void mostrarVentanaBienvenida() {
        ventanaBienvenida.setVisible(true);

        // Después de cerrar la ventana de bienvenida, mostrar la imagen del entrenador
        if (!ventanaBienvenida.isVisible()) {
            mostrarEntrenador();
        }
    }

    private void mostrarEntrenador() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(entrenador, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
    }

    public void mostrarInterfaz() {
        frame.setVisible(true);
    }
}
