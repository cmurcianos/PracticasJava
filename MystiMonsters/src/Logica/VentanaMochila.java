
package Logica;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class VentanaMochila extends JDialog {
    private Mochila mochila;

    public VentanaMochila(JFrame parent, Mochila mochila) {
        super(parent, "Mochila", true);
        this.mochila = mochila;
        this.setSize(300, 150);
        this.setLocationRelativeTo(parent);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarElementosMochila(g);
            }
        };

        this.getContentPane().add(panel, BorderLayout.CENTER);
        // Agregar etiqueta para "Elementos de la mochila"
        JLabel etiquetaMochila = new JLabel("Elementos de la mochila: ");
        panel.add(etiquetaMochila);
    }

    private void dibujarElementosMochila(Graphics g) {
        int mochilaX = this.getWidth() - mochila.getMochilaImage().getWidth();
        int mochilaY = 0;
        g.drawImage(mochila.getMochilaImage(), mochilaX, mochilaY, this);

        // Aquí puedes agregar lógica para dibujar elementos específicos de la mochila si los tienes
    }
}

