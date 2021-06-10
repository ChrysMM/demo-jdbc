package fr.diginamic.jdbc;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
        Statement stat = conn.createStatement();
        int nb = stat.executeUpdate("DELETE FROM FOURNISSEUR WHERE id=4");
        System.out.println("ligne supprimée");
        stat.close();
        conn.close();
    }
}
