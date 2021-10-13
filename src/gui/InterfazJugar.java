/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logica.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jose Daniel Parra - Andres Felipe Cortes.
 */
public class InterfazJugar extends JFrame implements ActionListener {

    private static final String RESOURCES = "../sources/";
    //Declaracion de la matriz de botones
    private JButton[][] btnMatriz;
    //Declaracion de las imagenes de cada boton
    private ImageIcon imageBoton;
    private ImageIcon imageChelsea;
    private ImageIcon imageJuve;
    private ImageIcon imageMilan;
    private ImageIcon imageManchester;
    private ImageIcon imageReal;
    private ImageIcon imageBarca;
    private ImageIcon imageBorussia;
    private ImageIcon imageBayern;
    //Decclaracion de jugadas y tiempo
    int jugadas;
    double tiempoInicial;
    //Declaracion de los arreglos que llevaran la fila y la columna aleatoria
    private int[] filas;
    private int[] columnas;

    //Declaracion de las clases que se necesitan
    private Jugador jugador;
    private InterfazInformativa interfazInformativa;
    private InterfazPrincipal interfazPrincipal;

    //Etiquetas de texto
    private JLabel txtJugador;
    private JLabel txtJugadas;

    /**
     * Constructor que incializa los atributos de InterfazJugar
     *
     * @param jugador
     * @param interfazPrincipal
     */
    public InterfazJugar(Jugador jugador, InterfazPrincipal interfazPrincipal) {

        //Se declara null para no usar layouts
        setLayout(null);
        //Inicializacion de la matriz de botones
        btnMatriz = new JButton[4][4];
        //Inicializacion arreglos columnas filas
        filas = determinarPosiciones();
        columnas = determinarPosiciones();
        //Inicializacion jugador e interfazPricipal
        this.jugador = jugador;
        this.interfazPrincipal = interfazPrincipal;
        //Inicializacion de las jugadas y el tiempo
        jugadas = 0;
        tiempoInicial = 0;
        //Inicializacion de las imagenes que llevara la matriz
        imageBoton = new ImageIcon(this.getClass().getResource(
                RESOURCES + "boton.gif"));

        imageChelsea = new ImageIcon(this.getClass().getResource(
                RESOURCES + "chelsea.jpg"));

        imageManchester = new ImageIcon(this.getClass().getResource(
                RESOURCES + "Manchester.jpg"));

        imageBarca = new ImageIcon(this.getClass().getResource(
                RESOURCES + "barca.jpg"));

        imageReal = new ImageIcon(this.getClass().getResource(
                RESOURCES + "real.jpg"));

        imageJuve = new ImageIcon(this.getClass().getResource(
                RESOURCES + "juventus.jpg"));

        imageBorussia = new ImageIcon(this.getClass().getResource(
                RESOURCES + "borussia.jpg"));

        imageBayern = new ImageIcon(this.getClass().getResource(
                RESOURCES + "bayern.jpg"));

        imageMilan = new ImageIcon(this.getClass().getResource(
                RESOURCES + "milan.jpg"));

        //Inicializacion y adicion de las etiquetas de texto
        txtJugador = new JLabel(jugador.getNombre());
        txtJugadas = new JLabel("Jugadas: " + jugadas);
        txtJugador.setBounds(35, -30, 600, 150);
        txtJugadas.setBounds(625, -30, 600, 150);
        txtJugador.setFont(new java.awt.Font("Arial", 60, 71));
        txtJugadas.setFont(new java.awt.Font("Arial", 60, 71));
        add(txtJugador);
        add(txtJugadas);
        
        //Ciclo que creara los botones y les asignara la imagen por defecto (imageBoton)
        for (int i = 0; i < btnMatriz.length; i++) {
            for (int j = 0; j < btnMatriz.length; j++) {

                btnMatriz[i][j] = new JButton();
                btnMatriz[i][j].setBounds(240 + 140 * j, 100 + 140 * i, 125, 125);
                btnMatriz[i][j].addActionListener(this);
                btnMatriz[i][j].setIcon(imageBoton);
                add(btnMatriz[i][j]);
            }
        }

        //Se agrega el fondo del JFrame
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Sources/jugar.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

        //Agregar icono de la aplicacacion
        setIconImage(new ImageIcon(getClass().getResource("/Sources/icono.png")).getImage());

        //Titulo de la pantalla
        setTitle("Concentrese");
        //Posición y tamaño del JFrame
        setSize(1024, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        //Operacion por defecto del boton cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

   /**
     * Actualiza el tiempo y las jugadas de un jugador
     *
     * @param tiempo
     * @param jugadas
     * @param jugador
     */
    public void actualizarDatos(Jugador jugador, double tiempo, int jugadas) {
        if (jugador.getTiempo() != 0 && jugador.getJugadas() != 0) {
            if (jugador.getTiempo() > tiempo) {
                jugador.setTiempo(tiempo);
                if (jugador.getJugadas() > jugadas) {
                    jugador.setJugadas(jugadas);
                }
            }
        } else {
            jugador.setJugadas(jugadas);
            jugador.setTiempo(tiempo);
        }

    }

    /**
     * Busca numeros aleatorios
     *
     * @return arreglo con numeros aleatorios
     */
    private int[] determinarPosiciones() {
        String[] numeros = new String[]{"", "", "", "",};
        String pos = null;
        int[] pos2 = new int[4];
        int i = 0;

        for (int a = 0; a < numeros.length; a++) {
            do {
                i = (int) (Math.random() * 4);
                pos = "" + i + "";
            } while (comprobarSiContiene(pos, numeros));
            numeros[a] = pos;
            pos2[a] = i;
        }
        return pos2;
    }

    /**
     * Busca un dato en un arreglo String
     *
     * @param pos dato a buscar
     * @param numeros arreglo en el que se buscara el dato
     * @return true si se encuentra el dato, de lo contrario false
     */
    private boolean comprobarSiContiene(String pos, String[] numeros) {
        for (int j = 0; j < numeros.length; j++) {
            if (numeros[j].equals(pos)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Numero de veces que se repite una imagen en una matriz de botones
     *
     * @param btnMatriz true si se encuentra el dato, de lo contrario false
     * @param imagen imagen a buscar
     * @return numero de veces que se repite la imagen en la matriz
     */
    private int reconocerIguales(JButton[][] btnMatriz, ImageIcon imagen) {
        int aux = 0;
        for (int i = 0; i < btnMatriz.length; i++) {
            for (int j = 0; j < btnMatriz.length; j++) {
                if (btnMatriz[i][j].getIcon() == imagen) {
                    aux++;
                }
            }
        }

        return aux;
    }

    /**
     * Recorre una matriz de botones en busca de imagenes iguales
     *
     * @param btnMatriz btnMatriz, matriz de botones a recorrer
     * @param imagen imagen, imagen a buscar
     * @return arreglo de enteros con las posiciones de las imagenes en la
     * matriz
     */
    private int[] posicionesElementosIguales(JButton[][] btnMatriz, ImageIcon imagen) {
        int aux = 0;
        int posiciones[] = new int[4];
        for (int i = 0; i < btnMatriz.length; i++) {
            for (int j = 0; j < btnMatriz.length; j++) {
                if (btnMatriz[i][j].getIcon() == imagen) {
                    aux++;
                    if (aux == 1) {
                        posiciones[0] = i;
                        posiciones[1] = j;
                    }
                    if (aux == 2) {
                        posiciones[2] = i;
                        posiciones[3] = j;
                    }
                }
            }
        }
        return posiciones;
    }

    /**
     * Asigna el boton por defecto(imageBoton) a los botones habilitados de
     * btnMatriz
     */
    private void llenarDeNuevoMatriz() {
        for (int i = 0; i < btnMatriz.length; i++) {
            for (int j = 0; j < btnMatriz.length; j++) {
                if (btnMatriz[i][j].isEnabled()) {
                    btnMatriz[i][j].setIcon(imageBoton);
                }

            }
        }
    }

    /**
     * Cuenta el numero de botones deshabilitados en una matriz
     *
     * @param btnMatriz
     * @return el numero de botones habilitados
     */
    private int botonesHabilitados(JButton[][] btnMatriz) {
        int numero = 0;
        for (int i = 0; i < btnMatriz.length; i++) {
            for (int j = 0; j < btnMatriz.length; j++) {
                if (btnMatriz[i][j].isEnabled()) {
                    numero++;
                }

            }
        }
        return numero;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Se toma el tiempo cuando se identifica el primer evento
        if (jugadas == 0) {
            tiempoInicial = System.currentTimeMillis();
           
        }
        /*
         Cada que la imagen por defecto se repite un numero par de veces
         se debe asignar de nuevo la imagen por defecto a los botones habilitados
         */
        if (reconocerIguales(btnMatriz, imageBoton) % 2 == 0) {
            llenarDeNuevoMatriz();
        }
        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[0]][columnas[0]]) {
            //Cada vez que se identifique un evento en el boton se suma una jugada 
            jugadas++;
            //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            //Se deja ver la imagen asignada al boton
            btnMatriz[filas[0]][columnas[0]].setIcon(imageChelsea);
            //Se identifica si la pareja de la iamgen esta descubierta para deshabilitarlas
            if (reconocerIguales(btnMatriz, imageChelsea) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageChelsea)[0]][posicionesElementosIguales(btnMatriz, imageChelsea)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageChelsea)[2]][posicionesElementosIguales(btnMatriz, imageChelsea)[3]].setEnabled(false);
            }

        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[0]][columnas[1]]) {
            jugadas++;
            //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[0]][columnas[1]].setIcon(imageJuve);
            if (reconocerIguales(btnMatriz, imageJuve) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageJuve)[0]][posicionesElementosIguales(btnMatriz, imageJuve)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageJuve)[2]][posicionesElementosIguales(btnMatriz, imageJuve)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[0]][columnas[2]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[0]][columnas[2]].setIcon(imageBarca);
            if (reconocerIguales(btnMatriz, imageBarca) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBarca)[0]][posicionesElementosIguales(btnMatriz, imageBarca)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBarca)[2]][posicionesElementosIguales(btnMatriz, imageBarca)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[0]][columnas[3]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[0]][columnas[3]].setIcon(imageReal);
            if (reconocerIguales(btnMatriz, imageReal) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageReal)[0]][posicionesElementosIguales(btnMatriz, imageReal)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageReal)[2]][posicionesElementosIguales(btnMatriz, imageReal)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[1]][columnas[0]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[1]][columnas[0]].setIcon(imageManchester);
            if (reconocerIguales(btnMatriz, imageManchester) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageManchester)[0]][posicionesElementosIguales(btnMatriz, imageManchester)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageManchester)[2]][posicionesElementosIguales(btnMatriz, imageManchester)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[1]][columnas[1]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[1]][columnas[1]].setIcon(imageBayern);
            if (reconocerIguales(btnMatriz, imageBayern) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBayern)[0]][posicionesElementosIguales(btnMatriz, imageBayern)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBayern)[2]][posicionesElementosIguales(btnMatriz, imageBayern)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[1]][columnas[2]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[1]][columnas[2]].setIcon(imageChelsea);
            if (reconocerIguales(btnMatriz, imageChelsea) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageChelsea)[0]][posicionesElementosIguales(btnMatriz, imageChelsea)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageChelsea)[2]][posicionesElementosIguales(btnMatriz, imageChelsea)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[1]][columnas[3]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[1]][columnas[3]].setIcon(imageBorussia);
            if (reconocerIguales(btnMatriz, imageBorussia) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBorussia)[0]][posicionesElementosIguales(btnMatriz, imageBorussia)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBorussia)[2]][posicionesElementosIguales(btnMatriz, imageBorussia)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[2]][columnas[0]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[2]][columnas[0]].setIcon(imageMilan);
            if (reconocerIguales(btnMatriz, imageMilan) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageMilan)[0]][posicionesElementosIguales(btnMatriz, imageMilan)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageMilan)[2]][posicionesElementosIguales(btnMatriz, imageMilan)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[2]][columnas[1]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[2]][columnas[1]].setIcon(imageReal);
            if (reconocerIguales(btnMatriz, imageReal) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageReal)[0]][posicionesElementosIguales(btnMatriz, imageReal)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageReal)[2]][posicionesElementosIguales(btnMatriz, imageReal)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[2]][columnas[2]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[2]][columnas[2]].setIcon(imageJuve);
            if (reconocerIguales(btnMatriz, imageJuve) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageJuve)[0]][posicionesElementosIguales(btnMatriz, imageJuve)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageJuve)[2]][posicionesElementosIguales(btnMatriz, imageJuve)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[2]][columnas[3]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[2]][columnas[3]].setIcon(imageBarca);
            if (reconocerIguales(btnMatriz, imageBarca) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBarca)[0]][posicionesElementosIguales(btnMatriz, imageBarca)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBarca)[2]][posicionesElementosIguales(btnMatriz, imageBarca)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[3]][columnas[0]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[3]][columnas[0]].setIcon(imageBayern);
            if (reconocerIguales(btnMatriz, imageBayern) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBayern)[0]][posicionesElementosIguales(btnMatriz, imageBayern)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBayern)[2]][posicionesElementosIguales(btnMatriz, imageBayern)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[3]][columnas[1]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[3]][columnas[1]].setIcon(imageBorussia);
            if (reconocerIguales(btnMatriz, imageBorussia) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBorussia)[0]][posicionesElementosIguales(btnMatriz, imageBorussia)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageBorussia)[2]][posicionesElementosIguales(btnMatriz, imageBorussia)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[3]][columnas[2]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[3]][columnas[2]].setIcon(imageManchester);
            if (reconocerIguales(btnMatriz, imageManchester) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageManchester)[0]][posicionesElementosIguales(btnMatriz, imageManchester)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageManchester)[2]][posicionesElementosIguales(btnMatriz, imageManchester)[3]].setEnabled(false);
            }
        }

        //Se identifica el boton presionado
        if (e.getSource() == btnMatriz[filas[3]][columnas[3]]) {
            jugadas++;
             //Se actualiza el contador en pantalla
            txtJugadas.setText("Jugadas:"+Integer.toString(jugadas));
            btnMatriz[filas[3]][columnas[3]].setIcon(imageMilan);
            if (reconocerIguales(btnMatriz, imageMilan) == 2) {
                btnMatriz[posicionesElementosIguales(btnMatriz, imageMilan)[0]][posicionesElementosIguales(btnMatriz, imageMilan)[1]].setEnabled(false);
                btnMatriz[posicionesElementosIguales(btnMatriz, imageMilan)[2]][posicionesElementosIguales(btnMatriz, imageMilan)[3]].setEnabled(false);
            }
        }

        if (botonesHabilitados(btnMatriz) == 0) {
            double tiempoFinal = System.currentTimeMillis();
            double tiempo = (tiempoFinal - tiempoInicial) * 0.001;
            actualizarDatos(jugador, tiempo, jugadas);
            interfazInformativa = new InterfazInformativa(tiempo, jugadas, interfazPrincipal, jugador);
            interfazInformativa.setVisible(true);
            setVisible(false);
        }
    }

}
