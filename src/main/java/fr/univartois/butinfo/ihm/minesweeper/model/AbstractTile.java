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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * La classe AbtractTile est la classe parente des différentes tuiles constituant la
 * grille du jeu du Démineur.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public abstract class AbstractTile {

    /**
     * La propriété indiquant si cette tuile est révélée.
     */
    private final BooleanProperty revealed = new SimpleBooleanProperty();

    /**
     * La propriété indiquant si un drapeau a été posé sur cette tuile.
     */
    private final BooleanProperty flag = new SimpleBooleanProperty();

    /**
     * Vérifie si cette tuile comporte une bombe.
     *
     * @return Si cette tuile comporte une bombe.
     */
    public abstract boolean isBomb();

    /**
     * Change la propriété {@code revealed} de cette tuile.
     *
     * @param revealed Si cette tuile est maintenant révélée.
     */
    public void setReavealed(boolean revealed) {
        this.revealed.set(revealed);
    }

    /**
     * Vérifie si cette tuile est révélée.
     *
     * @return Si cette tuile est révélée.
     */
    public boolean isRevealed() {
        return revealed.get();
    }

    /**
     * Donne la propriété {@code revealed} de cette tuile.
     *
     * @return La propriété indiquant si cette tuile est révélée.
     */
    public BooleanProperty revealedProperty() {
        return revealed;
    }

    /**
     * Change la propriété {@code flag} de cette tuile.
     *
     * @param flag Si cette tuile comporte maintenant un drapeau.
     */
    public void setFlag(boolean flag) {
        this.flag.set(flag);
    }

    /**
     * Vérifie si cette tuile comporte un drapeau.
     *
     * @return Si cette tuile comporte un drapeau.
     */
    public boolean hasFlag() {
        return flag.get();
    }

    /**
     * Donne la propriété {@code flag} de cette tuile.
     *
     * @return La propriété indiquant si cette tuile comporte un drapeau.
     */
    public BooleanProperty flagProperty() {
        return flag;
    }

    /**
     * Donne la valeur de cette tuile.
     *
     * @return La valeur de cette tuile.
     */
    public abstract int getValue();

}
