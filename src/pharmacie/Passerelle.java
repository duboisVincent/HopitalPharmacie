/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacie;

import java.util.ArrayList;
import java.sql.*;
import java.security.*;
import java.time.LocalDate;

/**
 *
 * @author zking
 */
public class Passerelle {

    private static Connection conn;
    private static int idEmploye, idGrade, idService;
    private static String nom, prenom;
    
    public static Employe lEmploye;

    public static Connection connexion() {
        try {
            String url = "jdbc:postgresql://192.168.1.245:5432/slam2024hopitalpharmacie_dubois"; // à changer en cours
            String user = "dubois";
            String passwd = "Chienchatcheval.";
            conn = DriverManager.getConnection(url, user, passwd);

            System.out.println("connexion réussie");

        } catch (SQLException e) {
            System.out.println("Echec de la connexion : " + e);
        }
        return conn;
    }

    public static void deconnexion() {
        try {
            conn.close();
            System.out.println("Connexion fermée");
        } catch (SQLException e) {
            System.out.println("ERROR (deconnection BDD) : " + e);
        }
    }

    public static ArrayList<Produit> donnerTousLesProduits() {
        Connection conn = connexion();
        ArrayList<Produit> lesProduits = new ArrayList<>();
        try {
            Produit p;
            java.sql.Statement state = conn.createStatement();
            ResultSet R1 = state.executeQuery("select * from \"medicament\"");
            while (R1.next()) {
                int id = R1.getInt(1);
                String nom = R1.getString(2);
                double prix = R1.getDouble(4);
                int qtte = R1.getInt(5);
                String local = R1.getString(3);
                int seuilCrit = R1.getInt(6);
                p = new Produit(id, nom, prix, qtte, local, seuilCrit);
                lesProduits.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Echec de la connexion : " + e);
        }
        return lesProduits;

    }

    public static Produit donnerUnProduit(int unId) {
        Connection conn = connexion();
        PreparedStatement prepare;
        ResultSet R2;
        Produit p1 = null;
        String requete = "Select * from \"medicament\" where id=?" ;
        try{
            prepare=conn.prepareStatement(requete);
        }
        catch(SQLException ex){
            prepare=null;
        }
        try{
            prepare.setInt(1,unId);
            R2=prepare.executeQuery();
        }
        catch(SQLException ex){
            R2=null;
        }
        try{
            while(R2.next()){
                int id = R2.getInt(1);
                String nom = R2.getString(2);
                double prix = R2.getDouble(4);
                int qtte = R2.getInt(5);
                String local = R2.getString(3);
                int seuilCrit = R2.getInt(6);
                p1 = new Produit(id, nom, prix, qtte, local,seuilCrit);
            }
            }
        
        catch(SQLException ex){
            p1=null;
        }    
        return p1;
    }

    public static boolean ajouterProduit(Produit unProduit) {
        Connection conn = connexion();
         boolean vraiFaux = true;
        try {
            PreparedStatement sql = conn.prepareStatement("insert into \"medicament\" (id,libelle,prix,quantite,localisation,seuilcrit) values (?,?,?,?,?,?)");
            sql.setInt(1, unProduit.getId());
            sql.setString(2, unProduit.getLibelle());
            sql.setDouble(3, unProduit.getPrix());
            sql.setInt(4, unProduit.getQuantite());
            sql.setString(5, unProduit.getLocalisation());
            sql.setInt(6, unProduit.getSeuilCrit());
            sql.executeUpdate();
        } catch (SQLException e) {
            System.out.println("erreur : " + e);
            vraiFaux=false;
        }
        return vraiFaux;
    }

    public static boolean modifierProduit(Produit unProduit) {
        Connection conn = connexion();
        int i = 0;
        boolean retour = false;
        try {
            PreparedStatement sql = conn.prepareStatement("UPDATE \"medicament\" SET libelle=?,prix=?,quantite=?,localisation=?, seuilcrit=? where id=?;");
            sql.setString(1, unProduit.getLibelle());
            sql.setDouble(2, unProduit.getPrix());
            sql.setInt(3, unProduit.getQuantite());
            sql.setString(4, unProduit.getLocalisation());
            sql.setInt(5, unProduit.getSeuilCrit());
            sql.setInt(6, unProduit.getId());
            i = sql.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur : " + e);
        }
        if (i > 0) {
            retour = true;
        }
        return (retour);
    }

    public static boolean supprimerProduit(Produit unProduit) {
        Connection conn = connexion();
        boolean vraiFaux = true;
        try {
            PreparedStatement sql = conn.prepareStatement("DELETE FROM \"medicament\" WHERE id =?;");
            sql.setInt(1, unProduit.getId());    
        } catch (SQLException e) {
            System.out.println("echec : " + e);
            vraiFaux = false;
        } 
        return vraiFaux;
    }

public static boolean authentification(String pLogin, String pMdp) throws NoSuchAlgorithmException {
        Connection conn = connexion();
        int i = 0;
        String mdp = null;
        try {
            PreparedStatement sql = conn.prepareStatement("select motdepasse, id, grade from employe where login=?");
            sql.setString(1, pLogin);
            ResultSet R2 = sql.executeQuery();
            if (R2.next()) {
                mdp = R2.getString(1);
                idEmploye = R2.getInt(2);
                idGrade = R2.getInt(3);
            }
            String input = pMdp;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(input.getBytes());

            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            if (mdp.equals(sb.toString())) {
                i = 1;
            }

        } catch (SQLException e) {

        }
        return (i > 0);
    }

 public static Employe authentification2(String pLogin, String pMdp) throws NoSuchAlgorithmException {
        Connection conn = connexion();
        Employe unEmploye = null;
        int i = 0;
        String mdp = null;
        try {
            PreparedStatement sql = conn.prepareStatement("select motdepasse, id, grade,Idservice,nom,prenom from employe where login=?");
            sql.setString(1, pLogin);
            ResultSet R2 = sql.executeQuery();
            if (R2.next()) {
                mdp = R2.getString(1);
                idEmploye = R2.getInt(2);
                idGrade = R2.getInt(3);
                idService = R2.getInt(4);
                nom = R2.getString(5);
                prenom = R2.getString(6);
                
                String input = pMdp;
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(input.getBytes());

                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                if (mdp.equals(sb.toString())) {
                    unEmploye = new Employe(idEmploye,idService,idGrade,nom,prenom);
                    lEmploye = unEmploye;
                }
            }
            

        } catch (SQLException e) {

        }
        return unEmploye;
    }

    public static boolean log(int idEmploye) {
        Connection conn = connexion();
        int i = 0;
        try {
            PreparedStatement sql = conn.prepareStatement("insert into authentification(date,\"idemploye\") values(?,?) ");
            Date dateAInserer = new Date(System.currentTimeMillis()); // Utilisez la date actuelle ici
            sql.setDate(1, dateAInserer);
            sql.setInt(2, idEmploye);
            i = sql.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return (i > 0);
    }

    public static boolean sortie(int idMedicament, int quantite, int idEmploye) throws SQLException {
        Connection conn = connexion();
        int i = 0;
        int j=0;
        try {
            //creation de la ligne de sortie dans la table Sortie
            PreparedStatement insert = conn.prepareStatement("insert into \"sortie\" (date,idemploye,idmedicament,quantite) values(?,?,?,?)");
            Date dateAInserer = new Date(System.currentTimeMillis()); // Utilisez la date actuelle ici
            insert.setDate(1, dateAInserer);
            insert.setInt(2, idEmploye);
            insert.setInt(3, idMedicament);
            insert.setInt(4, quantite);
            //update de la table medicament afin de changer la quantite
            PreparedStatement update=conn.prepareStatement("update \"medicament\" set quantite =quantite-? where id=?");
            update.setInt(1, quantite);
            update.setInt(2, idMedicament);
            
            j=update.executeUpdate();
            i=insert.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return(i>0 && j>0);
    }
    
    public static ArrayList<Sortie> getAllSorties(){
        Connection conn = connexion();
        PreparedStatement prepare;
        String requete = "Select \"id\",\"idemploye\",\"date\",\"quantite\",\"idmedicament\" from \"sortie\" ORDER BY \"date\" asc ";
        ArrayList<Sortie> lesSorties= new ArrayList<>();
        ResultSet jeuResultat ;
        try{
            prepare=conn.prepareStatement(requete);
            jeuResultat=prepare.executeQuery();   
            while(jeuResultat.next()){       
                int idSortie = jeuResultat.getInt(1);
                String employe = jeuResultat.getString(2);
                LocalDate dateSortie = jeuResultat.getObject(3,LocalDate.class);
                int nbProduits = jeuResultat.getInt(4);
                int idProduit = jeuResultat.getInt(5);
                Sortie s1 = new Sortie(idSortie, dateSortie, employe, nbProduits, idProduit );
                lesSorties.add(s1); 
            }
        }catch(SQLException e){
            jeuResultat=null;
            e.printStackTrace();
        }           
        
        return lesSorties;       
    }
    
    //A finir
    public static boolean creerEmploye(int idEmploye, int idService, int grade, String nom, String prenom, String login, String passwd) throws SQLException{
        Connection conn = connexion();
        PreparedStatement prepare;
        String requete = "UPDATE * from \"employe\" set ...";
        boolean vraiFaux = true;
        try{
            prepare=conn.prepareStatement(requete);
            prepare.setInt(1,idEmploye);
            prepare.setInt(2,idService);
            prepare.setInt(3,grade);
            prepare.setString(4,nom);
            prepare.setString(5,prenom);
            prepare.setString(6,login);
            prepare.setString(7,passwd);
            
            
        }
        catch(SQLException ex){
            vraiFaux=false;
        }
        return vraiFaux;
    }
    
}
