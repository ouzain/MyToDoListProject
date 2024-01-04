class Tache {
    private String nom;
    private String description;
    private boolean estTerminee;

    public Tache(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.estTerminee = false;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public boolean estTerminee() {
        return estTerminee;
    }

    public void marquerCommeTerminee() {
        this.estTerminee = true;
    }

    @Override
    public String toString() {
        return "Tâche : " + nom + "\nDescription : " + description + "\nStatut : " + (estTerminee ? "Terminée" : "En cours");
    }
}
