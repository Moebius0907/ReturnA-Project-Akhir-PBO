/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package border;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
/**
 *
 * @author lala_
 */
public class panelround extends JPanel  {
    
    private int roundTopLeft = 0;
    int roundTopRight = 0;
    int roundBottomLeft = 0;
    int roundBottomRight = 0;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
    }
    
    public panelround() {
        setOpaque(false);
    }
    @Override
    protected void paintComponent (Graphics grphcs){
        Graphics2D g2=(Graphics2D)grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        
        
        if (roundTopRight > 0){
            area.intersect(new Area(createRoundTopRight()));
        }
        
        if (roundTopLeft > 0){
            area.intersect(new Area(createRoundBottomLeft()));
        }
        
        if (roundBottomRight > 0){
            area.intersect(new Area(createRoundBottomRight()));
        }
        
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }
    
    private Shape createRoundTopLeft(){
        int Width=getWidth();
        int Height =getHeight();
        int roundX=Math.min(Width, roundTopLeft);
        int roundY=Math.min(Height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, Width, Height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, Width-roundX/2, Width)));
        area.add(new Area(new Rectangle2D.Double(0, roundY/2, Width, Height-roundY/2)));
        return area;
    }
    
    private Shape createRoundTopRight(){
        int Width=getWidth();
        int Height =getHeight();
        int roundX=Math.min(Width, roundTopRight);
        int roundY=Math.min(Height, roundTopRight);
        
        Area area = new Area(new RoundRectangle2D.Double(0, 0, Width, Height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, Width-roundX/2, Width)));
        area.add(new Area(new Rectangle2D.Double(0, roundY/2, Width, Height-roundY/2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int Width=getWidth();
        int Height =getHeight();
        int roundX=Math.min(Width, roundBottomLeft);
        int roundY=Math.min(Height, roundBottomLeft);
        
        Area area = new Area(new RoundRectangle2D.Double(0, 0, Width, Height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, Width - roundX / 2, Height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, Width, Height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int Width=getWidth();
        int Height =getHeight();
        int roundX=Math.min(Width, roundBottomRight);
        int roundY=Math.min(Height, roundBottomRight);
        
        Area area = new Area(new RoundRectangle2D.Double(0, 0, Width, Height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, Width - roundX / 2, Height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, Width, Height - roundY / 2)));
        return area;
    }
}

