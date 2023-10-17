/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacie;

import java.time.LocalDate;

/**
 *
 * @author sio2023
 */
public class Sortie {
    private int idSortie;
    private String utilisateur;
    private LocalDate dateSortie;
    private int nbProduits;
    private int idProduit;
    private Integer idAdmin;
    private Boolean estValide;
    
    //Constructeur
    public Sortie(int pIdSortie, LocalDate pDateSortie, String pUtilisateur,int pNbProduits, int pIdProduit, int pIdAdmin, boolean pEstValide){
        idSortie = pIdSortie;
        dateSortie = pDateSortie;
        utilisateur = pUtilisateur;
        nbProduits = pNbProduits;
        idProduit = pIdProduit;
        idAdmin = pIdAdmin;
        estValide = pEstValide;
    }   
    
        public Sortie(int pIdSortie, LocalDate pDateSortie, String pUtilisateur,int pNbProduits, int pIdProduit){
        idSortie = pIdSortie;
        dateSortie = pDateSortie;
        utilisateur = pUtilisateur;
        nbProduits = pNbProduits;
        idProduit = pIdProduit;
        idAdmin = null;
        estValide = null;
    }   
    
    
    //Getters
    
    public String getUtilisateur(){
        return utilisateur ;
    }
    
    public int getIdSortie(){
        return idSortie;
    }
    
    public LocalDate getDateSortie(){
        return dateSortie;
    }
    
    public int getNbProduits(){ 
        return nbProduits;
    }
    
    public int getLibelleProduit(){ 
        return idProduit ;
    }
    
    //Mutateurs
    
    public void setUtilisateur(String pUtilisateur){
        utilisateur = pUtilisateur;

    }
    
    public void setIdSortie(int pIdSortie){
        idSortie = pIdSortie;           
    }
    
    public void setDateSortie(LocalDate pDateSortie){
        dateSortie = pDateSortie;           
    }
    
    public void setNbProduits(int pNbProduits){
        nbProduits = pNbProduits;           
    }
    
    public void setLibelleProduit(int pIdProduit){
        idProduit = pIdProduit;           
    }
    
    public int getIdProduit(){
        return idProduit;
    }
    
    @Override
    public String toString(){
        String texte = "L'id de ce produit est '"+idProduit+"' il y a "+nbProduits+" exemplaire(s) qui ont été sorties le "+dateSortie+" par "+utilisateur+" l'ID de cette sortie est: "+idSortie;
        return texte;
    }
    
}
