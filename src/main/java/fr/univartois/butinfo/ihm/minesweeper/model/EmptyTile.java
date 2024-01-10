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
 * La classe EmptyTile représente une tuile vide sur la grille du jeu du Démineur.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class EmptyTile extends AbstractTile {

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
        return 0;
    }


}
