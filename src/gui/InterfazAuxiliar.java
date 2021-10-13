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
public class InterfazAuxiliar extends JFrame implements ActionListener {

    //Declaracion de los botones de la interfaz
    private JButton btnAceptar;
    private JButton btnVolver;
    //Declaracion de los campos de texto
    private JTextField cmpId;
    //Declaracion de etiqueta de texto
    private JLabel txtId;
    //Declaracion de las clases de GUI que se necesitan
    private InterfazPrincipal interfazPrincipal;
    private InterfazJugar interfazJugar;
    private Concentrese concentrese;

    //Constructor que inicializa los atributos de clase
    InterfazAuxiliar(InterfazPrincipal interfazPrincipal, Concentrese concentrese) {
        //Se declar null para no usar Layouts
        setLayout(null);
        //Inicializacion de las clases
        this.interfazPrincipal = interfazPrincipal;
        this.concentrese = concentrese;
        //Inicializacion botones
        btnVolver = new JButton("Volver");
        btnAceptar = new JButton("Aceptar");
        //Ubicacion y tamaño de los botones
        btnAceptar.setBounds(60, 180, 100, 30);
        btnVolver.setBounds(220, 180, 100, 30);
        //Adicion del evento al boton
        btnAceptar.addActionListener(this);
        btnVolver.addActionListener(this);
        //Adicion del boton JFrame
        add(btnAceptar);
        add(btnVolver);

        //Inicializacion de la etiqueta de texto
        txtId = new JLabel("Ingrese su ID (Si no tiene uno debe registrarse)");
        //Ubicacion y tamaño de la etiqueta
        txtId.setBounds(50, -70, 600, 150);
        //Adicion de la etiqueta al JFrame
        getContentPane().add(txtId);

        //Inicializacion del campo de texto
        cmpId = new JTextField();
        //Ubicacion y tamaño
        cmpId.setBounds(140, 55, 100, 25);
        //Adicion del campo de texto al JFrame
        add(cmpId);

        //Agregar icono de la aplicacacion
        setIconImage(new ImageIcon(getClass().getResource("/Sources/icono.png")).getImage());

        //Tamaño y posicion del JFrame
        setSize(380, 270);
        setResizable(false);

        //Se centra el JFrame
        setLocationRelativeTo(null);

        setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Se agrega el fondo del JFrame
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Sources/fondotodo.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(-70, 0, uno.getIconWidth(), uno.getIconHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVolver) {
            setVisible(false);
            interfazPrincipal.setVisible(true);
        }
        if (e.getSource() == btnAceptar) {
            String id = cmpId.getText();
            //Se valida que se tenga informacion en los campos de texto
            if (!id.trim().equals("")) {
                if (concentrese.buscarJugador(id) != -1) {
                    interfazJugar = new InterfazJugar(concentrese.getJugadores().get(concentrese.buscarJugador(id)), interfazPrincipal);
                    interfazJugar.setVisible(true);
                    setVisible(false);
                    cmpId.setText("");
                }
                if (concentrese.buscarJugador(id) == -1) {
                    JOptionPane.showMessageDialog(null, "Este jugador no ha sido registrado");
                    cmpId.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique haber escrito el ID");
            }
        }

    }

}
