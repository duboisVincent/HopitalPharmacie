/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacie;

/**
 *
 * @author zking
 */
public class Employe {
    private int id, idService, grade;
    private String nom,prenom,login,passwd;

    public Employe(int id, int idService, int grade, String nom, String prenom, String login, String passwd) {
        this.id = id;
        this.idService = idService;
        this.grade = grade;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.passwd = passwd;
    }
    
    public Employe(int id, int idService, int grade, String nom, String prenom) {
        this.id = id;
        this.idService = idService;
        this.grade = grade;
        this.nom = nom;
        this.prenom = prenom;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
}
