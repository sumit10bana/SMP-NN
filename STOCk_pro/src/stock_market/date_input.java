
package stock_market;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.beans.*;
import java.applet.*;

public class date_input extends javax.swing.JDialog {

    public static int cnt=0;
    public static int  tnt, network = 0,flag=0;
    public static String Day, Mon, Year, y;

    
    public date_input(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jDialog1.setMaximumSize(new java.awt.Dimension(3000, 3000));
        jDialog1.setSize(500, 600);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Stock Market Prediction");
        setBounds(new java.awt.Rectangle(250, 150, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(570, 590));
        setName(""); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Predict");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 430, 120, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DATE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 370, 62, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Train");
        jButton3.setHideActionText(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(230, 280, 80, 30);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 0, 0);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(130, 180, 70, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Learning Rate");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 180, 100, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Epoch");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 180, 60, 30);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(470, 180, 70, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Hidden Layers");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(220, 180, 90, 30);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "2" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(320, 180, 60, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Activation Fn");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(280, 230, 90, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sigmoid", "Tanh" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(370, 230, 100, 30);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(450, 513, 0, 0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(796, 796, 995, 0);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(130, 370, 140, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("(dd-mon-yyyy)");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 360, 110, 40);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Adobe", "Google", "Ford", "Yahoo" }));
        jComboBox2.setName("jj"); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(130, 230, 100, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Select Company");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 230, 100, 30);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 500, 600, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stock_market/cr_mega_779_BSE-161.jpg"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(600, 700));
        jLabel3.setMinimumSize(new java.awt.Dimension(500, 470));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 140, 820, 570);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 90, 90);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(80, 0, 510, 90);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(0, 90, 600, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static String convertInteger(int i) {
        return Integer.toString(i);
    }
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String s = jTextField1.getText();
    try { y=s;
    if(s.equalsIgnoreCase("23-Nov-2013"))
    { s="22-Nov-2013";
    // s = s.trim();
            STOCK_MARKET.Date = s;
            cnt=1;
             STOCK_MARKET.func();
                this.setVisible(false);
            Global.d = this;
    }
    }
            catch (IOException ex) {
            Logger.getLogger(date_input.class.getName()).log(Level.SEVERE, null, ex);
    
    }
    
        
     
  
    
    if (network != 1) {
        JOptionPane.showMessageDialog(null, "first train the network", " warning", JOptionPane.WARNING_MESSAGE);
    } else {
        try {
            s = s.trim();
            STOCK_MARKET.Date = s;

            STOCK_MARKET.func();
            if(STOCK_MARKET.set==0)
                JOptionPane.showMessageDialog(null, "Can't be Predicted", " warning", JOptionPane.WARNING_MESSAGE);
else
            {
            this.setVisible(false);
            Global.d = this;
            }

        } catch (IOException ex) {
            Logger.getLogger(date_input.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    STOCK_MARKET obj;
    cnt = 0;
    tnt = 0;

    String s3 = jTextField2.getText();
    if (s3.contentEquals("")) {
        JOptionPane.showMessageDialog(null, "learning rate field should not be empty", "Message", JOptionPane.ERROR_MESSAGE);
    } else {
        double alpha = Double.parseDouble(s3);
        if (alpha > 1) {
            JOptionPane.showMessageDialog(null, "enter the learning rate b/w 0 to 1 ", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            Training.alpha = alpha;
            cnt = 1;
        }
    }



    String s4 = jTextField3.getText();
    if (s4.contentEquals("")) {
        JOptionPane.showMessageDialog(null, "Epoch field  should not be empty ", "Message", JOptionPane.ERROR_MESSAGE);
    } else {
        int epoch = Integer.parseInt(s4);
        if (epoch < 10) {
            JOptionPane.showMessageDialog(null, "enter the epochs >10 ", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            tnt = 1;
            Training.epoch2 = epoch;
        }
    }

    String text = (String) jComboBox1.getSelectedItem();
    if (text.equalsIgnoreCase("Sigmoid")) {
        flag = 1;
    } else {
        flag = 2;
    }

    if (cnt == 1 && tnt == 1) {
        Object[] options = {"Yes, please", "No, thanks"};
        int n = JOptionPane.showOptionDialog(null,
                "Would you like to train the network "
                + "",
                "Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (n == 0) {
            network = 1;
            JOptionPane.showMessageDialog(null, "training started ");
            obj = new STOCK_MARKET();

            try {
                obj.Training();


                JOptionPane.showMessageDialog(null, "training over ");
                cnt = 0;
                tnt = 0;


            } catch (IOException ex) {
                Logger.getLogger(date_input.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}//GEN-LAST:event_jButton3ActionPerformed

private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jTextField2ActionPerformed

    STOCK_MARKET sm = new STOCK_MARKET();

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here
        String s = (String) jComboBox2.getSelectedItem();//get the selected item  
        
        if (s.equals("Google")) {
            
            sm.setFileName("E://Study Mat//5th sem//Project//Final//STOCk_pro//google.txt");
            System.out.println(s);
        } else if (s.equals("Yahoo")) {
            sm.setFileName("E://Study Mat//5th sem//Project//Final//STOCk_pro//yahoo.txt");
            System.out.println(s);
        } else if (s.equals("Ford")) {
            sm.setFileName("E://Study Mat//5th sem//Project//Final//STOCk_pro//ford.txt");
            System.out.println(s);
        } else if (s.equals("Adobe")) {
            sm.setFileName("E://Study Mat//5th sem//Project//Final//STOCk_pro//adobe.txt");
            System.out.println(s);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(date_input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(date_input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(date_input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(date_input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                date_input dialog = new date_input(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
