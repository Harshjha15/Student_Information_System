/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentinfo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author harsh
 */
public class informationsystem extends javax.swing.JFrame {

     Connection con=null;
    PreparedStatement pst = null;
    
    
    public informationsystem() {
       initComponents();
       show_table();
    }
    
    private void arrange(){
     try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo","root","");
            pst = con.prepareStatement("SELECT * FROM info order by first_name");
            pst.executeQuery();
     }
     catch (SQLException ex) {
            Logger.getLogger(informationsystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   private void show_table(){
     int CC;
        
        try {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo","root","");
            pst = con.prepareStatement("SELECT *FROM info");
            arrange();
            ResultSet Rs = pst.executeQuery();
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel)table.getModel();
            
            DFT.setRowCount(0);
            while (Rs.next()){
                
                Vector v2 = new Vector();
                
                for (int i=1; i<=CC;i++) {
                    v2.add(Rs.getString("id"));
                    v2.add(Rs.getString("first_name"));
                    v2.add(Rs.getString("last_name"));
                    v2.add(Rs.getString("email"));
                    v2.add(Rs.getString("roll_number"));
                    v2.add(Rs.getString("course"));  
                }
              //  System.out.println(v2);
                DFT.addRow(v2);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(informationsystem.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfirst = new javax.swing.JTextField();
        txtlast = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtroll = new javax.swing.JTextField();
        txtcourse = new javax.swing.JTextField();
        btninsert = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 185, 185));
        jPanel1.setForeground(new java.awt.Color(179, 174, 174));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("STUDENT INFORMATION SYSTEM");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        table.setBackground(new java.awt.Color(51, 51, 51));
        table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        table.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name", "Email", "Roll no.", "Course"
            }
        ));
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setDragEnabled(true);
        table.setName(""); // NOI18N
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("First Name :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Last Name :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Email  :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Roll number  :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Course  :");

        txtfirst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtfirst.setForeground(new java.awt.Color(238, 10, 10));
        txtfirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtfirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfirstMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtfirstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtfirstMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtfirstMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtfirstMouseReleased(evt);
            }
        });

        txtlast.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtlast.setForeground(new java.awt.Color(237, 11, 11));
        txtlast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtlast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtlastMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtlastMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtlastMousePressed(evt);
            }
        });

        txtemail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtemail.setForeground(new java.awt.Color(237, 11, 11));
        txtemail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtemail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtemailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtemailMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtemailMousePressed(evt);
            }
        });

        txtroll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtroll.setForeground(new java.awt.Color(237, 11, 11));
        txtroll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtrollMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtrollMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtrollMousePressed(evt);
            }
        });

        txtcourse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtcourse.setForeground(new java.awt.Color(237, 11, 11));
        txtcourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtcourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtcourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtcourseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtcourseMousePressed(evt);
            }
        });

        btninsert.setBackground(new java.awt.Color(51, 255, 0));
        btninsert.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btninsert.setForeground(new java.awt.Color(255, 255, 255));
        btninsert.setText("INSERT");
        btninsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btninsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btninsertMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btninsertMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btninsertMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btninsertMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btninsertMouseReleased(evt);
            }
        });
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(0, 0, 204));
        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("UPDATE");
        btnupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnupdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnupdateMouseExited(evt);
            }
        });
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(255, 0, 0));
        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("DELETE");
        btndelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndeleteMouseExited(evt);
            }
        });
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(255, 102, 0));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("CLEAR");
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearMouseExited(evt);
            }
        });
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtlast, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(txtfirst, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtroll, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btninsert, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtfirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtlast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(btninsert)
                        .addGap(45, 45, 45)
                        .addComponent(btnupdate)
                        .addGap(44, 44, 44)
                        .addComponent(btndelete)
                        .addGap(43, 43, 43)
                        .addComponent(clear)
                        .addContainerGap(173, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
        String fname,lname,email,rollno,course;
        fname=txtfirst.getText();
        lname=txtlast.getText();
        email=txtemail.getText();
        rollno=txtroll.getText();
        course=txtcourse.getText();
        if(fname.equals("")){
        JOptionPane.showMessageDialog(null,"Please enter the First Name");
        }
        else if(lname.equals("")){
        JOptionPane.showMessageDialog(null,"Please enter the Last Name");
        }
        else if(email.equals("")){
        JOptionPane.showMessageDialog(null,"Please enter the Email");
        }
        else if(rollno.equals("")){
        JOptionPane.showMessageDialog(null,"Please enter the Roll Number");
        }
        else if(course.equals("")){
        JOptionPane.showMessageDialog(null,"Please enter the Course Name");
        }
        else{
            try {
               
              con=DriverManager.getConnection("jdbc:mysql://localhost/studentinfo","root","");
                pst = con.prepareStatement("INSERT INTO info(first_name,last_name,email,roll_number,course) VALUES(?,?,?,?,?)");
                
        pst.setString(1,fname);
        pst.setString(2,lname);
        pst.setString(3,email);
        pst.setString(4,rollno);
        pst.setString(5,course);
        
        pst.executeUpdate();
     
             txtfirst.setText("");
              txtlast.setText("");
              txtemail.setText("");
              txtcourse.setText("");
              txtroll.setText("");
              JOptionPane.showMessageDialog(null,"INFORMATION INSERTED SUCCESSFULLY");
              show_table();
              
            }
            
            catch (SQLException ex) {
                Logger.getLogger(informationsystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btninsertActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
         
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        int selectedIndex = table.getSelectedRow();
        
       int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        txtfirst.setText(model.getValueAt(selectedIndex, 1).toString());
        txtlast.setText(model.getValueAt(selectedIndex, 2).toString());
        txtemail.setText(model.getValueAt(selectedIndex, 3).toString());
        txtroll.setText(model.getValueAt(selectedIndex, 4).toString());
        txtcourse.setText(model.getValueAt(selectedIndex, 5).toString());
        
    }//GEN-LAST:event_tableMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        String fname, lname, email, rollnumber, course;
        
        fname = txtfirst.getText();
        lname = txtlast.getText();
        email = txtemail.getText();
        rollnumber = txtroll.getText();
        course = txtcourse.getText();
        
        if(fname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter first name");
        }
        else if(lname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter last name");
        }
        else if(email.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter  email");
        }
        else if(rollnumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter roll number");
        }
        else if(course.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter course");
        }
        
         else {
            try {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                int selectedIndex = table.getSelectedRow();
                int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
                con = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo","root","");
                pst = con.prepareStatement ("update info set first_name =?, last_name=?, email =?, roll_number =?, course = ? where id =?");
                
                pst.setString(1, fname);
                pst.setString(2, lname);
                pst.setString(3, email);
                pst.setString(4, rollnumber);
                pst.setString(5, course);
                pst.setInt(6, id);
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data updated successfully");
                show_table();
                
                txtfirst.setText("");
                txtlast.setText("");
                txtemail.setText("");
                txtroll.setText("");
                txtcourse.setText("");
                
            } catch (SQLException ex) {
                Logger.getLogger(informationsystem.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception e){
          JOptionPane.showMessageDialog(null, "ERROR ! Select a row to update");
       }
        }
        
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
       try {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                int selectedIndex = table.getSelectedRow();
                
                int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
                
                con = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo","root","");
                pst = con.prepareStatement ("delete from info where id =?");
                
                pst.setInt(1,id);
                
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Data Deleted successfully");
                show_table();
                
                txtfirst.setText("");
                txtlast.setText("");
                txtemail.setText("");
                txtroll.setText("");
                txtcourse.setText("");
       }
         catch (SQLException ex) {
                Logger.getLogger(informationsystem.class.getName()).log(Level.SEVERE, null, ex);
            }
       catch(Exception e){
       JOptionPane.showMessageDialog(null, "ERROR ! Select a row to delete");
       }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btninsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninsertMouseClicked
       btninsert.setForeground(Color.black);
    }//GEN-LAST:event_btninsertMouseClicked

    private void btninsertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninsertMouseEntered
        btninsert.setForeground(Color.black);
    }//GEN-LAST:event_btninsertMouseEntered

    private void btninsertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninsertMouseExited
       btninsert.setForeground(Color.white);
    }//GEN-LAST:event_btninsertMouseExited

    private void btninsertMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninsertMousePressed
        btninsert.setForeground(Color.black);
    }//GEN-LAST:event_btninsertMousePressed

    private void btninsertMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninsertMouseReleased
       btninsert.setForeground(Color.white);
    }//GEN-LAST:event_btninsertMouseReleased

    private void btnupdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseEntered
       btnupdate.setForeground(Color.black);
    }//GEN-LAST:event_btnupdateMouseEntered

    private void btnupdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseExited
       btnupdate.setForeground(Color.white);
    }//GEN-LAST:event_btnupdateMouseExited

    private void btndeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseEntered
         btndelete.setForeground(Color.black);
    }//GEN-LAST:event_btndeleteMouseEntered

    private void btndeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseExited
        btndelete.setForeground(Color.white);
    }//GEN-LAST:event_btndeleteMouseExited

    private void txtfirstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfirstMouseEntered
       Color  blu   = new Color(178,102,255);
        jLabel2.setForeground(blu);
    }//GEN-LAST:event_txtfirstMouseEntered

    private void txtfirstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfirstMouseExited
       jLabel2.setForeground(Color.black);
    }//GEN-LAST:event_txtfirstMouseExited

    private void txtlastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtlastMouseEntered
        Color  blu   = new Color(178,102,255);
        jLabel3.setForeground(blu);
    }//GEN-LAST:event_txtlastMouseEntered

    private void txtlastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtlastMouseExited
       jLabel3.setForeground(Color.black);
    }//GEN-LAST:event_txtlastMouseExited

    private void txtemailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtemailMouseEntered
      Color  blu   = new Color(178,102,255);
        jLabel4.setForeground(blu);
    }//GEN-LAST:event_txtemailMouseEntered

    private void txtemailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtemailMouseExited
        jLabel4.setForeground(Color.black);
    }//GEN-LAST:event_txtemailMouseExited

    private void txtrollMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrollMouseEntered
       Color  blu   = new Color(178,102,255);
        jLabel5.setForeground(blu);
    }//GEN-LAST:event_txtrollMouseEntered

    private void txtrollMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrollMouseExited
        jLabel5.setForeground(Color.black);
    }//GEN-LAST:event_txtrollMouseExited

    private void txtcourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcourseMouseEntered
      Color  blu   = new Color(178,102,255);
        jLabel6.setForeground(blu);
    }//GEN-LAST:event_txtcourseMouseEntered

    private void txtcourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcourseMouseExited
         jLabel6.setForeground(Color.black);
    }//GEN-LAST:event_txtcourseMouseExited

    private void txtfirstMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfirstMousePressed
        jLabel2.setForeground(Color.yellow);
    }//GEN-LAST:event_txtfirstMousePressed

    private void txtfirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfirstMouseClicked
   //    jLabel2.setForeground(Color.yellow);
    }//GEN-LAST:event_txtfirstMouseClicked

    private void txtfirstMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfirstMouseReleased
  //      jLabel2.setForeground(Color.black);
    }//GEN-LAST:event_txtfirstMouseReleased

    private void txtlastMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtlastMousePressed
        jLabel3.setForeground(Color.yellow);
    }//GEN-LAST:event_txtlastMousePressed

    private void txtemailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtemailMousePressed
        jLabel4.setForeground(Color.yellow);
    }//GEN-LAST:event_txtemailMousePressed

    private void txtrollMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrollMousePressed
       jLabel5.setForeground(Color.yellow);
    }//GEN-LAST:event_txtrollMousePressed

    private void txtcourseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcourseMousePressed
       jLabel6.setForeground(Color.yellow);
    }//GEN-LAST:event_txtcourseMousePressed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setForeground(Color.red);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
         jLabel1.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
         Color  blu   = new Color(255,255,0);
        jLabel1.setForeground(blu);
    }//GEN-LAST:event_jLabel1MousePressed

    private void clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseEntered
        clear.setForeground(Color.black);
    }//GEN-LAST:event_clearMouseEntered

    private void clearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseExited
        clear.setForeground(Color.white);
    }//GEN-LAST:event_clearMouseExited

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        txtfirst.setText("");
        txtlast.setText("");
        txtemail.setText("");
        txtroll.setText("");
        txtcourse.setText("");
        show_table();
    }//GEN-LAST:event_clearActionPerformed
                           

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
            java.util.logging.Logger.getLogger(informationsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informationsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informationsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informationsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informationsystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtcourse;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfirst;
    private javax.swing.JTextField txtlast;
    private javax.swing.JTextField txtroll;
    // End of variables declaration//GEN-END:variables
}
