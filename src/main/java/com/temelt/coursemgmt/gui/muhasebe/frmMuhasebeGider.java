/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temelt.coursemgmt.gui.muhasebe;

import com.temelt.coursemgmt.model.muhasebe.Gider;
import com.temelt.coursemgmt.service.muhasebe.GiderService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Master
 */
public class frmMuhasebeGider extends javax.swing.JDialog {
  JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem menuItemAdd = new JMenuItem("Fatura Sil");
    JMenuItem menuItemAdd1 = new JMenuItem("Fatura Guncelle");
    public static String clickValue;
    /**
     * Creates new form frmMuhasebeGider
     */
    public frmMuhasebeGider(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tabloDoldur();
        popupMenuEkle();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("File");

        jMenuItem1.setText("Gider Ekle");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Cıkıs");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
          try {
           giderEklePop p=new giderEklePop(null, rootPaneCheckingEnabled);
        JOptionPane.showMessageDialog(rootPane, "Baska Departmanların vermedıgı bır paraya fatura kesemezsınız.");
        p.show();
        tabloDoldur();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,  "Fatura Kesmen Icın Oncelıkle Diger departmanların odeme yapması lazım.");
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int row = jTable1.rowAtPoint(evt.getPoint());
         int col = jTable1.columnAtPoint(evt.getPoint());
         clickValue = (String)jTable1.getValueAt(row, 0);
        System.out.println(clickValue);
    }//GEN-LAST:event_jTable1MouseClicked
private void tabloDoldur() {
 
        GiderService giderService=new GiderService();
        List<Gider> git = giderService.getAll();
        String[][] data = new String[git.size()][7];
        for (int i = 0; i < git.size(); i++) {
           
            data[i][0] = git.get(i).getId().toString();
            data[i][1] = git.get(i).getKonu();
            data[i][2] = String.valueOf(git.get(i).getMiktar());
            data[i][3] = String.valueOf(git.get(i).getPersonel());
            data[i][4] = String.valueOf(git.get(i).getOgretmen());
            data[i][5] = String.valueOf(git.get(i).getEnvanter());
            data[i][6] = String.valueOf(git.get(i).getTarih());

        }
 jTable1.setModel(new DefaultTableModel(data, new String[]{"Id", "Konu", "Miktar", "Personel_id","Ogretmen_Id", "Envanter_id" ,"Tarih"}));

    }


   private void popupMenuEkle() {
        popupMenu.add(menuItemAdd);
        menuItemAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
    
                giderSilPop pop=new giderSilPop(null, rootPaneCheckingEnabled);
                pop.show();
                tabloDoldur();
            }
        });
        popupMenu.add(menuItemAdd1);
        menuItemAdd1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            giderGuncellePop gp=new giderGuncellePop(null, rootPaneCheckingEnabled);
            gp.show();
            tabloDoldur();
                
            }
        });
       jTable1.setComponentPopupMenu(popupMenu);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}