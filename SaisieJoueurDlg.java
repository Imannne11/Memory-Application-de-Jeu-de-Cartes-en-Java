
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class SaisieJoueurDlg extends javax.swing.JDialog {
    private Joueur j;//attribut de type joueur qui gere le joueur a creer
    private boolean ok;//aatribut de type boolean
    private ImageIcon photo;//attribut de type ImageIcon qui gere la photo du personnage
    private LesPersonnages lp;//attribut de type LesPersonnages

    //accesseur des attributs de la classe
    public Joueur getJ() {
        return this.j;
    }

    public boolean isOk() {
        return this.ok;
    }

    public ImageIcon getPhoto() {
        return this.photo;
    }
    
    /**
     * Creates new form SaisieJoueurDlg
     */
    public SaisieJoueurDlg(java.awt.Frame parent, boolean modal, LesPersonnages lesp) {
        super(parent, modal);// appel constructreur de la class ancetre 
        initComponents();//creation de l'interface pas l'EDI
        this.lp = lesp;//initialisation de l'attribut
        this.j = null;
        this.photo = null;
        this.ok = false;
        initListeFamilles();//methode qui remplit la JList avec les familles des personnages passé en paramètre 
    }
    
  private void initListeFamilles(){
        ArrayList lst = this.lp.getFamilles();//recupere les familles des personnages sans doublants
        DefaultListModel mod = new DefaultListModel();
        ListeFamille.setModel(mod);//affecte le modele a JList
        for(int i=0;i<lst.size();i++)
            mod.addElement(lst.get(i));//remplit la JList avec les familles du tableau lst
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PChoix = new javax.swing.JPanel();
        PPseudo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Pseudo = new javax.swing.JTextArea();
        PFamille = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListeFamille = new javax.swing.JList<>();
        PPhoto = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        BParcourir = new javax.swing.JButton();
        PAffich = new javax.swing.JPanel();
        BPhoto = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        BAnnuler = new javax.swing.JButton();
        BValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titre.setText("Créez votre joueur ! ");
        Titre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Titre, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        PChoix.setLayout(new java.awt.GridLayout(3, 1));

        PPseudo.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Donnez votre pseudo");
        PPseudo.add(jLabel2, java.awt.BorderLayout.NORTH);

        Pseudo.setColumns(20);
        Pseudo.setRows(5);
        jScrollPane1.setViewportView(Pseudo);

        PPseudo.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        PChoix.add(PPseudo);

        PFamille.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Quelle est votre famille préférée de personnages ?");
        PFamille.add(jLabel3, java.awt.BorderLayout.NORTH);

        ListeFamille.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(ListeFamille);

        PFamille.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        PChoix.add(PFamille);

        PPhoto.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Choisissez une photo :");
        PPhoto.add(jLabel4, java.awt.BorderLayout.NORTH);

        BParcourir.setText("Parcourir");
        BParcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BParcourirActionPerformed(evt);
            }
        });
        PPhoto.add(BParcourir, java.awt.BorderLayout.CENTER);

        PChoix.add(PPhoto);

        jPanel1.add(PChoix);

        PAffich.setLayout(new java.awt.BorderLayout());
        PAffich.add(BPhoto, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        BAnnuler.setText("Annuler");
        BAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAnnulerActionPerformed(evt);
            }
        });
        jPanel7.add(BAnnuler);

        BValider.setText("Valider");
        BValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BValiderActionPerformed(evt);
            }
        });
        jPanel7.add(BValider);

        PAffich.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jPanel1.add(PAffich);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BParcourirActionPerformed
    JFileChooser jf= new JFileChooser();// attribut de type FileChooser
    if (jf.showOpenDialog(this)== JFileChooser.APPROVE_OPTION){
        String path = jf.getSelectedFile().getPath();//recupere le chemin absolue
        Image img = Toolkit.getDefaultToolkit().getImage(path);//recupere la photo
        img=img.getScaledInstance(BPhoto.getWidth()-10, BPhoto.getHeight()-10, Image.SCALE_DEFAULT);//redimensionne la photo
        ImageIcon photo = new ImageIcon(img);//convertir l'image en ImageIcon et l'affecte a la variable photo
        this.photo = photo;//affecte la photo a l'attribut photo de la classe 
        BPhoto.setIcon(photo);//aafiche la photo dans le JPanel Photo
    }
    }//GEN-LAST:event_BParcourirActionPerformed

    private void BValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BValiderActionPerformed
        int ind = ListeFamille.getSelectedIndex();//recupere l'indice de l'element cliqué dans la JList
        if(Pseudo.getText() != null && ind != -1){// si une famille a été choisis dans la JList et pseudo ren,seigné 
            Joueur jp = new Joueur(lp.getPerso(ind).getFamille(),Pseudo.getText());//création d'un joueur avec pseudo et famille choisis 
            if(this.photo != null)  {    //si la photo n'est pas null                
                jp.setPhoto(photo);//change la photo du joueur 
            }
                this.ok = true;
                this.setVisible(false);//ferme la boite de dialogue
                this.j=jp;//affecte le joueur créé a l'attribut j de la classe
        }   
        else
            Pseudo.setText("pseudo vide ou familles préféré non choisis dans la liste");//sinon affiche ue message 
    }//GEN-LAST:event_BValiderActionPerformed

    private void BAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAnnulerActionPerformed
        this.ok = false;
        this.dispose();// ferme la boite de dialogue
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
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton BParcourir;
    private javax.swing.JButton BPhoto;
    private javax.swing.JButton BValider;
    private javax.swing.JList<String> ListeFamille;
    private javax.swing.JPanel PAffich;
    private javax.swing.JPanel PChoix;
    private javax.swing.JPanel PFamille;
    private javax.swing.JPanel PPhoto;
    private javax.swing.JPanel PPseudo;
    private javax.swing.JTextArea Pseudo;
    private javax.swing.JLabel Titre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}