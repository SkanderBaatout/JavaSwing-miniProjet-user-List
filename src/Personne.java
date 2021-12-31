

public class Personne {
    public String nom;
    public String genre;
    public int id;
    public Personne(String nom, String genre, int id) {
        this.nom = nom;
        this.genre = genre;
        this.id = id;
    }

    public Personne() {
        this.nom = "random2";
        this.genre = "Femme";
    }

    public Personne(String nom, String genre) {
        this.nom = nom;
        this.genre = genre;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
