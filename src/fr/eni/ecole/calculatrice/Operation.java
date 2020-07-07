package fr.eni.ecole.calculatrice;

import java.lang.constant.Constable;

public class Operation {

    /**
     * Effectue la somme de deux valeurs.
     *
     * @param x int | 1ère valeur.
     * @param y int | 2nde valeur à ajouter à la 1ère.
     * @return int | Somme des valeurs.
     * @throws DepassementCapaciteException Exception | Dépassement de la capacité lié au typage.
     */
    public static int ajouter(int x, int y) throws DepassementCapaciteException {
        if ((long) x + y == x + y) { return x + y; }
        throw new DepassementCapaciteException();
    }

    /**
     * Effectue la soustraction d'une valeur à une autre.
     *
     * @param x int | 1ère valeur.
     * @param y int | 2nde valeur à soustraire à la 1ère
     * @return int | Résultat de la soustraction.
     * @throws DepassementCapaciteException Exception | Dépassement de la capacité lié au typage.
     */
    public static int soustraire(int x, int y) throws DepassementCapaciteException {
        if ((long) x - y == x - y) { return x - y; }
        throw new DepassementCapaciteException();
    }

    /**
     * Effectue le produit de deux valeurs.
     *
     * @param x int | 1ère valeur.
     * @param y int | 2nde valeur à multiplier avec la 1ère
     * @return int | Résultat de la multiplication.
     * @throws DepassementCapaciteException Exception | Dépassement de la capacité lié au typage.
     */
    public static int multiplier(int x, int y) throws DepassementCapaciteException {
        if ((long) x * y == x * y) { return x * y; }
        throw new DepassementCapaciteException();
    }
}
