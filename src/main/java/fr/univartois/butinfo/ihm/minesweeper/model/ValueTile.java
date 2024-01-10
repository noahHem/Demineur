/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.ihm.minesweeper.model;

import fr.univartois.butinfo.ihm.minesweeper.model.AbstractTile;

/**
 * La classe ValueTile représente une tuile de la grille du jeu du Démineur comportant le
 * nombre de tuiles voisine sur lesquelles se trouve une bombe.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class ValueTile extends AbstractTile {

    /**
     * La valeur sur cette tuile.
     */
    private final int value;

    /**
     * Crée une nouvelle instance de ValueTile.
     *
     * @param value La valeur de cette tuile.
     */
    public ValueTile(int value) {
        this.value = value;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.ihm.minesweeper.model.AbstractTile#isBomb()
     */
    @Override
    public boolean isBomb() {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.ihm.minesweeper.model.AbstractTile#getValue()
     */
    @Override
    public int getValue() {
        return value;
    }

}
