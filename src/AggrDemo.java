import java.sql.*;

public class AggrDemo {
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

        //Aggregate Function
        String sql = "select count(*) as Count , min(gpa) as minimum_gpa, max(gpa) as maximum_gpa, avg(gpa) as Average, sum(gpa) as Sum from student";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()){
            System.out.println("Count of all Entries : " + rs.getInt("Count"));
            System.out.println("Minimum GPA : " + rs.getDouble("minimum_gpa"));
            System.out.println("Maximum GPA : " + rs.getDouble("maximum_gpa"));
            System.out.println("Average GPA : " + rs.getDouble("Average"));
            System.out.println("Sum of GPA : " + rs.getDouble("Sum"));

        }
    }
}
