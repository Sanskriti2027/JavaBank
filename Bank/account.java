package bank;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class account extends javax.swing.JInternalFrame {
    public account() {
        initComponents();
        autoId();
    }
    Connection con1;
  PreparedStatement insert;
  ResultSet rs1;
    @SuppressWarnings("unchecked")
    private void initComponents() {
        txtbal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtcust = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtbal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbalActionPerformed(evt);
            }
        });
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Account"));
        jLabel3.setText("Account type");
        jLabel1.setText("Customer ID");
        txtcust.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcustKeyPressed(evt);
            }
        });
        jLabel2.setText("Custmer Name");
        jLabel7.setText("Account No");
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); 
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("jLabel8");
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Saving", "Fix", "Current" }));
        jLabel4.setText("Balance");
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
       public void autoId()
    {
        try {
             Class.forName("com.mysql.jdbc.Driver");
             con1 = DriverManager.getConnection("jdbc:mysql://localhost/customer","root","");
            Statement s = con1.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(acc_id) FROM account");
            rs.next();
            rs.getString("MAX(acc_id)");
            if (rs.getString("MAX(acc_id)") == null) {
                jLabel8.setText("A0001");
                
            } else {
                long id = Long.parseLong(rs.getString("MAX(acc_id)").substring(2, rs.getString("MAX(acc_id)").length()));
                id++;
                jLabel8.setText("A0" + String.format("%03d", id));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }      
    }
  