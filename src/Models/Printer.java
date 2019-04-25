/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class Printer implements Printable {
    final Component comp;
    final Double scale;

    public Printer(Component comp, Double scale){
        this.comp = comp;
        this.scale = scale;
    }

    @Override
    public int print(Graphics _graphics, PageFormat _format, int _page_index) 
            throws PrinterException {
        if (_page_index > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // get the bounds of the component
        Dimension dim = this.comp.getSize();
        double cHeight = dim.getHeight();
        double cWidth = dim.getWidth();

        // get the bounds of the printable area
        double pHeight = _format.getImageableHeight();
        double pWidth = _format.getImageableWidth();

        double pXStart = _format.getImageableX();
        double pYStart = _format.getImageableY();

        double xRatio = pWidth / cWidth;
        double yRatio = pHeight / cHeight;


        Graphics2D g2 = (Graphics2D) _graphics;
        g2.translate(pXStart, pYStart);
//        g2.scale(xRatio, yRatio);
        g2.scale(this.scale, this.scale);
        this.comp.paint(g2);

        return Printable.PAGE_EXISTS;
    }
}