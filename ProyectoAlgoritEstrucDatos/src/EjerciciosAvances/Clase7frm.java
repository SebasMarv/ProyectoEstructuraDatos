/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EjerciciosAvances;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Agustin Ivan
 */
public class Clase7frm extends javax.swing.JFrame implements KeyListener {

    /**
     * Creates new form frmSnake
     */
    int snake = -1;
    boolean valido = true, activado = false, co = false;
    int direccion, puntos = 0, contador;
    Point ultimo;
    int x, y;

    public frmSnake() {
        initComponents();
        setSize(500, 500);

        do {
            x = (int) Math.floor(Math.random() * 23);
            y = (int) Math.floor(Math.random() * 23);
            valido = false;

        } while (valido);
        jPanel1.setBounds(0, 0, 500, 500);

        JButton cabeza = new JButton();
        List<JButton> serp = new ArrayList<>();
        List<Point> PartesSerp = new ArrayList<>();
        cabeza.setBounds(x * 20, y * 20, 20, 20);
        cabeza.setContentAreaFilled(false);
        cabeza.setOpaque(true);
        cabeza.setBackground(new Color(103, 156, 221));
        cabeza.addKeyListener(this);

        jPanel1.add(cabeza);

        JButton comida = new JButton();
        comida.setBounds(x * 20, y * 20, 20, 20);
        comida.setContentAreaFilled(false);
        comida.setOpaque(true);
        comida.setBackground(new Color(234, 129, 84));
        comida.addKeyListener(this);
        jPanel1.add(comida);
        jPanel1.addKeyListener(this);

        Timer p = new Timer();

        TimerTask movimiento = new TimerTask() {
            @Override
            public void run() {
                co = false;
                contador = 0;
                jLabel1.setText("Puntos: " + puntos);
                PartesSerp.add(cabeza.getLocation());
                activado = false;
                int tamaño = PartesSerp.size();
                for (int i = 0; i <= tamaño - 1; i++) {
                    if (PartesSerp.size() == serp.size()) {
                        break;
                    }
                    PartesSerp.remove(0);
                }

                switch (direccion) {
                    case 1:
                        cabeza.setLocation(cabeza.getX() + 20, cabeza.getY());
                        if (cabeza.getX() >= comida.getX() & cabeza.getX() <= comida.getX() + 20) {
                            if (cabeza.getY() >= comida.getY() & cabeza.getY() <= comida.getY() + 20) {
                                PartesSerp.add(cabeza.getLocation());
                                serp.add(new JButton());
                                snake++;
                                serp.get(snake).setContentAreaFilled(false);
                                serp.get(snake).setOpaque(true);
                                serp.get(snake).setOpaque(true);
                                serp.get(snake).setBounds(new Rectangle(PartesSerp.get(snake), new Dimension(20, 20)));
                                serp.get(snake).setBackground(new Color(86, 204, 79));
                                jPanel1.add(serp.get(snake));

                                do {
                                    for (int e = 0; e <= serp.size() - 1; e++) {
                                        x = (int) Math.floor(Math.random() * 23);
                                        y = (int) Math.floor(Math.random() * 23);

                                        valido = (new Point(x * 20, y * 20).equals(serp.get(e).getLocation()));
                                        if (!valido)
                                            break;
                                    }
                                } while (valido);
                                comida.setLocation(x * 20, y * 20);
                                puntos++;
                                co = true;
                            }
                        }
                        break;

                    case 2:
                        cabeza.setLocation(cabeza.getX() - 20, cabeza.getY());
                        if (cabeza.getX() >= comida.getX() & cabeza.getX() <= comida.getX() + 20) {
                            if (cabeza.getY() >= comida.getY() & cabeza.getY() <= comida.getY() + 20) {
                                PartesSerp.add(cabeza.getLocation());
                                serp.add(new JButton());
                                snake++;
                                serp.get(snake).setContentAreaFilled(false);
                                serp.get(snake).setOpaque(true);
                                serp.get(snake).setOpaque(true);
                                serp.get(snake).setBounds(new Rectangle(PartesSerp.get(snake), new Dimension(20, 20)));
                                serp.get(snake).setBackground(new Color(86, 204, 79));
                                jPanel1.add(serp.get(snake));

                                do {
                                    for (int e = 0; e <= serp.size() - 1; e++) {
                                        x = (int) Math.floor(Math.random() * 23);
                                        y = (int) Math.floor(Math.random() * 23);

                                        valido = (new Point(x * 20, y * 20).equals(serp.get(e).getLocation()));
                                        if (!valido)
                                            break;
                                    }
                                } while (valido);
                                comida.setLocation(x * 20, y * 20);
                                puntos++;
                                co = true;
                            }
                        }
                        break;

                    case 3:
                        cabeza.setLocation(cabeza.getX(), cabeza.getY() + 20);
                        if (cabeza.getX() >= comida.getX() & cabeza.getX() <= comida.getX() + 20) {
                            if (cabeza.getY() >= comida.getY() & cabeza.getY() <= comida.getY() + 20) {
                                PartesSerp.add(cabeza.getLocation());
                                serp.add(new JButton());
                                snake++;
                                serp.get(snake).setContentAreaFilled(false);
                                serp.get(snake).setOpaque(true);
                                serp.get(snake).setOpaque(true);
                                serp.get(snake).setBounds(new Rectangle(PartesSerp.get(snake), new Dimension(20, 20)));
                                serp.get(snake).setBackground(new Color(86, 204, 79));
                                jPanel1.add(serp.get(snake));

                                do {
                                    for (int e = 0; e <= serp.size() - 1; e++) {
                                        x = (int) Math.floor(Math.random() * 23);
                                        y = (int) Math.floor(Math.random() * 23);

                                        valido = (new Point(x * 20, y * 20).equals(serp.get(e).getLocation()));
                                        if (!valido)
                                            break;
                                    }
                                } while (valido);
                                comida.setLocation(x * 20, y * 20);
                                puntos++;
                                co = true;
                            }
                        }
                        break;

                    case 4:
                        cabeza.setLocation(cabeza.getX(), cabeza.getY() - 20);
                        if (cabeza.getX() >= comida.getX() & cabeza.getX() <= comida.getX() + 20) {
                            if (cabeza.getY() >= comida.getY() & cabeza.getY() <= comida.getY() + 20) {
                                PartesSerp.add(cabeza.getLocation());
                                serp.add(new JButton());
                                snake++;
                                serp.get(snake).setContentAreaFilled(false);
                                serp.get(snake).setOpaque(true);
                                serp.get(snake).setOpaque(true);
                                serp.get(snake).setBounds(new Rectangle(PartesSerp.get(snake), new Dimension(20, 20)));
                                serp.get(snake).setBackground(new Color(86, 204, 79));
                                jPanel1.add(serp.get(snake));

                                do {
                                    for (int e = 0; e <= serp.size() - 1; e++) {
                                        x = (int) Math.floor(Math.random() * 23);
                                        y = (int) Math.floor(Math.random() * 23);

                                        valido = (new Point(x * 20, y * 20).equals(serp.get(e).getLocation()));
                                        if (!valido)
                                            break;
                                    }
                                } while (valido);
                                comida.setLocation(x * 20, y * 20);
                                puntos++;
                                co = true;
                            }
                        }
                        break;
                }

                for (int i = 0; i <= PartesSerp.size() - 1; i++) {
                    if (cabeza.getLocation().equals(PartesSerp.get(i))) {
                        contador++;
                        System.out.println(contador);
                        if (co) {
                            if (contador == 2) {
                                JOptionPane.showMessageDialog(null, "Perdistes, Tus Puntos Son: " + puntos);
                                System.exit(0);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Perdiste, tus puntos son: " + puntos);
                            System.exit(0);
                        }
                    }
                }

                for (int i = 0; i <= serp.size() - 1; i++) {
                    serp.get(i).setLocation(PartesSerp.get(i));
                }
                if (cabeza.getLocation().getX() >= 500) {
                    JOptionPane.showMessageDialog(null, "Perdiste, tus puntos son: " + puntos);
                    System.exit(0);
                }
                if (cabeza.getLocation().getY() >= 500) {
                    JOptionPane.showMessageDialog(null, "Perdiste, tus puntos son: " + puntos);
                    System.exit(0);
                }
                if (cabeza.getLocation().getX() < 0) {
                    JOptionPane.showMessageDialog(null, "Perdiste, tus puntos son: " + puntos);
                    System.exit(0);
                }
                if (cabeza.getLocation().getY() < 0) {
                    JOptionPane.showMessageDialog(null, "Perdiste, tus puntos son: " + puntos);
                    System.exit(0);
                }
            }
        };
        p.schedule(movimiento, 0, 100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Puntos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 359, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(502, Short.MAX_VALUE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSnake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSnake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSnake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSnake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSnake().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed");
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (direccion != 3)
                direccion = 4;
            // ARRIBA
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (direccion != 4)
                direccion = 3;
            // ABAJO
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (direccion != 1)
                direccion = 2;
            // IZQUIERDA
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (direccion != 2)
                direccion = 1;
            // DERECHA
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
