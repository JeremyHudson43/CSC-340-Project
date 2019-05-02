package BarcodeTranslator;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

/**
 *
 * @author Charles Brady
 *
 * Last updated 3/16
 *
 * This is the translator for the bar code of the library card.
 */
public class BarcodeTranslator {

    private Barcode barcode;

    public Barcode createBarcode(String _code, String _label) throws BarcodeException {
            this.barcode = BarcodeFactory.createCode128A(_code);
            this.barcode.setLabel(_label);
            this.barcode.setBarHeight(40);
            this.barcode.setBarWidth(2);
            this.barcode.setResolution(600);
            this.barcode.setDrawingText(true);

        return this.barcode;
    }

    public Barcode getBarcode() {
        return this.barcode;
    }
}
