package Logica;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class MystiMonstersGUI extends JFrame {

    private JLabel background;
    private JLabel entrenador;
    private int entrenadorX; // Posición X del personaje
    private int entrenadorY; // Posición Y del personaje

    private final int mapaAncho = 400; // Ancho del mapa
    private final int mapaAlto = 600; // Alto del mapa

    private List<String> mapas; // Lista de nombres de mapas
    private int mapaActual; // Índice del mapa actual

    public MystiMonstersGUI() {
        setTitle("MystiMonsters Game");
        setSize(mapaAncho, mapaAlto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa la lista de mapas y el índice del mapa actual
        mapas = new ArrayList<>();
        mapas.add("Resources/mapa2.png");
        mapas.add("Resources/maparocapeque.png");
        mapaActual = 0;

        // Inicializa la posición del personaje
        entrenadorX = 100;
        entrenadorY = 400;

        // Configura el fondo con el mapa actual
        background = new JLabel(new ImageIcon(mapas.get(mapaActual)));
        background.setBounds(0, 0, mapaAncho, mapaAlto);

        // Configura el personaje "Entrenador"
        entrenador = new JLabel(new ImageIcon("Resources/entrenador.png"));
        entrenador.setBounds(entrenadorX, entrenadorY, 50, 50); // Tamaño a 50x50

        // Agrega el fondo al contenedor primero
        getContentPane().add(background);
        // Luego, agrega el personaje para que esté en la parte delantera
        getContentPane().add(entrenador, 0);

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
                    if (entrenadorX - step >= 0) {
                        entrenadorX -= step;
                    }
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    // Mover el personaje hacia la derecha
                    if (entrenadorX + step + 50 <= mapaAncho) {
                        entrenadorX += step;
                    }
                } else if (keyCode == KeyEvent.VK_UP) {
                    // Mover el personaje hacia arriba
                    if (entrenadorY - step >= 0) {
                        entrenadorY -= step;
                    }

                    // Verifica si el personaje ha llegado a la parte superior del mapa2.png
                    if (entrenadorY <= 0 && background.getIcon().toString().equals("Resources/mapa2.png")) {
                        // Cambia al mapa de "agua.png"
                        background.setIcon(new ImageIcon("Resources/agua.png"));
                    }
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    // Mover el personaje hacia abajo
                    if (entrenadorY + step + 50 <= mapaAlto) {
                        entrenadorY += step;
                    }

                    // Verifica si el personaje ha llegado al fondo del mapa
                    if (entrenadorY >= mapaAlto - 50) {
                        // Cambia al mapa de "maparocapeque.png"
                        background.setIcon(new ImageIcon("Resources/maparocapeque.png"));
                    }
                } else if (keyCode == KeyEvent.VK_C) {
                    // Cambia al mapa principal ("mapa2.png") al presionar la tecla "c"
                    background.setIcon(new ImageIcon("Resources/mapa2.png"));
                }

                // Actualiza la posición del personaje
                entrenador.setBounds(entrenadorX, entrenadorY, 50, 50);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar este método
            }
        });

        setFocusable(true); // Permite que la ventana obtenga el enfoque para capturar eventos de teclado
        requestFocusInWindow();  // Solicita el enfoque de la ventana para que pueda recibir eventos de teclado
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {  //Se encarga de iniciar la interfaz gráfica
            new MystiMonstersGUI();
        });
    }
}



