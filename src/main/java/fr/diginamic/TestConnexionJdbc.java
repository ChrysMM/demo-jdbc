package fr.diginamic;
import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class TestConnexionJdbc {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
        System.out.println(conn);
        conn.close();

    }
    }
