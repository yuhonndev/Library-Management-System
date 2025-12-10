
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Librarian extends javax.swing.JFrame {
   private static final Logger logger = Logger.getLogger(NewStudent.class.getName());
     Connection con;
     PreparedStatement pst;
     ResultSet rs;

private String originalEmail = ""; 

  public Librarian() {
    initComponents();
    Connect();       
    table_update();   
    LibrarianData();
    
jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            txtname.setText(jTable1.getValueAt(row, 0).toString());
            txtposition.setText(jTable1.getValueAt(row, 1).toString());
            txtemail.setText(jTable1.getValueAt(row, 2).toString());
            txtaddress.setText(jTable1.getValueAt(row, 3).toString());

            originalEmail = jTable1.getValueAt(row, 2).toString(); 
        }
    }
});

}


    public void Connect() {
        String SUrl  = "jdbc:mysql://localhost:3306/borrowingdb"; 
        String SUser = "java_user";
        String SPass = ""; 
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(SUrl, SUser, SPass); 
            System.out.println("Database connected successfully!");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage());
            this.con = null; 
        }
    }
       public void table_update() {
        int c;
        try {
            Connect();
            pst = con.prepareStatement("SELECT * FROM librarian");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("position"));
                    v2.add(rs.getString("email"));
                    v2.add(rs.getString("address"));
                }
                d.addRow(v2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Table load failed: " + e.getMessage());
        }
    }

   private void LibrarianData() {
   
    try {
        pst = con.prepareStatement("SELECT * FROM librarian");
        ResultSet Rs = pst.executeQuery();

        DefaultTableModel DFG = (DefaultTableModel) jTable1.getModel();
        DFG.setRowCount(0); 

        while (Rs.next()) {
            Vector v2 = new Vector();

            v2.add(Rs.getString("name"));
            v2.add(Rs.getString("position"));
            v2.add(Rs.getString("email"));
            v2.add(Rs.getString("address")); 

            DFG.addRow(v2);
        }

    } catch (SQLException ex) {
        Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
    }
   }

    



             
             
             
             
             @SuppressWarnings("unchecked")
             // <editor-fold defaultstate="collapsed" desc="Generated Code">
             
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtposition = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        btninsert = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NewStudent");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel7.setText("LIBRARIAN");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(287, 287, 287)
                .addComponent(jButton2)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText("NAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("POSITION");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("EMAIL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("ADDRESS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 300, -1));
        getContentPane().add(txtposition, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 300, -1));
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 300, -1));

        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 300, -1));

        btninsert.setText("INSERT");
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });
        getContentPane().add(btninsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 90, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Position", "Email", "Address"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 390, 310));

        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 90, 30));

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 90, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OFFICIAL BACKGROUND.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 900, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
        String name = txtname.getText();
        String position = txtposition.getText();
        String email = txtemail.getText();
        String address = txtaddress.getText();
        
        try {
         Connect(); 

Connect(); 

pst = con.prepareStatement(
    "INSERT INTO librarian (name, position, email, address) VALUES (?, ?, ?, ?)"
);
pst.setString(1, name);
pst.setString(2, position);      
pst.setString(3, email);      
pst.setString(4, address);   

pst.executeUpdate();

JOptionPane.showMessageDialog(this, "Record inserted successfully!");


            JOptionPane.showMessageDialog(this, "Record Added Successfully!");
            LibrarianData();
            
            
            
            txtname.setText("");
            txtposition.setText("");
            txtemail.setText("");
            txtaddress.setText("");
            txtname.requestFocus();

            table_update();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
           
 
    }//GEN-LAST:event_btninsertActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
      int selectedRow = jTable1.getSelectedRow();
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Please select a record to delete.");
    return;
}

DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
String name = model.getValueAt(selectedRow, 0).toString(); 
String email = model.getValueAt(selectedRow, 2).toString(); 

int confirm = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete this record?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION);

if (confirm != JOptionPane.YES_OPTION) return;

try {
    pst = con.prepareStatement("DELETE FROM librarian WHERE name = ? AND email = ?");
    pst.setString(1, name);
    pst.setString(2, email);

    int rows = pst.executeUpdate();

    if (rows > 0) {
        JOptionPane.showMessageDialog(this, "Record deleted successfully!");
        LibrarianData(); 
    } else {
        JOptionPane.showMessageDialog(this, "No record found with this Name and Email!");
    }

    pst.close();

} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
}

    }//GEN-LAST:event_btndeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
                                          
    try {
        String name = txtname.getText().trim();
        String position = txtposition.getText().trim();
        String email = txtemail.getText().trim();
        String address = txtaddress.getText().trim();

        if (originalEmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pumili ka muna ng record sa table!");
            return;
        }

        pst = con.prepareStatement(
            "UPDATE librarian SET name=?, position=?, email=?, address=? WHERE email=?"
        );
        pst.setString(1, name);
        pst.setString(2, position);
        pst.setString(3, email);           
        pst.setString(4, address);
        pst.setString(5, originalEmail);   

        int updated = pst.executeUpdate();

        if (updated > 0) {
            JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
            LibrarianData(); 

            // Clear fields
            txtname.setText("");
            txtposition.setText("");
            txtemail.setText("");
            txtaddress.setText("");
            txtname.requestFocus();

            originalEmail = ""; 
        } else {
            JOptionPane.showMessageDialog(this, "No record found with that email.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }




            





    }//GEN-LAST:event_btnupdateActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Librarian().setVisible(true));
    }

    void setvisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtposition;
    // End of variables declaration//GEN-END:variables
}