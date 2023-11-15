package Logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MystiMonstersGUI extends JFrame {

    private BufferedImage backgroundImage;
    private BufferedImage floraflameImage;
    private BufferedImage entrenadorImage;

    private int entrenadorX;
    private int entrenadorY;

    private final int mapaAncho = 400;
    private final int mapaAlto = 600;

    private List<String> mapas;
    private int mapaActual;

    public MystiMonstersGUI() {
        super("MystiMonsters");

        try {
            // Carga la imagen inicial del mapa (mapa2.png)
            backgroundImage = ImageIO.read(new File("Resources/mapa2.png"));
            // Carga la imagen de Floraflame
            floraflameImage = ImageIO.read(new File("Resources/floraflame.png"));
            // Carga la imagen del entrenador
            entrenadorImage = ImageIO.read(new File("Resources/entrenador.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawImages(g);
            }
        };

        add(panel);

        // Configuración básica de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Inicializa la lista de mapas
        mapas = new ArrayList<>();
        mapas.add("Resources/mapa2.png");
        mapas.add("Resources/maparocapeque.png");
        mapas.add("Resources/agua.png");
        mapas.add("Resources/fuego.png");
        mapaActual = 0;

        // Inicializa la posición del personaje
        entrenadorX = 100;
        entrenadorY = 400;

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

                        // Cambia al mapa de "fuego.png" cuando estás en la izquierda de "mapa2.png"
                        if (mapaActual == 0 && entrenadorX == 0) {
                            mapaActual = 3;
                            backgroundImage = loadImage(mapas.get(mapaActual));
                        }
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

                    // Cambia el mapa según la ubicación del entrenador
                    if (entrenadorY <= 0 && mapaActual == 0) {
                        // Cambia al mapa de "agua.png" cuando estás arriba del mapa2.png
                        mapaActual = 2;
                        backgroundImage = loadImage(mapas.get(mapaActual));
                        entrenadorY = mapaAlto - 50;
                    } else if (entrenadorY <= 0 && mapaActual == 3) {
                        // Cambia al mapa de "mapa2.png" cuando estás arriba del fuego.png
                        mapaActual = 0;
                        backgroundImage = loadImage(mapas.get(mapaActual));
                        entrenadorY = mapaAlto - 50;
                    }
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    // Mover el personaje hacia abajo
                    if (entrenadorY + step + 50 <= mapaAlto) {
                        entrenadorY += step;
                    }

                    // Cambia el mapa cuando estás en la parte inferior del mapa2.png
                    if (entrenadorY >= mapaAlto - 50 && mapaActual == 0) {
                        // Cambia al mapa de "maparocapeque.png"
                        mapaActual = 1;
                        backgroundImage = loadImage(mapas.get(mapaActual));
                        entrenadorY = 0;
                    }
                } else if (keyCode == KeyEvent.VK_C) {
                    // Cambia al mapa principal ("mapa2.png") al presionar la tecla "c"
                    mapaActual = 0;
                    backgroundImage = loadImage(mapas.get(mapaActual));
                    entrenadorY = 400;
                }

                // Actualiza la posición del personaje
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar este método
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    private void drawImages(Graphics g) {
        if (backgroundImage != null && floraflameImage != null) {
            // Dibuja la imagen del mapa
            g.drawImage(backgroundImage, 0, 0, null);

            // Dibuja la imagen de Floraflame en una posición específica
            int floraflameX = 100; // Posición X de Floraflame en el mapa
            int floraflameY = 150; // Posición Y de Floraflame en el mapa
            g.drawImage(floraflameImage, floraflameX, floraflameY, null);

            // Dibuja la imagen del entrenador en la posición actual
            g.drawImage(entrenadorImage, entrenadorX, entrenadorY, null);
        }
    }

    private BufferedImage loadImage(String fileName) {
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MystiMonstersGUI());
    }
}


