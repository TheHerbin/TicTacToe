package PJ;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class grafic extends JDialog {
    private JPanel contentPane;
    private JPanel coteG;
    private JPanel coteD;
    private JPanel coteM;
    private JButton bouton8;
    private JButton bouton5;
    private JButton bouton2;
    private JButton bouton7;
    private JButton bouton9;
    private JButton bouton3;
    private JButton bouton6;
    private JButton bouton4;
    private JButton bouton1;
    private JLabel question;
    private JButton quitterB;
    private JLabel caseP;
    private JButton restart;
    private Morpion morpion;
    private ArrayList<JButton> listebouton;



    public grafic() {
      //  exemple : morpion.tour=4;
        setContentPane(contentPane);
        setModal(true);
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        // perso

        initListe();
        init();

    }

    public void initListe(){
        this.listebouton= new ArrayList<>();
        this.listebouton.add(bouton1);
        this.listebouton.add(bouton2);
        this.listebouton.add(bouton3);
        this.listebouton.add(bouton4);
        this.listebouton.add(bouton5);
        this.listebouton.add(bouton6);
        this.listebouton.add(bouton7);
        this.listebouton.add(bouton8);
        this.listebouton.add(bouton9);
    }

    private void init() {
        quitterB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuitter();
            }
        });

        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRestart();
            }
        });

        for (JButton unboutton:this.listebouton  ) {
            unboutton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClick(unboutton.getName());

                }
            });
        }
        this.caseP.setText(" ");
        this.question.setText(" ");
        restart.setEnabled(false);
        caseP.setText(" ");

        morpion = new Morpion();
        //éxécution du jeu :
        int tour =0 ;




    }


    //accesseurs
    public Morpion getMorpion() {
        return morpion;
    }

    public void setgagnant() {
        this.question.setText(morpion.retournegagnant());

    }
    public void setjoueur() {
        this.question.setText(morpion.choixjoueur());

    }
    public void setCaseP(){
        this.caseP.setText(morpion.casePrise());
    }





    //autres
    private void onQuitter() {
        // add your code here
        dispose();
    }

    private void onRestart() {
        // add your code here

            init();
            morpion.initialisergrille();
                morpion.affichertab();
            morpion.setTour(0);
        for (JButton cebouton : listebouton) {
            cebouton.setEnabled(true);
           cebouton.setText(" ");
        }

    }

    private void onClick(String s) {    // s est les coordonées du bouton

        //transtypage :

       String ax= Character.toString(s.charAt(0));
        String ay= Character.toString(s.charAt(1));

        Integer tx = Integer.parseInt(ax);
        Integer ty = Integer.parseInt(ay);
        

            int x = tx;
            int y = ty;
        morpion.setX(tx);
        morpion.setY(ty);

        if (morpion.testcaseP()==false){
            caseP.setText("Cette case n'est pas vide");




        }  else {

            caseP.setText(" ");
            String symbol = morpion.getSymbol();
            morpion.tableau[x][y]= symbol;
            for (JButton unboutton:this.listebouton  ) {
                if (unboutton.getName().equals(s)) {
                    unboutton.setText(symbol);
                }


            }

            if (morpion.testfin()==true){

                for (JButton cebouton : listebouton) {
                    cebouton.setEnabled(false);
                }
                question.setText("Le joueur "+morpion.determinejoueur()+" a gagné");
                restart.setEnabled(true);

            }else {
                int T = morpion.getTour() + 1;
                System.out.println("tour =" + T);
                morpion.setTour(T);

                if (morpion.getTour() == 9) {
                    for (JButton cebouton : listebouton) {
                        cebouton.setEnabled(false);
                    }
                    question.setText("Egalité !");
                    restart.setEnabled(true);
                } else {

                    question.setText("C'est au joueur " + morpion.determinejoueur() + " de jouer !");
                }
            }




        }



    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void placerSymbol(){


    }






}
