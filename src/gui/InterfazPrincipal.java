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
public class InterfazPrincipal extends JFrame implements ActionListener {

    //Se declaran todos los botones de la interfaz
    private JButton btnRegistrar;
    private JButton btnJugar;
    private JButton btnCreditos;
    private JButton btnResultados;
   

    //Se declara la etiqueta de texto de la interfaz
    private final JLabel txtBienvenido;

    //Declaracion de las clases que se van a usar
    private InterfazRegistrar interfazRegistrar;
    private InterfazResultados interfazResultados;
    private InterfazCreditos interfazCreditos;
    private Concentrese concentrese;
    private InterfazAuxiliar interfazAuxiliar;

    //Constructor que inicializa los atributos de la clase
    public InterfazPrincipal() {
        //Se declara null para no usar layouts
        getContentPane().setLayout(null);

        //Inicializacion de las clases que se van a usar
        concentrese = new Concentrese();
        interfazRegistrar = new InterfazRegistrar(this, concentrese);
        interfazCreditos = new InterfazCreditos(this);
        interfazResultados = new InterfazResultados(this, concentrese);
        interfazAuxiliar = new InterfazAuxiliar(this, concentrese);

        //INICIALIZACIÓN DE LOS BOTONES
        btnJugar = new JButton("Jugar!");
        btnRegistrar = new JButton("Registrarse");
        btnResultados = new JButton("Resultados");
        btnCreditos = new JButton("Creditos");
        

        //Posicion y tamaño del boton
        btnJugar.setBounds(385, 30, 150, 40);
        btnRegistrar.setBounds(385, 100, 150, 40);
        btnResultados.setBounds(385, 170, 150, 40);
        btnCreditos.setBounds(385, 240, 150, 40);
        

        //Adicion del Boton al JFrame          
        getContentPane().add(btnJugar);
        getContentPane().add(btnRegistrar);
        getContentPane().add(btnResultados);
        getContentPane().add(btnCreditos);
        

        //Adición del evento al boton
        btnJugar.addActionListener(this);
        btnRegistrar.addActionListener(this);
        btnResultados.addActionListener(this);
        btnCreditos.addActionListener(this);
        

        //Se iniciliza la etiqueta y se le asigna un texto
        txtBienvenido = new JLabel("FUTB   LIZATE!");
        //Fuente del texto y tamaño
        txtBienvenido.setFont(new java.awt.Font("Arial Black", 60, 71));
        //Color del texto
        txtBienvenido.setForeground(Color.black);
        //Ubicacion del texto
        txtBienvenido.setBounds(30, 265, 600, 150);
        //Adicion de la etiqueta al JFrame
        getContentPane().add(txtBienvenido);

        //Se agrega el fondo del JFrame
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Sources/fondo.gif"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        setBackground(Color.white);

        //Agregar icono de la aplicacacion
        setIconImage(new ImageIcon(getClass().getResource("/Sources/icono.png")).getImage());

        //Titulo de la pantalla
        setTitle("Futbolizate");
        //Posición y tamaño del JFrame
        setSize(638, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        //Operacion por defecto del boton cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Se identifica el boton presionado
        if (e.getSource() == btnCreditos) {
            //Se hace visible la interfaz solicitada
            interfazCreditos.setVisible(true);
            //Se oculta la interfaz principal
            setVisible(false);
        }

        if (e.getSource() == btnRegistrar) {
            interfazRegistrar.setVisible(true);
            setVisible(false);
        }

        if (e.getSource() == btnResultados) {
            if (concentrese.getJugadores() != null) {
                interfazResultados.mostrarLista();
            }
            interfazResultados.setVisible(true);
            setVisible(false);
        }

        if (e.getSource() == btnJugar) {
            setVisible(false);
            interfazAuxiliar.setVisible(true);
        }
    }

}
