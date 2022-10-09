package z_labWork.sem6.java;

import java.sql.*;

public class Lab_1_ConnectDbAndShowTable {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/lab1?autoReconnect=true&useSSL=false"
                        ,"hrithik481","8696hri40");

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM student");

        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }
    }

}
