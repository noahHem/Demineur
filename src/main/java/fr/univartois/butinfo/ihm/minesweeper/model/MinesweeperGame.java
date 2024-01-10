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

import fr.univartois.butinfo.ihm.minesweeper.controller.interfaceController;

/**
 * La MinesweeperGame gère une partie du jeu du Démineur.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class MinesweeperGame {

    /**
     * La hauteur de la grille du jeu, en nombre de lignes.
     */
    private final int height;

    /**
     * La largeur de la grille du jeu, en nombre de colonnes.
     */
    private final int width;

    /**
     * La grille sur laquelle se déroule le jeu du démineur.
     */
    private MinesweeperGrid grid;


    private interfaceController accessController;

    public void setInterfaceControl(interfaceController accessController) {
        this.accessController = accessController;
    }

    /**
     * Crée une nouvelle instance de MinesweeperGame.
     *
     * @param height La hauteur de la grille du jeu.
     * @param width La largeur de la grille du jeu.
     */
    public MinesweeperGame(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /**
     * Démarre la partie en cours.
     */
    public void start() {
        grid = new MinesweeperGrid(height, width);
        grid.initialize();
        accessController.setGrid(grid);

    }

    /**
     * Révèle la tuile à la position donnée.
     *
     * @param row La ligne de la tuile à révéler.
     * @param column La colonne de la tuile à révéler.
     */
    public void reveal(int row, int column) {
        if (grid.reveal(row, column)) {
            BombTile bomb = (BombTile) grid.get(row, column);
            bomb.setReavealed(true);
            bomb.setExploded(true);
        }
    }

}
