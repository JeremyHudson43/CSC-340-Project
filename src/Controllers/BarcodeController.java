package Controllers;

import net.sourceforge.barbecue.Barcode;


/**
 *
 * @author Charles Brady
 *
 * Last updated 4/13
 *
 * This is the controller for the bar code of the library card.
 */
public class BarcodeController {
   
    private Barcode barcode;

    public Barcode getBarcode() {
        return this.barcode;
    }
}