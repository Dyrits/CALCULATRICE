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
        char operator;
        do {
            System.out.println("Operation #" + operation);
            x = inputInt();
            operator = inputOperator();
            if (operator == 'Q') { continue; }
            y = inputInt();
            try {
                System.out.println();
                System.out.println("Résultat de l'opération #" + operation + " : ");
                int result = switch (operator) {
                    case '+' -> Operation.ajouter(x, y);
                    case '-' -> Operation.soustraire(x, y);
                    case '*' -> Operation.multiplier(x, y);
                    case '/' -> x / y;
                    default -> x % y; // Cas correspondant au %.
                };
                System.out.println(x + " " + operator + " " + y + " = " + result);
            } catch (DepassementCapaciteException exception) {
                System.err.println(exception.getMessage());
            } catch (ArithmeticException exception) {
                System.err.println("Il est impossible d'effectuer une division par zéro.");
            }
            operation ++;
            System.out.println();
        } while (operator != 'Q');
        console.close();
    }
    

    /**
     * Permet d'obtenir et contrôler la saisie d'un entier par l'utilisateur.
     *
     * @return int | Entier saisi par l'utilisateur.
     */
    public static int inputInt() {
        long input;
        do {
            System.out.println("Veuillez saisir un nombre entier:");
            input = console.nextLong();
            if (input > Integer.MAX_VALUE) {
                System.err.println("La valeur saisie dépasse les capacités de cette calculatrice. Réessayez...");
            }
        } while (input > Integer.MAX_VALUE);
        return (int) input;
    }

    /**
     * Permet d'obtenir et contrôler la saisie d'un opérateur par l'utilisateur.
     * @return char | Opérateur saisi par l'utilisateur.
     */
    public static char inputOperator() {
        char input;
        do {
            System.out.println("Veuillez saisir un opérateur. Saisissez Q pour quitter.");
            System.out.println("Liste des opérateurs valides: [+] [-] [*] [/] [%]");
            input = console.next().toUpperCase().charAt(0);
            if (!isOperator(input)) {
                System.err.println("L'opérateur saisie est invalide. Réessayez...");
            }
        } while (!isOperator(input));
        return input;
    }

    /**
     * Permet de tester si un caractère entré en paramètre fait partie des opérateurs valides ou non.
     *
     * @param input char | Caractère à tester.
     * @return boolean | "true" si le caractère est valide, sinon "false".
     */
    public static boolean isOperator(char input) {
        char[] operators = {'+', '-', '*', '/', '%', 'Q'};
        for (char operator : operators) {
            if (input == operator) { return true; }
        }
        return false;
    }
}
