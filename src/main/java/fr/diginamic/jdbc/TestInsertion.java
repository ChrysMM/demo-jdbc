package fr.diginamic.jdbc;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertion {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
        Statement stat = conn.createStatement();
        int nb = stat.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('La Maison Peinture')");
        if (nb != 0) {
            System.out.println("L'insertion s'est bien passée.");

            stat.close();
            conn.close();
        }
}}
