package fr.diginamic.jdbc.dao;

public class FournisseurDaoJdbc2 {
    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "FournisseurDaoJdbc2{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }

    public FournisseurDaoJdbc2(int id, String nom) {
        this.id = id;
        this.nom = nom;


    }

}
