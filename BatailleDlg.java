
import java.util.HashSet;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author msi
 */
public class BatailleDlg extends javax.swing.JDialog {

    /**
     * Creates new form BatailleDlg
     */
    private LesJoueurs lj;//collection des joueurs (en entrée 
    private int indj;//indice du joueur courant (en entrée)
    private Joueur adversaire; //adversaire sélectionné (en sortie)
    private boolean ok;// action faite ou non (en sortie)
    private Bataille b;// action réalisée
    
    // constructeur avec parametre 
    public BatailleDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj,int jc) {
        super(parent, modal);//appel du constructeur de la classe super
        initComponents();//appel de la méthode initComponents() 
        //initialisation des attributs 
        this.lj=lj;
        this.indj=jc;
        this.ok=false;
        this.b=null;
        initListeJ();//appel de la méthode initListeJ(
        BAnnuler.setText("Annuler");//initialiser le texte sur le bouton à annuler 
        BAnnuler.setVisible(false);//aucune bataille existe
        Message.setText(lj.getJoueur(indj).getPseudo()+" va effectuer une bataille contre: ");
                //affichage du pseudo du joueur qui va joueur
    }
    
    public boolean isOk(){return ok;}
    public Joueur getAdversaire(){return adversaire;}
    public Bataille getBataille(){return b;}

    public void initListeJ(){
        DefaultListModel mod=new DefaultListModel();
        ListeJ.setModel(mod);
        for(int i=0;i<this.lj.getNbJoueurs();i++)
            mod.addElement(this.lj.getJoueur(i).getPseudo());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InfoCartesGauche = new javax.swing.JTextArea();
        Carte2 = new javax.swing.JButton();
        Carte1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        InfoCartesDroite = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListeJ = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        Adversaire = new javax.swing.JLabel();
        Joueur = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Vainqueur = new javax.swing.JLabel();
        BAnnuler = new javax.swing.JButton();
        BDemarrer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 4));

        InfoCartesGauche.setColumns(20);
        InfoCartesGauche.setRows(5);
        jScrollPane1.setViewportView(InfoCartesGauche);

        jPanel1.add(jScrollPane1);
        jPanel1.add(Carte2);
        jPanel1.add(Carte1);

        InfoCartesDroite.setColumns(20);
        InfoCartesDroite.setRows(5);
        jScrollPane2.setViewportView(InfoCartesDroite);

        jPanel1.add(jScrollPane2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        Message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Message.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(Message);

        ListeJ.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListeJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeJMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ListeJ);

        jPanel8.add(jScrollPane4);

        jPanel4.add(jPanel8);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));
        jPanel5.add(Adversaire);
        jPanel5.add(Joueur);

        jPanel2.add(jPanel5, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.GridLayout(1, 3));
        jPanel3.add(Vainqueur);

        BAnnuler.setText("Annuler / Fermer");
        BAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAnnulerActionPerformed(evt);
            }
        });
        jPanel3.add(BAnnuler);

        BDemarrer.setText("Démarrer");
        BDemarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDemarrerActionPerformed(evt);
            }
        });
        jPanel3.add(BDemarrer);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListeJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeJMouseClicked
        int ind = ListeJ.getSelectedIndex();//recuperation de l'elemnet selectionné 
        if(ind != -1) //si cet element existe
        {
            Joueur jo = this.lj.getJoueur(indj);
            if(ind == this.indj)//si l'element selectionné est le meme que indj
                Message.setText("Séléctionné un autre joueur");//affichage d'un message d'erreur 
            else{
                this.adversaire = this.lj.getJoueur(ind);
                this.b = new Bataille(jo,adversaire);
                BAnnuler.setVisible(true);
                Message.setText(jo.getPseudo());
                Joueur.setText(jo.getPseudo()); 
                Adversaire.setText(adversaire.getPseudo()); //fficher le pseudo de l'adversaire 
                InfoCartesDroite.append("paquet de "+jo.getPseudo()+"\n"+jo.getPaquet().toString());//remplissage de InfoCartesDroite
                InfoCartesGauche.append("paquet de "+adversaire.getPseudo()+"\n"+adversaire.getPaquet().toString());//remplissage de InfoCartesGauche
            }
        }
    }//GEN-LAST:event_ListeJMouseClicked

    private void BDemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDemarrerActionPerformed

        Joueur jo=this.lj.getJoueur(this.indj); 
      if(jo!=null && this.adversaire!=null)
          //affichage au 1er personnage de chauqe paquet
          InfoCartesDroite.append(jo.getPseudo()+" joue "+jo.getPaquet().getPerso(0));
          InfoCartesGauche.append(adversaire.getPseudo()+" joue "+adversaire.getPaquet().getPerso(0));
          int nes=this.b.execute();//on execute un tour de bataille retourn 0,1 ou 2
          //on teste le resultat 
          switch(nes){
              case 1: InfoCartesDroite.setText(jo.getPseudo()+"gagne"+"\n");
                      InfoCartesGauche.setText(adversaire.getPseudo()+"perd"+"\n");
                      Vainqueur.setText(jo.getPseudo());
                      break;
              case 2: InfoCartesDroite.setText(jo.getPseudo()+"perd"+"\n");
                      InfoCartesGauche.setText(adversaire.getPseudo()+"gagne"+"\n");
                      Vainqueur.setText(adversaire.getPseudo());
                      break;
              case 0:Vainqueur.setText("Aucun gagnant");
                     InfoCartesDroite.append(jo.getPaquet().toString());
                     InfoCartesGauche.append(this.adversaire.getPaquet().toString());
                    break;
          }
           LesPersonnages pjo=jo.getPaquet();
                   LesPersonnages pad=this.adversaire.getPaquet();
                   if(pjo.getTaille()==0 && pad.getTaille()>=0){
                       Vainqueur.setText(this.adversaire.getPseudo()+" a gagné");
                       BDemarrer.setEnabled(false);
                       BAnnuler.setText("Fermer");
                   }
                   else if(pjo.getTaille()>0 && pad.getTaille()==0){
                       Vainqueur.setText(jo.getPseudo()+" a gagné");
                       BDemarrer.setEnabled(false);
                       BAnnuler.setText("Fermer");
                   }
                   else{
                   Carte1.setIcon(new ImageIcon(pjo.getPerso(0).getPhoto()));
                   Carte2.setIcon(new ImageIcon(pad.getPerso(0).getPhoto()));                  
                   this.ok=true;
                   }
    }//GEN-LAST:event_BDemarrerActionPerformed

    private void BAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAnnulerActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_BAnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(BatailleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatailleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatailleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatailleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Adversaire;
    private javax.swing.JButton BAnnuler;
    private javax.swing.JButton BDemarrer;
    private javax.swing.JButton Carte1;
    private javax.swing.JButton Carte2;
    private javax.swing.JTextArea InfoCartesDroite;
    private javax.swing.JTextArea InfoCartesGauche;
    private javax.swing.JLabel Joueur;
    private javax.swing.JList<String> ListeJ;
    private javax.swing.JLabel Message;
    private javax.swing.JLabel Vainqueur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
