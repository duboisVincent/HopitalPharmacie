/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacie;

/**
 *
 * @author zking
 */
public class Produit {
    private int id;
    private String libelle;
    private double prix;
    private int quantite;
    private String localisation;
    private int seuilCrit;

    // Constructeur
    public Produit(int id, String libelle, double prix, int quantite, String localisation, int seuilCrit) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.quantite = quantite;
        this.localisation = localisation;
        this.seuilCrit = seuilCrit;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getLocalisation() {
        return localisation;
    }
    
    public int getSeuilCrit(){
        return seuilCrit;
    }
    
    public void setSeuilCrit(int seuilCrit){
        this.seuilCrit = seuilCrit;
    }
    
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    public String toString(){
        String retour = "Le produit "+this.libelle+" au prix de : "+this.prix+"€ a comme quantité : "+this.quantite+" se trouve sur l'étagère : "+this.localisation + " sa quantité critique est: " +this.seuilCrit;
        return(retour);
    }
}