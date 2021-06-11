package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;
import org.mariadb.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class TestDaoJdbc {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
        Statement stat = conn.createStatement();
        int nb = stat.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('France de Matériaux')");
        if (nb != 0) {
            System.out.println("L'insertion s'est bien passée.");


            stat.close();
            conn.close();

        }
        ArrayList<Fournisseur> listeFournisseur = new ArrayList<>();

        conn = null;
        stat = null;
        ResultSet result = null;
        try {
            // 1 - je charge le driver
            DriverManager.registerDriver(new Driver());

            // 2 - je créé une connexion
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
            // opérations 3 à N
            stat = conn.createStatement();

            result = stat.executeQuery("SELECT * FROM FOURNISSEUR");
            stat.executeUpdate("UPDATE FOURNISSEUR SET nom='France Materiaux' where id=4");
            while (result.next()) {
                Integer id = result.getInt("id");
                String nom = result.getString("NOM");


                Fournisseur fournisseur = new Fournisseur(id, nom);
                listeFournisseur.add(fournisseur);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Problème de fermeture des ressources :" + e.getMessage());
            }
        }


        for (Fournisseur fournisseur : listeFournisseur) {
            System.out.println(fournisseur.getNom());
        }
        ArrayList<Fournisseur> listeFournisseur2 = new ArrayList<>();

        conn = null;
        stat = null;
        result = null;
        try {
            // 1 - je charge le driver
            DriverManager.registerDriver(new Driver());

            // 2 - je créé une connexion
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
            // opérations 3 à N
            stat = conn.createStatement();

            result = stat.executeQuery("SELECT * FROM FOURNISSEUR");

            while (result.next()) {
                Integer id = result.getInt("id");
                String nom = result.getString("NOM");


                Fournisseur fournisseur = new Fournisseur(id, nom);
                listeFournisseur.add(fournisseur);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Problème de fermeture des ressources :" + e.getMessage());
            }
        }


        for (Fournisseur fournisseur : listeFournisseur) {
            System.out.println(fournisseur.getNom());
        }
    }

}






