/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author DELL6420
 */
public class IndividualBookView extends javax.swing.JPanel {

    /**
     * Creates new form IndividualBookView
     */
    public IndividualBookView() {
        initComponents();

    }

    public void setIndividualBookVewAuthorPlaceholderTxtLbl(String IndividualBookVewAuthorPlaceholderTxtLbl) {
        this.IndividualBookVewAuthorPlaceholderTxtLbl.setText(IndividualBookVewAuthorPlaceholderTxtLbl);
    }

    public void setIndividualBookVewCategoryPlaceholderTxtLbl(String IndividualBookVewCategoryPlaceholderTxtLbl) {
        this.IndividualBookVewCategoryPlaceholderTxtLbl.setText(IndividualBookVewCategoryPlaceholderTxtLbl);
    }

    public void setIndividualBookVewISBNPlaceholderTxtLbl(String IndividualBookVewISBNPlaceholderTxtLbl) {
        this.IndividualBookVewISBNPlaceholderTxtLbl.setText(IndividualBookVewISBNPlaceholderTxtLbl);
    }

    public void setIndividualBookVewNamePlaceholderTxtLbl(String IndividualBookVewNamePlaceholderTxtLbl) {
        this.IndividualBookVewNamePlaceholderTxtLbl.setText(IndividualBookVewNamePlaceholderTxtLbl);
    }

    public void setImagePlaceholderLbl(String _imageLink)
            throws MalformedURLException, IOException {
                imagePlaceholderLbl.setText("");
        BufferedImage img = ImageIO.read(new URL(_imageLink));
        imagePlaceholderLbl.setIcon(new javax.swing.ImageIcon(img));
        
        this.imagePlaceholderLbl = imagePlaceholderLbl;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imagePlaceholderLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        IndividualBookVewISBNTxtLbl = new javax.swing.JLabel();
        IndividualBookVewNamePlaceholderTxtLbl = new javax.swing.JLabel();
        IndividualBookVewAuthorPlaceholderTxtLbl = new javax.swing.JLabel();
        IndividualBookVewCategoryPlaceholderTxtLbl = new javax.swing.JLabel();
        IndividualBookVewISBNPlaceholderTxtLbl = new javax.swing.JLabel();
        IndividualBookViewBookNameTxtLbl = new javax.swing.JLabel();
        IndividualBookViewExitButton = new javax.swing.JButton();
        checkedOutTxtLbl = new javax.swing.JLabel();
        bookCheckedOutPlaceHolderTxtLbl = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        imagePlaceholderLbl.setText("Image Placeholder ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(imagePlaceholderLbl)
                .addGap(199, 199, 199))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(imagePlaceholderLbl)
                .addGap(0, 169, Short.MAX_VALUE))
        );

        jLabel10.setText("Individual Book View");

        jLabel2.setText("Book Author:");

        jLabel3.setText("Book Category:");

        IndividualBookVewISBNTxtLbl.setText("Book ISBN:");

        IndividualBookVewNamePlaceholderTxtLbl.setText("Book Name Placeholder");

        IndividualBookVewAuthorPlaceholderTxtLbl.setText("Book Author Placeholder");

        IndividualBookVewCategoryPlaceholderTxtLbl.setText("Book Category Placeholder");

        IndividualBookVewISBNPlaceholderTxtLbl.setText("Book ISBN Placeholder");

        IndividualBookViewBookNameTxtLbl.setText("Book Name:");

        IndividualBookViewExitButton.setText("Exit Program");

        checkedOutTxtLbl.setText("Checked out:");

        bookCheckedOutPlaceHolderTxtLbl.setText("Book Checked Out Placholder");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel10))
                    .addComponent(IndividualBookViewExitButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IndividualBookViewBookNameTxtLbl)
                            .addComponent(checkedOutTxtLbl)
                            .addComponent(IndividualBookVewISBNTxtLbl)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IndividualBookVewAuthorPlaceholderTxtLbl)
                            .addComponent(IndividualBookVewCategoryPlaceholderTxtLbl)
                            .addComponent(IndividualBookVewISBNPlaceholderTxtLbl)
                            .addComponent(bookCheckedOutPlaceHolderTxtLbl)
                            .addComponent(IndividualBookVewNamePlaceholderTxtLbl))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IndividualBookViewBookNameTxtLbl)
                    .addComponent(IndividualBookVewNamePlaceholderTxtLbl))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IndividualBookVewAuthorPlaceholderTxtLbl))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(IndividualBookVewCategoryPlaceholderTxtLbl))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IndividualBookVewISBNTxtLbl)
                    .addComponent(IndividualBookVewISBNPlaceholderTxtLbl))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkedOutTxtLbl)
                    .addComponent(bookCheckedOutPlaceHolderTxtLbl))
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IndividualBookViewExitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IndividualBookVewAuthorPlaceholderTxtLbl;
    private javax.swing.JLabel IndividualBookVewCategoryPlaceholderTxtLbl;
    private javax.swing.JLabel IndividualBookVewISBNPlaceholderTxtLbl;
    private javax.swing.JLabel IndividualBookVewISBNTxtLbl;
    private javax.swing.JLabel IndividualBookVewNamePlaceholderTxtLbl;
    private javax.swing.JLabel IndividualBookViewBookNameTxtLbl;
    private javax.swing.JButton IndividualBookViewExitButton;
    private javax.swing.JLabel bookCheckedOutPlaceHolderTxtLbl;
    private javax.swing.JLabel checkedOutTxtLbl;
    private javax.swing.JLabel imagePlaceholderLbl;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
