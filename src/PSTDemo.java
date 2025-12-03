import java.sql.*;
import java.util.Scanner;

public class PSTDemo {
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

        //Prepared Statement
        String pq = "insert into student1 values(?,?,?)";

        System.out.println("Enter Student Details : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID : ");
        int sid = sc.nextInt();
        System.out.println("Enter Student Name : ");
        String sname = sc.next();
        System.out.println("Enter Student CGPA : ");
        double cgpa = sc.nextDouble();


        PreparedStatement pst = con.prepareStatement(pq);
        pst.setInt(1,sid);
        pst.setString(2,sname);
        pst.setDouble(3,cgpa);

        int x = pst.executeUpdate();
        if (x > 0){
            System.out.println(x + " records inserted");
        }
        else {
            System.out.println("Records not inserted");
        }



        pst = con.prepareStatement("update student set sname = ? where sid = ?");
        pst.setString(1,"Sumitra");
        pst.setInt(2,789);
        int y = pst.executeUpdate();

        if (y > 0)
        {
            System.out.println(y + " rows updated");
        }
        else {
            System.out.println("Rows not updated");
        }

        ResultSet rs = pst.executeQuery("select * from student1");
        while(rs.next()){
            System.out.println(rs.getInt("sid") + " " + rs.getString("sname") + " " + rs.getDouble("cgpa"));
        }

        con.close();
    }
}
