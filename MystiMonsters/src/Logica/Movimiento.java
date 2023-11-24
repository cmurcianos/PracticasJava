package Logica;

import java.awt.event.KeyEvent;

public class Movimiento implements MovimientoListener {

    private MystiMonstersGUI gui;

    public Movimiento(MystiMonstersGUI gui) {
        this.gui = gui;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int step = 10;

        if (keyCode == KeyEvent.VK_LEFT) {
            if (gui.getEntrenadorX() - step >= 0) {
                gui.setEntrenadorX(gui.getEntrenadorX() - step);
                if (gui.getMapaActual() == 0 && gui.getEntrenadorX() == 0) {
                    gui.cambiarMapa(3);
                }
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            if (gui.getEntrenadorX() + step + 50 <= gui.getMapaAncho()) {
                gui.setEntrenadorX(gui.getEntrenadorX() + step);
                if (gui.getMapaActual() == 0 && gui.getEntrenadorX() >= 300) {
                    gui.cambiarMapa(4);
                } else if (gui.getMapaActual() == 4 && gui.getEntrenadorX() >= 300) {
                    gui.cambiarMapa(5);
                }
            }
        } else if (keyCode == KeyEvent.VK_UP) {
            if (gui.getEntrenadorY() - step >= 0) {
                gui.setEntrenadorY(gui.getEntrenadorY() - step);
                if (gui.getEntrenadorY() <= 0) {
                    if (gui.getMapaActual() == 0) {
                        gui.cambiarMapa(2);
                    } else if (gui.getMapaActual() == 3) {
                        gui.cambiarMapa(0);
                    }
                }
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {
            if (gui.getEntrenadorY() + step + 50 <= gui.getMapaAlto()) {
                gui.setEntrenadorY(gui.getEntrenadorY() + step);
                if (gui.getEntrenadorY() >= gui.getMapaAlto() - 50 && gui.getMapaActual() == 0) {
                    gui.cambiarMapa(1);
                }
            }
        } else if (keyCode == KeyEvent.VK_C) {
            gui.cambiarMapa(0);
        } else if (keyCode == KeyEvent.VK_M) {
            gui.mostrarMochila();
        }

        gui.verificarProximidad();

        if (gui.isCercaDeIgniverno()) {
            gui.mostrarVentanaCaptura();
        }

        gui.repaint();
    }
}
