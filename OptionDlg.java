
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author msi
 */
public class OptionDlg extends javax.swing.JDialog {
    private LesJoueurs lesj;//attribut de type LesJoueurs pour gerer les joueurs selectionnés
    private boolean ok;//attribut de type boolean
    private int nivCarte;// attribut de type int pour gerer l'entier choisis parmi les boutons radios
    /**
     * Creates new form OptionDlg
     */
    public OptionDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);//appel du constructeur de la classe ancetre 
        initComponents();//cr&ation de l'interface par l'EDI
        this.lesj = new LesJoueurs();//initialise l'attribut lesj
        this.ok=false;
        this.nivCarte=0;
    }

    //accesseur des attributs de la classe
    public LesJoueurs getLesj() {
        return this.lesj;
    }

    public boolean isOk() {
        return this.ok;
    }

    public int getNivCarte() {
        return this.nivCarte;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PCentre = new javax.swing.JPanel();
        PanneauNiv = new javax.swing.JPanel();
        jTaille = new javax.swing.JLabel();
        BEnfant = new javax.swing.JRadioButton();
        BDebutant = new javax.swing.JRadioButton();
        BAvance = new javax.swing.JRadioButton();
        BExpert = new javax.swing.JRadioButton();
        PanneauJoueurs = new javax.swing.JPanel();
        jJoueur = new javax.swing.JLabel();
        BLara = new javax.swing.JCheckBox();
        BJack = new javax.swing.JCheckBox();
        BJean = new javax.swing.JCheckBox();
        BMozart = new javax.swing.JCheckBox();
        PDroit = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        BPhoto = new javax.swing.JButton();
        PBas = new javax.swing.JPanel();
        BAnnuler = new javax.swing.JButton();
        BValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PCentre.setLayout(new java.awt.GridLayout(1, 0));

        PanneauNiv.setLayout(new java.awt.GridLayout(5, 1));

        jTaille.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTaille.setText("Choisissez la taille du jeu :");
        PanneauNiv.add(jTaille);

        buttonGroup1.add(BEnfant);
        BEnfant.setText("enfant (4 personnage, 2 familles)");
        BEnfant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnfantActionPerformed(evt);
            }
        });
        PanneauNiv.add(BEnfant);

        buttonGroup1.add(BDebutant);
        BDebutant.setText("débutant (10 personnages, 2 familles)");
        BDebutant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDebutantActionPerformed(evt);
            }
        });
        PanneauNiv.add(BDebutant);

        buttonGroup1.add(BAvance);
        BAvance.setText("avancé (18 personnage, 4 familles)");
        BAvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAvanceActionPerformed(evt);
            }
        });
        PanneauNiv.add(BAvance);

        buttonGroup1.add(BExpert);
        BExpert.setText("expert (32 personnages, 6 familles)");
        BExpert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExpertActionPerformed(evt);
            }
        });
        PanneauNiv.add(BExpert);

        PCentre.add(PanneauNiv);

        PanneauJoueurs.setLayout(new java.awt.GridLayout(5, 1));

        jJoueur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jJoueur.setText("Choisissez les joueurs crées par défaut :");
        PanneauJoueurs.add(jJoueur);

        BLara.setText("Lara");
        BLara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLaraActionPerformed(evt);
            }
        });
        PanneauJoueurs.add(BLara);

        BJack.setText("Jack");
        BJack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BJackActionPerformed(evt);
            }
        });
        PanneauJoueurs.add(BJack);

        BJean.setText("Jean-Sébastien");
        BJean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BJeanActionPerformed(evt);
            }
        });
        PanneauJoueurs.add(BJean);

        BMozart.setText("Mozart");
        BMozart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMozartActionPerformed(evt);
            }
        });
        PanneauJoueurs.add(BMozart);

        PCentre.add(PanneauJoueurs);

        PDroit.setLayout(new java.awt.GridLayout(2, 1));

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        PDroit.add(jScrollPane1);
        PDroit.add(BPhoto);

        PCentre.add(PDroit);

        getContentPane().add(PCentre, java.awt.BorderLayout.CENTER);

        PBas.setLayout(new java.awt.GridLayout(1, 0));

        BAnnuler.setText("Annuler");
        BAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAnnulerActionPerformed(evt);
            }
        });
        PBas.add(BAnnuler);

        BValider.setText("Valider");
        BValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BValiderActionPerformed(evt);
            }
        });
        PBas.add(BValider);

        getContentPane().add(PBas, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BEnfantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEnfantActionPerformed
       if(BEnfant.isSelected() == true)//si le bouton est coché
        this.nivCarte = 4;//affecte la valeur 4 a l'attribut nivCarte
    }//GEN-LAST:event_BEnfantActionPerformed

    private void BDebutantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDebutantActionPerformed
       if(BDebutant.isSelected() == true)
        this.nivCarte = 10;
    }//GEN-LAST:event_BDebutantActionPerformed

    private void BAvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAvanceActionPerformed
        if(BAvance.isSelected() == true)
        this.nivCarte = 18;
    }//GEN-LAST:event_BAvanceActionPerformed

    private void BExpertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExpertActionPerformed
       if(BExpert.isSelected() == true)
        this.nivCarte = 32;
    }//GEN-LAST:event_BExpertActionPerformed

    private void BLaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLaraActionPerformed
       Joueur j=new Joueur("épiques", "Lara");//creation du joueur 
       j.setPhoto(new ImageIcon(getClass().getResource("/img/lara.jpg")));//change sa photo
       Edition.setText(j.toString());//affiche ses informations dans la zone d'édition
       Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(), BPhoto.getHeight(), Image.SCALE_SMOOTH);
       BPhoto.setIcon(new ImageIcon(img));//affiche l'image sur le bouton
          if(BLara.isSelected() == true)//si le bouton est séléctionné on ajoute le joueur dans le tableau lesJ
            lesj.ajouteJoueur(j);
        else
            lesj.supprimeJoueur(j);//sinon on l'enleve 
    }//GEN-LAST:event_BLaraActionPerformed

    private void BJackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJackActionPerformed
        Joueur j=new Joueur("rares", "Jack");//creation du joueur
       j.setPhoto(new ImageIcon(getClass().getResource("/img/jack.png")));//change sa photo
       Edition.setText(j.toString());//affiche ses informations dans la zone d'édition
       Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(), BPhoto.getHeight(), Image.SCALE_SMOOTH);
       BPhoto.setIcon(new ImageIcon(img));//affiche l'image sur le bouton
          if(BJack.isSelected() == true)//si le bouton est séléctionné on ajoute le joueur dans le tableau lesJ
            lesj.ajouteJoueur(j);
        else
            lesj.supprimeJoueur(j);//sinon on l'enleve 
    }//GEN-LAST:event_BJackActionPerformed

    private void BJeanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJeanActionPerformed
      Joueur j=new Joueur("alpins femmesJ", "Jean Sébastien");//creation du joueur
       j.setPhoto(new ImageIcon(getClass().getResource("/img/bach.jpg")));//change sa photo
       Edition.setText(j.toString());//affiche ses informations dans la zone d'édition
       Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(), BPhoto.getHeight(), Image.SCALE_SMOOTH);
       BPhoto.setIcon(new ImageIcon(img));//affiche l'image sur le bouton
        if(BJean.isSelected() == true)//si le bouton est séléctionné on ajoute le joueur dans le tableau lesJ
            lesj.ajouteJoueur(j);
        else
            lesj.supprimeJoueur(j);//sinon on l'enleve 
    }//GEN-LAST:event_BJeanActionPerformed

    private void BMozartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMozartActionPerformed
       Joueur j=new Joueur("commun", "mozart");//creation du joueur
       j.setPhoto(new ImageIcon(getClass().getResource("/img/mozart.jpg")));//change sa photo
       Edition.setText(j.toString());//affiche ses informations dans la zone d'édition
       Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(), BPhoto.getHeight(), Image.SCALE_SMOOTH);
       BPhoto.setIcon(new ImageIcon(img));//affiche l'image sur le bouton
          if(BMozart.isSelected() == true)//si le bouton est séléctionné on ajoute le joueur dans le tableau lesJ
            lesj.ajouteJoueur(j);
          else
            lesj.supprimeJoueur(j);//sinon on l'enleve 
    }//GEN-LAST:event_BMozartActionPerformed

    private void BValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BValiderActionPerformed
        if(lesj.getNbJoueurs()>=2){// verifie si le nombre de joueurs choisis est supérieur a 2
        this.ok = true;//affecte la valeur true a l'attribut ok
        this.setVisible(false);//ferme la boite de dialogue
        }
    }//GEN-LAST:event_BValiderActionPerformed

    private void BAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAnnulerActionPerformed
      this.ok = false;
      this.dispose();//ferme la boite dialogue
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
            java.util.logging.Logger.getLogger(OptionDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAnnuler;
    private javax.swing.JRadioButton BAvance;
    private javax.swing.JRadioButton BDebutant;
    private javax.swing.JRadioButton BEnfant;
    private javax.swing.JRadioButton BExpert;
    private javax.swing.JCheckBox BJack;
    private javax.swing.JCheckBox BJean;
    private javax.swing.JCheckBox BLara;
    private javax.swing.JCheckBox BMozart;
    private javax.swing.JButton BPhoto;
    private javax.swing.JButton BValider;
    private javax.swing.JTextArea Edition;
    private javax.swing.JPanel PBas;
    private javax.swing.JPanel PCentre;
    private javax.swing.JPanel PDroit;
    private javax.swing.JPanel PanneauJoueurs;
    private javax.swing.JPanel PanneauNiv;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jJoueur;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTaille;
    // End of variables declaration//GEN-END:variables
}