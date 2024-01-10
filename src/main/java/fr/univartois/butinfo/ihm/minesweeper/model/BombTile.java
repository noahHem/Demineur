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
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * La classe BombTile représente une tuile de la grille du jeu du Démineur sur laquelle se
 * trouve une bombe.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class BombTile extends AbstractTile {

    /**
     * La propriété indiquant si la bombe sur cette tuile a explosé.
     */
    private final BooleanProperty exploded = new SimpleBooleanProperty();

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.ihm.minesweeper.model.AbstractTile#isBomb()
     */
    @Override
    public boolean isBomb() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.ihm.minesweeper.model.AbstractTile#getValue()
     */
    @Override
    public int getValue() {
        throw new UnsupportedOperationException();
    }

    /**
     * Change la propriété {@code exploded} de cette tuile.
     *
     * @param exploded Si cette tuile a maintenant explosé.
     */
    public void setExploded(boolean exploded) {
        this.exploded.set(exploded);
    }

    /**
     * Vérifie si cette tuile a explosé.
     *
     * @return Si cette tuile a explosé.
     */
    public boolean isExploded() {
        return exploded.get();
    }

    /**
     * Donne la propriété {@code exploded} de cette tuile.
     *
     * @return La propriété indiquant si cette tuile a explosé.
     */
    public BooleanProperty explodedProperty() {
        return exploded;
    }

}
