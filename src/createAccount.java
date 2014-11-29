

import javax.swing.ImageIcon;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shubham
 */
public class createAccount extends javax.swing.JFrame {

    int a[];
    String name1;
    String father1;
    String address1;
    String city1;
    String pin1;
    int age1;
    String mobile1;
    String email1;
    String state1;
    String gender1;
    java.sql.Date dob1;
    Connection conn;
    
    
    private boolean checkname(String s) {
        if ("".equals(s)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) {
                return true;
            }
        }   
        return false;
    }
    
    private boolean checkmobile(String s) {
        if (s.length() != 10) {
            return true;
        }
        if ("".equals(s)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return true;
            }
        }   
        return false;
    }
    private boolean checkemail(String s) {
        if ("".equals(s)) {
            return true;
        }
        int p= 0, q = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                return true;
            }
            if (s.charAt(i) == '@') {
                p++;
            }
            if (s.charAt(i) == '.') {
                q++;
            }
            
        }
        if (p != 1 || q == 0) {
            return true;
        }
        return false;
    }
    private boolean checkpin(String s) {
        if (s.length() != 6) {
            return true;
        }
        if ("".equals(s)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return true;
            }
        }   
        return false;
    }
    
    private boolean checkage(String s) {
        if ("".equals(s)) {
            return true;
        }
        if (s.length() >= 4 || s.charAt(0) == '-') {
            return true;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return true;
            }
        }   
        return false;
    }
    /**
     * Creates new form createAccount
     */
    public createAccount() {
        initComponents();
        submit.setEnabled(true);
        this.setDefaultCloseOperation(createAccount.DISPOSE_ON_CLOSE);
        jLabel13.setVisible(false);
        a = new int[11];
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        father = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox();
        address = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        state = new javax.swing.JComboBox();
        pin = new javax.swing.JTextField();
        dob = new com.toedter.calendar.JDateChooser();
        age = new javax.swing.JTextField();
        mobile = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        mesagedisp = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 242, 24));

        jLabel1.setText("Name :");

        jLabel2.setText("Father's Name :");

        jLabel3.setText("Street Address :");

        jLabel4.setText("City :");

        jLabel5.setText("State :");

        jLabel6.setText("Pin :");

        jLabel7.setText("Date Of Birth :");

        jLabel8.setText("Age :");

        jLabel9.setText("Gender :");

        jLabel10.setText("Mobile # :");

        jLabel11.setText("Email Id :");

        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFocusLost(evt);
            }
        });

        father.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fatherFocusLost(evt);
            }
        });

        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "Male", "Female", "Other" }));
        gender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                genderFocusLost(evt);
            }
        });

        address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressFocusLost(evt);
            }
        });

        city.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cityFocusLost(evt);
            }
        });

        state.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu And Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Punjab", "Rajasthan", "Sikkim", "Tamilnadu", "Tripura", "Uttarakhand (Uttaranchal)", "Uttar Pradesh", "West Bengal" }));
        state.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                stateFocusLost(evt);
            }
        });

        pin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pinFocusLost(evt);
            }
        });

        age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ageFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                ageFocusGained(evt);
            }
        });

        mobile.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobileFocusLost(evt);
            }
        });

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });

        jLabel12.setText("+91");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(father, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesagedisp, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(submit)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel10, jLabel11, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {address, age, city, dob, email, father, gender, mobile, name, pin, state});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(father, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(submit)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mesagedisp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {address, age, city, email, father, gender, jLabel1, jLabel10, jLabel11, jLabel12, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, mobile, name, pin, state});

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-632)/2, (screenSize.height-593)/2, 632, 593);
    }// </editor-fold>//GEN-END:initComponents

    
    private void getconnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(Exception e) {
            System.out.println("Oops! Can't find classoracle.jdbc.driver.OracleDriver");
        }
        
        
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "nextgene");
            
        } catch (Exception e) {
            System.out.println("Cannot Connect");
        }
    }
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        int flag = 0;
        int i;
        String s = "";
        for (i = 0; i < 11; i++) {
           if (a[i] == 0) {
               flag = 1;
               break;
           }
       }
       if (flag == 1) {
           if (i == 0) {
               s = "Name";
           } else if (i == 1) {
               s = "Father's Name";
           } else if (i == 2) {
               s = "Gender";
           } else if (i == 3) {
               s = "Street Address";
           } else if (i == 4) {
               s = "City";
           } else if (i == 5) {
               s = "State";
           } else if (i == 6) {
               s = "Pin Code";
           } else if (i == 7) {
               s = "Date of Birth";
           } else if (i == 8) {
               s = "Age";
           } else if (i == 9) {
               s = "Mobile Number";
           } else if (i == 10) {
               s = "Email ID";
           }
           mesagedisp.setText("Invalid " + s);
       }
       else {
           mesagedisp.setText("Done");
           getconnection();
           try {
                accountnumbergenerator n = new accountnumbergenerator();
                String acc = n.build(age1);
                String table_name;
                if (age1 > 58) {
                    table_name = "interestcalculatorseniorcust";
                } else {
                    table_name = "interestcalculatornormalcust";
                }
                Statement stmt = conn.createStatement();
                int c = 0, bal = 0;
                String str = Integer.toString(bal);
                String query = "INSERT INTO " + table_name + " values ('" + name1 + "', '" + father1 + "', '" + address1 + "', '" + age.getText() + "', to_date('" + dob1 + "', 'YYYY-MM-DD'), '" + acc + "', '" + mobile1 + "', '" + email1 + "', '" + str + "', '" + pin1 + "', '" + state1 + "', '" + city1 + "')";
                stmt.executeQuery(query);
                c++;
                if (c == 1) {
                    submit.setEnabled(false);
                    JOptionPane.showMessageDialog(null,"New Account Created","Registration",JOptionPane.WARNING_MESSAGE);
                    query = "create table " + "a" + acc + " (interestDate varchar(4000), Accountnumber varchar(4000), Balance number(20, 2), interest number(10, 2))";
                    stmt.executeQuery(query);
                    this.dispose();
                    Accountant accn = new Accountant();
                    accn.setVisible(true);
                }
            } catch (SQLException ex) {
                System.out.println("cannot execute");
            }
       }
    }//GEN-LAST:event_submitActionPerformed

    private void nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusLost
        name1 = name.getText();
        if (checkname(name1)){          //if true wrong input
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/wrong.png");
            jLabel13.setIcon(imgThisImg);
            jLabel13.setVisible(true);
            a[0] = 0;
        } else {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/tick.png");
            jLabel13.setIcon(imgThisImg);
            jLabel13.setVisible(true);
            a[0] = 1;
        }
    }//GEN-LAST:event_nameFocusLost

    private void fatherFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fatherFocusLost
        father1 = father.getText();
        if (checkname(father1)){
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/wrong.png");
            jLabel14.setIcon(imgThisImg);
            jLabel14.setVisible(true);
            a[1] = 0;
        } else {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/tick.png");
            jLabel14.setIcon(imgThisImg);
            jLabel14.setVisible(true);
            a[1] = 1;
        }
    }//GEN-LAST:event_fatherFocusLost
    
    
    
    private void addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFocusLost
        address1 = address.getText();
        if ("".equals(address1)) {
            a[3] = 0;
        } else {
            a[3] = 1;
        }
    }//GEN-LAST:event_addressFocusLost

    private void cityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFocusLost
        city1 = city.getText();
        if (checkname(city1)){
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/wrong.png");
            jLabel16.setIcon(imgThisImg);
            jLabel16.setVisible(true);
            a[4] = 0;
        } else {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/tick.png");
            jLabel16.setIcon(imgThisImg);
            jLabel16.setVisible(true);
            a[4] = 1;
        }
    }//GEN-LAST:event_cityFocusLost

    private void pinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pinFocusLost
        pin1 = pin.getText();
        if (checkpin(pin1)) {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/wrong.png");
            jLabel17.setIcon(imgThisImg);
            jLabel17.setVisible(true);
            a[6] = 0;
        } else {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/tick.png");
            jLabel17.setIcon(imgThisImg);
            jLabel17.setVisible(true);
            a[6] = 1;
        }
    }//GEN-LAST:event_pinFocusLost

    private void ageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageFocusLost
        String s = age.getText();
        if (checkage(s)) {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/wrong.png");
            jLabel18.setIcon(imgThisImg);
            jLabel18.setVisible(true);
            a[8] = 0;
        } else {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/tick.png");
            jLabel18.setIcon(imgThisImg);
            jLabel18.setVisible(true);
            try {
                age1 = Integer.parseInt(s);
                a[8] = 1;
            } catch (Exception e) {
                a[8] = 0;
            }
        }
        
        
    }//GEN-LAST:event_ageFocusLost

    private void mobileFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobileFocusLost
        mobile1 = mobile.getText();
        if (checkmobile(mobile1)) {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/wrong.png");
            jLabel19.setIcon(imgThisImg);
            jLabel19.setVisible(true);
            a[9] = 0;
        } else {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/tick.png");
            jLabel19.setIcon(imgThisImg);
            jLabel19.setVisible(true);
            a[9] = 1;
        }
    }//GEN-LAST:event_mobileFocusLost

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        email1 = email.getText();
        if (checkemail(email1)) {
            a[10] = 0;
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/wrong.png");
            jLabel21.setIcon(imgThisImg);
            jLabel21.setVisible(true);
        } else {
            ImageIcon imgThisImg = new ImageIcon("C:/Users/Shubham/Documents/NetBeansProjects/InterestCalculator/src/tick.png");
            jLabel21.setIcon(imgThisImg);
            jLabel21.setVisible(true);
            a[10] = 1;
        }
        
    }//GEN-LAST:event_emailFocusLost

    private void stateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stateFocusLost
        int state2 = state.getSelectedIndex();
        state1 = (String) state.getItemAt(state2);
        if (state2 != 0) {
            a[5] = 1;
        } else {
            a[5] = 0;
        }
    }//GEN-LAST:event_stateFocusLost

    private void genderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_genderFocusLost
        int gender2 = gender.getSelectedIndex();
        gender1 = (String) gender.getItemAt(gender2);
        if (gender2 != 0) {
            a[2] = 1;
        } else {
            a[2] = 0;
        }
    }//GEN-LAST:event_genderFocusLost

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void ageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageFocusGained
        try {
            a[7] = 1;        
            java.util.Date dt = dob.getDate();
            //java.sql.Date dob1;
            dob1 = new java.sql.Date(dt.getTime());
        } catch (Exception e) {
            a[7] = 0;
        }
    }//GEN-LAST:event_ageFocusGained

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new createAccount().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JTextField city;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JTextField father;
    private javax.swing.JComboBox gender;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mesagedisp;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pin;
    private javax.swing.JComboBox state;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}