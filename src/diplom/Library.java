/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Алексей
 */
public class Library extends javax.swing.JFrame {

    DefaultListModel<String> model;
    int count;

    /**
     * Creates new form Library
     */
    public Library() {
            
        model = new DefaultListModel<>();
        ArrayList<String> s = MainFrame.c.iml.getListDirectories();
        for (int i = 0; i < s.size(); i++) {
            model.addElement(s.get(i));
        }
        initComponents();
        jList1.setSelectedIndex(0);
        jButton4.setVisible(false);
    }

    public Library(String category) {
        ArrayList<String> s = MainFrame.c.iml.getListDirectories();
        model = new DefaultListModel<>();
        for (int i = 0; i < s.size(); i++) {
            model.addElement(s.get(i));
        }
        initComponents();
        count = 0;
        jLabel1.setText("Выберите ПО для");
        jLabel2.setText(TableView.selectedData.get(0));
        jButton3.setVisible(false);
        model = new DefaultListModel<>();

        jList1.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Добавить категорию");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Список категорий:");

        jButton2.setText("Добавить ЗИ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jList1.setModel(model);
        jScrollPane1.setViewportView(jList1);

        jButton3.setText("Назад");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Выбрать категорию");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dir = System.getProperty("user.dir") + "\\library" + "\\";
        String message = JOptionPane.showInputDialog(null, "Название ПО:");
        dir += message;
        File directory = new File(String.valueOf(dir));
        if (!directory.exists()) {
            directory.mkdirs();
        }
        model.addElement(message);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser1.setMultiSelectionEnabled(true);
        jFileChooser1.showOpenDialog(this);
        File[] files = jFileChooser1.getSelectedFiles();
        for (int i = 0; i < files.length; i++) {
            if (isImage(files[i])) {
                String res = jList1.getSelectedValue();
                String dir = System.getProperty("user.dir") + "\\library" + "\\" + res + "\\";
                dir += files[i].getName();
                try {
                    System.out.println(dir);
                    File s = new File(dir);
                    copyFile(files[i], s);
                } catch (Exception e) {
                    System.out.println("oops");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Файлы не являются изображениями");
                break;

            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MainFrame.count = 0;
        List<String> a = jList1.getSelectedValuesList();
        String selected = "";
        for (int i = 0; i < a.size(); i++) {
            selected = selected + "/" + a.get(i);
        }
        TableView.categoriesUse.add(selected);
        count++;
        if (count == TableView.selectedData.size()) {
            setVisible(false);
            MainFrame.c.m.setVisible(true);
           
            for (int i = 0; i < TableView.categoriesUse.size(); i++) {
                String res = TableView.categoriesUse.get(i);
                String[] res2 = res.split("/");
                for (int j = 1; j < res2.length; j++) {
                    String path = System.getProperty("user.dir") + "\\library\\" + res2[j];
                    File f = new File(path);
                    MainFrame.c.m.listFilesForFolder(f);
                }
                
                String s = TableView.selectedData.get(i);
                String another[] = s.split("/");
                MainFrame.c.tw.getData(another[0], another[1], res, MainFrame.c.ia, MainFrame.c.il);    
            }
             ArrayList<ImageData> ls = MainFrame.c.il.getImageList();
             for(int i = 0; i < ls.size();i++){
                 String res = MainFrame.c.il.imToString(ls.get(i));
                 System.out.println(res);
             }
             MainFrame.c.m.updateLabels();
        } else {
            jLabel1.setText("Выберите ПО для");
            jLabel2.setText(TableView.selectedData.get(count));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MainFrame.c.m.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
        }
    }

    public static boolean isImage(File file) {
        /*
    // Solution 1 
    String mimeType = new MimetypesFileTypeMap().getContentType(file);
    log.info("MimeType Type = " + mimeType);
    String type = mimeType.split("/")[0].toLowerCase();
    log.info("File Type = " + type);
    return type.equals("image");
         */
        boolean b = false;
        try {
            b = (ImageIO.read(file) != null);
        } catch (IOException e) {
        }
        return b;
    }

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
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Library().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
