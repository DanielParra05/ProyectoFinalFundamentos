/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logica.Concentrese;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jose Daniel Parra - Andres Felipe Cortes.
 */
public class InterfazResultados extends JFrame implements ActionListener {

    //Declaracion de los botones 
    private JButton btnAceptar;

    //Declaracion de las clases que se necesitan
    private InterfazPrincipal interfazPrincipal;
    private Concentrese concentrese;

    //Declaracion de la lista que mostrara los jugadores menor a tiempo a mayor
    private JList<String> listaDeJugadores;

    //Declaracion de etiqueta de texto
    private JLabel txtIndicador;

    /*
     Constructor que iniciliza los objetos de la clase
     @param interfazPrincipal
     @param concentrese
     */
    public InterfazResultados(InterfazPrincipal interfazPrincipal, Concentrese concentrese) {
        //Se declara null para no usar layouts
        getContentPane().setLayout(null);

        //Inicilizacion de las clases utilizadas
        this.interfazPrincipal = interfazPrincipal;
        this.concentrese = concentrese;

        //Inicilizacion del boton
        btnAceptar = new JButton("Aceptar");
        //Posicion y tamaño del boton 
        btnAceptar.setBounds(220, 280, 100, 30);
        //Adicion del Boton al JFrame          
        getContentPane().add(btnAceptar);
        //Adicion del evento al boton
        btnAceptar.addActionListener(this);

        //Se iniciliza la etiqueta y se le asigna un texto
        txtIndicador = new JLabel("Resultados segun jugadas(menos a mas):");
        //Ubicacion del texto
        txtIndicador.setBounds(20, 10, 600, 25);
        //Fuente del texto y tamaño
        txtIndicador.setFont(new java.awt.Font("Arial Black", 10, 20));
        //Adicion de la etiqueta al JFrame
        getContentPane().add(txtIndicador);

        //Se inicializa la lista de jugadores y se agrega al JFrame
        listaDeJugadores = new JList<String>();
        JScrollPane scroll = new JScrollPane(listaDeJugadores);
        scroll.setBounds(20, 40, 530, 220);
        getContentPane().add(scroll);

        //Agregar icono de la aplicacacion
        setIconImage(new ImageIcon(getClass().getResource("/Sources/icono.png")).getImage());

        //Titulo de la pantalla
        setTitle("Resultados");
        //Posición y tamaño del JFrame
        setSize(578,356);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        
         //Se agrega el fondo del JFrame
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Sources/fondotodo.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(20, 20, uno.getIconWidth(), uno.getIconHeight());
        
       

    }

    //Actualiza la lista de jugadores
    public void mostrarLista() {
        listaDeJugadores.setListData(concentrese.desempate());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAceptar) {
            interfazPrincipal.setVisible(true);
            setVisible(false);

        }

    }

}
