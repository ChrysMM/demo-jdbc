package fr.diginamic.jdbc;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
        Statement stat = conn.createStatement();
        stat.executeUpdate("UPDATE FOURNISSEUR SET nom='La maison des peintures' where id=4");
        System.out.println("lignes modifiées:");

        stat.close();
        conn.close();

    }
}
