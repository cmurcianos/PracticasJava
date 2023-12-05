
package Logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaBienvenida extends JDialog {
    private JTextArea mensajeBienvenida;

    public VentanaBienvenida(JFrame parent) {
        super(parent, "Bienvenida", true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(parent);

        this.mensajeBienvenida = new JTextArea("¡Bienvenido al juego MystiMonsters and go!\n"
                + "Estás en el mapa principal. Tu misión es capturar a todos los mystiMonsters posibles para acabar el juego.\n"
                + "Te presento al entrenador. Con él podrás capturar mystiMonsters y moverte por los distintos mapas.\n "
                + "También tendrás acceso a la mochila pulsando la letra 'C' .Podrás visualizar su contenido en el que aparecerán los mystiMonsters capturados.");
        this.mensajeBienvenida.setEditable(false);
        this.mensajeBienvenida.setLineWrap(true);
        this.mensajeBienvenida.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(mensajeBienvenida);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No es necesario implementar keyTyped para este caso
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dispose(); // Cerrar la ventana al presionar Enter
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar keyReleased para este caso
            }
        });

        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cerrarButton);

        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
}

