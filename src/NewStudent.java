
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NewStudent extends javax.swing.JFrame {
   private static final Logger logger = Logger.getLogger(NewStudent.class.getName());
     Connection con;
     PreparedStatement pst;
     ResultSet rs;


  public NewStudent() {
    initComponents();
    Connect();       
    table_update();   
    StudentData();
    
  
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = jTable1.getSelectedRow();
            if (row != -1) {
                txtid.setText(jTable1.getValueAt(row, 0).toString());       
                txtname.setText(jTable1.getValueAt(row, 1).toString());     
                txtyear.setText(jTable1.getValueAt(row, 2).toString());     
                txtsection.setText(jTable1.getValueAt(row, 3).toString());  

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
            pst = con.prepareStatement("SELECT * FROM student");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
                Vector v2 = new Vector();
           v2.add(rs.getString("id"));
           v2.add(rs.getString("name"));
           v2.add(rs.getString("year")); 
           v2.add(rs.getString("section"));    
            d.addRow(v2);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Table load failed: " + e.getMessage());
        }
    }

   private void StudentData() {
   
    try {
        pst = con.prepareStatement("SELECT * FROM student");
        ResultSet Rs = pst.executeQuery();

        DefaultTableModel DFG = (DefaultTableModel) jTable1.getModel();
        DFG.setRowCount(0); 

        while (Rs.next()) {
            Vector v2 = new Vector();

            v2.add(Rs.getString("id"));
            v2.add(Rs.getString("name"));
            v2.add(Rs.getString("year"));
            v2.add(Rs.getString("section")); 

            DFG.addRow(v2);
        }

    } catch (SQLException ex) {
        Logger.getLogger(NewStudent.class.getName()).log(Level.SEVERE, null, ex);
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
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtyear = new javax.swing.JTextField();
        txtsection = new javax.swing.JTextField();
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
        jLabel7.setText("NEW STUDENT");

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
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229)
                .addComponent(jButton2)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton2)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText("STUDENT ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText(" NAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("YEAR");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("SECTION");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 300, -1));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 300, -1));
        getContentPane().add(txtyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 300, -1));

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
        getContentPane().add(btninsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 90, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentID", "Name", "Year", "Section"
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

    private void txtsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsectionActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
        String id = txtid.getText();
        String name = txtname.getText();
        String year = txtyear.getText();
        String section = txtsection.getText();
        
        try {
         Connect(); 

Connect(); 

pst = con.prepareStatement(
    "INSERT INTO student (id, name, year, section) VALUES (?, ?, ?, ?)"
);
pst.setString(1, id);
pst.setString(2, name);
pst.setString(3, year);    
pst.setString(4, section);  
  

pst.executeUpdate();

JOptionPane.showMessageDialog(this, "Record inserted successfully!");


            JOptionPane.showMessageDialog(this, "Record Added Successfully!");
            StudentData();
            
            
            
            txtid.setText("");
            txtname.setText("");
            txtyear.setText("");
            txtsection.setText("");
            txtid.requestFocus();

            table_update();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
           
 
    }//GEN-LAST:event_btninsertActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int selectedRow = jTable1.getSelectedRow();
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Please select a student to delete.");
    return;
}

DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
Object idObj = model.getValueAt(selectedRow, 0); 
if (idObj == null || idObj.toString().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Selected row has empty ID.");
    return;
}

String studentId = idObj.toString().trim();
System.out.println("Deleting Student ID: '" + studentId + "'"); 

int confirm = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete this student?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION);

if (confirm != JOptionPane.YES_OPTION) return;

try {
    pst = con.prepareStatement("DELETE FROM student WHERE id = ?");
    pst.setInt(1, Integer.parseInt(studentId)); 

    int rows = pst.executeUpdate();

    if (rows > 0) {
        JOptionPane.showMessageDialog(this, "Student deleted successfully!");
        StudentData(); 
    } else {
        JOptionPane.showMessageDialog(this, "No record found with this ID!");
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
        String studentid = txtid.getText();
        String name = txtname.getText();
        String year = txtyear.getText();
        String section = txtsection.getText();

        if (studentid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pumili ka muna ng record sa table!");
            return;
        }

      pst = con.prepareStatement(
    "UPDATE student SET name = ?, year = ?, section = ? WHERE id = ?"
);
pst.setString(1, name);
pst.setString(2, year);     
pst.setString(3, section);  
pst.setString(4, studentid);


        int updated = pst.executeUpdate();

        if (updated > 0) {
            JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
                StudentData(); // refresh table
        } else {
            JOptionPane.showMessageDialog(this, "No record found with that Book ID.");
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
        java.awt.EventQueue.invokeLater(() -> new NewStudent().setVisible(true));
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
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsection;
    private javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}