
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shubham
 */
public class accountnumbergenerator {
    /**
     *
     * @param a
     * @return
     */
    Connection conn;
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
    
    public String build(int age) {
        String lastacc = "", initial = "";
        getconnection();
           try {
                String table_name;
                if (age > 58) {
                    table_name = "interestcalculatorseniorcust";
                    initial = "0000004236891";
                } else {
                    table_name = "interestcalculatornormalcust";
                    initial = "0000003236971";
                }
                Statement stmt = conn.createStatement();
                String query = "select * from " + table_name ;
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String g = rs.getString("accountnumber");
                    int l = g.compareTo(lastacc);
                    if (l > 0) {
                        lastacc = g;
                    }
                }
                //System.out.println(lastacc);
                if ("".equals(lastacc)) {
                    if(age > 58) {
                        return "00000042368910000";
                    } else {
                        return "00000032369710000";
                    }
                } else {
                    String s = "";
                    int acc = 0;
                    if (age <= 58) {
                        s = s + lastacc.substring(13, 14) + lastacc.substring(14, 15) + lastacc.substring(15, 16) + lastacc.substring(16, 17);
                        for (int i = 0; i < s.length(); i++) {
                            acc = 10 * acc + (s.charAt(i) - '0');
                        }
                        acc++;
                        int p10 = (int) Math.log10(acc);
                        s = "";
                        for (int i = 3; i > p10; i--) {
                            s = s + '0';
                        }
                        s = initial + s + Integer.toString(acc);
                       // System.out.println(s);
                    } else {
                        s = s + lastacc.substring(13, 14) + lastacc.substring(14, 15) + lastacc.substring(15, 16) + lastacc.substring(16, 17);
                       // System.out.println(s);
                        for (int i = 0; i < s.length(); i++) {
                            acc = acc * 10 + (s.charAt(i) - '0');
                        }
                        acc++;
                       // System.out.println(acc);
                        int p10 = (int) Math.log10(acc);
                        s = "";
                        for (int i = 3; i > p10; i--) {
                            s = s + "0";
                        }
                        s = initial + s + Integer.toString(acc);
                        //System.out.println(s);
                    }
                    return s;
                }
                
            } catch (SQLException ex) {
                System.out.println("cannot execute");
            }
           return "";
    }
    
    
    /**
     *
     */
}
