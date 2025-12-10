import java.awt.Component;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Returnbook extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(Returnbook.class.getName());
    
     Connection con;
     PreparedStatement pst;
     ResultSet rs;


  public Returnbook() {
    initComponents();
    Connect();         
    ReturnbookData();
    
   jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            txtstudentid.setText(jTable1.getValueAt(row, 0).toString());
            txtstudentname.setText(jTable1.getValueAt(row, 1).toString());
            txtbookname.setText(jTable1.getValueAt(row, 2).toString());
            txtsection.setText(jTable1.getValueAt(row, 3).toString());

            Object dateValue = jTable1.getValueAt(row, 4);
            if (dateValue != null) {
                try {
                    java.util.Date borrowDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateValue.toString());
                    txtreturndate.setDate(borrowDate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                txtreturndate.setDate(null); 
            }
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
    public void ReturnbookData() {
   try {
        pst = con.prepareStatement("SELECT * FROM returnbook");
        rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 

        while (rs.next()) {
            Object[] row = {
                rs.getString("studentid"),
                rs.getString("studentname"),
                rs.getString("bookname"),
                rs.getString("section"),
                rs.getString("returndate")
            };
            model.addRow(row);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading returnbook data: " + ex.getMessage());
    }
}




    



          
             @SuppressWarnings("unchecked")
             // <editor-fold defaultstate="collapsed" desc="Generated Code">
             
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtstudentid = new javax.swing.JTextField();
        txtstudentname = new javax.swing.JTextField();
        txtbookname = new javax.swing.JTextField();
        txtsection = new javax.swing.JTextField();
        btninsert = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btndelete = new javax.swing.JButton();
        txtreturndate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

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

        jButton7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LEAVEE ICON.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Returnbook");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel7.setText("RETURN BOOK");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton2)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText(" STUDENT ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText("STUDENT NAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("BOOK NAME");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("SECTION");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));
        getContentPane().add(txtstudentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 300, -1));
        getContentPane().add(txtstudentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 300, -1));
        getContentPane().add(txtbookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 300, -1));

        txtsection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsectionActionPerformed(evt);
            }
        });
        getContentPane().add(txtsection, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 300, -1));

        btninsert.setText("INSERT");
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });
        getContentPane().add(btninsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 90, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentID", "Name", "BookName", "section", "Return Date"
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
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 90, 30));
        getContentPane().add(txtreturndate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 300, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel8.setText("RETURN DATE");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 90, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OFFICIAL BACKGROUND.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 900, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsectionActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
 try {
    String studentid = txtstudentid.getText().trim();
    String studentname = txtstudentname.getText().trim();
    String bookname = txtbookname.getText().trim();
    String section = txtsection.getText().trim(); 
    java.util.Date utilDate = txtreturndate.getDate();

    if (studentname.isEmpty() || bookname.isEmpty() || section.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    if (utilDate == null) {
        JOptionPane.showMessageDialog(this, "Please select a return date.");
        return;
    }

    java.sql.Date returnDate = new java.sql.Date(utilDate.getTime());

 pst = con.prepareStatement(
    "INSERT INTO returnbook(studentid, studentname, bookname, section, returndate) VALUES(?, ?, ?, ?, ?)"
);
    pst.setString(1, studentid);
    pst.setString(2, studentname);
    pst.setString(3, bookname);
    pst.setString(4, section);
    pst.setDate(5, returnDate);

    pst.executeUpdate();

    JOptionPane.showMessageDialog(this, "Return book inserted successfully!");
    ReturnbookData(); 

    
    txtstudentname.setText("");
    txtbookname.setText("");
    txtsection.setText("");
    txtreturndate.setDate(null);

    pst.close();

} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
}






    }//GEN-LAST:event_btninsertActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
  int selectedRow = jTable1.getSelectedRow();
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Please select a row to delete.");
    return;
}


DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
String returnid = model.getValueAt(selectedRow, 0).toString().trim();


int confirm = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete this record?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION);

if (confirm != JOptionPane.YES_OPTION) return;

try {
    
    pst = con.prepareStatement("DELETE FROM returnbook WHERE studentid = ?");
    pst.setString(1, returnid);

    int rows = pst.executeUpdate();

    if (rows > 0) {
        JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
        ReturnbookData(); 
    } else {
        JOptionPane.showMessageDialog(this, "No record found with this ID!");
    }

    pst.close();

} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
}




    }//GEN-LAST:event_btndeleteActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
    String studentid = txtstudentid.getText();
    String name = txtstudentname.getText();
    String book = txtbookname.getText();
    String section = txtsection.getText();

    java.util.Date utilDate = txtreturndate.getDate();
    if (utilDate == null) {
        JOptionPane.showMessageDialog(this, "Pumili muna ng date!");
        return;
    }

    java.sql.Date returndate = new java.sql.Date(utilDate.getTime());

    if (studentid.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pumili ka muna ng record sa table!");
        return;
    }

    pst = con.prepareStatement(
        "UPDATE `returnbook` SET studentname = ?, bookname = ?, section = ?, returndate = ? WHERE studentid = ?"
    );

    pst.setString(1, name);
    pst.setString(2, book);
    pst.setString(3, section);
    pst.setDate(4, returndate);
    pst.setString(5, studentid);

    int updated = pst.executeUpdate();

    if (updated > 0) {
        JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
        ReturnbookData(); 
    } else {
        JOptionPane.showMessageDialog(this, "No record found with that Student ID.");
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
        java.awt.EventQueue.invokeLater(() -> new Borrow().setVisible(true));
    }

    void setvisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtbookname;
    private com.toedter.calendar.JDateChooser txtreturndate;
    private javax.swing.JTextField txtsection;
    private javax.swing.JTextField txtstudentid;
    private javax.swing.JTextField txtstudentname;
    // End of variables declaration//GEN-END:variables
}
