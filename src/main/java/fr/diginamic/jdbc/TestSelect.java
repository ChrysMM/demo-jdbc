package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;
import org.mariadb.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class TestSelect {
    public static void main(String[] args) throws Exception {
        ArrayList<Fournisseur> listeFournisseur = new ArrayList<>();

        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
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
