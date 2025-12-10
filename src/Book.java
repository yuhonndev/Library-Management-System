import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Book extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(Book.class.getName());

     Connection con;
     PreparedStatement pst;
     ResultSet rs;
    private String bookid;


  public Book() {
    initComponents();
    Connect();       
    table_update();   
    BookData();
    
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            txtbookid.setText(jTable1.getValueAt(row, 0).toString());      
            txtbookname.setText(jTable1.getValueAt(row, 1).toString());  
            txtauthor.setText(jTable1.getValueAt(row, 2).toString());       
            txtpublisher.setText(jTable1.getValueAt(row, 3).toString());   
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
            pst = con.prepareStatement("SELECT * FROM book");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("bookid"));
                    v2.add(rs.getString("bookname"));
                    v2.add(rs.getString("author"));
                    v2.add(rs.getString("publisher"));
                } 
                d.addRow(v2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Table load failed: " + e.getMessage());
        }
    }

   private void BookData() {
   
    try {
        pst = con.prepareStatement("SELECT * FROM book");
        ResultSet Rs = pst.executeQuery();

        DefaultTableModel DFG = (DefaultTableModel) jTable1.getModel();
        DFG.setRowCount(0); 

        while (Rs.next()) {
            Vector v2 = new Vector();

            v2.add(Rs.getString("bookid"));
            v2.add(Rs.getString("bookname"));
            v2.add(Rs.getString("author"));
            v2.add(Rs.getString("publisher")); 

            DFG.addRow(v2);
        }

    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
        txtbookid = new javax.swing.JTextField();
        txtbookname = new javax.swing.JTextField();
        txtauthor = new javax.swing.JTextField();
        txtpublisher = new javax.swing.JTextField();
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
        setTitle("Book");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel7.setText("BOOKS");

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
                .addContainerGap(391, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(307, 307, 307)
                .addComponent(jButton2)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setText(" BOOK ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setText(" BOOK NAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 20));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setText("AUTHOR");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("PUBLISHER");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));
        getContentPane().add(txtbookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 300, -1));
        getContentPane().add(txtbookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 300, -1));
        getContentPane().add(txtauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 300, -1));

        txtpublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpublisherActionPerformed(evt);
            }
        });
        getContentPane().add(txtpublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 300, -1));

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
                "BookID", "BookName", "Author", "Publisher"
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
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 900, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpublisherActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
        String bookid = txtbookid.getText();
        String bookname = txtbookname.getText();
        String author = txtauthor.getText();
        String publisher = txtpublisher.getText();
        
        try {
            Connect();
            pst = con.prepareStatement("INSERT INTO book (bookid,bookname, author, publisher) VALUES (?, ?, ?, ?)");
            pst.setString(1, bookid);
            pst.setString(2, bookname);
            pst.setString(3, author);
            pst.setString(4, publisher);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record Added Successfully!");
            BookData();
            
            txtbookid.setText("");
            txtbookname.setText("");
            txtauthor.setText("");
            txtpublisher.setText("");
            txtbookid.requestFocus();

            table_update();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
           
 
    }//GEN-LAST:event_btninsertActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
         int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        return;
    }

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    String studentid = model.getValueAt(selectedRow, 0).toString();

    System.out.println("Deleting Bookid: " + bookid); 

    int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this record?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) return;

    try {
        pst = con.prepareStatement("DELETE FROM book WHERE bookid = ?");
        pst.setString(1, studentid);
        int rows = pst.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
            BookData(); 
        } else {
            JOptionPane.showMessageDialog(this, "No record found with this ID!");
        }

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
        String bookid = txtbookid.getText();
        String bookname = txtbookname.getText();
        String author = txtauthor.getText();
        String publisher = txtpublisher.getText();

        if (bookid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pumili ka muna ng record sa table!");
            return;
        }

        pst = con.prepareStatement(
            "UPDATE book SET bookname = ?, author = ?, publisher = ? WHERE bookid = ?"
        );
        pst.setString(1, bookname);
        pst.setString(2, author);
        pst.setString(3, publisher);
        pst.setString(4, bookid);

        int updated = pst.executeUpdate();

        if (updated > 0) {
            JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
            BookData(); 
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
        java.awt.EventQueue.invokeLater(() -> new Book().setVisible(true));
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
    private javax.swing.JTextField txtauthor;
    private javax.swing.JTextField txtbookid;
    private javax.swing.JTextField txtbookname;
    private javax.swing.JTextField txtpublisher;
    // End of variables declaration//GEN-END:variables
}