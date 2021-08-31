/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.util.Timer;
import java.util.TimerTask;
import modelo.Estaticos;

/**
 *
 * @author 55159
 */
public class frmPrincipal extends javax.swing.JDialog
{

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        txfNumero1 = new javax.swing.JTextField();
        txfNumero2 = new javax.swing.JTextField();
        lblSoma = new javax.swing.JLabel();
        lblSubtracao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txfNumero1.addCaretListener(new javax.swing.event.CaretListener()
        {
            public void caretUpdate(javax.swing.event.CaretEvent evt)
            {
                txfNumero1onChange(evt);
            }
        });

        txfNumero2.addCaretListener(new javax.swing.event.CaretListener()
        {
            public void caretUpdate(javax.swing.event.CaretEvent evt)
            {
                txfNumero2onChanged(evt);
            }
        });

        lblSoma.setText("Resposta da Soma");

        lblSubtracao.setText("Resposta da Subtracao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtracao)
                    .addComponent(lblSoma)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txfNumero1)
                        .addComponent(txfNumero2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(txfNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txfNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lblSoma)
                .addGap(18, 18, 18)
                .addComponent(lblSubtracao)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    Timer timer = new Timer();
    
    public void executar()
    {
        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                lblSoma.setText(Estaticos.soma.toString());
                lblSubtracao.setText(Estaticos.subtracao.toString());
            }
        }, 100, 500);
        
        try
        {
            Estaticos.n1 = Double.parseDouble(txfNumero1.getText());
        } catch (Exception e)
        {
            Estaticos.n1 = 0.0;
        }
        try
        {
            Estaticos.n2 = Double.parseDouble(txfNumero2.getText());
        } catch (Exception e)
        {
            Estaticos.n2 = 0.0;
        }
        lblSoma.setText(Estaticos.soma.toString());
        lblSubtracao.setText(Estaticos.subtracao.toString());
    }
    
    private void txfNumero1onChange(javax.swing.event.CaretEvent evt)//GEN-FIRST:event_txfNumero1onChange
    {//GEN-HEADEREND:event_txfNumero1onChange
        executar();
    }//GEN-LAST:event_txfNumero1onChange

    private void txfNumero2onChanged(javax.swing.event.CaretEvent evt)//GEN-FIRST:event_txfNumero2onChanged
    {//GEN-HEADEREND:event_txfNumero2onChanged
        executar();
    }//GEN-LAST:event_txfNumero2onChanged

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                frmPrincipal dialog = new frmPrincipal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSoma;
    private javax.swing.JLabel lblSubtracao;
    private javax.swing.JTextField txfNumero1;
    private javax.swing.JTextField txfNumero2;
    // End of variables declaration//GEN-END:variables
}