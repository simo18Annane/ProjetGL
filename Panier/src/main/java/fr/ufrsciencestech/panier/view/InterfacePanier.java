/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author betul
 */
public class InterfacePanier extends javax.swing.JFrame {
    
    private DefaultListModel<String> listModel;
    private DefaultListModel<String> listFruit;
    private ActionListener boutonModifListener;

    public JButton getjButtonModifier() {
        return jButtonModifier;
    }

    private ActionListener boutonCreerFruitListener;
    private ActionListener boutonCreerPanierListener;
    private ListSelectionListener selectedListFruitListener;
    private ActionListener boutonSuppPanierListener;
    
    /**
     * Creates new form InterfacePanier
     */
    public InterfacePanier() {
        initComponents();
        setTitle("Gestion de Paniers");
        setSize(700,500);
        // Définissez la position de la nouvelle interface
        int x = 500; // Coordonnée X de la nouvelle fenêtre
        int y = 250; // Coordonnée Y de la nouvelle fenêtre
        setLocation(x, y);
        setVisible(true);
        
        this.setResizable(false);
        
        jLabelListePanier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListePanier.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));
        
        jLabelNomPanier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomPanier.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));

        ImageIcon imageIcon = new ImageIcon("Panier/src/main/java/fr/ufrsciencestech/panier/image/recherche.png");
        //pour remplir la liste des paniers
        listModel = new DefaultListModel<>();
        jListPanier.setModel(listModel);
        listFruit = new DefaultListModel<>();
        jlistFruit.setModel(listFruit);
        
        desactiverButton();

    }
    
    //desactiver les buttons supprimer et modifier
    public void desactiverButton(){
        jButtonModifier.setEnabled(false);
        jButtonSupprimer.setEnabled(false);
    }
    
    //remplir la liste des paniers 
    public void remplirListPanier(String element){
        listModel.addElement(element);
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public ArrayList<String> getElementFromListPanier(){
        ArrayList<String> listePanier =new ArrayList<String>();
        for (int i=0;i<listModel.getSize()/2;i++) {
            listePanier.add(listModel.getElementAt(i));
        }
        return listePanier;
    }
    
    public void ecraserLP(){
        listModel.removeAllElements();
    }


    //ouvrir l'interface qui contient les fruits en cliquant sur modifier
    public void buttonModifierListener(ActionListener listener){
        this.boutonModifListener = listener;
    }

    public ActionListener getBoutonModifListener() {
        return boutonModifListener;
    }

    public void setBoutonModifListener(ActionListener boutonModifListener) {
        this.boutonModifListener = boutonModifListener;
    }

    //ouvrir l'interface qui permet de creer un fruit
    public void buttonCreerFruitListener(ActionListener listener){
        this.boutonCreerFruitListener = listener;
    }

    public ActionListener getBoutonCreerPanierListener() {
        return boutonCreerPanierListener;
    }

    public ActionListener getBoutonCreerFruitListener() {
        return boutonCreerFruitListener;
    }

    //ouvrir l'interface qui permet de creer un panier
    public void buttonCreerPanierListener(ActionListener listener){
        this.boutonCreerPanierListener = listener;
    }

    //pour recuperer le panier selectionner
    public String getPanier(){
        return jListPanier.getSelectedValue();
    }

    public void setPanier(String Panier){
        jListPanier.setSelectedValue(Panier,false);
    }

    //liste des fruits de chaque panier
    public void remplirListFruit(String element){
        listFruit.addElement(element);
    }

    public ArrayList<String> getElementFromListFruit(){
        ArrayList<String> listeFruit=new ArrayList<String>();
        for (int i=0;i<listFruit.getSize();i++) {
            listeFruit.add(listFruit.getElementAt(i));
        }
        return listeFruit;
    }

    public void reinitListFruit(){
        listFruit.removeAllElements();
    }
    
    public void selectedFruitListener(ListSelectionListener listener){
        this.selectedListFruitListener = listener;
    }
    
    //recuperer le type de chaque panier
    public void receiveType(String type){
        jLabelAfficherType.setText(type);
    }
    
    //supprimer un panier
    public void buttonSuppPanierListener(ActionListener listener){
        this.boutonSuppPanierListener = listener;
    }

    public JLabel getjLabelAfficherType() {
        return jLabelAfficherType;
    }

    public JLabel getjLabelAfficheCout() {
        return jLabelAfficheCout;
    }

    //afficher le cout d'un panier
    public void afficherCout(String cout){
        jLabelAfficheCout.setText(cout);
    }
    
    public JFrame getMainFrame(){
        return this;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton4 = new javax.swing.JButton();
        jPanelGauche = new javax.swing.JPanel();
        jLabelListePanier = new javax.swing.JLabel();
        jPanelFiltre = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPanier = new javax.swing.JList<>();
        jPanelSupprimer = new javax.swing.JPanel();
        jButtonSupprimer = new javax.swing.JButton();
        jPanelDroite = new javax.swing.JPanel();
        jLabelNomPanier = new javax.swing.JLabel();
        jPanelContenuePanier = new javax.swing.JPanel();
        jLabelType = new javax.swing.JLabel();
        jLabelAfficherType = new javax.swing.JLabel();
        jLabelCout = new javax.swing.JLabel();
        jLabelAfficheCout = new javax.swing.JLabel();
        jLabelEspace = new javax.swing.JLabel();
        jLabelContenue = new javax.swing.JLabel();
        jScrollPaneListeFruit = new javax.swing.JScrollPane();
        jlistFruit = new javax.swing.JList<>();
        jButtonModifier = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuAjouter = new javax.swing.JMenu();
        jMenuItemCreerPanier = new javax.swing.JMenuItem();
        jMenuItemCreerFruit = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton4.setText("Supprimer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 333));

        jLabelListePanier.setText("Liste de paniers");

        jListPanier.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListPanierValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListPanier);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelFiltreLayout = new javax.swing.GroupLayout(jPanelFiltre);
        jPanelFiltre.setLayout(jPanelFiltreLayout);
        jPanelFiltreLayout.setHorizontalGroup(
            jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelFiltreLayout.setVerticalGroup(
            jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltreLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSupprimerLayout = new javax.swing.GroupLayout(jPanelSupprimer);
        jPanelSupprimer.setLayout(jPanelSupprimerLayout);
        jPanelSupprimerLayout.setHorizontalGroup(
            jPanelSupprimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonSupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelSupprimerLayout.setVerticalGroup(
            jPanelSupprimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanelGaucheLayout = new javax.swing.GroupLayout(jPanelGauche);
        jPanelGauche.setLayout(jPanelGaucheLayout);
        jPanelGaucheLayout.setHorizontalGroup(
            jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelListePanier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanelFiltre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelGaucheLayout.setVerticalGroup(
            jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGaucheLayout.createSequentialGroup()
                .addComponent(jLabelListePanier, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFiltre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelNomPanier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelType.setText("Type : ");

        jLabelCout.setText("Coût total:");

        jLabelEspace.setText("€");

        jLabelContenue.setText("Contenue du panier :");

        jScrollPaneListeFruit.setViewportView(jlistFruit);

        javax.swing.GroupLayout jPanelContenuePanierLayout = new javax.swing.GroupLayout(jPanelContenuePanier);
        jPanelContenuePanier.setLayout(jPanelContenuePanierLayout);
        jPanelContenuePanierLayout.setHorizontalGroup(
            jPanelContenuePanierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneListeFruit)
            .addGroup(jPanelContenuePanierLayout.createSequentialGroup()
                .addGroup(jPanelContenuePanierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelContenue, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(jPanelContenuePanierLayout.createSequentialGroup()
                        .addComponent(jLabelType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAfficherType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAfficheCout, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEspace, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        jPanelContenuePanierLayout.setVerticalGroup(
            jPanelContenuePanierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenuePanierLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelContenuePanierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAfficherType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAfficheCout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEspace))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelContenue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneListeFruit, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDroiteLayout = new javax.swing.GroupLayout(jPanelDroite);
        jPanelDroite.setLayout(jPanelDroiteLayout);
        jPanelDroiteLayout.setHorizontalGroup(
            jPanelDroiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNomPanier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelContenuePanier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelDroiteLayout.createSequentialGroup()
                .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDroiteLayout.setVerticalGroup(
            jPanelDroiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDroiteLayout.createSequentialGroup()
                .addComponent(jLabelNomPanier, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContenuePanier, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar.setPreferredSize(new java.awt.Dimension(61, 30));

        jMenuAjouter.setText("Ajouter");
        jMenuAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAjouterActionPerformed(evt);
            }
        });

        jMenuItemCreerPanier.setText("Créer un panier");
        jMenuItemCreerPanier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreerPanierActionPerformed(evt);
            }
        });
        jMenuAjouter.add(jMenuItemCreerPanier);

        jMenuItemCreerFruit.setText("Créer un fruit");
        jMenuItemCreerFruit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreerFruitActionPerformed(evt);
            }
        });
        jMenuAjouter.add(jMenuItemCreerFruit);

        jMenuBar.add(jMenuAjouter);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGauche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanelDroite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGauche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDroite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    public ActionListener getBoutonSuppPanierListener() {
        return boutonSuppPanierListener;
    }

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // TODO add your handling code here:
        if(boutonSuppPanierListener != null){
            boutonSuppPanierListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        if(boutonModifListener != null){
            boutonModifListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jMenuAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAjouterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuAjouterActionPerformed

    private void jMenuItemCreerPanierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCreerPanierActionPerformed
        if(boutonCreerPanierListener != null){
            boutonCreerPanierListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jMenuItemCreerPanierActionPerformed

    private void jMenuItemCreerFruitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCreerFruitActionPerformed
        if(boutonCreerFruitListener != null){
            boutonCreerFruitListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jMenuItemCreerFruitActionPerformed

    public JButton getjButtonSupprimer() {
        return jButtonSupprimer;
    }

    public JList<String> getjListPanier() {
        return jListPanier;
    }

    protected void jListPanierValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListPanierValueChanged
        // TODO add your handling code here:
        jLabelNomPanier.setText(jListPanier.getSelectedValue());
        jButtonModifier.setEnabled(true);
        jButtonSupprimer.setEnabled(true);
        if(selectedListFruitListener != null){
            selectedListFruitListener.valueChanged(evt);
        }
    }//GEN-LAST:event_jListPanierValueChanged

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
            java.util.logging.Logger.getLogger(InterfacePanier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacePanier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacePanier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacePanier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacePanier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelAfficheCout;
    private javax.swing.JLabel jLabelAfficherType;
    private javax.swing.JLabel jLabelContenue;
    private javax.swing.JLabel jLabelCout;
    private javax.swing.JLabel jLabelEspace;
    private javax.swing.JLabel jLabelListePanier;
    private javax.swing.JLabel jLabelNomPanier;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JList<String> jListPanier;
    private javax.swing.JMenu jMenuAjouter;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemCreerFruit;
    private javax.swing.JMenuItem jMenuItemCreerPanier;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContenuePanier;
    private javax.swing.JPanel jPanelDroite;
    private javax.swing.JPanel jPanelFiltre;
    private javax.swing.JPanel jPanelGauche;
    private javax.swing.JPanel jPanelSupprimer;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneListeFruit;
    private javax.swing.JList<String> jlistFruit;
    // End of variables declaration//GEN-END:variables
}
