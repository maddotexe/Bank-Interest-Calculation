import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class time10secs implements Runnable {

    Connection conn;
    
    int c, nr, sr;
    String table_name;
    String d;
    float si, ni,st, nt;
    float[] nib = new float[30];
    float[] sib = new float[30];
    
    public time10secs() {
        c = 0;
        d = "";
        for (int i = 0; i < 30; i++) {
            nib[i] = 0;
            sib[i] = 0;
        }
    }
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
    @Override
    public void run() {
        getconnection();
        try {
            Statement stmt = conn.createStatement();
            String query = "select * from " + "A00000032369710000";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                d = rs.getString("interestdate");
                
                    //System.out.println(d);
            }
            if (d.equals("")) {
                query = "select sysdate from dual";
                rs = stmt.executeQuery(query);
                while(rs.next()) {
                    d = rs.getDate(1).toString();
                    System.out.println(d);
                }
            }
        } catch (SQLException ex) {
            System.out.println("cannot take date");
        }
        while (true) {
            float[] nb = new float[30];
            float[] sb = new float[30];
            String[] nac = new String[30];
            String[] sac = new String[30];
            try {
                
                Statement stmt = conn.createStatement();
                String query = "select * from " + "interestcalculatorseniorcust";
                ResultSet rs = stmt.executeQuery(query);
                sr = 0;
                while(rs.next()) {
                    String s = rs.getString("balance");
                    sb[sr] = Float.parseFloat(s);
                    sac[sr] = rs.getString("accountnumber");
                    sr++;
                    
                }
                query = "select * from " + "interestcalculatornormalcust";
                rs = stmt.executeQuery(query);
                //    System.out.println("kkk");
                nr = 0;
                while(rs.next()) {
                    String s = rs.getString("balance");
                    nb[nr] = Float.parseFloat(s);
                    nac[nr] = rs.getString("accountnumber");
                    nr++;
                    
                }
                query = "select * from " + "INTERESTCALCULATORRATES";
                rs = stmt.executeQuery(query);
                int i = 0;
                while(rs.next()) {
                    if (i == 0) {
                        String s = rs.getString("interestrate");
                        ni = Float.parseFloat(s);
                        s = rs.getString("taxrate");
                        nt = Float.parseFloat(s);
                        i++;
                    } else {
                        String s = rs.getString("interestrate");
                        si = Float.parseFloat(s);
                        s = rs.getString("taxrate");
                        st = Float.parseFloat(s);
                    }
                }
                
                try {
                    Thread.sleep(1000);
                    c++;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar cal = Calendar.getInstance();
                    try {
                       // System.out.println(sdf.parse(d));
                        cal.setTime(sdf.parse(d));
                    } catch (ParseException ex) {
                        System.out.println("date not converted");
                    }
                    cal.add(Calendar.DAY_OF_MONTH, 1);  // number of days to add
                    d = sdf.format(cal.getTime());
                    System.out.println(d);
                    for (int j = 0; j < sr; j++) {
                        float f;
                        f = sb[j] * si / 100;
                        sib[j] += f;
                        stmt = conn.createStatement();
                        query = "insert into a" + sac[j] + " values ('" + d + "', '" + sac[j] + "' , '" + Float.toString(sb[j]) + "' , '" + Float.toString(f) + "')";
                        stmt.executeQuery(query);
                    }
                    for (int j = 0; j < nr; j++) {
                        float f;
                        f = nb[j] * ni / 100;
                        nib[j] += f;
                        stmt = conn.createStatement();
                        query = "insert into a" + nac[j] + " values ('" + d + "' , '" + nac[j] + "' , '" + Float.toString(nb[j]) + "' , '" + Float.toString(f) + "')";
                        stmt.executeQuery(query);
                    }
                    if (c == 30) {
                        c = 0;
                        for (int p = 0; p < nr; p++) {
                            stmt = conn.createStatement();
                            query = "update " + "interestcalculatornormalcust" + " set balance =  balance + '" + nib[p] + "' where accountnumber = '" + nac[p] + "'";
                            stmt.executeQuery(query);
                        }
                        for (int p = 0; p < sr; p++) {
                            stmt = conn.createStatement();
                            query = "update " + "interestcalculatorseniorcust" + " set balance =  balance + '" + sib[p] + "' where accountnumber = '" + sac[p] + "'";
                            stmt.executeQuery(query);
                        }
                    }
                } catch (InterruptedException ex) {
                    System.out.println("cannot sleep");
                }
            
            } catch (SQLException ex) {
                System.out.println("cannot execute");
            }
        }
    }    
}
