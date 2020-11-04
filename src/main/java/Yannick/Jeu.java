package Yannick;

import java.util.Scanner;

public class Jeu {

    public void chosePlayer(Joueur joueur1, Joueur joueur2){
        double random = Math.random() * 2;
        if (random <= 1) {
            System.out.println("Joueur1, le hasard t'a choisis pour commencer la partie!");
            System.out.println(" ");
            joueur1.isPlaying = true;
        } else {
            System.out.println("Joueur2, le hasard choisis pour commencer la partie!");
            System.out.println(" ");
            joueur2.isPlaying = true;
        }
    }

    public void gameInit() {
        System.out.println("Bienvenue sur le jeu Tic Tac Toe");
        System.out.println(" ");
        Scanner sc = new Scanner(System.in);
        String answer = "";
        Grille grille = new Grille();
        grille.setNewGrille();




        System.out.println("Les règles sont très simple : Deux joueurs s'affrontent au tour par tour");
        System.out.println("pour être le premier joueur à aligner trois 'X' dans une gille de 9 cases.");
        System.out.println("Pour se faire un joueur sera tiré au sort en début de partie pour débuter le jeu");
        System.out.println("puis chacun leur tour les joueurs placeront une croix dans la case disponible de leur choix en tapant ses coordonnées");
        System.out.println(" ");
        System.out.println("Pour commencer à jouer tape 'j'");
        System.out.println("Pour quitter le jeu tape 'q'");
        answer = sc.nextLine().toLowerCase();


        if (!answer.equals("j")) {
            while (!answer.equals("j") && !answer.equals("q")) {
                System.out.println("Je n'ai pas compris votre saisie :");
                System.out.println("Pour commencer à jouer tape 'j'");
                System.out.println("Pour quitter le jeu tape 'q'");
                answer = sc.nextLine();
            }
        }
        if (answer.equals("j")) {

            System.out.println("Entrez le nom du joueur 1 :");
            Joueur joueur1 = new Joueur(sc.next());
            System.out.println("Entrez le nom du joueur 2 :");
            Joueur joueur2 = new Joueur(sc.next());
            System.out.println(" ");
            System.out.println("C'est partie!");

            this.chosePlayer(joueur1,joueur2);

            while (!joueur1.getWinner() && !joueur2.getWinner() && grille.checkGrille()) {
                int abscisse = -1;
                int ordonnee = -1;
                String abscisseString = " ";

                if (joueur1.isPlaying) {
                    System.out.println(joueur1.getName() + " c'est à toi:");
                } else {
                    System.out.println(joueur2.getName() + " c'est à toi:");
                }
                grille.displayGrille();
                try {
                    System.out.println("Entre le numéro de la ligne sur laquelle tu souhaite placer ta croix:");
                    ordonnee = sc.nextInt();
                }catch (Exception e) {
                    abscisse = -1;
                    ordonnee = -1;
                    System.out.println("Vous devez entrer un entier (1 , 2 ou 3)");
                }
                System.out.println("Entre la lettre de la colonne sur laquelle tu souhaite placer ta croix:");
                abscisseString = sc.next().toLowerCase();

                switch (abscisseString) {
                    case "a":
                        abscisse = 0;
                        break;
                    case "b":
                        abscisse = 1;
                        break;
                    case "c":
                        abscisse = 2;
                        break;
                    default:
                        System.out.println("Cette colonne n'existe pas! Entrez a, b ou c .");
                        break;
                }
                if (abscisse != -1 && ordonnee != -1) {
                    try{
                        if(joueur1.isPlaying && grille.checkPosition(ordonnee, abscisse)){
                            grille.setGrilleX(ordonnee, abscisse);   
                        }else if(joueur2.isPlaying && grille.checkPosition(ordonnee, abscisse)){
                            grille.setGrilleO(ordonnee, abscisse); 
                        }else{
                            System.out.println("Cette position est ivalide!");
                            joueur1.setPlaying(!joueur1.getPlaying());
                            joueur2.setPlaying(!joueur2.getPlaying());
                        }
                        joueur1.setPlaying(!joueur1.getPlaying());
                        joueur2.setPlaying(!joueur2.getPlaying());
                    }catch (Exception e){
                        System.out.println("Cette ligne n'existe pas, vous devez choisir la ligne 1 , 2 ou 3");

                    }

                }if(grille.isWinningGrille() && joueur1.getPlaying()){
                    joueur2.setWinner(true);
                    grille.displayGrille();
                    System.out.println("Bravo " + joueur2.getName() + ", tu as gagné!");
                    System.out.println("Tapez 'j' pour rejouer ou une autre touche pour quitter.");
                    answer = sc.next().toLowerCase();
                    if(answer.equals("j")){
                        joueur2.setWinner(false);
                        grille.setNewGrille();
                        this.chosePlayer(joueur1,joueur2);
                    }
                }else if(grille.isWinningGrille() && joueur2.getPlaying()){
                    joueur1.setWinner(true);
                    grille.displayGrille();
                    System.out.println("Bravo " + joueur1.getName() + ", tu as gagné!");
                    System.out.println("Tapez 'j' pour rejouer ou une autre touche pour quitter.");
                    answer = sc.next().toLowerCase();
                    if(answer.equals("j")){
                        joueur1.setWinner(false);
                        grille.setNewGrille();
                        this.chosePlayer(joueur1,joueur2);
                    }
                }else if(!grille.checkGrille()){
                    System.out.println("Vous êtes Exe aequo!");
                    System.out.println("Tapez 'j' pour rejouer ou une autre touche pour quitter.");
                    answer = sc.next().toLowerCase();
                    if(answer.equals("j")){
                        grille.setNewGrille();
                        this.chosePlayer(joueur1,joueur2);
                    }
                }

            }

        }
        System.out.println("Fin de partie");
    }


}
