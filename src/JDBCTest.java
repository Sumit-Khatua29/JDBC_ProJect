import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
       //1. Loading Drivers
       Class.forName("com.mysql.cj.jdbc.Driver");

       //2. Establishing Connection
        String url = "jdbc:mysql://localhost:3307/jdbc";
        String user = "root";
        String password = "Sumit@123";

        Connection con = DriverManager.getConnection(url, user, password);

        if (con != null)
        {
            System.out.println("Connection Established");
        }
        else
        {
            System.out.println("Connection Failed");
        }

        //3. Create Statement
        Statement st = con.createStatement();

        //4. Execute Query
        String sql = "select * from student";
        ResultSet rs = st.executeQuery(sql);

        //5. Process Result
        while (rs.next()){
            System.out.println(rs.getInt("sid") + " " + rs.getString("sname") + " " + rs.getDouble("gpa") + " " + rs.getString("dept"));
        }

        //6. Close Connection
        con.close();

    }
}
