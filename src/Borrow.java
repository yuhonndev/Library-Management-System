
import java.awt.Component;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Borrow extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(Borrow.class.getName());
    
    Connection con;
     PreparedStatement pst;
     ResultSet rs;


  public Borrow() {
    initComponents();
    Connect();         
    BorrowData();
    
    
jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            txtborrowid.setText(jTable1.getValueAt(row, 0).toString());
            txtname.setText(jTable1.getValueAt(row, 1).toString());
            txtbook.setText(jTable1.getValueAt(row, 2).toString());
            txtsection.setText(jTable1.getValueAt(row, 3).toString());

            Object dateValue = jTable1.getValueAt(row, 4);
            if (dateValue != null) {
                try {
                    java.util.Date borrowDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateValue.toString());
                    txtdateborrow.setDate(borrowDate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                txtdateborrow.setDate(null); 
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
     public void BorrowData() {
    try {
        
        pst = con.prepareStatement("SELECT * FROM borrow");
        rs = pst.executeQuery();

    
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            Vector v = new Vector();
            v.add(rs.getInt("borrowid"));                  
            v.add(rs.getString("name"));             
            v.add(rs.getString("book"));             
            v.add(rs.getString("section"));          
            v.add(rs.getDate("dateborrow"));        
            model.addRow(v);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
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
        txtborrowid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtbook = new javax.swing.JTextField();
        txtsection = new javax.swing.JTextField();
        btninsert = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btndelete = new javax.swing.JButton();
        txtdateborrow = new com.toedter.calendar.JDateChooser();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Borrow");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel7.setText("BOOK BORROWING");

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
                .addContainerGap(248, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(200, 200, 200)
                .addComponent(jButton2)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText(" STUDENT ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText(" NAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("BOOK");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("SECTION");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));
        getContentPane().add(txtborrowid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 300, -1));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 300, -1));
        getContentPane().add(txtbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 300, -1));

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
                " ID", "Name", "book", "section", "Dateborrow"
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
        getContentPane().add(txtdateborrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 300, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel8.setText("DATE BORROW");
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
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsectionActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
try {
        Connect(); 

        pst = con.prepareStatement(
    "INSERT INTO borrow(borrowid, name, book, section, dateborrow) VALUES(?, ?, ?, ?, ?)"
);
       pst.setInt(1, Integer.parseInt(txtborrowid.getText())); 
       pst.setString(2, txtname.getText());
       pst.setString(3, txtbook.getText());
       pst.setString(4, txtsection.getText());

   java.util.Date utilDate = txtdateborrow.getDate();
   java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
   pst.setDate(5, sqlDate);

    pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Record Inserted Successfully");
        BorrowData(); 

        
        txtname.setText("");
        txtbook.setText("");
        txtsection.setText("");
        txtdateborrow.setDate(null);

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
Object borrowidObj = model.getValueAt(selectedRow, 0); 
String borrowid = borrowidObj.toString().trim();

int confirm = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete this record?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION);

if (confirm != JOptionPane.YES_OPTION) return;

try {
    pst = con.prepareStatement("DELETE FROM borrow WHERE BorrowID = ?");
    pst.setInt(1, Integer.parseInt(borrowid));

    int rows = pst.executeUpdate();

    if (rows > 0) {
        JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
        BorrowData(); 
    } else {
        JOptionPane.showMessageDialog(this, "No record found with this BorrowID!");
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
  
        String borrowid = txtborrowid.getText();
        String name = txtname.getText();
        String book = txtbook.getText();
        String section = txtsection.getText();

        
        java.util.Date utilDate = txtdateborrow.getDate();
        if (utilDate == null) {
            JOptionPane.showMessageDialog(this, "choose date");
            return;
        }
        java.sql.Date dateborrow = new java.sql.Date(utilDate.getTime()); 

       
        if (borrowid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "select the table");
            return;
        }

      
     pst = con.prepareStatement(
    "UPDATE borrow SET name = ?, book = ?, section = ?, dateborrow = ? WHERE borrowid = ?"
);
pst.setString(1, name);
pst.setString(2, book);
pst.setString(3, section);
pst.setDate(4, dateborrow); 
pst.setString(5, borrowid);
        int updated = pst.executeUpdate();

        if (updated > 0) {
            JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
            BorrowData(); 
        } else {
            JOptionPane.showMessageDialog(this, "No record found with that Borrow ID.");
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
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextField txtbook;
    private javax.swing.JTextField txtborrowid;
    private com.toedter.calendar.JDateChooser txtdateborrow;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsection;
    // End of variables declaration//GEN-END:variables
}
