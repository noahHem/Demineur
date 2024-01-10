package fr.univartois.butinfo.ihm.minesweeper.controller;

import fr.univartois.butinfo.ihm.minesweeper.model.MinesweeperGame;
import fr.univartois.butinfo.ihm.minesweeper.model.MinesweeperGrid;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

public class minesweeperController implements interfaceController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button boutonCommencer;

    @FXML
    private GridPane grid;

    private MinesweeperGame game;

    private static final int LONGUEUR = 12;
    private static final int HAUTEUR = 12;
    private Button[][] grille = new Button[LONGUEUR][HAUTEUR];

    private Stage stage;

    private MinesweeperGrid mineGrid;

    @FXML
    void commencerPartie(ActionEvent event) {

    }

    @Override
    public void setGame(MinesweeperGame game) {
        this.game = game;
    }

    @Override
    public void setGrid(MinesweeperGrid grid) {
        for (int ligne =0; ligne<HAUTEUR;ligne++) {
            for(int colonne=0;colonne<LONGUEUR;colonne++) {
                final int l = ligne;
                final int c = colonne;
                Button btn = new Button();
                grille[ligne][colonne] = btn;
                this.grid.add(btn,ligne,colonne);
                grille[ligne][colonne].setPrefSize(40,40);

                mineGrid.get(l,c).flagProperty().addListener((p,o,n)-> {
                    if(n) {
                        grille[l][c].setStyle("-fx-background-color:#e74c3c;");
                    } else {
                        grille[l][c].setStyle("-fx-background-color:#95a5a6;");
                    }
                    grille[l][c].disableProperty().bind(mineGrid.get(l,c).revealedProperty());
                });

                mineGrid.get(l,c).revealedProperty().addListener((p,o,n)-> {
                    if(mineGrid.get(l,c).isBomb()) {
                        grille[l][c].setText("Bombe");
                    } else {
                        mineGrid.get(l,c).getValue();
                    }
                });


            };
        }
    }
}

