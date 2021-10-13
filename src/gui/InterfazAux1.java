/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logica.Jugador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jose Daniel Parra - Andres Felipe Cortes.
 */
public class InterfazAux1 extends JFrame implements ActionListener {

    //Clases que se necesitan
    InterfazJugar interfazJugar;
    Jugador jugador;
    InterfazRegistrar interfazRegistrar;
    InterfazPrincipal interfazPrincipal;
    //Etiqueta pregunta
    JLabel txtPregunta;
    //Botones
    JButton btnAceptar;
    JButton btnVolver;

    /**
     * Constructor que incializa los atributos de clase
     * @param jugador
     * @param interfazRegistrar
     * @param interfazPrincipal 
     */
    public InterfazAux1(Jugador jugador, InterfazRegistrar interfazRegistrar, InterfazPrincipal interfazPrincipal) {
        //Inicializacion de las clases que se necesitan
        this.jugador = jugador;
        this.interfazRegistrar = interfazRegistrar;
        this.interfazPrincipal = interfazPrincipal;
        //Se declara null para no usar layouts
        setLayout(null);
        //Operacion por defecto del boton cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Agregar icono de la aplicacacion
        setIconImage(new ImageIcon(getClass().getResource("/Sources/icono.png")).getImage());
        //Tamaño y posicion del JFrame
        setSize(415, 180);
        setResizable(false);
        //Se centra el JFrame
        setLocationRelativeTo(null);
        //Se agrega el fondo del JFrame
        setBackground(Color.white);
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Sources/fondotodo.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(-70, 20, uno.getIconWidth(), uno.getIconHeight());

        //Inicializacion botones
        btnVolver = new JButton("NO!");
        btnAceptar = new JButton("Aceptar");
        //Ubicacion y tamaño de los botones
        btnAceptar.setBounds(60, 100, 100, 30);
        btnVolver.setBounds(250, 100, 100, 30);
        //Adicion del evento al boton
        btnAceptar.addActionListener(this);
        btnVolver.addActionListener(this);
        //Adicion del boton JFrame
        add(btnAceptar);
        add(btnVolver);

        //Inicializacion de la etiqueta de texto
        txtPregunta = new JLabel("¿Desea empezar a jugar?");
        //Ubicacion y tamaño de la etiqueta
        txtPregunta.setBounds(70, -50, 600, 150);
        //Adicion de la etiqueta al JFrame
        getContentPane().add(txtPregunta);
        //Tamaño y fuente
        txtPregunta.setFont(new java.awt.Font("Arial Black", 10, 20));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Se identifica el boton presionado
        if (e.getSource() == btnVolver) {
            //Se oculta la interfaz
            setVisible(false);
            //Se muestra visible la siguiente interfaz
            interfazRegistrar.setVisible(true);
        }

        if (e.getSource() == btnAceptar) {
            interfazJugar = new InterfazJugar(jugador, interfazPrincipal);
            interfazJugar.setVisible(true);
            setVisible(false);
        }
    }

}
