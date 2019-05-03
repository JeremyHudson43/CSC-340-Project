package Views;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Charles Brady
 * Last modified 4-25-2019
 * 
 *  This class adds a listener to the print button and allows the name and 
 *  barcode to be modified with setters from the UserController 
 */
public class LibraryCardView extends javax.swing.JFrame {


    public LibraryCardView() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barCode = new javax.swing.JButton();
        LibraryCardLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        printButtonLibCard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LibraryCardLabel.setText("Library Card");

        printButtonLibCard.setText("Print");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(LibraryCardLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barCode, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(printButtonLibCard)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LibraryCardLabel)
                .addGap(18, 18, 18)
                .addComponent(barCode, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(printButtonLibCard)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void printListener(ActionListener _listenForPrint) {
        this.printButtonLibCard.addActionListener(_listenForPrint);
    }

    public void setNameField(String _name) {
        this.nameTextField.setText(_name);
    }

    public void setBarCode(ImageIcon _image) {
        this.barCode.setIcon(_image);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LibraryCardLabel;
    private javax.swing.JButton barCode;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton printButtonLibCard;
    // End of variables declaration//GEN-END:variables
}
