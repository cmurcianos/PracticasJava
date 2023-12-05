package Logica;

import javax.swing.*;
import java.awt.*;

public class BarraDeVidaDialog extends JDialog {

    public BarraDeVidaDialog(JFrame parent, Monstruo monstruo) {
        super(parent, "Barra de Vida", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(200, 100);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Vida de " + monstruo.getNombre());
        panel.add(label, BorderLayout.NORTH);

        JProgressBar progressBar = new JProgressBar(0, monstruo.getVidaMaxima());
        progressBar.setValue(monstruo.getVidaActual());
        progressBar.setStringPainted(true);
        panel.add(progressBar, BorderLayout.CENTER);

        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(e -> dispose());
        panel.add(cerrarButton, BorderLayout.SOUTH);

        setContentPane(panel);
    }
}
