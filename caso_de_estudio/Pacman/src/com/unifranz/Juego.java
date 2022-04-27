package com.unifranz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Juego extends JPanel implements ActionListener {
    //Atributos
    private Dimension d;
    private Image heart;
    private Image ghost;
    private Image up;
    private Image down, left, right;

    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private boolean estaInicializadoElJuego = false;
    private boolean estaMuerto = false;


    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private final int MAX_GHOSTS = 12;
    private final int PACMAN_SPEED = 6;

    private int N_GHOSTS = 6;
    private int vidas, puntaje;
    private int[] dx, dy;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;

    private int pacman_x, pacman_y, pacmand_x, pacmand_y;
    private int req_dx, req_dy;

    //Definimos la forma del tablero o escenario
    //16 representará los "o"
    //
    private final short levelData[] = {
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
            17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
            21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
            17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 0, 0, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };

    private final int validSpeeds[] = {1, 2, 3, 4, 6, 8};
    private final int maxSpeed = 6;

    private int actualVelocidad = 3;
    private short[] screenData;
    private Timer tiempo;

    //Contructor
    public Juego() {
        System.out.println("Creando el juego");
        cargarImagenes();

        inicializarVariables();

        //Agregamos el control de teclado
        addKeyListener(new ControlDeTeclado());

        setFocusable(true);

        inicializarConfiguracionJuego();
    }

    private void cargarImagenes() {
        down = new ImageIcon(getClass().getResource("/assets/imagenes/down.gif")).getImage();
        up = new ImageIcon(getClass().getResource("/assets/imagenes/up.gif")).getImage();
        left = new ImageIcon(getClass().getResource("/assets/imagenes/left.gif")).getImage();
        right = new ImageIcon(getClass().getResource("/assets/imagenes/right.gif")).getImage();
        ghost = new ImageIcon(getClass().getResource("/assets/imagenes/ghost.gif")).getImage();
        ghost = new ImageIcon(getClass().getResource("/assets/imagenes/ghost.gif")).getImage();
        heart = new ImageIcon(getClass().getResource("/assets/imagenes/heart.png")).getImage();
    }

    public void inicializarVariables() {
        screenData = new short[N_BLOCKS * N_BLOCKS];
        d = new Dimension(400, 400);
        ghost_x = new int[MAX_GHOSTS];
        ghost_dx = new int[MAX_GHOSTS];
        ghost_y = new int[MAX_GHOSTS];
        ghost_dy = new int[MAX_GHOSTS];
        ghostSpeed = new int[MAX_GHOSTS];
        dx = new int[4];
        dy = new int[4];

        tiempo = new Timer(40, this);
        tiempo.start();
    }

    private void playGame(Graphics2D g2d) {
        if (estaMuerto) {
            perderVida();
        } else {
            //Mover el pacman
            moverPacman();
            dibujarPacman(g2d);
            //Mover a los enemigos
            moverFantasmita(g2d);
            verificarLaberinto();
        }
    }

    private void verificarLaberinto() {
        int i = 0;
        boolean finished = true;

        while (i < N_BLOCKS * N_BLOCKS && finished) {
            if ((screenData[i]) != 0) {
                finished = false;
            }
            i++;
        }

        if (finished) {
            puntaje += 50;
            if (N_GHOSTS < MAX_GHOSTS) {
                N_GHOSTS++;
            }

            if (actualVelocidad < maxSpeed) {
                actualVelocidad++;
            }

            inicializarNivel();
        }
    }

    private void perderVida() {
        vidas--;

        if (vidas == 0) {
            estaInicializadoElJuego = false;
        }

        continuarNivel();
    }

    private void moverFantasmita(Graphics2D g2d) {
        int posicion;
        int contador;

        for (int i = 0; i < N_GHOSTS; i++) {
            if (ghost_x[i] % BLOCK_SIZE == 0 && ghost_y[i] % BLOCK_SIZE == 0) {
                posicion = ghost_x[i] / BLOCK_SIZE + N_BLOCKS * (int) (ghost_y[i] / BLOCK_SIZE);
                contador = 0;

                if ((screenData[posicion] & 1) == 0 && ghost_dx[i] != 1) {
                    dx[contador] = -1;
                    dy[contador] = 0;
                    contador++;
                }

                if ((screenData[posicion] & 2) == 0 && ghost_dy[i] != 1) {
                    dx[contador] = 0;
                    dy[contador] = -1;
                    contador++;
                }

                if ((screenData[posicion] & 4) == 0 && ghost_dx[i] != -1) {
                    dx[contador] = 1;
                    dy[contador] = 0;
                    contador++;
                }

                if ((screenData[posicion] & 8) == 0 && ghost_dy[i] != -1) {
                    dx[contador] = 0;
                    dy[contador] = 1;
                    contador++;
                }

                if (contador == 0) {
                    if ((screenData[posicion] & 15) == 15) {
                        ghost_dx[i] = 0;
                        ghost_dy[i] = 0;
                    } else {
                        ghost_dx[i] = -ghost_dx[i];
                        ghost_dy[i] = -ghost_dy[i];
                    }
                } else {
                    contador = (int) (Math.random() * contador);
                    if (contador > 3) {
                        contador = 3;
                    }
                    ghost_dx[i] = dx[contador];
                    ghost_dy[i] = dy[contador];
                }
            }

            ghost_x[i] = ghost_x[i] + (ghost_dx[i] * ghostSpeed[i]);
            ghost_y[i] = ghost_y[i] + (ghost_dy[i] * ghostSpeed[i]);
            dibujarFantasma(g2d, ghost_x[i] + 1, ghost_y[i] + 1);

            if (pacman_x > (ghost_x[i] - 12) && pacman_x < (ghost_x[i] + 12)
                    && pacman_y > (ghost_y[i] - 12) && pacman_y < (ghost_y[i] + 12)
                    && estaInicializadoElJuego) {
                estaMuerto = true;
            }
        }
    }

    private void dibujarFantasma(Graphics2D g2d, int x, int y) {
        g2d.drawImage(ghost, x, y, this);
    }

    private void moverPacman() {
        int pos;
        short ch;

        if (pacman_x % BLOCK_SIZE == 0 && pacman_y % BLOCK_SIZE == 0) {
            pos = pacman_x / BLOCK_SIZE + N_BLOCKS * (int) (pacman_y / BLOCK_SIZE);
            ch = screenData[pos];

            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
                puntaje++;
            }

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacmand_x = req_dx;
                    pacmand_y = req_dy;
                }
            }

            // Check for standstill
            if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)
                    || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)
                    || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)
                    || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0)) {
                pacmand_x = 0;
                pacmand_y = 0;
            }
        }
        pacman_x = pacman_x + PACMAN_SPEED * pacmand_x;
        pacman_y = pacman_y + PACMAN_SPEED * pacmand_y;
    }

    private void dibujarPacman(Graphics2D g2d) {
        if (req_dx == -1) {
            //Dibujar Pacman que va la izquierda
            g2d.drawImage(left, pacman_x + 1, pacman_y + 1, this);
        } else if (req_dx == 1) {
            //Dibujar Pacman que va la derecha
            g2d.drawImage(right, pacman_x + 1, pacman_y + 1, this);
        } else if (req_dy == -1) {
            //Dibujar Pacman que va la arriba
            g2d.drawImage(up, pacman_x + 1, pacman_y + 1, this);
        } else {
            //Dibujar Pacman que va a abajo
            g2d.drawImage(down, pacman_x + 1, pacman_y + 1, this);
        }
    }

    private void dibujarEscenario(Graphics2D g2d) {
        short i = 0;
        int x, y;

        //Recorrido de filas
        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            //Recorrido de columnas
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {
                //Cambiamos a color medio azul g2d.setColor(new Color(r,g,b));
                g2d.setColor(new Color(0, 79, 250));
                //Definimos el ancho
                g2d.setStroke(new BasicStroke(5));

//                if ((levelData[i] == 0)) {
//                    g2d.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
//                }

                if ((screenData[i] & 1) != 0) {
                    //Dibujar la linea recta a la izquierda que va de arriba a abajo
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 2) != 0) {
                    //Dibujar la linea recta en la parte de superior que va de izquierda a derecha
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) {
                    //Dibujar la linea recta en la parte derecha que va de arriba a abajo
                    g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) {
                    //Dibujar la linea recta en la parte inferior que va de izquierda a derecha
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 16) != 0) {
                    //Cambiamos a color blanco
                    g2d.setColor(new Color(255,255,255));
                    //Dibujamos un circulo
                    g2d.fillOval(x + 10, y + 10, 6, 6);
                }
                i++;
            }
        }
    }

    private void inicializarConfiguracionJuego() {
        //Numero de vidas
        vidas = 5;
        //Puntaje
        puntaje = 0;
        inicializarNivel();
        //Numero de enemigos
        N_GHOSTS = 6;
        // Asignar la velocidad
        actualVelocidad = 3;
    }

    private void inicializarNivel() {
        for (int i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }

        continuarNivel();
    }

    private void continuarNivel() {
        int dx = 1;
        int random;

        for (int i = 0; i < N_GHOSTS; i++) {
            ghost_y[i] = 4 * BLOCK_SIZE; //start position
            ghost_x[i] = 4 * BLOCK_SIZE;
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (actualVelocidad + 1));

            if (random > actualVelocidad) {
                random = actualVelocidad;
            }

            ghostSpeed[i] = validSpeeds[random];
        }

        pacman_x = 7 * BLOCK_SIZE;  //start position
        pacman_y = 11 * BLOCK_SIZE;
        pacmand_x = 0;	//reset direction move
        pacmand_y = 0;
        req_dx = 0;		// reset direction controls
        req_dy = 0;
        estaMuerto = false;
    }

    private void mostrarPantallaDeIntro(Graphics2D g2d) {
        g2d.setColor(new Color(0, 32, 48));
        g2d.fillRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);
        g2d.setColor(Color.white);
        g2d.drawRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);

        String s = "Presiona s para empezar.";
        Font small = new Font("Helvetica", Font.BOLD, 15);
        FontMetrics metr = this.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, (SCREEN_SIZE - metr.stringWidth(s)) / 2, SCREEN_SIZE / 2);
    }

    //paintComponent es el método que nos permitirá dibujar en el JPanel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Dibujar en el JPanel
        dibujar(g);
    }

    public void dibujar(Graphics g) {
        //Casteamos los graficos a graficos 2d para nuestro juego
        Graphics2D g2d = (Graphics2D) g;

        //Cambiamos a color negro con Color.black
        g2d.setColor(Color.black);

        //Dibujamos un rectangulo de acuerdo a las dimensiones 400 X 400
        g2d.fillRect(0, 0, d.width, d.height);

        //Dibujamos el escenario
        dibujarEscenario(g2d);

        //Dibujamos el puntaje del juego en la parte inferior de la pantalla
        dibujarPuntaje(g2d);

        if (estaInicializadoElJuego) {
            playGame(g2d);
        } else {
            mostrarPantallaDeIntro(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    public void dibujarPuntaje(Graphics2D g) {
        //Cambiamos el tipo de letra a Arial 14
        g.setFont(smallFont);

        //Cambiamos el color a azul
        g.setColor(new Color(26, 66, 241));

        String mensaje = "Puntaje: " + puntaje;

        //Dibujamos el mensaje del Puntaje: 10(SCORE) donde g.drawString(mensaje, x, y)
        g.drawString(mensaje, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);

        for (int i = 0; i < vidas; i++) {
            //Dibujamos las imagenes de los corazones usamos g.drawImage(ImagenCargada, x, y, this);
            //NOTA la imagen de heart ya ha sido cargado en el metodo cargarImagenes()
            g.drawImage(heart, i * 28 + 8, SCREEN_SIZE + 1, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    class ControlDeTeclado extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (estaInicializadoElJuego) {
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        req_dx = -1;
                        req_dy = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        req_dx = 1;
                        req_dy = 0;
                        break;
                    case KeyEvent.VK_UP:
                        req_dx = 0;
                        req_dy = -1;
                        break;
                    case KeyEvent.VK_DOWN:
                        req_dx = 0;
                        req_dy = 1;
                        break;
                    default:
                        if (key == KeyEvent.VK_ESCAPE && tiempo.isRunning()) {
                            estaInicializadoElJuego = false;
                        } else if (key == KeyEvent.VK_PAUSE) {
                            if (tiempo.isRunning()) {
                                tiempo.stop();
                            } else {
                                tiempo.start();
                            }
                        }
                        break;
                }
            } else {
                if (key == 's' || key == 'S') {
                    estaInicializadoElJuego = true;
                    inicializarConfiguracionJuego();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == Event.LEFT || key == Event.RIGHT
                    || key == Event.UP || key == Event.DOWN) {
                req_dx = 0;
                req_dy = 0;
            }
        }
    }
}
