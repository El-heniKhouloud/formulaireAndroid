package com.example.epilog;

public class etudiant {
    String nom, prenom,genre, date, email,tel,adr,niv;

    public etudiant(String nom, String prenom, String genre, String date, String email, String tel,String adr, String niv){
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.date = date;
        this.email = email;
        this.tel = tel;
        this.adr = adr;
        this.niv = niv;
    }

    public etudiant() {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getNiv() {
        return niv;
    }

    public void setNiv(String niv) {
        this.niv = niv;
    }

    @Override
    public String toString() {
        return
                "nom =" + nom + "  " +
                        " prenom =" + prenom + "  " +
                        " email =" + email + "  " +
                        " niv = " + niv + "  "
                ;
    }


}
