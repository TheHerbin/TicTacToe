package PJ;

import javax.swing.*;
import java.awt.event.*;



public class Morpion {      //---------------------------attributs
     String tableau[][];
     int tour;
     int x;
    int y;
    String symbol;


    public Morpion() { //-----------------------------constructeur

        tableau=new String[3][3];
        initialisergrille();


       



    }

//-----------------------------------------------------Fonctions-------------

    public void affichertab(){
        for (int cy = 0;cy<this.tableau.length;cy++){

            for (int cx =0;cx<this.tableau.length;cx++){
                System.out.print(tableau[cx][cy]);
            }
            System.out.println(" ");
        }

    }







    public void initialisergrille(){       //initialise la grille de jeu en remplissant d'espaces

        for (int cy = 0;cy<this.tableau.length;cy++){

            for (int cx = 0;cx<this.tableau.length;cx++){
                this.tableau[cx][cy] = " ";
            }
        }

    }


    public int determinejoueur() {                   //détermine le joueur qui doit jouer et le retourne
        int joueur = this.tour % 2;
        joueur = joueur +1;
        return joueur;
    }

    public boolean testfin(){             //teste si un joueur gagne et arrète le jeu


        if (      (tableau[0][0]== tableau[1][0]&&tableau[0][0]==tableau[2][0]&&tableau[0][0]!=" ")
                ||(tableau[0][1]==tableau[1][1]&&tableau[2][1]==tableau[0][1]&&tableau[0][1]!=" ")
                ||(tableau[0][2]==tableau[1][2]&&tableau[2][2]==tableau[0][2]&&tableau[0][2]!=" ")
                ||(tableau[0][0]== tableau[0][1]&&tableau[0][0]==tableau[0][2]&&tableau[0][0]!=" ")
                ||(tableau[1][0]==tableau[1][1]&&tableau[1][2]==tableau[1][0]&&tableau[1][0]!=" ")
                ||(tableau[2][0]==tableau[2][1]&&tableau[2][2]==tableau[2][0]&&tableau[2][0]!=" ")
                ||(tableau[0][0]== tableau[1][1]&&tableau[0][0]==tableau[2][2]&&tableau[0][0]!=" ")
                ||(tableau[0][2]== tableau[1][1]&&tableau[0][2]==tableau[2][0]&&tableau[0][2]!=" ")

        ){
            // ("Le joueur "+(determinejoueur(tour-1))+" a gagné !");
            return true;
        }


        return false;

    }


    public String retournegagnant(){             //teste si un joueur gagne et arrète le jeu


        if (      (tableau[0][0]== tableau[1][0]&&tableau[0][0]==tableau[2][0]&&tableau[0][0]!=" ")
                ||(tableau[0][1]==tableau[1][1]&&tableau[2][1]==tableau[0][1]&&tableau[0][1]!=" ")
                ||(tableau[0][2]==tableau[1][2]&&tableau[2][2]==tableau[0][2]&&tableau[0][2]!=" ")
                ||(tableau[0][0]== tableau[0][1]&&tableau[0][0]==tableau[0][2]&&tableau[0][0]!=" ")
                ||(tableau[1][0]==tableau[1][1]&&tableau[1][2]==tableau[1][0]&&tableau[1][0]!=" ")
                ||(tableau[2][0]==tableau[2][1]&&tableau[2][2]==tableau[2][0]&&tableau[2][0]!=" ")
                ||(tableau[0][0]== tableau[1][1]&&tableau[0][0]==tableau[2][2]&&tableau[0][0]!=" ")
                ||(tableau[0][2]== tableau[1][1]&&tableau[0][2]==tableau[2][0]&&tableau[0][2]!=" ")

        ){

            return "Le joueur "+determinejoueur()+" a gagné !";
        }


        return " ";
    }


    public String choixjoueur(){
        return "C'est au joueur "+determinejoueur()+"de jouer !";
    }

    public boolean testcaseP(){

        if (tableau[x][y]!= " "){


            return false;
        }else{
            return true;
        }

    }

    public String casePrise(){
        return "Cette case n'est pas vide ...";
    }

    public String casepPrise(){
        return "cette case a été remplie ";
    }

    //----------------------------------------------------------------ACCESSEURS-------------------------------------
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getSymbol() {
        if (determinejoueur()==1){
            symbol = "X";
        }else{
            symbol ="O";
        }
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTableau(String[][] tableau) {
        this.tableau = tableau;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }
}
