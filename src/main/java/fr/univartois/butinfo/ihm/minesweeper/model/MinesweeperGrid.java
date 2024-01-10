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

import java.util.Random;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;

/**
 * La classe MinesweeperGrid représente la grille du jeu du Démineur.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class MinesweeperGrid {

    /**
     * Le générateur de nombres pseudo-aléatoires utilisé pour placer les bombes
     * aléatoirement sur la grille.
     */
    private static final Random RANDOM = new Random();

    /**
     * La hauteur de la grille, en nombre de lignes.
     */
    private final int height;

    /**
     * La largeur de la grille, en nombre de colonnes.
     */
    private final int width;

    /**
     * Les tuiles qui constituent cette grille.
     */
    private final AbstractTile[][] tiles;

    /**
     * Crée une nouvelle instance de MinesweeperGrid.
     *
     * @param height La hauteur de la grille, en nombre de lignes.
     * @param width La largeur de la grille, en nombre de colonnes.
     */
    public MinesweeperGrid(int height, int width) {
        this.height = height;
        this.width = width;
        this.tiles = new AbstractTile[height][width];
    }

    /**
     * Initialise la grille en plaçant les bombes et en les comptant.
     */
    public void initialize() {
        int nBombs = height * width / 10;
        putBombs(nBombs);
        countBombs();
    }

    /**
     * Donne la hauteur de cette grille.
     *
     * @return La hauteur de cette grille.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Donne la largeur de cette grille.
     *
     * @return La largeur de cette grille.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Vérifie si une position donnée se trouve sur la grille.
     *
     * @param row La ligne de la position à vérifier.
     * @param column La colonne de la position à vérifier.
     *
     * @return Si la position donnée est sur la grille.
     */
    private boolean isOnGrid(int row, int column) {
        return ((0 <= row) && (row < height))
                && ((0 <= column) && (column < width));
    }

    /**
     * Place aléatoirement les bombes sur la grille.
     *
     * @param nBombs Le nombre de bombes à placer.
     */
    private void putBombs(int nBombs) {
        // On crée une propriété permettant de révéler toutes les bombes à la fois.
        BooleanProperty reveal = new SimpleBooleanProperty();

        for (int i = 0; i < nBombs; i++) {
            // On choisit un emplacement aléatoirement sur la grille.
            int row = RANDOM.nextInt(height);
            int column = RANDOM.nextInt(width);

            // S'il y a déjà une bombe placée à cet endroit, on recommence.
            while (tiles[row][column] != null) {
                row = RANDOM.nextInt(height);
                column = RANDOM.nextInt(width);
            }

            // On crée une bombe à cet endroit.
            tiles[row][column] = new BombTile();
            tiles[row][column].revealedProperty().bindBidirectional(reveal);
        }
    }

    /**
     * Compte les bombes autour de chacune des cases de la grille.
     */
    private void countBombs() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tiles[i][j] == null) {
                    tiles[i][j] = createCountTile(i, j);
                }
            }
        }
    }

    /**
     * Crée une tuile comptant le nombre de bombes autour de la position donnée.
     *
     * @param row La ligne de la tuile à créer.
     * @param column La colonne de la tuile à créer.
     *
     * @return La tuile comptant les bombes autour de la position donnée.
     */
    private AbstractTile createCountTile(int row, int column) {
        int nb = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!isOnGrid(row + i, column + j)) {
                    // Cette position est en dehors de la grille.
                    continue;
                }

                if ((tiles[row + i][column + j] != null)
                        && (tiles[row + i][column + j].isBomb())) {
                    // Cette tuile voisine comporte une bombe.
                    nb++;
                }
            }
        }

        // S'il n'y a pas de bombes, on crée une tuile vide.
        if (nb == 0) {
            return new EmptyTile();
        }

        // On crée la tuile avec le nombre de bombes.
        return new ValueTile(nb);
    }

    /**
     * Donne la tuile à la position donnée sur cette tuile.
     *
     * @param row La ligne de la tuile à donner.
     * @param column La colonne de la tuile à donner.
     *
     * @return La tuile à la position donnée.
     */
    public AbstractTile get(int row, int column) {
        return tiles[row][column];
    }

    /**
     * Révèle la tuile à la position donnée, ainsi que les tuiles
     * voisines si elles ne comportent pas de bombes.
     *
     * @param row La ligne de la tuile à révéler.
     * @param column La colonne de la tuile à révéler.
     *
     * @return Si la tuile à la position donnée comporte une bombe.
     */
    public boolean reveal(int row, int column) {
        if (!isOnGrid(row, column)) {
            // La case est en dehors de la grille : on s'arrête là.
            return false;
        }

        if (tiles[row][column].isBomb()) {
            // La case comporte une bombe : on s'arrête là.
            return true;
        }

        if (tiles[row][column].isRevealed()) {
            // Inutile d'aller plus loin : la case est déjà révélée.
            return false;
        }

        // On révèle la case, et les cases voisines lorsque c'est nécessaire.
        tiles[row][column].setReavealed(true);
        if (tiles[row][column].getValue() == 0) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    reveal(row + i, column + j);
                }
            }
        }
        return false;
    }

}
