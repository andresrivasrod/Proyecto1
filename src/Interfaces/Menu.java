/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import Clases.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author andresrivas
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        leerTxt();
    }
    
    public static ListaUser listaUser = new ListaUser();
    public static ListaRelation listaRelation = new ListaRelation();
    public static Grafo grafo = new Grafo(listaUser, listaRelation);
    
    public boolean validarEspacio(String palabra) {//Método para validar que no hayan solo espacios
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (c == ' ') {
                contador += 0;
            } else {
                contador += 1;
            }
        }
        return (contador == 0);
    }
    
    public void leerTxt() {//Método para leer el archivo txt
        try {
            ListaUser listaUser1 = new ListaUser();
            ListaRelation listaRelation1 = new ListaRelation();
            String line;
            int caso = -1;
            int user1, user2, tiempo;
            String path = "test\\usuarios.txt";
            File file = new File(path);

            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (line.toLowerCase().equals("usuarios")) {
                        caso = 0;
                    } else if (!line.isEmpty() && !validarEspacio(line) && !"\n".equals(line) && caso == 0 && line.contains(",")) {
                        String[] datosUser = line.split(",");
                        listaUser1.añadirElemento(datosUser[1], Integer.parseInt(datosUser[0]));
                    } else if (line.toLowerCase().equals("relaciones")) {
                        caso = 1;
                    } else if (!line.isEmpty() && !validarEspacio(line) && !"\n".equals(line) && caso == 1 && line.contains(",")) {
                        String[] datosRlation = line.split(",");
                        user1 = Integer.parseInt(datosRlation[0]);
                        user2 = Integer.parseInt(datosRlation[1]);
                        tiempo = Integer.parseInt(datosRlation[2]);
                        listaRelation1.añadirElemento(user1, user2, tiempo);
                    }
                }
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al leer el archivo");
            }
            listaUser = listaUser1;
            listaRelation = listaRelation1;
            if (listaRelation.getTamaño() > 0){
                NodoRelation aux = listaRelation.getFirst();
                boolean tiempoCero = false;
                for (int i = 0; i < listaRelation.getTamaño(); i++) {
                    if (aux.getTiempo() == 0){
                        tiempoCero = true;
                    }
                    aux = aux.getSiguiente();
                }
                if (tiempoCero){
                    JOptionPane.showMessageDialog(null, "Uno de los tiempos de amistad es 0, se vaciara el txt para corregir esto.");
                    vaciarTxt();
                    leerTxt();
                }
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Hubo un error al leer el archivo. Se vaciara para corregir.");
            vaciarTxt();
            leerTxt();
        }
    }

    public void vaciarTxt() {//Método para eliminar el contenido del txt
        String textoBase = "usuarios\n" +
"121, @Pepe_Gónzales\n" +
"254, @StephaniaCominos\n" +
"365, @AndreaStanislao\n" +
"412, @Josefina_La_Sifrina\n" +
"512, @RosaMosa\n" +
"231, @EduardoPetardo\n" +
"123, @EnriqueManrique\n" +
"129, @casanova23\n" +
"870, @venepositivo\n" +
"758, @yosoylatorre\n" +
"578, @pitiypo\n" +
"909, @obiwan123\n" +
"893, @caribu_sol\n" +
"467, @trapos232\n" +
"788, @bandido121\n" +
"239, @justiciero11\n" +
"443, @fuerza_bruta\n" +
"907, @Presentesiempre\n" +
"relaciones\n" +
"121, 254, 7\n" +
"121, 909, 8\n" +
"254,909,5\n" +
"909, 893, 5\n" +
"254, 893, 1\n" +
"893, 129, 3\n" +
"129, 512, 10\n" +
"512, 412, 2\n" +
"893, 412, 4\n" +
"231, 870, 5\n" +
"231, 123, 1\n" +
"123, 870, 15\n" +
"123, 467, 6\n" +
"788, 239, 7\n" +
"788, 443, 11\n" +
"239, 443, 6\n" +
"239, 907, 3\n" +
"443, 907, 9\n" +
"788, 412, 7\n" +
"870, 578, 7\n" +
"870, 758, 1\n" +
"758, 365, 9\n" +
"578, 365, 4";
        try {
            PrintWriter pw = new PrintWriter("test\\usuarios.txt");
            pw.println(textoBase);
            pw.close();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error al vaciar el repositorio.");
        }

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MostrarIslasDfs1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MostrarGrafo = new javax.swing.JButton();
        MostrarIslasDfs = new javax.swing.JButton();
        MostrarPuentes = new javax.swing.JButton();
        MostrarIslasBfs = new javax.swing.JButton();

        MostrarIslasDfs1.setText("Mostrar Islas (DFS)");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        Close.setBackground(new java.awt.Color(255, 51, 51));
        Close.setForeground(new java.awt.Color(255, 255, 255));
        Close.setText("X");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Red Social");

        MostrarGrafo.setText("Mostrar Grafo");
        MostrarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarGrafoActionPerformed(evt);
            }
        });

        MostrarIslasDfs.setText("Mostrar Islas (DFS)");
        MostrarIslasDfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarIslasDfsActionPerformed(evt);
            }
        });

        MostrarPuentes.setText("Mostrar Puentes");
        MostrarPuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarPuentesActionPerformed(evt);
            }
        });

        MostrarIslasBfs.setText("Mostrar Islas (BFS)");
        MostrarIslasBfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarIslasBfsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Close))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MostrarGrafo)
                    .addComponent(MostrarIslasDfs))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MostrarPuentes)
                    .addComponent(MostrarIslasBfs))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Close)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MostrarGrafo)
                    .addComponent(MostrarPuentes))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MostrarIslasDfs)
                    .addComponent(MostrarIslasBfs))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void MostrarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarGrafoActionPerformed
        MostrarGrafo graf = new MostrarGrafo();
        graf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MostrarGrafoActionPerformed

    private void MostrarIslasDfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarIslasDfsActionPerformed
        MostrarIslasDFS islas = new MostrarIslasDFS();
        islas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MostrarIslasDfsActionPerformed

    private void MostrarIslasBfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarIslasBfsActionPerformed
        MostrarIslasBFS islas = new MostrarIslasBFS();
        islas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MostrarIslasBfsActionPerformed

    private void MostrarPuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarPuentesActionPerformed
        MostrarPuentes puentes = new MostrarPuentes();
        puentes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MostrarPuentesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close;
    private javax.swing.JButton MostrarGrafo;
    private javax.swing.JButton MostrarIslasBfs;
    private javax.swing.JButton MostrarIslasDfs;
    private javax.swing.JButton MostrarIslasDfs1;
    private javax.swing.JButton MostrarPuentes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
