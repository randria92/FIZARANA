package librairie2;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javafx.application.Platform.exit;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import packageClient.Client;
import packageClient.Detail_client;

public final class FrameClient extends javax.swing.JFrame {

    private ResultSet rs;

    public FrameClient() {
        initComponents();
        montrer_client();
        setTitle("BACK-OFFICE LIBRAIRIE RANDRIA JEFF");
    }

    public ArrayList<Client> clientList() {
        ArrayList<Client> clientsList = new ArrayList();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Librairie;"
                    + "user=sa;password=sa";
            Connection con = DriverManager.getConnection(url);
            String req = "select idClient,civiliteClient,nomClient,prenomClient from client";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            Client ct1;
            //--stockage
            while (rs.next()) {
                ct1 = new Client(rs.getInt(ICONIFIED), rs.getString("civiliteClient"), rs.getString("nomClient"),
                        rs.getString("prenomClient"));
                clientsList.add(ct1);
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return clientsList;
    }

    public void rafraichir_table() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Librairie;"
                    + "user=sa;password=sa";
            Connection con = DriverManager.getConnection(url);
            int row = maTable.getSelectedRow();
            String value = (maTable.getModel().getValueAt(row, 0).toString());
            String req = "select *  from client";
            PreparedStatement pst = con.prepareStatement(req);
            //----
            ResultSet rs = pst.executeQuery();
            int dataModel = rs.getRow();
            //DefaultTableModel model = (DefaultTableModel) maTable.getModel();
            //DefaultTableModel model = maTable.setModel(dataModel);

        } catch (Exception e) {
        }
    }

    public void montrer_client() {
        ArrayList<Client> list = clientList();
        //----ici on a reinitialisé le tableau.
        maTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "idClient", "civiliteClient", "NOM CLIENT", "PRENOM CLIENT"
                }
        ));

        DefaultTableModel model = (DefaultTableModel) maTable.getModel();
        Object[] row = new Object[4];
        row.toString();

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getIdClient();
            row[1] = list.get(i).getCivilite();
            row[2] = list.get(i).getNom();
            row[3] = list.get(i).getPrenom();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        MODIFIER_CLIENT = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        panel1 = new java.awt.Panel();
        name = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Bouton_Ajout = new javax.swing.JButton();
        list1 = new java.awt.List();
        list3 = new java.awt.List();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        maTable = new javax.swing.JTable();
        jTabbedPane11 = new javax.swing.JTabbedPane();
        pane = new java.awt.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jT_recherche = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        panel3 = new java.awt.Panel();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        panel2 = new java.awt.Panel();
        iMessage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jT_prenom = new javax.swing.JTextField();
        jT_civilite = new javax.swing.JTextField();
        jT_nom = new javax.swing.JTextField();
        jT_idClient = new javax.swing.JTextField();
        jB_supprimer = new javax.swing.JButton();
        jB_rafraihir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librairie2/titre.png"))); // NOI18N
        jLabel1.setText("BACK OFFICE - LIBRAIRIE EN LIGNE");

        MODIFIER_CLIENT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librairie2/edit-file-icon.png"))); // NOI18N
        MODIFIER_CLIENT.setText("Modifier");
        MODIFIER_CLIENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFIER_CLIENTActionPerformed(evt);
            }
        });

        jButton4.setText("Afficher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BACK OFFICE MANAGER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });
        jTabbedPane1.addTab("Ouvrage", jTabbedPane2);
        jTabbedPane1.addTab("Commande", jTabbedPane4);
        jTabbedPane1.addTab("Evenement", jTabbedPane5);
        jTabbedPane1.addTab("Avis", jTabbedPane6);

        jTabbedPane7.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jLabel3.setText("civilite");

        jLabel4.setText("nomClient");

        jLabel5.setText("prenomClient");

        Bouton_Ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librairie2/edit-file-icon.png"))); // NOI18N
        Bouton_Ajout.setText("AJOUTER");
        Bouton_Ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_AjoutActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Madame", "Monsieur" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librairie2/livre copie.png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(8, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(Bouton_Ajout))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25)))
                        .addComponent(Bouton_Ajout)
                        .addGap(26, 26, 26))))
        );

        jTabbedPane7.addTab("Veuillez ajouter un client", panel1);

        jTabbedPane3.addTab("Ajout client", jTabbedPane7);

        maTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idClient", "civiliteClient", "NOM CLIENT", "PRENOM CLIENT"
            }
        ));
        maTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(maTable);

        jTabbedPane3.addTab("Liste client", jScrollPane1);

        jTabbedPane11.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idClient", "civiliteClient", "nomClient", "prenomClient"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jT_recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_rechercheActionPerformed(evt);
            }
        });
        jT_recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_rechercheKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jT_rechercheKeyReleased(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librairie2/search.png"))); // NOI18N

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paneLayout = new javax.swing.GroupLayout(pane);
        pane.setLayout(paneLayout);
        paneLayout.setHorizontalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneLayout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneLayout.createSequentialGroup()
                        .addComponent(jT_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        paneLayout.setVerticalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(paneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane11.addTab("Veuillez saisir le nom du client", pane);

        jTabbedPane3.addTab("Recherche client", jTabbedPane11);

        jTabbedPane1.addTab("Client", jTabbedPane3);

        jTabbedPane9.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("AJOUT ADRESSE CLIENT EXISTANT", panel3);

        jTabbedPane8.addTab("Ajouter  Adresse", jTabbedPane9);
        jTabbedPane9.getAccessibleContext().setAccessibleName("");

        jTabbedPane10.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        jTabbedPane10.addTab("LISTE ADRESSES POUR UN CLIENT", panel2);

        jTabbedPane8.addTab("Lister Adresse", jTabbedPane10);

        jTabbedPane1.addTab("Adresse", jTabbedPane8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        iMessage.setBackground(new java.awt.Color(204, 204, 204));
        iMessage.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        iMessage.setForeground(new java.awt.Color(255, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MODIF MANAGER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jT_idClient, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jT_civilite, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jT_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jT_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_civilite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_idClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jB_supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librairie2/Button-Close-icon.png"))); // NOI18N
        jB_supprimer.setText("Supprimer");
        jB_supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_supprimerActionPerformed(evt);
            }
        });

        jB_rafraihir.setText("Rafraichir");
        jB_rafraihir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_rafraihirActionPerformed(evt);
            }
        });

        jButton1.setText("Statistique client");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MODIFIER_CLIENT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB_supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB_rafraihir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(iMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(307, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jB_rafraihir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jB_supprimer)
                        .addGap(18, 18, 18)
                        .addComponent(MODIFIER_CLIENT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //---eto mbola tsy misy ilana azy mbola vide 
        //--fafana rehefa fa ajanona aloha sao mety hisy lahasa omena later
        close();
        Detail_client dc = new Detail_client();
        dc.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void MODIFIER_CLIENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFIER_CLIENTActionPerformed
        //-----------------------eto no manova
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Librairie;"
                    + "user=sa;password=sa";
            Connection con = DriverManager.getConnection(url);

            DefaultTableModel model = (DefaultTableModel) maTable.getModel();

            //--- ici on va transmettre un message comme quoi le tableau est vide
            if (maTable.getSelectedRow() == -1) {
                if (maTable.getRowCount() == 0) {
                    iMessage.setText("Votre liste client est vide");
                } else {
                    iMessage.setText("Veuillez selectionner un client");
                }
            } else {
                //montrer_client();
                System.out.println("je rajoute ici en fait");
                //--novaina faharoa
                String idClient = jT_idClient.getText().toString();
                String civilite = jT_civilite.getText().toString();
                String Fname = jT_nom.getText().toString();
                String Fprenom = jT_prenom.getText().toString();

                int row = maTable.getSelectedRow();
                String value = (maTable.getModel().getValueAt(row, 0).toString());
                System.out.println(" identifiant est unique value est" + value);

                String req = "UPDATE  client SET civiliteClient='" + civilite + " ', nomClient='" + Fname + "',"
                        + "prenomClient='" + Fprenom + "',telephoneClient='0101010101',"
                        + "emailClient='Dupon@onconnaipas', motDePasseClient='duponmdp',"
                        + "dateAdhesionClient='2018-01-01' where idClient =" + value;

                PreparedStatement pst = con.prepareStatement(req);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Modification reussie");
                //---je montre le contenu de jTable mais aussi j'ai besoin de rafraîchir.

                //DefaultTableModel model =new  (DefaultTableModel) maTable.removeKeyListener(l);
                montrer_client();
                pst.close();
                con.close();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_MODIFIER_CLIENTActionPerformed

    private void maTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maTableMouseClicked

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Librairie;"
                    + "user=sa;password=sa";
            Connection con = DriverManager.getConnection(url);
            int row = maTable.getSelectedRow();
            //String Table_click = maTable.getModel().getValueAt(row, ICONIFIED).toString();
            String Table_click = maTable.getModel().getValueAt(row, 0).toString();
            String sql = "select idClient,civiliteClient,nomClient,prenomClient from client where idClient=" + Table_click;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("idClient");
                jT_idClient.setText(add1);
                String add2 = rs.getString("civiliteClient");
                jT_civilite.setText(add2);
                String add3 = rs.getString("nomClient");
                jT_nom.setText(add3);
                String add4 = rs.getString("prenomClient");
                jT_prenom.setText(add4);
            }
            
            pst.close();
            con.close();
        } catch (Exception e) {
        }
        //        DefaultTableModel model = (DefaultTableModel) maTable.getModel();
        //        jT_idClient.setText((String) model.getValueAt(maTable.getSelectedRow(), 0));
        //        jT_civilite.setText((String) model.getValueAt(maTable.getSelectedRow(), 1));
        //        jT_nom.setText((String) model.getValueAt(maTable.getSelectedRow(), 2));
        //        jT_prenom.setText((String) model.getValueAt(maTable.getSelectedRow(), 3));
        //
    }//GEN-LAST:event_maTableMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void Bouton_AjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_AjoutActionPerformed

        String civilite = jComboBox1.getSelectedItem().toString();
        String Fname = name.getText();
        String Fprenom = prenom.getText();
        System.out.println("le rezu est civilite " + civilite + " nom " + Fname + ", prenom " + Fprenom + " ");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Librairie;"
                    + "user=sa;password=sa";
            Connection con = DriverManager.getConnection(url);
            String req = "INSERT INTO client\n"
                    + "(civiliteClient, nomClient, prenomClient,telephoneClient,\n"
                    + " emailClient, motDePasseClient, dateAdhesionClient)\n"
                    + "VALUES\n"
                    + "(' " + civilite + "',' " + Fname + "',' " + Fprenom + "','0101010101',\n"
                    + "'Dupon@onconnaipas','duponmdp','2018-01-01')";
            PreparedStatement pst = con.prepareStatement(req);
            pst.executeUpdate();
            Icon icon = null;
            //pst.executeQuery(req);
            //pst.execute();
            //montrer_client();
            JOptionPane.showMessageDialog(null, "Ajout reussi");
 
            montrer_client();
            pst.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ajout NON reussi");
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_Bouton_AjoutActionPerformed

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void jT_rechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_rechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_rechercheActionPerformed

    private void jB_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_supprimerActionPerformed
        //------------------------eto no mamono
        if (maTable.getSelectedRow() == -1) {
            if (maTable.getRowCount() == 0) {
                iMessage.setText("Votre liste client est vide");
            } else {
                iMessage.setText("Veuillez selectionner un client");
            }
        } else {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=Librairie;"
                        + "user=sa;password=sa";
                Connection con = DriverManager.getConnection(url);
                int row = maTable.getSelectedRow();
                String value = (maTable.getModel().getValueAt(row, 0).toString());
                String req = "DELETE from client where idClient =" + value;
                PreparedStatement pst = con.prepareStatement(req);

                int result = JOptionPane.showConfirmDialog(null, "Attention DANGER voulez-vous vraiment supprimer", "avertissement",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.ERROR_MESSAGE
                );
                if (result == JOptionPane.YES_OPTION) {
                    System.out.println("YES");
                    //--execution de la requête est ici
                    pst.executeUpdate();
                    DefaultTableModel model = (DefaultTableModel) maTable.getModel();
                    model.setRowCount(0);
                    JOptionPane.showMessageDialog(null, "Suppression reussie");
                    montrer_client();
                    pst.close();
                    con.close();
                }

                //--ici le dba decide de ne rien faire.
                if (result == JOptionPane.NO_OPTION) {
                    System.out.println("NO");
                    exit();
                }

            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jB_supprimerActionPerformed

    private void jB_rafraihirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_rafraihirActionPerformed
        jT_idClient.setText("");
        jT_civilite.setText("");
        jT_nom.setText("");
        jT_prenom.setText("");
    }//GEN-LAST:event_jB_rafraihirActionPerformed

    private void jT_rechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_rechercheKeyReleased
        try {
            String name = jT_recherche.getText().toString();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Librairie;"
                    + "user=sa;password=sa";
            Connection con = DriverManager.getConnection(url);
            System.out.println("la valeur obtenue ici est" + name);
            String req = "select * from client where nomClient ="+name;
            PreparedStatement pst = con.prepareStatement(req);
            pst.setString(1, jT_recherche.getText());
             rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("idClient"); 
                jT_idClient.setText(add1);
                String add2 = rs.getString("civiliteClient");
                jT_civilite.setText(add2);
                String add3 = rs.getString("nomClient");
                jT_nom.setText(add3);
                String add4 = rs.getString("prenomClient");
                jT_prenom.setText(add4);
            }
            pst.close();
            con.close();
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jT_rechercheKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               //---eto mbola tsy misy ilana azy mbola vide 
        //--fafana rehefa fa ajanona aloha sao mety hisy lahasa omena later
        close();
        //Detail_client dc = new Detail_client();
        Taux_participation tp = new Taux_participation();
        tp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jT_rechercheKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_rechercheKeyPressed
        //------------------eto 759 no miasa--------------------------
        try {
            String name = jT_recherche.getText().toString();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Librairie;"
                    + "user=sa;password=sa";
            Connection con = DriverManager.getConnection(url);
            System.out.println("la valeur obtenue ici est" + name);
            String req = "select * from client where nomClient =?";
            PreparedStatement pst = con.prepareStatement(req);
            pst.setString(1, jT_recherche.getText());
             rs = pst.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("idClient"); 
                 jT_idClient.setText(add1);
                String add2 = rs.getString("civiliteClient");
                jT_civilite.setText(add2);
                String add3 = rs.getString("nomClient");
                jT_nom.setText(add3);
                String add4 = rs.getString("prenomClient");
                jT_prenom.setText(add4);
            }
            
            pst.close();
            con.close();
            
        } catch (Exception e) {
        }
        
        
    }//GEN-LAST:event_jT_rechercheKeyPressed

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
            java.util.logging.Logger.getLogger(FrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bouton_Ajout;
    private javax.swing.JButton MODIFIER_CLIENT;
    private javax.swing.JLabel iMessage;
    private javax.swing.JButton jB_rafraihir;
    private javax.swing.JButton jB_supprimer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jT_civilite;
    private javax.swing.JTextField jT_idClient;
    private javax.swing.JTextField jT_nom;
    private javax.swing.JTextField jT_prenom;
    private javax.swing.JTextField jT_recherche;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane11;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JTable jTable1;
    private java.awt.List list1;
    private java.awt.List list3;
    private javax.swing.JTable maTable;
    private javax.swing.JTextField name;
    private java.awt.Panel pane;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private javax.swing.JTextField prenom;
    // End of variables declaration//GEN-END:variables
    //this.WindowEvent.WINDOW_CLOSING
    private void close() {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }


}
