import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CSTDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3307/jdbc";
        String username = "root";
        String password = "Sumit@123";

        Connection con = DriverManager.getConnection(url, username,password);

        if (con != null)
        {
            System.out.println("Connection Established");
        }
        else
        {
            System.out.println("Connection Failed");
        }
        //Calling stored procedure
        //String sql = " {call first_pro1(?,?)}";

        //Calling stored functions
        String query = "{? = call add_nums(?,?)}";


        //CallableStatement cst = con.prepareCall(sql);

        CallableStatement cst = con.prepareCall(query);


//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the first number");
//        int a = sc.nextInt();

        //setting the parameters
//        cst.setInt(1,num);
//        cst.registerOutParameter(2,Types.INTEGER);

        //executing the query
        //cst.execute();

//        int result = cst.getInt(2);
//        System.out.println("Square is = " + result);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = sc.nextInt();
        System.out.println("Enter the second number");
        int b = sc.nextInt();

        //setting the parameters
        cst.setInt(2,a);
        cst.setInt(3,b);
        cst.registerOutParameter(1,Types.INTEGER);

        //executing the query
        cst.execute();

        int result = cst.getInt(1);
        System.out.println("Addition is = " + result);
    }
}
