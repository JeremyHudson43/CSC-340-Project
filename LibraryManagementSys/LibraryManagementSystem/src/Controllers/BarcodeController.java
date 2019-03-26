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
    
    public Barcode CreateBarcode(String code, String label) throws BarcodeException {
        barcode = BarcodeFactory.createCode128A(code);
        barcode.setLabel(label);
        barcode.setBarHeight(40);
        barcode.setBarWidth(2);
        barcode.setResolution(600);
        barcode.setDrawingText(true);
        return barcode;
    }

    public Barcode GetBarcode(){
        return barcode;
    }
}
