import java.sql.*;

public class CrudOps {
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

        //4. create a table // should be run only once
        String cq = "create table student1(sid int primary key, sname varchar(50), cgpa float)";
        int x = st.executeUpdate(cq);
        if (x == 0)
        {
            System.out.println("Table Created");
        }
        else
        {
            System.out.println("Table Not Created");
        }

        //5. Insert Data
        String iq = "insert into student1 values(123, 'Sumit', 8.56),(456, 'Smitu', 8.02),(789, 'Neha', 7.86)";
        int x = st.executeUpdate(iq);
        if (x > 0){
            System.out.println(x + " record inserted");
        }
        else
        {
            System.out.println("Record Not Inserted");
        }

        //6. Read Data
        String sq = "select * from student1";
        ResultSet rs = st.executeQuery(sq);
        while (rs.next()){
            System.out.println(rs.getInt("sid") + " " + rs.getString("sname") + " " + rs.getDouble("cgpa"));
        }

        //7. Update Data
        String uq = "update student1 set sname = 'Samriddhi' where sid = 789";
        int y = st.executeUpdate(uq);
        if(y > 0)
        {
            System.out.println(y + " record updated");
        }
        else {
            System.out.println("Record Not Updated");
        }

        String sq1= "select * from student1";
        ResultSet rs1 = st.executeQuery(sq1);
        while (rs1.next()){
            System.out.println(rs1.getInt("sid") + " " + rs1.getString("sname") + " " + rs1.getDouble("cgpa"));
        }


        //7. Delete Data
        String dq = "delete from student1 where sid = 456";
        int z = st.executeUpdate(dq);
        if(z > 0)
        {
            System.out.println(z + " record deleted");
        }
        else {
            System.out.println("Record Not Deleted");
        }

        String sq2 = "select * from student1";
        ResultSet rs2 = st.executeQuery(sq2);
        while (rs2.next()){
            System.out.println(rs2.getInt("sid") + " " + rs2.getString("sname") + " " + rs2.getDouble("cgpa"));
        }

        //5. Close Connection
        con.close();
    }
}
