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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class MystiMonstersGUI extends JFrame implements MovimientoListener{

        private BufferedImage backgroundImage;
        private BufferedImage floraflameImage;
        private BufferedImage ignivernoImage;
        private BufferedImage rocluminisImage;
        private BufferedImage entrenadorImage;
        private BufferedImage mochilaImage;

        private Point mochilaPosition;
        private int entrenadorX;
        private int entrenadorY;

        private final int mapaAncho = 400;
        private final int mapaAlto = 600;

        private List<String> mapas;
        private int mapaActual;

    private Map<Integer, Boolean> mostrarImagenesMap;

    private boolean floraflameEnAgua = false;
    private boolean cercaDeIgniverno = false;
    private final int distanciaProximidad = 50;

    private int saludEntrenador = 100;
    private int saludIgniverno = 100;

    private List<String> mochila;


    private Movimiento movimiento;



    public int getEntrenadorX() {
            return entrenadorX;
        }
    public int getEntrenadorY() {
            return entrenadorY;
        }
     public void setEntrenadorX(int x) {
            entrenadorX = x;
        }
     public void setEntrenadorY(int y) {
            entrenadorY = y;
        }
        public int getMapaAncho() {
            return mapaAncho;
        }
        public int getMapaAlto() {
            return mapaAlto;
        }
        public int getMapaActual() {
            return mapaActual;
        }
        public boolean isCercaDeIgniverno() {
            return cercaDeIgniverno;
        }

    public MystiMonstersGUI() {
        super("MystiMonsters");



        // Inicializa la mochila
        mochila = new ArrayList<>();

        movimiento = new Movimiento(this);


        try {
            backgroundImage = ImageIO.read(new File("Resources/mapa2.png"));
            floraflameImage = ImageIO.read(new File("Resources/floraflame.png"));
            ignivernoImage = ImageIO.read(new File("Resources/igniverno.png"));
            rocluminisImage = ImageIO.read(new File("Resources/rocluminis.png"));
            entrenadorImage = ImageIO.read(new File("Resources/entrenador.png"));
            mochilaImage = ImageIO.read(new File("Resources/mochila.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mochilaPosition = new Point(getWidth() - mochilaImage.getWidth(), getHeight() - mochilaImage.getHeight());
        mapas = new ArrayList<>();
        mapas.add("Resources/mapa2.png");
        mapas.add("Resources/maparocapeque.png");
        mapas.add("Resources/agua.png");
        mapas.add("Resources/fuego.png");
        mapaActual = 0;

        entrenadorX = 100;
        entrenadorY = 400;

        mostrarImagenesMap = new HashMap<>();
        mostrarImagenesMap.put(0, false);
        mostrarImagenesMap.put(3, false);
        mostrarImagenesMap.put(1, false);
        mostrarImagenesMap.put(2, false);

        mochilaPosition = new Point(getWidth() - 40, getHeight() - 70);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawImages(g);
            }
        };

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No es necesario implementar este método
            }

            @Override
            public void keyPressed(KeyEvent e) {
                movimiento.keyPressed(e);
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
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, null);
            drawMapSpecificImages(g);
            g.drawImage(entrenadorImage, entrenadorX, entrenadorY, null);
            drawHealthBars(g);

            if (mochilaImage != null) {
                g.drawImage(mochilaImage, mochilaPosition.x, mochilaPosition.y, null);
            }
        }
    }

    private void drawMapSpecificImages(Graphics g) {
        switch (mapaActual) {
            case 0:
                if (mostrarImagenesMap.get(0) && !floraflameEnAgua) {
                    int floraflameX = 100;
                    int floraflameY = 150;
                    g.drawImage(floraflameImage, floraflameX, floraflameY, null);
                }
                break;
            case 3:
                boolean enBatallaConIgniverno = false;
                if (mostrarImagenesMap.get(3) && !enBatallaConIgniverno) {
                    int ignivernoX = 100;
                    int ignivernoY = 150;
                    g.drawImage(ignivernoImage, ignivernoX, ignivernoY, null);
                }
                break;
            case 1:
                int rocluminisX = (mapaAncho - rocluminisImage.getWidth()) / 2;
                int rocluminisY = (mapaAlto - rocluminisImage.getHeight()) / 2;
                g.drawImage(rocluminisImage, rocluminisX, rocluminisY, null);
                break;
            case 2:
                if (mostrarImagenesMap.get(2)) {
                    int floraflameX = 100;
                    int floraflameY = 150;
                    g.drawImage(floraflameImage, floraflameX, floraflameY, null);
                    floraflameEnAgua = true;
                }
                break;
        }
    }

    private void drawHealthBars(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(10, 10, saludEntrenador * 2, 20);
        g.setColor(Color.BLACK);
        g.drawString("Entrenador", 10, 40);

        if (cercaDeIgniverno) {
            g.setColor(Color.BLUE);
            g.fillRect(10, 60, saludIgniverno * 2, 20);
            g.setColor(Color.BLACK);
            g.drawString("Igniverno", 10, 90);
        }
    }

    void verificarProximidad() {
        int ignivernoX = 100;
        int ignivernoY = 150;
        int distancia = (int) Math.sqrt(Math.pow(entrenadorX - ignivernoX, 2) + Math.pow(entrenadorY - ignivernoY, 2));
        cercaDeIgniverno = distancia < distanciaProximidad;
    }

    void cambiarMapa(int nuevoMapa) {
        mapaActual = nuevoMapa;
        backgroundImage = loadImage(mapas.get(mapaActual));
        ocultarImagenesEspecificas();
        floraflameEnAgua = false;
        mostrarImagenesMap.put(mapaActual, true);
    }

    private void ocultarImagenesEspecificas() {
        mostrarImagenesMap.replaceAll((k, v) -> false);
    }

    private BufferedImage loadImage(String fileName) {
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    void mostrarVentanaCaptura() {
        int option = JOptionPane.showOptionDialog(this,
                "Te has encontrado con Igniverno, ¿Quieres capturarlo?",
                "Encuentro con Igniverno",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"SI", "NO"},
                "SI");

        if (option == JOptionPane.YES_OPTION) {
            mostrarVentanaAtaques();
        } else {
            System.out.println("Has decidido no capturar a Igniverno");
        }
    }

    private void mostrarVentanaAtaques() {
        Object[] ataques = {"Lanzallamas", "Bomba de fuego", "MOAB"};
        Object seleccion = JOptionPane.showInputDialog(this,
                "Selecciona un ataque:",
                "Ataques",
                JOptionPane.PLAIN_MESSAGE,
                null,
                ataques,
                ataques[0]);

        if (seleccion != null) {
            String ataqueSeleccionado = seleccion.toString();
            mostrarInformacionAtaque(ataqueSeleccionado);
        }
    }

    private void mostrarInformacionAtaque(String ataque) {
        String mensaje = "";
        if (ataque.equals("Lanzallamas")) {
            mensaje = "Informacion ataque Lanzallamas: Se trata de un ataque muy fuerte pero poco dañino a los MystiMonster de fuego, esto restará una puntuacion de 25 pts";
        } else if (ataque.equals("Bomba de fuego")) {
            mensaje = "Muy dañino por la explosión, restará 50 pts";
        } else if (ataque.equals("MOAB")) {
            mensaje = "Bomba ultrasónica, que resta 75 pts";
        }

        int option = JOptionPane.showOptionDialog(this,
                mensaje + "\n¿Quieres utilizar este ataque?",
                "Información del Ataque",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Utilizar", "No utilizar"},
                "Utilizar");

        if (option == JOptionPane.YES_OPTION) {
            realizarAtaque(ataque);
        } else {
            mostrarVentanaAtaques();
        }
    }

    private void realizarAtaque(String ataque) {
        boolean ataqueRealizado = true;
        int puntuacionAleatoria = (int) (Math.random() * 21) + 10;
        saludIgniverno -= puntuacionAleatoria;
        mochila.add(ataque);
        System.out.println("¡Ataque " + ataque + " ejecutado con puntuación " + puntuacionAleatoria + "!");
        repaint();
    }

    void mostrarMochila() {
        StringBuilder contenidoMochila = new StringBuilder("Contenido de la Mochila:\n");
        if (mochila.isEmpty()) {
            contenidoMochila.append("La mochila está vacía.");
        } else {
            for (String item : mochila) {
                contenidoMochila.append("- ").append(item).append("\n");
            }
        }

        JOptionPane.showMessageDialog(this, contenidoMochila.toString(), "Mystidex Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MystiMonstersGUI());
    }

        @Override
        public void keyPressed(KeyEvent e) {

        }
    }

