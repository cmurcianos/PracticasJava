package Logica;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MystiMonstersGUI extends JFrame {

    private JLabel background;
    private JLabel entrenador;
    private int entrenadorX; // Posición X del personaje
    private int entrenadorY; // Posición Y del personaje

    public MystiMonstersGUI() {
        setTitle("MystiMonsters Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa la posición del personaje
        entrenadorX = 100;
        entrenadorY = 400;

        // Configura el fondo
        background = new JLabel(new ImageIcon("resources/mapa2.png"));
        background.setBounds(0, 0, 800, 600);

        // Configura el personaje "Entrenador" y hazlo más pequeño
        entrenador = new JLabel(new ImageIcon("resources/entrenador.png"));
        entrenador.setBounds(entrenadorX, entrenadorY, 50, 50); // Cambia el tamaño a 50x50

        // Agrega el fondo al contenedor primero para que esté en la parte posterior
        getContentPane().add(background);
        // Luego, agrega el personaje para que esté en la parte delantera
        getContentPane().add(entrenador,0);
        
        
        setLayout(null);  // Usamos un diseño absoluto para posicionar los componentes
        setVisible(true);

        // Agrega un KeyListener para controlar el movimiento del personaje
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No es necesario implementar este método
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int step = 10; // Cantidad de píxeles para mover al personaje

                if (keyCode == KeyEvent.VK_LEFT) {
                    // Mover el personaje hacia la izquierda
                    entrenadorX -= step;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    // Mover el personaje hacia la derecha
                    entrenadorX += step;
                } else if (keyCode == KeyEvent.VK_UP) {
                    // Mover el personaje hacia arriba
                    entrenadorY -= step;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    // Mover el personaje hacia abajo
                    entrenadorY += step;
                }

                // Actualizar la posición del personaje
                entrenador.setBounds(entrenadorX, entrenadorY, 50, 50);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar este método
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MystiMonstersGUI();
        });
    }
}

