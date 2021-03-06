/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Алексей
 */
public class MainFrame extends javax.swing.JFrame {

    public static Controller c;
    public static int count = 0;
    ArrayList<File> f;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        f = new ArrayList();
        initComponents();
    }

    private class ImageFileFilter extends FileFilter {

        public String getDescription() {
            return "";
        }

        public boolean accept(File file) {
            if (file.isDirectory()) {
                return false; //or ur code what file u want to return
            }
            return true;
        }
    }

    public void updateLabels() {
        jLabel2.setText("Колличество ОИ: " + c.il.getSize());
        if (c.il.getSize() == 0) {
            jLabel3.setText("Колличество ЗИ: 0");
        } else {
            jLabel3.setText("Колличество ЗИ: " + count);
        }

        if (count != 0) {
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
        }
        if (c.il.getSize() != 0) {
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
        } else {
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
        }
    }

    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                if (fileEntry.getName().equals("Thumbs.db")) {

                } else {
                    
                   
                    count++;
                    System.out.println(fileEntry.getName());
                     System.out.println(count);
                }

            }
        }

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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Основное меню:");

        jButton1.setText("Подключение к БД");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Библиотека");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Замена");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Колличество ОИ:    ");

        jButton4.setText("Сохранить данные в файл");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Колличество ЗИ:");

        jButton5.setText("Модификации изображений");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(10, 10, 10)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton3)))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FrameDB().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        File file = null;
        jFileChooser1.addChoosableFileFilter(new ImageFileFilter());
        int returnVal = jFileChooser1.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser1.getSelectedFile();
            String path = file.getPath();
            ArrayList<ImageData> l = c.il.getImageList();
            ArrayList<String> result = new ArrayList();
            for (int i = 0; i < l.size(); i++) {
                String intoFile = c.il.imToString(l.get(i));
                result.add(intoFile);
            }
            c.il.writeToFile(path, result);

            System.out.println(path);
        }

//        int returnVal = jFileChooser1.showOpenDialog(this);
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            File file = jFileChooser1.getSelectedFile();
//            try {
//                String absolutePath = file.getAbsolutePath();
//                int res = c.il.setImageListFromFile(absolutePath, c.tw);
//
//                if (res == 1) {
//                    JOptionPane.showMessageDialog(this, "Ошибка формата файла");
//                } else {
//                    setVisible(false);
//                    c.m.updateLabels();
//                    c.m.setVisible(true);
//
//                }
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(this, "Ошибка доступа к файлу");
//            }
//        } else {
//            System.out.println("File access cancelled by user.");
//        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        setVisible(false);
        new ModFrame().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Library().setVisible(true);
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void ArraylistFilesForFolder(final File folder) {
        f = new ArrayList();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                if (fileEntry.getName().equals("Thumbs.db")) {

                } else {
                    f.add(fileEntry);
                }

            }
        }

    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean greater = false;
        if (c.il.getSize() >= count) {

            String[] buttons = {"Пополнить БЗИ", "Использовать ЗИ повторно"};
            int rc = JOptionPane.showOptionDialog(null, "Кол-во ОИ > ЗИ. Желаете пополнить БЗИ"
                    + " с \n помощью модификаций? Или использовать ЗИ повторно? ", "Confirmation",
                    JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[1]);
            if (rc == 0) {
                new ModFrame().setVisible(true);
                setVisible(false);
                return;
            }
            greater = true;
        }
        String po = "";
         String path = System.getProperty("user.dir") + "\\library\\";
        ArrayList<ImageData> workList = c.il.getImageList();
        for (int i = 0; i < workList.size(); i++) {
            ImageData imd = workList.get(i);
            String currentPO = imd.getSubjectArea();
            if (!po.equals(currentPO)) {
                po = currentPO;
                    System.out.println(po);
                String[] parse = currentPO.split("/");
                for(int j = 1; j < parse.length; j++){
                    String patsh = System.getProperty("user.dir") + "\\library\\" + parse[j];
                       System.out.println(patsh);
                    File fs = new File(patsh);
                    ArraylistFilesForFolder(fs);
                }
            } 
            if(greater){
                while(workList.size() > f.size()){
                    f.add(f.get(i));
                }
            }
            
            c.ie.prepareWork(imd,f.get(i));
            c.ie.equalizeWidthHeight();
            c.ie.equalizeSize();
            
            System.out.println("vse ok");
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                c = new Controller();
                MainFrame m = new MainFrame();
                m.setVisible(true);
                c.m = m;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
