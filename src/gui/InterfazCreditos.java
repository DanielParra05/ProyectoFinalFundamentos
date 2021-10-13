/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jose Daniel Parra - Andres Felipe Cortes.
 */
public class InterfazCreditos extends JFrame implements ActionListener {

    //Declaracion del boton "Aceptar"
    private JButton btnAceptar;

    //Declaracion de la interfaz Principal
    private InterfazPrincipal interfazPrincipal;

    /*
     Constructor que inicializa los atributos de la clase
     @param interfazPrincipal
     */
    public InterfazCreditos(InterfazPrincipal interfazPrincipal) {
        //Se declara null para no usar layouts
        getContentPane().setLayout(null);

        //Inicializacion de la InterfazPrincipal
        this.interfazPrincipal = interfazPrincipal;

        //Inicilizacion del boton
        btnAceptar = new JButton("Aceptar");
        //Posicion y tamaño del boton 
        btnAceptar.setBounds(300, 650, 100, 30);
        //Adicion del Boton al JFrame          
        getContentPane().add(btnAceptar);
        //Adicion del evento al boton
        btnAceptar.addActionListener(this);

        //Se agregan los fondos
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Sources/creditos.gif"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 230, uno.getIconWidth(), uno.getIconHeight());

        ImageIcon dos = new ImageIcon(this.getClass().getResource("/Sources/creditos1.gif"));
        JLabel fondo2 = new JLabel();
        fondo2.setIcon(dos);
        getLayeredPane().add(fondo2, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo2.setBounds(520, 230, dos.getIconWidth(), dos.getIconHeight());
        setBackground(Color.white);

        ImageIcon tres = new ImageIcon(this.getClass().getResource("/Sources/creditos2.gif"));
        JLabel fondo3 = new JLabel();
        fondo3.setIcon(tres);
        getLayeredPane().add(fondo3, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo3.setBounds(180, 150, tres.getIconWidth(), tres.getIconHeight());

        ImageIcon logoUQ = new ImageIcon(this.getClass().getResource("/Sources/logouq.jpg"));
        JLabel fondo5 = new JLabel();
        fondo5.setIcon(logoUQ);
        getLayeredPane().add(fondo5, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo5.setBounds(310, 520, logoUQ.getIconWidth(), logoUQ.getIconHeight());

        ImageIcon cuatro = new ImageIcon(this.getClass().getResource("/Sources/creditos3.jpg"));
        JLabel fondo4 = new JLabel();
        fondo4.setIcon(cuatro);
        getLayeredPane().add(fondo4, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo4.setBounds(0, 0, cuatro.getIconWidth(), cuatro.getIconHeight());

        //Agregar icono de la aplicacacion
        setIconImage(new ImageIcon(getClass().getResource("/Sources/icono.png")).getImage());
        //Titulo de la pantalla
        setTitle("Creditos");
        //Posición y tamaño del JFrame
        setSize(700, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        //Operacion por defecto del boton cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAceptar) {
            interfazPrincipal.setVisible(true);
            setVisible(false);
            }

    }

}
