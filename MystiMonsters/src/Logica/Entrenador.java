
package Logica;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Entrenador extends JPanel {
    private BufferedImage entrenadorImage;
    private int x, y; // Posición del entrenador
    private Mapa mapa; // Referencia al mapa
    private Mochila mochila;

    private Monstruo monstruoActual;  // Agrega esta propiedad

    private int vidaMaxima;
    private int vidaActual;


    public Entrenador(Mapa mapa) {
        this.mapa = mapa;
        this.mochila = new Mochila();

        vidaMaxima = 100; // Puedes ajustar este valor según sea necesario
        vidaActual = vidaMaxima;

        try {
            entrenadorImage = ImageIO.read(new File("Imagenes/entrenador.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 100;
        y = 100;

        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No es necesario implementar keyTyped para este caso
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                    mostrarMochila();
                } else {
                    moverEntrenador(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar keyReleased para este caso
            }
        });

        Timer timer = new Timer(16, e -> repaint());
        timer.start();
    }

    private void moverEntrenador(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int speed = 5;

        if (keyCode == KeyEvent.VK_LEFT) {
            x -= speed;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            x += speed;
        } else if (keyCode == KeyEvent.VK_UP) {
            y -= speed;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            y += speed;
        }

        repaint();
        mapa.actualizarMapa(x, y, entrenadorImage.getWidth(), entrenadorImage.getHeight());

    }

    private void mostrarMochila() {
        VentanaMochila ventanaMochila = new VentanaMochila((JFrame) SwingUtilities.getWindowAncestor(this), mochila);
        ventanaMochila.setVisible(true);
    }

    private void atacarLanzallamas() {
        if (monstruoActual != null && monstruoActual.isVisible()) {
            monstruoActual.recibirDanio(monstruoActual.getVidaMaxima() / 2);
            JOptionPane.showMessageDialog(null, "¡Has usado Ataque Lanzallamas!\n" +
                    "¡" + monstruoActual.getNombre() + " ha recibido daño!");
        }
    }

    // Modificar verificarColision para asignar monstruoActual


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mapa.getBackgroundImage(), 0, 0, this); // Dibuja el fondo del mapa
        g.drawImage(entrenadorImage, x, y, this);

        dibujarBarraDeVida(g);
    }

    public void recibirDanio(int danio) {
        vidaActual -= danio;
        if (vidaActual <= 0) {
            // Realizar acciones si la vida llega a cero (por ejemplo, reiniciar juego)
        }
        repaint(); // Actualizar la barra de vida al recibir daño
    }

    private void dibujarBarraDeVida(Graphics g) {
        int barraWidth = 100;
        int barraHeight = 10;

        g.setColor(Color.RED);
        g.fillRect(x, y - 15, barraWidth, barraHeight);  // Barra de vida completa en rojo
        g.setColor(Color.GREEN);
        int vidaPorcentaje = (int) Math.ceil((double) vidaActual / vidaMaxima * barraWidth);
        g.fillRect(x, y - 15, vidaPorcentaje, barraHeight);  // Barra de vida actual en verde
    }


    public Mochila getMochila() {
        return mochila;
    }
}
