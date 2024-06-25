
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author msi
 */
public class JeuMemory extends javax.swing.JFrame {
    private LesPersonnages persos; //attribut de type LesPersonnages 
    private LesJoueurs joueurs; //attribut de type LesJoueurs
    private Jeu monjeu;
    private int l1,c1,l2,c2;
    /**
     * Creates new form JeuMemory
     */
    public JeuMemory() {
        initComponents(); //création de l'interface par l'EDI
        this.persos = new LesPersonnages(4); // initialise l'attribut avec le constructeur per defaut de la classe LesPersonnages
        this.joueurs = new LesJoueurs(); // initialise l'attribut avec le constructeur per defaut de la classe LesJoueurs
        this.monjeu= new Jeu(this.persos,this.joueurs,4);
        this.l1 = -1;
        this.l2 = -1;
        this.c1 = -1;
        this.c2 = -1;
        /*Joueur j=new Joueur("epiques", "lara"); // créé un nouveau joueur et l'affecte a l'attribut j afin de tester la boite de dialogue 
        j.setPhoto(new ImageIcon(getClass().getResource("/img/lara.jpg"))); //change la photo du joueur 
        this.joueurs.ajouteJoueur(j); // ajoute le joueur j dans la liste joueurs 
        j=new Joueur("rares", "jack");
        j.setPhoto(new ImageIcon(getClass().getResource("/img/jack.png")));
        this.joueurs.ajouteJoueur(j);
        */
        
    }
    
    //Le clic sur une carte du jeu, qui correspond à l’exécution du gestionnaire 
    private void boutonActionPerformed(ActionEvent evt){
        JButton bt=(JButton) evt.getSource();
        String v = bt.getName();
        PlateauJeu plt = this.monjeu.getPlateau();
        int nB = Integer.parseInt(bt.getName());
        int nbCol = plt.getNbcol();
        int l = nB/nbCol;
        int c = nB - (l*nbCol);
        int valeur = plt.getCase(l,c);
        Personnage p = this.persos.getPerso(valeur);
        Image img = p.getPhoto().getScaledInstance(bt.getWidth(),bt.getHeight(),Image.SCALE_DEFAULT);
        bt.setIcon(new ImageIcon(img));
        if(l1==-1 && c1==-1){
            this.l1 = l;
            this.c1 = c;
        }
        else if(l2==-1 && c2==-1){
            this.l2 = l;
            this.c2 = c;
            startTimer();
        }
    }
    
    //permet d’avoir un temps d’attente, après le clic sur la 2ème carte,
    //pour que le joueur voit les 2 cartes avant leur traitement
    public void startTimer(){
    // définit un timer qui lance la vérification des deux personnages au bout d'une demi-seconde
    Timer t = new Timer(500, new ActionListener(){
    public void actionPerformed(ActionEvent ae){
    verifPersos();
    }
    });
    t.setRepeats(false);
    t.start();
 }
    //méthode qui vérifie les personnages des deux cartes
//retournées, traite le tour de jeu, met à jour l’interface et passe au joueur suivant.
 public void verifPersos(){
        int case1=this.monjeu.getPlateau().getCase(l1,c1);
        int case2=this.monjeu.getPlateau().getCase(l2,c2);
        int b1 = l1*monjeu.getPlateau().getNbcol()+c1;
        int b2 = l2*monjeu.getPlateau().getNbcol()+c2;
        if(case1==case2){
        Panneau.getComponent(b1).setEnabled(false);
        Panneau.getComponent(b2).setEnabled(false);
        String fam=this.persos.getPerso(case1).getFamille();
        int bonus=this.monjeu.traiterTour(this.monjeu.getJoueurCourant(),case1);
        if (bonus>=0){
            Edition.setText(this.monjeu.getJoueurCourant().getPseudo()+" a récupérer tous les personnages");
        if(bonus==0){
            this.monjeu.finJeu();
            Edition.append(this.monjeu.getJoueurCourant().getPseudo()+" a gagné!");
            for(int i=0;i<this.persos.getTaille()*2;i++)
            Panneau.getComponent(i).setEnabled(false);
        }
        else if(bonus==1){
            TransfertDlg t = new TransfertDlg(this,true,this.joueurs,this.monjeu.getIndc());
            t.setVisible(true);
            if(t.isOk()==true)
                Edition.append("\n"+t.getTransfert().getDeroulement());
        }
        else if(bonus==2){
            BatailleDlg b = new BatailleDlg(this,true,this.joueurs,this.monjeu.getIndc());
            b.setVisible(true);
            if(b.isOk()==true)
                Edition.append("\n"+b.getBataille().getDeroulement());
        }
        bonus= -1;
        int indC =this.monjeu.getIndc();
        this.monjeu.setJoueurCourant(this.monjeu.getIndSuivant(indC));
}
        this.monjeu.getPlateau().invalide(l1, c1, l2, c2);
        if(this.monjeu.getPlateau().jeuVide()){
            Edition.append("\n Fin du jeu");
            LesJoueurs lesj = this.monjeu.getLesJ().getGagnants();
            if(lesj.getNbJoueurs()>1){
                Edition.append("\nLes joueurs gagnants sont: \n"+lesj.toString());
            }
            else if(lesj.getNbJoueurs()==1){
                Edition.append("\nLe joueur gagnant est: "+lesj.getJoueur(0).toString());
                Jc.setText("C'est "+this.monjeu.getJoueurCourant().getPseudo()+" le gagnant ");//lesj.getJoueur(0)
            }
            }
} 
else{
    JButton bt1 = (JButton)Panneau.getComponent(b1);
    bt1.setIcon(null);
    JButton bt2 = (JButton)Panneau.getComponent(b2);
    bt2.setIcon(null);
    int indc = this.monjeu.getIndc();
    this.monjeu.setJoueurCourant(this.monjeu.getIndSuivant(indc));
    Jc.setText("C'est a "+this.monjeu.getJoueurCourant().getPseudo()+" de jouer");
}
    this.l1=-1;this.c1=-1;this.l2=-1;this.c2=-1;
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanDroite = new javax.swing.JPanel();
        PanneauEdition = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        PanneauMsg = new javax.swing.JPanel();
        NbPerso = new javax.swing.JLabel();
        NbPersoR = new javax.swing.JLabel();
        Jc = new javax.swing.JLabel();
        PanneauBouton = new javax.swing.JPanel();
        BDemarrer = new javax.swing.JButton();
        BRecommencer = new javax.swing.JButton();
        Panneau = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MParametres = new javax.swing.JMenu();
        MOptions = new javax.swing.JMenuItem();
        MAjoutJoueur = new javax.swing.JMenuItem();
        MVisualiser = new javax.swing.JMenu();
        MJoueur = new javax.swing.JMenuItem();
        MCartes = new javax.swing.JMenuItem();
        MTest = new javax.swing.JMenu();
        MTransfertTest = new javax.swing.JMenuItem();
        MBataille = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        PanDroite.setLayout(new java.awt.BorderLayout());

        PanneauEdition.setLayout(new java.awt.GridLayout(1, 0));

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        PanneauEdition.add(jScrollPane1);

        PanDroite.add(PanneauEdition, java.awt.BorderLayout.CENTER);

        PanneauMsg.setLayout(new java.awt.GridLayout(3, 1));
        PanneauMsg.add(NbPerso);
        PanneauMsg.add(NbPersoR);
        PanneauMsg.add(Jc);

        PanDroite.add(PanneauMsg, java.awt.BorderLayout.PAGE_START);

        PanneauBouton.setLayout(new java.awt.GridLayout(1, 2));

        BDemarrer.setText("Démarrer");
        BDemarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDemarrerActionPerformed(evt);
            }
        });
        PanneauBouton.add(BDemarrer);

        BRecommencer.setText("Recommencer");
        BRecommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRecommencerActionPerformed(evt);
            }
        });
        PanneauBouton.add(BRecommencer);

        PanDroite.add(PanneauBouton, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(PanDroite);

        javax.swing.GroupLayout PanneauLayout = new javax.swing.GroupLayout(Panneau);
        Panneau.setLayout(PanneauLayout);
        PanneauLayout.setHorizontalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        PanneauLayout.setVerticalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        getContentPane().add(Panneau);

        MParametres.setText("Paramètres");

        MOptions.setText("Options");
        MOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MOptionsActionPerformed(evt);
            }
        });
        MParametres.add(MOptions);

        MAjoutJoueur.setText("Ajout joueur");
        MAjoutJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAjoutJoueurActionPerformed(evt);
            }
        });
        MParametres.add(MAjoutJoueur);

        jMenuBar1.add(MParametres);

        MVisualiser.setText("Visualiser");

        MJoueur.setText("Joueurs");
        MJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MJoueurActionPerformed(evt);
            }
        });
        MVisualiser.add(MJoueur);

        MCartes.setText("Cartes");
        MCartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MCartesActionPerformed(evt);
            }
        });
        MVisualiser.add(MCartes);

        jMenuBar1.add(MVisualiser);

        MTest.setText("Test");

        MTransfertTest.setText("Transfert_Test");
        MTransfertTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MTransfertTestActionPerformed(evt);
            }
        });
        MTest.add(MTransfertTest);

        MBataille.setText("Bataille_Test");
        MBataille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBatailleActionPerformed(evt);
            }
        });
        MTest.add(MBataille);

        jMenuBar1.add(MTest);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MJoueurActionPerformed
        VisuJoueursDlg diag = new VisuJoueursDlg(this,true,this.joueurs);// creation d'une instance de VisuJoueursDlg
        diag.setVisible(true); //methode pour afficher la jdialog diag
    }//GEN-LAST:event_MJoueurActionPerformed

    private void MAjoutJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAjoutJoueurActionPerformed
        SaisieJoueurDlg diag = new SaisieJoueurDlg(this,true,this.persos);// creation d'une instance de SaisieJoueurDlg
        diag.setVisible(true);//methode pour afficher la jdialog diag
        if(diag.isOk())//verifie si diag est ouvert ou non 
        this.joueurs.ajouteJoueur(diag.getJ()); //quand diag se ferme ajoute le joueur crée dans la jdialog dans la liste joueurs
    }//GEN-LAST:event_MAjoutJoueurActionPerformed

    private void MOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MOptionsActionPerformed
        OptionDlg diag = new OptionDlg(this,true);// creation d'une instance de SaisieJoueurDlg
        diag.setVisible(true);
        if(diag.isOk() == true){
        LesJoueurs n = diag.getLesj();//recupere la liste de joueurs remplit dans la jdialog 
        int nv = diag.getNivCarte();//recupere le niveau de carte choisis dans diag
        this.persos = new LesPersonnages(nv);
        for(int i=0; i<n.getNbJoueurs();i++){
            this.joueurs.ajouteJoueur(n.getJoueur(i));//boucle for pour ajouter les joueurs dans la liste joueurs
        }  
        this.monjeu = new Jeu(persos,joueurs,nv); 
        }
    }//GEN-LAST:event_MOptionsActionPerformed

    private void MCartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MCartesActionPerformed
     Joueur j=new Joueur("FanMemory", "commun");//création d'un joueur j avec un pseudo (FanMemory) et une familles (communs)
        j.initPaquetTest();//appel de la méthode innitPaquetTest
        //appel du constructeur de la classe VisuPersonnagesDlg 
        VisuPersonnageDlg dl = new VisuPersonnageDlg(this, rootPaneCheckingEnabled, j);
        dl.setVisible(true);//affichage 
    }//GEN-LAST:event_MCartesActionPerformed

    private void MTransfertTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTransfertTestActionPerformed
        Joueur j1=new Joueur("commun", "FanMemory0");
        j1.initPaquetTest();
        Joueur j2=new Joueur("commun", "FanMemory1");
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
        j2.getPaquet().ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
        this.joueurs.ajouteJoueur(j1);
        this.joueurs.ajouteJoueur(j2);
        TransfertDlg diag = new TransfertDlg(this,true,joueurs,0 );
        diag.setVisible(true);
    }//GEN-LAST:event_MTransfertTestActionPerformed

    private void BDemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDemarrerActionPerformed
        // TODO add your handling code here:
        if(this.joueurs.getNbJoueurs()<2)//Si le nombre de joueurs est inférieur à 2 
            Edition.setText("choisir 2 joueur");//un message d’erreur est affiché dans la zone d’édition 
        else //sinon
        {
            BDemarrer.setEnabled(false);//Le bouton « Démarrer » est invalidé
            BRecommencer.setEnabled(true);//Le bouton « Recommencer » est validé
            //Les sous-options de menu « Options » et « Ajout Joueur » sont invalidés. 
            MOptions.setEnabled(false);
            MAjoutJoueur.setEnabled(false);
            // Les sous-options de menu « Joueurs » et « Cartes » de l’option « Visualisation » sont validés 
            MJoueur.setEnabled(true);
            MCartes.setEnabled(true);
            //Les messages indiquant le nombre de personnages trouvés et le nombre
            //de personnages restants de la fenêtre sont affichés avec les bonnes valeurs
            int mc= this.monjeu.getPlateau().getNbc();
            NbPerso.setText("NB de personnage trouvés "+mc);
            NbPersoR.setText("nombre de personnage restant "+this.monjeu.getPlateau().getNbp());
            //Le message indiquant le nom du joueur courant est également affiché .
            //Le panneau nommé « Panneau » des cartes est construit dynamiquement
            int l = this.monjeu.getPlateau().getNblig();
            int c = this.monjeu.getPlateau().getNbcol();
            Panneau.setLayout(new GridLayout(l,c));
            for(int i=0;i<2*mc;i++){
                JButton bt=new JButton();
                bt.setName(""+i);
                Panneau.add(bt);
                //ce panneu comporte des boutons et chaque bouton « bt » a une propriété  affectée au numéro du bouton, et est abonné à 
                //un écouteur de type « ActionListener » et exécute un gestionnaire identique.
               bt.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                        boutonActionPerformed(evt);
                    }
                });
                }
            
        }
    }//GEN-LAST:event_BDemarrerActionPerformed

    private void MBatailleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBatailleActionPerformed
        // ajout de cartes aux 2 premiers joueurs
    this.joueurs.getJoueur(0).initPaquetTest();
    this.joueurs.getJoueur(1).getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
    this.joueurs.getJoueur(1).getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
    // ouverture de la boîte de dialogue, avec le 1er joueur en joueur courant.
     BatailleDlg diag = new BatailleDlg(this, true, this.joueurs, 0);
    diag.setSize(1000,600);
    diag.setVisible(true);

    }//GEN-LAST:event_MBatailleActionPerformed

    private void BRecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRecommencerActionPerformed
      Edition.setText("");
      this.persos = null;
      this.joueurs = null;
      BDemarrer.setEnabled(true);
      l1=-1;
      l2=-1;
      c1=-1;
      c2=-1;
      Panneau.removeAll();
       MOptions.setEnabled(true);
       MAjoutJoueur.setEnabled(true);
       MJoueur.setEnabled(true);
       MCartes.setEnabled(true);
       NbPerso.setText("");
       NbPersoR.setText("");
       Jc.setText("");
    }//GEN-LAST:event_BRecommencerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JeuMemory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BDemarrer;
    private javax.swing.JButton BRecommencer;
    private javax.swing.JTextArea Edition;
    private javax.swing.JLabel Jc;
    private javax.swing.JMenuItem MAjoutJoueur;
    private javax.swing.JMenuItem MBataille;
    private javax.swing.JMenuItem MCartes;
    private javax.swing.JMenuItem MJoueur;
    private javax.swing.JMenuItem MOptions;
    private javax.swing.JMenu MParametres;
    private javax.swing.JMenu MTest;
    private javax.swing.JMenuItem MTransfertTest;
    private javax.swing.JMenu MVisualiser;
    private javax.swing.JLabel NbPerso;
    private javax.swing.JLabel NbPersoR;
    private javax.swing.JPanel PanDroite;
    private javax.swing.JPanel Panneau;
    private javax.swing.JPanel PanneauBouton;
    private javax.swing.JPanel PanneauEdition;
    private javax.swing.JPanel PanneauMsg;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
