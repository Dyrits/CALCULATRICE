package fr.eni.ecole.calculatrice;

import java.util.Scanner;

public class Calculatrice {
    private static Scanner console;

    /**
     * Méthode principale permettant d'effectuer des calculs arithmétiques basiques.
     *
     * @param args | Aucun argument requis.
     */
    public static void main(String[] args) {
        console = new Scanner(System.in);
        int x, y, operation = 1;
        char operateur;
        do {
            System.out.println("Operation #" + operation);
            x = saisirEntier();
            operateur = saisirOperateur();
            if (operateur == 'Q') { continue; }
            y = saisirEntier();
            System.out.println();
            System.out.println("Résultat de l'opération #" + operation + " : ");
            calculer(x, operateur, y);
            operation ++;
            System.out.println();
        } while (operateur != 'Q');
        console.close();
    }

    /**
     * Calcule, formate et affiche le résultat d'une opération entre deux valeurs.
     * @param x int | 1ère valeur.
     * @param operateur char | Caractère désignant le type d'opération.
     * @param y int | 2nde valeur.
     */
    public static void calculer(int x, char operateur, int y) {
        try {
            System.out.println(
                    x + " " +
                    operateur + " " +
                    y + " = " +
                    switch (operateur) {
                        case '+' -> Operation.ajouter(x, y);
                        case '-' -> Operation.soustraire(x, y);
                        case '*' -> Operation.multiplier(x, y);
                        case '/' -> x / y;
                        default -> x % y; // Cas correspondant au %.
            });
        } catch (DepassementCapaciteException exception) {
            System.out.println(exception.getMessage()); // Délai en utilisant "System.err"
        } catch (ArithmeticException exception) {
            System.out.println("Il est impossible d'effectuer une division par zéro."); // Délai en utilisant "System.err"
        }
    }
    

    /**
     * Permet d'obtenir et contrôler la saisie d'un entier par l'utilisateur.
     *
     * @return int | Entier saisi par l'utilisateur.
     */
    public static int saisirEntier() {
        long entier;
        do {
            System.out.println("Veuillez saisir un nombre entier:");
            entier = console.nextLong();
            if (entier > Integer.MAX_VALUE) {
                System.err.println("La valeur saisie dépasse les capacités de cette calculatrice. Réessayez...");
            }
        } while (entier > Integer.MAX_VALUE);
        return (int) entier;
    }

    /**
     * Permet d'obtenir et contrôler la saisie d'un opérateur par l'utilisateur.
     * @return char | Opérateur saisi par l'utilisateur.
     */
    public static char saisirOperateur() {
        char operateur;
        do {
            System.out.println("Veuillez saisir un opérateur. Saisissez Q pour quitter.");
            System.out.println("Liste des opérateurs valides: [+] [-] [*] [/] [%]");
            operateur = console.next().toUpperCase().charAt(0);
            if (!estOperateur(operateur)) {
                System.err.println("L'opérateur saisie est invalide. Réessayez...");
            }
        } while (!estOperateur(operateur));
        return operateur;
    }

    /**
     * Permet de tester si un caractère entré en paramètre fait partie des opérateurs valides ou non.
     *
     * @param charTest char | Caractère à tester.
     * @return boolean | "true" si le caractère est valide, sinon "false".
     */
    public static boolean estOperateur(char charTest) {
        char[] operateurs = {'+', '-', '*', '/', '%', 'Q'};
        for (char operateur : operateurs) {
            if (charTest == operateur) { return true; }
        }
        return false;
    }
}
