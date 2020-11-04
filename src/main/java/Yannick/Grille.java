package Yannick;


import java.sql.SQLOutput;

public class Grille {

    Pion[][] grille ;

    public Grille() {
        this.grille = new Pion[3][3];
    }

    public boolean isWinningGrille(){
        if ((this.grille[0][0].getValeur().equals("X") && this.grille[1][0].getValeur().equals("X") && this.grille[2][0].getValeur().equals("X"))
            || (this.grille[0][0].getValeur().equals("O") && this.grille[1][0].getValeur().equals("O") && this.grille[2][0].getValeur().equals("O"))){
            return true;
        }else if((this.grille[0][1].getValeur().equals("X") && this.grille[1][1].getValeur().equals("X") && this.grille[2][1].getValeur().equals("X"))
            || (this.grille[0][1].getValeur().equals("O") && this.grille[1][1].getValeur().equals("O") && this.grille[2][1].getValeur().equals("O"))){
            return true;
        }else if((this.grille[0][2].getValeur().equals("X") && this.grille[1][2].getValeur().equals("X") && this.grille[2][2].getValeur().equals("X"))
            || (this.grille[0][2].getValeur().equals("O") && this.grille[1][2].getValeur().equals("O") && this.grille[2][2].getValeur().equals("O"))){
            return true;
        }else if((this.grille[0][0].getValeur().equals("X") && this.grille[0][1].getValeur().equals("X") && this.grille[0][2].getValeur().equals("X"))
            || (this.grille[0][0].getValeur().equals("O") && this.grille[0][1].getValeur().equals("O") && this.grille[0][2].getValeur().equals("O"))){
            return true;
        }else if((this.grille[1][0].getValeur().equals("X") && this.grille[1][1].getValeur().equals("X") && this.grille[1][2].getValeur().equals("X"))
            || (this.grille[1][0].getValeur().equals("O") && this.grille[1][1].getValeur().equals("O") && this.grille[1][2].getValeur().equals("O"))){
            return true;
        }else if((this.grille[2][0].getValeur().equals("X") && this.grille[2][1].getValeur().equals("X") && this.grille[2][2].getValeur().equals("X"))
            || (this.grille[2][0].getValeur().equals("O") && this.grille[2][1].getValeur().equals("O") && this.grille[2][2].getValeur().equals("O"))){
            return true;
        }else if((this.grille[0][0].getValeur().equals("X") && this.grille[1][1].getValeur().equals("X") && this.grille[2][2].getValeur().equals("X"))
            || (this.grille[0][0].getValeur().equals("O") && this.grille[1][1].getValeur().equals("0") && this.grille[2][2].getValeur().equals("0"))){
            return true;
        }else if((this.grille[2][0].getValeur().equals("X") && this.grille[1][1].getValeur().equals("X") && this.grille[0][2].getValeur().equals("X"))
            || (this.grille[2][0].getValeur().equals("O") && this.grille[1][1].getValeur().equals("0") && this.grille[0][2].getValeur().equals("0"))){
            return true;
        }return false;
    }

    public void setNewGrille() {
        System.out.println("    A   B   C");
        for(int i = 0 ; i< this.grille.length ; i++){
            for(int j = 0 ; j < this.grille[i].length; j++){
                Pion pion = new Pion();
                this.grille[i][j] = pion;
            }

        }

    }
    public void displayGrille(){
        System.out.println("    A   B   C");
        for(int i = 0 ; i< this.grille.length ; i++){
            System.out.println((i+1) +" | " + this.grille[i][0].getValeur() + " | " + this.grille[i][1].getValeur() + " | " + this.grille[i][2].getValeur() + " |");
            if(i<2) {
                System.out.println("  -------------");
            }
        }
    }

    public Pion[][] getGrille() {
        return grille;
    }

    public void setGrille(int ordonnee, int abscisse) {
        this.grille[ordonnee-1][abscisse].setValeur("X");

    }
}
