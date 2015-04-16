
package stock_market;


public class predictedResult extends javax.swing.JFrame {

    /** Creates new form predictedResult */
    public predictedResult(String data_arr[][]) {
        initComponents();
      
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data_arr,
            new String [] {
                "Date DD/MM/YYYY", "Predicted Open","Actual Open","Predicted High","Actual High","Predicted Low","Actual Low"
 }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class,java.lang.String.class,java.lang.String.class,
                java.lang.String.class,java.lang.String.class,java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false,false,false,false,false,false,false
            };

                @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

                @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Predicted Table");
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(200, 200, 0, 0));
        setMaximumSize(new java.awt.Dimension(900, 500));
        setMinimumSize(new java.awt.Dimension(900, 500));
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Date(DD/MM/YYYY)", "Predicted Open", "Actual Open", "Predicted High", "Actual High", "Predicted Low", "Actual Low"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(5);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(5);
        jTable1.getColumnModel().getColumn(0).setHeaderValue("Date(DD/MM/YYYY)");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Predicted Open");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Actual Open");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Predicted High");
        jTable1.getColumnModel().getColumn(4).setHeaderValue("Actual High");
        jTable1.getColumnModel().getColumn(5).setHeaderValue("Predicted Low");
        jTable1.getColumnModel().getColumn(6).setHeaderValue("Actual Low");

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 880, 133);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(314, 240, 80, 27);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stock_market/business-stock market2-backgorunds-powerpoint.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -100, 1230, 680);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 40, 1020, 780);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // TODO add your handling code here:
try {
this.setVisible(false);  
Global.d.setVisible(true);
} catch(Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
