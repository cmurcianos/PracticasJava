
package Logica;

import java.awt.*;

public class Flecha {
    private int x, y;
    private int size;
    private Direccion direccion;

    public Flecha(int x, int y, int size, Direccion direccion) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.direccion = direccion;
    }

    public void dibujar(Graphics g) {
        // Implementa la lógica para dibujar la flecha en la posición (x, y)
        g.setColor(Color.BLACK);
        g.fillRect(x, y, size, size);

        // Dibuja una flecha simple
        int[] xPoints, yPoints;

        switch (direccion) {
            case ARRIBA:
                xPoints = new int[]{x, x + size / 2, x + size};
                yPoints = new int[]{y + size, y, y + size};
                break;
            case ABAJO:
                xPoints = new int[]{x, x + size / 2, x + size};
                yPoints = new int[]{y, y + size, y};
                break;
            case IZQUIERDA:
                xPoints = new int[]{x + size, x, x + size};
                yPoints = new int[]{y, y + size / 2, y + size};
                break;
            case DERECHA:
                xPoints = new int[]{x, x + size, x};
                yPoints = new int[]{y, y + size / 2, y + size};
                break;
            default:
                xPoints = new int[]{};
                yPoints = new int[]{};
        }

        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    public boolean entrenadorEnContacto(int entrenadorX, int entrenadorY, int entrenadorWidth, int entrenadorHeight) {
        // Verifica si el entrenador está en contacto con la flecha
        return entrenadorX < x + size &&
                entrenadorX + entrenadorWidth > x &&
                entrenadorY < y + size &&
                entrenadorY + entrenadorHeight > y;
    }

    public Direccion getDireccion() {
        return direccion;
    }


}


