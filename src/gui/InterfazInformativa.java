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
public class InterfazInformativa extends JFrame implements ActionListener {

    //Declaracion de los botones
    private JButton btnOk;
    private JButton btnJugar;
    //Declaracion de las etiquetas de la clase
    private JLabel txtTiempo;
    private JLabel txtJugadas;
    //Declaracion de las clases que se necesitan
    private InterfazJugar interfazJugar;
    private InterfazPrincipal interfazPrincipal;
    private Jugador jugador;

    public InterfazInformativa(double tiempo, int jugadas, InterfazPrincipal interfazPrincipal, Jugador jugador) {
        this.jugador = jugador;
        this.interfazPrincipal = interfazPrincipal;
        interfazJugar = new InterfazJugar(jugador, interfazPrincipal);
        //Se declara null para no usa layouts
        setLayout(null);
        //Inicializacion de etiquetas de texto
        txtTiempo = new JLabel("Tiempo: " + (int)tiempo + " segundos");
        txtJugadas = new JLabel("Jugadas: " + jugadas);
        //Iincializacion de los botones
        btnOk = new JButton("Ok");
        btnJugar = new JButton("Jugar de nuevo");
        //Ubicacion y tamaño de los botones
        btnOk.setBounds(380, 100, 100, 30);
        btnJugar.setBounds(350, 30, 150, 30);
        //Ubicacion y tamaño de las etiquetas de txt
        txtJugadas.setBounds(40, -30, 600, 150);
        txtTiempo.setBounds(40, 40, 600, 150);
        //Letra y tamaño del texto
        txtJugadas.setFont(new java.awt.Font("Arial Black", 10, 20));
        txtTiempo.setFont(new java.awt.Font("Arial Black", 10, 20));
        //Adicion de la etiqueta al Jframe
        add(txtJugadas);
        add(txtTiempo);
        //Adicion del evento al boton
        btnOk.addActionListener(this);
        btnJugar.addActionListener(this);
        //Adicion del boton JFrame
        add(btnOk);
        add(btnJugar);

        //Agregar icono de la aplicacacion
        setIconImage(new ImageIcon(getClass().getResource("/Sources/icono.png")).getImage());

        //Tamaño y posicion del JFrame
        setSize(550, 190);
        setResizable(false);

        //Se centra el JFrame
        setLocationRelativeTo(null);

        //Titulo de la ventena
        setTitle("Fin de la partida");

        //Se agrega el fondo del JFrame
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Sources/fondotodo.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnJugar) {
            interfazJugar.setVisible(true);
            setVisible(false);
        }

        if (e.getSource() == btnOk) {
           interfazPrincipal.setVisible(true);
           setVisible(false);
        }
    }

}
