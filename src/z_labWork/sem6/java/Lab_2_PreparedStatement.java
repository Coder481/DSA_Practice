package z_labWork.sem6.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Lab_2_PreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab1?autoReconnect=true&useSSL=false","root","8696hri40");

        PreparedStatement st = conn.prepareStatement("insert into student values(?,?)");
        st.setInt(1,3);
        st.setString(2,"ABCD");

        int i = st.executeUpdate();

        System.out.println(i + " records affected");
    }

}
