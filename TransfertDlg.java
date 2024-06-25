
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author msi
 */
public class TransfertDlg extends javax.swing.JDialog {
     private LesJoueurs lj; //collection des joueurs
     private int indj; //indice joueur courant
     private Transfert tc;
     private boolean ok;
     private int indjs; //indice du joueur sélectionné
     private String fs; //famille de la carte sélectionnée;
     
     //méthode qui renvoie la valeur de l'attribut ok
     public boolean isOk() { return ok; }
     //getter de l'attribut tc
     public Transfert getTransfert(){ return this.tc;}

    /**
     * Creates new form TransfertDlg
     */
     //constructeur avec parametre 
    public TransfertDlg(java.awt.Frame parent, boolean modal,LesJoueurs lj, int indj) {
        super(parent, modal);//appel du constructeur de la super classe 
        initComponents();//appel de la methode initComponents()
        //initialisation des attributs 
        this.lj = lj;
        this.indj = indj;
        this.tc=null;
        this.ok=false;
        this.fs=null;
        initCombo();//appel de la methode initCombo()
        indjs = 0;
        jLabel1.setText("Le joueur "+lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète");
//initialisation du texte sur le jLabel1
        Infos.setText("Personnages de "+lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet());
//initialisation du texte sur le jLabel nommé infos

    }
    
    public void initCombo(){
        for(int i=0;i<lj.getNbJoueurs();i++)
            jComboBox1.addItem(lj.getJoueur(i).getPseudo());
//ajout du pseudo du joueur d'indice i de la collection lj de joueurs à la jComboBox1
    }
    
    public void initPanneau(){
        PanneauGauche.removeAll();//vider le PanneauGauche
        this.repaint();//appel de la méthode repaint()
        LesPersonnages lcs = lj.getJoueur(indjs).getPaquet();
        int t = lcs.getTaille();//recuperation de la taille de lcs dans la variable t de type int 
        int n = 1+(t-1)/4;
        PanneauGauche.setLayout(new java.awt.GridLayout(4,n));
        for(int i=0;i<t;i++){
            JButton jb = new JButton();
            jb.setName(lcs.getPerso(i).getFamille());
            jb.addActionListener(new java.awt.event.ActionListener() { 
//on abonne le bouton a un ecouteur d'evenement
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            boutonActionPerformed(evt);
        }
         }); 
            PanneauGauche.add(jb);//ajoute le bouton au JPanel
            }
            this.pack();
                        }
    public void creePanneau(JPanel p,LesPersonnages lp){
        p.removeAll();
        p.repaint();
        int t = lp.getTaille();
        p.setLayout(new GridLayout(4,1+(t-1)/4));
        for(int i =0; i< t;i++){
            JButton jb = new JButton();
            p.add(jb);
        }
    }
    
    public void dessinePanneau(JPanel pan, LesPersonnages lp){
        int t = lp.getTaille();
        for(int i =0;i<t;i++){
            JButton jb = (JButton) pan.getComponent(i);
            jb.addActionListener(new java.awt.event.ActionListener() {
                //on abonne le bouton a un ecouteur d'evenement
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            boutonActionPerformed(evt);
         }
        }); 
            jb.setIcon(new ImageIcon(lp.getPerso(i).getPhoto()));
        }
                    
    }
    
    public void affichePanneau(){
        LesPersonnages lp = lj.getJoueur(indjs).getPaquet();//creation de lp
        for(int i = 0;i<lp.getTaille();i++)//parcours de la boucle
        {
            JButton jb = (JButton) PanneauGauche.getComponent(i);//recuperation du comonent d'indice i du Panneau dans jb
            Image img = lp.getPerso(i).getPhoto().getScaledInstance(jb.getWidth(),jb.getHeight(),Image.SCALE_DEFAULT);
            jb.setIcon(new ImageIcon(img));//modifier l'icone du bouton jb
        }
    }
    private void boutonActionPerformed(ActionEvent evt)
 {
    LesPersonnages lp = lj.getJoueur(indjs).getPaquet();//creation de l'instance lp
    int t = lp.getTaille();//recuperation de la taille de lp dans la variable t
    JButton bt=(JButton) evt.getSource();
    fs = bt.getName(); // la proprité Name, contient ici le nom du personnage affiché sur le bouton
     for(int i = 0; i < t; i++)
     //parcours de la boucle 
     {
        JButton b = (JButton)(PanneauGauche.getComponent(i));//creation de b
        if (
             b.getName().equals(fs))//si le nom de b est le meme de celui de fs
             b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0)));
        else
             b.setBorder(null);//enlever le border de b
        }
        LesPersonnages lps = lp.getPersosFamille(fs);//appel de la méthode getPersosFamille()
        Infos.setText("Vous pouvez récupérer "+lps.getTaille()+" personnages : \n"+lps.toString());
                    //remplissage du texte sue le jLabel nommé infos 
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
        PHaut = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Infos = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        PBas = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        Transfert = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        PanneauGauche = new javax.swing.JPanel();
        PanneauDroit = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        PHaut.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.GridLayout(4, 1));
        jPanel7.add(jLabel1);
        jPanel7.add(jLabel2);
        jPanel7.add(Infos);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel7.add(jComboBox1);

        PHaut.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(PHaut);

        PBas.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.GridLayout(2, 1));
        PBas.add(jPanel8, java.awt.BorderLayout.WEST);

        jPanel10.setLayout(new java.awt.BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel10.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        Transfert.setText("Transfert");
        Transfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransfertActionPerformed(evt);
            }
        });
        jPanel11.add(Transfert);

        jButton2.setText("Fermer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton2);

        jPanel10.add(jPanel11, java.awt.BorderLayout.SOUTH);

        PBas.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel1.add(PBas);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        PanneauGauche.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(PanneauGauche, java.awt.BorderLayout.WEST);

        PanneauDroit.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(PanneauDroit, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
     this.indjs = jComboBox1.getSelectedIndex();//recuperation d l'element selectionné
 if (indjs != -1)//si un element est séléctionné
 {
    if (this.indjs == this.indj)//si cet element est le indj
    {
        Infos.setText("Sélectionnez un joueur différent du joueur courant !");//affichage d'un message d'erreur
        PanneauGauche.removeAll();//vider lePanneauGauche
        PanneauGauche.repaint();//appel de la methode repint()
 }
 else//sinon
    {
        Infos.setText("\nJoueur sélectionné: "+lj.getJoueur(indjs).toString());//appel de la méthode toString()
        initPanneau();
        affichePanneau();
 }
 }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void TransfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransfertActionPerformed
        // TODO add your handling code here:
        int ind = jComboBox1.getSelectedIndex();//recuperation de l'elemnt selectionné
        if(ind != 1 && fs != null)//si ind et fs existent
        {
          Joueur j = this.lj.getJoueur(indj);//appel de la methode getJoueur 
          Joueur cible = this.lj.getJoueur(ind);
          tc = new Transfert(j,cible,fs);
          int res = tc.execute();//appel de la méthode exectute 
          if(res >0){
              LesPersonnages lp = tc.getCartesTransferees();
              creePanneau(PanneauDroit,lp);//creation du panneau
              dessinePanneau(PanneauDroit,lp);
              LesPersonnages pjs = cible.getPaquet();
              creePanneau(PanneauGauche,pjs);
              dessinePanneau(PanneauGauche,pjs);
              this.ok = true;
              Transfert.setEnabled(false);
          }
      }
      else
          Infos.setText("Sélectionné un joueur qui a au moins une carte");//affichage d'un message
    }//GEN-LAST:event_TransfertActionPerformed

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
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Infos;
    private javax.swing.JPanel PBas;
    private javax.swing.JPanel PHaut;
    private javax.swing.JPanel PanneauDroit;
    private javax.swing.JPanel PanneauGauche;
    private javax.swing.JButton Transfert;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
