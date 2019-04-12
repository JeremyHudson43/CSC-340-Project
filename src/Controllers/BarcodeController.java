package Controllers;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

/**
 *
 * @author Charles Brady
 *
 * Last updated 3/16
 *
 * This is the controller for the bar code of the library card.
 */
public class BarcodeController {

    private Barcode barcode;

    public Barcode getBarcode() {
        return this.barcode;
    }
}
