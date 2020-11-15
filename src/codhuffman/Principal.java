/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codhuffman;

/**
 *
 * @author ALEJANDRA
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rCadena = new javax.swing.JTextField();
        btnComprimir = new javax.swing.JButton();
        lbComp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbDiccionario = new javax.swing.JLabel();
        lbBinario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbDescomprimir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(rCadena, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 54, 139, -1));

        btnComprimir.setText("Comprimir");
        btnComprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnComprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 96, -1, -1));

        lbComp.setText("jLabel1");
        getContentPane().add(lbComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jLabel2.setText("%");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        lbDiccionario.setText("jLabel1");
        getContentPane().add(lbDiccionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 159, -1, -1));

        lbBinario.setText("jLabel1");
        getContentPane().add(lbBinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jLabel3.setText("Diccionario:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 159, -1, -1));

        jLabel4.setText("Binario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel5.setText("Cadena Ascii:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jButton1.setText("Descomprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        lbDescomprimir.setText("jLabel1");
        getContentPane().add(lbDescomprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprimirActionPerformed
        // TODO add your handling code here:
        String cadenaR = rCadena.getText();
        //
        CodHuffman h = new CodHuffman(cadenaR);
        Lista l = h.ToNodos();
        ListaArboles la = h.cuentaLetras(l);
        ListaArboles l2 = h.juntaNodo(la);
        h.encuentraCamino(l2.getInicio().getDato().getRaiz(), "");
        Lista listaCaminos = h.regresaCaminos();
        listaCaminos.recorrer2();///dicionario RECORRIDO
        String x = h.convierte(listaCaminos);//binario
        System.out.println("Binario" + x);
        String dic = listaCaminos.mandarCadenaDiccionario();// diccionario como string
        System.out.println("dic"+dic);
        lbComp.setText(h.encripta(x));
        lbDiccionario.setText(dic);
        lbBinario.setText(x);
        //
        h.crearTxtCadena(x);
        h.crearTxtDic(dic);

    }//GEN-LAST:event_btnComprimirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CodHuffman h = new CodHuffman();
        lbDescomprimir.setText(h.desencripta());
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbBinario;
    private javax.swing.JLabel lbComp;
    private javax.swing.JLabel lbDescomprimir;
    private javax.swing.JLabel lbDiccionario;
    private javax.swing.JTextField rCadena;
    // End of variables declaration//GEN-END:variables
}