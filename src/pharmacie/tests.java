/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pharmacie;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author zking
 */
public class tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        /*Passerelle.connexion();
        System.out.println(Passerelle.log(1));
        System.out.println(Passerelle.sortie(1, 20, 1));*/
        
        
        
        
        //Test fonction donnerTousLesProduits()
        /*ArrayList<Produit> p2 = Passerelle.donnerTousLesProduits();
        String retour="";
        for(Produit pdt:p2){
            retour+="\n"+pdt.toString();
        }
        System.out.println(retour);*/
        
        //Test fonction donnerUnProduit()
        /*Produit p2 = Passerelle.donnerUnProduit(1);
        String retour = p2.toString();
        System.out.println(retour);*/
        
        //Test fonction AjouterProduit()
        /*
        Produit p1 = new Produit(9,"Doliprane",5.50,80,"Sur l_étagère interdite",10);
        boolean testAjout = Passerelle.ajouterProduit(p1);
        System.out.println(testAjout);
        */
        
        //Test fonction SupprimerProduit()
        /*
        Produit p3 = Passerelle.donnerUnProduit(5);
        boolean testSuppr = Passerelle.supprimerProduit(p3);
        System.out.println(testSuppr);
        */
        
        //Test fonction ModifierProduit()
        Produit p1 = new Produit(2,"Xanax",5.50,80,"Sur l_étagère interdite",50);
        boolean testModif = Passerelle.modifierProduit(p1);
        System.out.println(testModif);
        
        //Test fonction sortie()
        /*boolean test = Passerelle.sortie(2,15,1);
        System.out.println(test);*/
      
        //Test fonction getAllSorties()
        
        /*
        ArrayList<Sortie> s2 = Passerelle.getAllSorties();
        String retour="";
        for(Sortie uneSortie:s2){
            retour+="\n"+uneSortie.toString();
        }
        System.out.println(retour);
        
        */
    }

}
