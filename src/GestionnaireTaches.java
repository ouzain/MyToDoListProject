import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestionnaireTaches {
    private static ArrayList<Tache> listeTaches = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()

            switch (choix) {
                case 1:
                    ajouterTache();
                    break;
                case 2:
                    afficherListeTaches();
                    break;
                case 3:
                    marquerTacheCommeTerminee();
                    break;
                case 4:
                    supprimerTache();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 5);
    }

    private static void afficherMenu() {
        System.out.println("\n===== Gestionnaire de Tâches =====");
        System.out.println("1. Ajouter une tâche");
        System.out.println("2. Afficher la liste des tâches");
        System.out.println("3. Marquer une tâche comme terminée");
        System.out.println("4. Supprimer une tâche");
        System.out.println("5. Quitter");
        System.out.print("Choix : ");
    }

    private static void ajouterTache() {
        System.out.print("Nom de la tâche : ");
        String nom = scanner.nextLine();
        System.out.print("Description de la tâche : ");
        String description = scanner.nextLine();

        Tache nouvelleTache = new Tache(nom, description);
        listeTaches.add(nouvelleTache);
        System.out.println("Tâche ajoutée avec succès !");
    }

    private static void afficherListeTaches() {
        if (listeTaches.isEmpty()) {
            System.out.println("La liste des tâches est vide.");
        } else {
            System.out.println("\n===== Liste des Tâches =====");
            for (Tache tache : listeTaches) {
                System.out.println(tache);
                System.out.println("------------------------------");
            }
        }
    }

    private static void marquerTacheCommeTerminee() {
        afficherListeTaches();
        System.out.print("Entrez le nom de la tâche à marquer comme terminée : ");
        String nomTache = scanner.nextLine();

        boolean tacheTrouvee = false;
        Iterator<Tache> iterator = listeTaches.iterator();
        while (iterator.hasNext()) {
            Tache tache = iterator.next();
            if (tache.getNom().equalsIgnoreCase(nomTache)) {
                tache.marquerCommeTerminee();
                System.out.println("Tâche marquée comme terminée !");
                tacheTrouvee = true;
                break;
            }
        }

        if (!tacheTrouvee) {
            System.out.println("Tâche non trouvée.");
        }
    }

    private static void supprimerTache() {
        afficherListeTaches();
        System.out.print("Entrez le nom de la tâche à supprimer : ");
        String nomTache = scanner.nextLine();

        boolean tacheTrouvee = false;
        Iterator<Tache> iterator = listeTaches.iterator();
        while (iterator.hasNext()) {
            Tache tache = iterator.next();
            if (tache.getNom().equalsIgnoreCase(nomTache)) {
                iterator.remove();
                System.out.println("Tâche supprimée avec succès !");
                tacheTrouvee = true;
                break;
            }
        }

        if (!tacheTrouvee) {
            System.out.println("Tâche non trouvée.");
        }
    }
}