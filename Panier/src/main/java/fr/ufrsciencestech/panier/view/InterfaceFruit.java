/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



/**
 *
 * @author betul
 */
public class InterfaceFruit extends javax.swing.JFrame {
    
    private DefaultListModel<String> listModel;
    private DefaultListModel<String> listFruit;
    private ActionListener boutonRechercheListener;
    private ActionListener boutonAjoutBoycottListener;
    private ActionListener boutonAjoutFruitListener;
    private ActionListener boutonSuppFruitListener;
    private ActionListener boutonModifPoidListener;
    private ActionListener boutonQuitterListener;
    private ActionListener boutonSuppFiltreListener;

    /**
     * Creates new form InterfaceFruit
     */
    public InterfaceFruit() {
        initComponents();
        setTitle("Gestion de Fruits");
        setSize(1100,600);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        jLabelModif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelModif.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));
        jLabelNomPanier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomPanier.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 17));
        jLabelBoycot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        ImageIcon IconRecherche = new ImageIcon("src/main/java/image/recherche.png");
        jButtonRecherche.setIcon(IconRecherche);
        
        ImageIcon IconPlus = new ImageIcon("src/main/java/image/plus.png");
        jButtonAjouter.setIcon(IconPlus);
        
        ImageIcon IconSuprBoycot = new ImageIcon("src/main/java/image/corbeil.png");
        jButtonSuprBoycot.setIcon(IconSuprBoycot);
        
        ImageIcon IconSupr = new ImageIcon("src/main/java/image/corbeil.png");
        jButtonSupp.setIcon(IconSupr);
        
        ImageIcon IconModif = new ImageIcon("src/main/java/image/modifier.png");
        //jButtonModif.setIcon(IconModif);
        //pour la liste des pays à boycotter
        listModel = new DefaultListModel<>();
        jListBoycot.setModel(listModel);
        listFruit = new DefaultListModel<>();
        jListFruit.setModel(listFruit);
        
        desactiverButtonSupp();
        desactiverButtonModif();
       
    }
    
    //desactiver le button supprimer
    public void desactiverButtonSupp(){
        jButtonSupp.setEnabled(false);
    }
    
    //desactiver le bouton modifier
    public void desactiverButtonModif(){
        jButtonModifierPoid.setEnabled(false);
    }
    
    
    //remplir la liste de fruit proposée au client lors du remplissage du panier
    public void remplirComboBox(String element){
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) jComboBoxFruit.getModel();
        
        comboBoxModel.addElement(element);
    }
    
    public void ecraserLF(){
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) jComboBoxFruit.getModel();
        
        comboBoxModel.removeAllElements();
    }
    
    //pour le filtrage des fruits
    public void buttonRechercherListener(ActionListener listener){
        this.boutonRechercheListener = listener;
    }
    
    public String getFilterText(){
        return jTextField1.getText();
    }
    
    public void reinitFiltre(){
        jTextField1.setText("");
    }
    
    //pour supprimer le filtre
    public void buttonSuppFiltreListener(ActionListener listener){
        this.boutonSuppFiltreListener = listener;
    }
    
    public String getFilter(){
        return jComboBox1.getSelectedItem().toString();
    }
    
    //pour boycotter
    public void buttonAjoutBoycottListener(ActionListener listener){
        this.boutonAjoutBoycottListener = listener;
    }
    
    public DefaultListModel<String> getListeBoycott(){
        return this.listModel;
    }
    
    
    //recevoir le nom du panier selectionner
    public void receivePanier(String panier){
        jLabelNomPanier.setText(panier);
    }
    
    //pour ajouter un fruit au panier
    public void buttonAjoutFruitListener(ActionListener listener) {
        this.boutonAjoutFruitListener = listener;
    }
    
    //recuperer l'id du fruit selectionner pour l'ajouter au panier
    public int recupererFruit(){
        String text = jComboBoxFruit.getSelectedItem().toString();
        String[] separer = text.split("-");
        String numberString = separer[0].trim();
        try {
            int number = Integer.parseInt(numberString);
            return number;
        } catch (NumberFormatException ex){
            System.out.println("erreur lors de la récuperation de l'id d'un fruit");
        }
        return 0;
    }
    
    //recuperer l'id di fruit selectionner pour le supprimer
    public int getIdFruit(){
        String text = jListFruit.getSelectedValue();
        String[] separer = text.split("-");
        String numberString = separer[0].trim();
        try {
            int number = Integer.parseInt(numberString);
            return number;
        } catch (NumberFormatException ex){
            System.out.println("erreur lors de la récuperation de l'id d'un fruit");
        }
        return 0;
    }
    
    //recuperer le nombre de kilo
    public double getPoid(){
        if(!Poids.getText().isEmpty())
            return Double.parseDouble(Poids.getText());
        else 
            return 1;
    }
    
    //reinitialiser le poid
    public void reinitPoid(){
        Poids.setText("");
    }
    
    //afficher la liste des fruits d'un panier
    public void remplirListFruit(String element){
        listFruit.addElement(element);
    }
    
    public void reinitListFruit(){
        listFruit.removeAllElements();
    }
    
    //pour le message retour qui verifie si le panier est plein
    public void receiveMessageRetour(String msg){
        messageRetour.setText(msg);
    }
    
    //pour supprimer un fruit d'un panier
    public void buttonSuppFruitListener(ActionListener listener) {
        this.boutonSuppFruitListener = listener;
    }

    //initialiser la liste des pays à boycotter
    public void reinitListBoycott(){
        listModel.removeAllElements();
    }
    
    public JFrame getMainFrame(){
        return this;
    }
    
    //recuperer le nouveau poid pour la modification
    public double getNewPoid(){
        if(!nvPoid.getText().isEmpty())
            return Double.parseDouble(nvPoid.getText());
        else 
            return 1;
    }
    
    public void reinitNPoid(){
        nvPoid.setText("");
    }
    
    //pour modifier le poid 
    public void buttonModifPoidListener(ActionListener listener){
        this.boutonModifPoidListener = listener;
    }
    
    //pour quitter
    public void buttonQuitterListener(ActionListener listener){
        this.boutonQuitterListener = listener;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitreModif = new javax.swing.JPanel();
        jLabelModif = new javax.swing.JLabel();
        jPanelGauche = new javax.swing.JPanel();
        jPanelLigneRecherche = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButtonRecherche = new javax.swing.JButton();
        jButtonSuppFiltre = new javax.swing.JButton();
        jPanelFiltre = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanelTextBoycot = new javax.swing.JPanel();
        jLabelBoycot = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelLigneAjoutBoycot = new javax.swing.JPanel();
        jButtonAjouter = new javax.swing.JButton();
        jTextFieldSaisie = new javax.swing.JTextField();
        jButtonSuprBoycot = new javax.swing.JButton();
        jPanelListePays = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListBoycot = new javax.swing.JList<>();
        jPanelDroite = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNomPanier = new javax.swing.JLabel();
        jPanelLigneAjoutFruit = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxFruit = new javax.swing.JComboBox<>();
        Poids = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonValiderAjout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        messageRetour = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanelValider = new javax.swing.JPanel();
        jButtonSupp = new javax.swing.JButton();
        jButtonModifierPoid = new javax.swing.JButton();
        nvPoid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelListePanier = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListFruit = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jButtonQuitterPanier = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelModif.setText("Modification");

        javax.swing.GroupLayout jPanelTitreModifLayout = new javax.swing.GroupLayout(jPanelTitreModif);
        jPanelTitreModif.setLayout(jPanelTitreModifLayout);
        jPanelTitreModifLayout.setHorizontalGroup(
            jPanelTitreModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelModif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelTitreModifLayout.setVerticalGroup(
            jPanelTitreModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelModif, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButtonRecherche.setToolTipText("");
        jButtonRecherche.setMaximumSize(new java.awt.Dimension(30, 30));
        jButtonRecherche.setMinimumSize(new java.awt.Dimension(30, 30));
        jButtonRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRechercheActionPerformed(evt);
            }
        });

        jButtonSuppFiltre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppFiltreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLigneRechercheLayout = new javax.swing.GroupLayout(jPanelLigneRecherche);
        jPanelLigneRecherche.setLayout(jPanelLigneRechercheLayout);
        jPanelLigneRechercheLayout.setHorizontalGroup(
            jPanelLigneRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLigneRechercheLayout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSuppFiltre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelLigneRechercheLayout.setVerticalGroup(
            jPanelLigneRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLigneRechercheLayout.createSequentialGroup()
                .addGroup(jPanelLigneRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLigneRechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonRecherche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelLigneRechercheLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButtonSuppFiltre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruit", "Origine", "" }));

        javax.swing.GroupLayout jPanelFiltreLayout = new javax.swing.GroupLayout(jPanelFiltre);
        jPanelFiltre.setLayout(jPanelFiltreLayout);
        jPanelFiltreLayout.setHorizontalGroup(
            jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelFiltreLayout.setVerticalGroup(
            jPanelFiltreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabelBoycot.setText("Pays Boycotter");

        javax.swing.GroupLayout jPanelTextBoycotLayout = new javax.swing.GroupLayout(jPanelTextBoycot);
        jPanelTextBoycot.setLayout(jPanelTextBoycotLayout);
        jPanelTextBoycotLayout.setHorizontalGroup(
            jPanelTextBoycotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelBoycot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelTextBoycotLayout.setVerticalGroup(
            jPanelTextBoycotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelBoycot, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jButtonAjouter.setMaximumSize(new java.awt.Dimension(30, 30));
        jButtonAjouter.setMinimumSize(new java.awt.Dimension(30, 30));
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jTextFieldSaisie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaisieActionPerformed(evt);
            }
        });

        jButtonSuprBoycot.setMaximumSize(new java.awt.Dimension(30, 30));
        jButtonSuprBoycot.setMinimumSize(new java.awt.Dimension(30, 30));
        jButtonSuprBoycot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuprBoycotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLigneAjoutBoycotLayout = new javax.swing.GroupLayout(jPanelLigneAjoutBoycot);
        jPanelLigneAjoutBoycot.setLayout(jPanelLigneAjoutBoycotLayout);
        jPanelLigneAjoutBoycotLayout.setHorizontalGroup(
            jPanelLigneAjoutBoycotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLigneAjoutBoycotLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldSaisie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSuprBoycot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelLigneAjoutBoycotLayout.setVerticalGroup(
            jPanelLigneAjoutBoycotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLigneAjoutBoycotLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelLigneAjoutBoycotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSuprBoycot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLigneAjoutBoycotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldSaisie, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jButtonAjouter, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))))
        );

        jListBoycot.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListBoycotValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListBoycot);

        javax.swing.GroupLayout jPanelListePaysLayout = new javax.swing.GroupLayout(jPanelListePays);
        jPanelListePays.setLayout(jPanelListePaysLayout);
        jPanelListePaysLayout.setHorizontalGroup(
            jPanelListePaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
        );
        jPanelListePaysLayout.setVerticalGroup(
            jPanelListePaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListePaysLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelLigneAjoutBoycot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelListePays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelLigneAjoutBoycot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelListePays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelGaucheLayout = new javax.swing.GroupLayout(jPanelGauche);
        jPanelGauche.setLayout(jPanelGaucheLayout);
        jPanelGaucheLayout.setHorizontalGroup(
            jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGaucheLayout.createSequentialGroup()
                .addGroup(jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelGaucheLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelLigneRecherche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelFiltre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelTextBoycot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGaucheLayout.setVerticalGroup(
            jPanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGaucheLayout.createSequentialGroup()
                .addComponent(jPanelLigneRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFiltre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanelTextBoycot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelNomPanier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNomPanier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelNomPanier, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setText("Ajouter un fruit :");

        Poids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoidsActionPerformed(evt);
            }
        });

        jLabel5.setText("Kg");

        jButtonValiderAjout.setText("Valider");
        jButtonValiderAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderAjoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLigneAjoutFruitLayout = new javax.swing.GroupLayout(jPanelLigneAjoutFruit);
        jPanelLigneAjoutFruit.setLayout(jPanelLigneAjoutFruitLayout);
        jPanelLigneAjoutFruitLayout.setHorizontalGroup(
            jPanelLigneAjoutFruitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLigneAjoutFruitLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFruit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Poids, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonValiderAjout))
        );
        jPanelLigneAjoutFruitLayout.setVerticalGroup(
            jPanelLigneAjoutFruitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLigneAjoutFruitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxFruit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Poids, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButtonValiderAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        messageRetour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(messageRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(messageRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButtonSupp.setText("Supprimer fruit");
        jButtonSupp.setMaximumSize(new java.awt.Dimension(30, 30));
        jButtonSupp.setMinimumSize(new java.awt.Dimension(30, 30));
        jButtonSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppActionPerformed(evt);
            }
        });

        jButtonModifierPoid.setText("Modifier poid");
        jButtonModifierPoid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierPoidActionPerformed(evt);
            }
        });

        nvPoid.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("sélectionner un fruit dans le panier pour modifier le poid: ");

        javax.swing.GroupLayout jPanelValiderLayout = new javax.swing.GroupLayout(jPanelValider);
        jPanelValider.setLayout(jPanelValiderLayout);
        jPanelValiderLayout.setHorizontalGroup(
            jPanelValiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelValiderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nvPoid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonModifierPoid, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelValiderLayout.setVerticalGroup(
            jPanelValiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelValiderLayout.createSequentialGroup()
                .addGroup(jPanelValiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModifierPoid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nvPoid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelValiderLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jListFruit.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListFruitValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListFruit);

        javax.swing.GroupLayout jPanelListePanierLayout = new javax.swing.GroupLayout(jPanelListePanier);
        jPanelListePanier.setLayout(jPanelListePanierLayout);
        jPanelListePanierLayout.setHorizontalGroup(
            jPanelListePanierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListePanierLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanelListePanierLayout.setVerticalGroup(
            jPanelListePanierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListePanierLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelListePanier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelValider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanelListePanier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelValider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanelDroiteLayout = new javax.swing.GroupLayout(jPanelDroite);
        jPanelDroite.setLayout(jPanelDroiteLayout);
        jPanelDroiteLayout.setHorizontalGroup(
            jPanelDroiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelDroiteLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 322, Short.MAX_VALUE))
            .addGroup(jPanelDroiteLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanelLigneAjoutFruit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelDroiteLayout.setVerticalGroup(
            jPanelDroiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDroiteLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLigneAjoutFruit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonQuitterPanier.setText("Quitter panier");
        jButtonQuitterPanier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterPanierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonQuitterPanier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonQuitterPanier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(61, 30));
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelGauche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelDroite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanelTitreModif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitreModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGauche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDroite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        String texteSaisi = jTextFieldSaisie.getText();  
        listModel.addElement(texteSaisi); 
        if(boutonAjoutBoycottListener != null){
            boutonAjoutBoycottListener.actionPerformed(evt);
        }
        jTextFieldSaisie.setText("");
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jTextFieldSaisieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaisieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaisieActionPerformed

    private void jButtonQuitterPanierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterPanierActionPerformed
        // TODO add your handling code here:
        if(boutonQuitterListener != null){
            boutonQuitterListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonQuitterPanierActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void PoidsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoidsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PoidsActionPerformed

    private void jButtonValiderAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderAjoutActionPerformed
        // TODO add your handling code here:
        jButtonSupp.setEnabled(false);
        if(boutonAjoutFruitListener != null){
            boutonAjoutFruitListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonValiderAjoutActionPerformed

    private void jButtonRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRechercheActionPerformed
        // TODO add your handling code here:
        if(boutonRechercheListener != null){
            boutonRechercheListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonRechercheActionPerformed

    private void jButtonSuprBoycotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuprBoycotActionPerformed

        // Obtenez l'index de l'élément sélectionné dans jList1
        int selectedIndex = jListBoycot.getSelectedIndex();

        // Assurez-vous qu'un élément est sélectionné (l'index n'est pas -1)
        if (selectedIndex != -1) {
            // Supprimez l'élément sélectionné du modèle de liste
            listModel.removeElementAt(selectedIndex);
        }
        if(boutonAjoutBoycottListener != null){
            boutonAjoutBoycottListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonSuprBoycotActionPerformed

    private void jListBoycotValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListBoycotValueChanged
        
    }//GEN-LAST:event_jListBoycotValueChanged

    private void jButtonSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppActionPerformed
        // TODO add your handling code here:
        if(boutonSuppFruitListener != null){
            boutonSuppFruitListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonSuppActionPerformed

    private void jListFruitValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListFruitValueChanged
        // TODO add your handling code here:
        jButtonSupp.setEnabled(true);
        jButtonModifierPoid.setEnabled(true);
    }//GEN-LAST:event_jListFruitValueChanged

    private void jButtonModifierPoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierPoidActionPerformed
        // TODO add your handling code here:
        if(boutonModifPoidListener != null){
            boutonModifPoidListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonModifierPoidActionPerformed

    private void jButtonSuppFiltreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppFiltreActionPerformed
        // TODO add your handling code here:
        if(boutonSuppFiltreListener != null){
            boutonSuppFiltreListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonSuppFiltreActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceFruit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceFruit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceFruit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceFruit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceFruit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Poids;
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonModifierPoid;
    private javax.swing.JButton jButtonQuitterPanier;
    private javax.swing.JButton jButtonRecherche;
    private javax.swing.JButton jButtonSupp;
    private javax.swing.JButton jButtonSuppFiltre;
    private javax.swing.JButton jButtonSuprBoycot;
    private javax.swing.JButton jButtonValiderAjout;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxFruit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelBoycot;
    private javax.swing.JLabel jLabelModif;
    private javax.swing.JLabel jLabelNomPanier;
    private javax.swing.JList<String> jListBoycot;
    private javax.swing.JList<String> jListFruit;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelDroite;
    private javax.swing.JPanel jPanelFiltre;
    private javax.swing.JPanel jPanelGauche;
    private javax.swing.JPanel jPanelLigneAjoutBoycot;
    private javax.swing.JPanel jPanelLigneAjoutFruit;
    private javax.swing.JPanel jPanelLigneRecherche;
    private javax.swing.JPanel jPanelListePanier;
    private javax.swing.JPanel jPanelListePays;
    private javax.swing.JPanel jPanelTextBoycot;
    private javax.swing.JPanel jPanelTitreModif;
    private javax.swing.JPanel jPanelValider;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldSaisie;
    private javax.swing.JLabel messageRetour;
    private javax.swing.JTextField nvPoid;
    // End of variables declaration//GEN-END:variables
}
