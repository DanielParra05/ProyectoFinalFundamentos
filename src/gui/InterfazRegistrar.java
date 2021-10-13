/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 * Interfaz
 *
 * @author Jose Daniel Parra - Andres Felipe Cortes.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Logica.Jugador;
import Logica.Concentrese;
import java.awt.Color;
import java.awt.Component;

public class InterfazRegistrar extends JFrame implements ActionListener {

    //Se declaran todas las etiquetas de texto de la interfaz
    private JLabel txtId;
    private JLabel txtNombre;
    private JLabel txtIndicador;

    //Se declaran todos los campos de texto de la interfaz
    private JTextField cmpId;
    private JTextField cmpNombre;

    //Se declaran los botones de la interfaz 
    private JButton btnAceptar;
    private JButton btnVolver;

    //Declaracion de las clases que se van a usar 
    private Jugador jugador;
    private Concentrese concentrese;
    private InterfazPrincipal interfazPrincipal;
    private InterfazJugar interfazJugar;
    private InterfazAux1 interfazAux1;

    //Declaracion de la lista que mopstarar los jugadores registrados
    private JList<String> listaDeJugadores;

    /**
     * Constructor que inicializa los atributos de la clase
     *
     * @param interfazPrincipal
     */
    public InterfazRegistrar(InterfazPrincipal interfazPrincipal, Concentrese concentrese) {
        //Se declara null para no usar layouts
        getContentPane().setLayout(null);

        //Inicializacion las clases que se van a usar 
        this.interfazPrincipal = interfazPrincipal;
        this.concentrese = concentrese;

        //Se inicializa la etiqueta y se le asigna un texto 
        txtId = new JLabel("ID:");
        txtNombre = new JLabel("Nombre:");
        txtIndicador = new JLabel("Jugadores registrados:");

        //Se pocisionan las etiquetas en el JFrame y se asignan el ancho y alto
        txtId.setBounds(10, 30, 50, 25);
        txtNombre.setBounds(10, 100, 50, 25);
        txtIndicador.setBounds(250, 3, 150, 25);

        //Se agrega la etiqueta al JFrame
        getContentPane().add(txtId);
        getContentPane().add(txtNombre);
        getContentPane().add(txtIndicador);

        //INICIALIZACIÓN DE LOS CAMPOS DE TEXTO 
        cmpId = new JTextField();
        cmpNombre = new JTextField();

        //Tamaño y ubicacion del campo de texto
        cmpNombre.setBounds(60, 100, 100, 25);
        cmpId.setBounds(60, 30, 100, 25);

        //Se agrega el campo de texto al JFrame
        getContentPane().add(cmpNombre);
        getContentPane().add(cmpId);

        //INICIALIZACIÓN DE LOS BOTONES
        btnAceptar = new JButton("Ok");
        btnVolver = new JButton("Volver");

        //Ubicacion y tamaño de los botones
        btnVolver.setBounds(300, 170, 100, 30);
        btnAceptar.setBounds(60, 170, 100, 30);

        //Adición del evento al boton 
        btnAceptar.addActionListener(this);
        btnVolver.addActionListener(this);

        //Adicion del evento a los botones
        getContentPane().add(btnVolver);
        getContentPane().add(btnAceptar);

        //Agregar icono de la aplicacacion
        setIconImage(new ImageIcon(getClass().getResource("/Sources/icono.png")).getImage());

        //Titulo de la pantalla
        setTitle("Registrarse");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tamaño y posicion del JFrame
        setSize(465, 270);
        setResizable(false);
        setBackground(Color.white);
        //Se agrega el fondo del JFrame
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Sources/fondotodo.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(-40, 10, uno.getIconWidth(), uno.getIconHeight());

        //Se centra el JFrame
        setLocationRelativeTo(null);

        //Se inicializa la lista de jugadores y se agrega al JFrame
        listaDeJugadores = new JList<String>();
        JScrollPane scroll = new JScrollPane(listaDeJugadores);
        scroll.setBounds(200, 30, 250, 120);
        getContentPane().add(scroll);

    }

    /**
     * @param e
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //e pregunta cual boton fue el presionado
        if (e.getSource() == btnAceptar) {

            String id = cmpId.getText();
            String nombre = cmpNombre.getText();

            //Se valida que se tenga informacion en los campos de texto
            if (!id.trim().equals("") && !nombre.trim().equals("")) {

                //Se validad que se haya agregado el jugador
                if (concentrese.agregarJugador(new Jugador(id, nombre, 0, 0))) {
                    String respuesta = null;
                    //Se dejan los campos vacios 
                    cmpId.setText("");
                    cmpNombre.setText("");
                    //Se actualiza la lista de jugadores 
                    listaDeJugadores.setListData(concentrese.obtenerListaDeJugadores());
                    
                    //Se pregunta si se desea empezar a jugar
                    interfazAux1=new InterfazAux1(concentrese.getJugadores().get(concentrese.buscarJugador(id)),this,interfazPrincipal);
                    interfazAux1.setVisible(true);
                    setVisible(false);
                } else {
                    //Se muestra una alerta
                    mostrarAlerta("El jugador con el Id:'" + id + "' \n ya fue registrado", this);
                }
            } else {
                mostrarAlerta("Verifique la información ingresada", this);

            }
        }
        if (e.getSource() == btnVolver) {

            interfazPrincipal.setVisible(true);
            setVisible(false);

        }

    }

    /**
     * Permite mostrar una alerta en caso de algun fallo
     * @param mensaje
     * @param object 
     */
    public static void mostrarAlerta(String mensaje, Component object) {

        JOptionPane.showMessageDialog(object, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

}
