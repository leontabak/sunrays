package com.eonsahead.sunrays;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class SunRaysPanel extends JPanel {

    private static final Color BG_COLOR = new Color(248, 192, 120);
    private static final Color RAYS_0 = new Color(112, 144, 236);
    private static final Color RAYS_1 = new Color(112, 236, 144);

    public SunRaysPanel() {
        this.setBackground(BG_COLOR);
    } // SunRaysPanel()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        Bounds world = new Bounds(-1.0, +1.0, -1.0, +1.0);

        int w = this.getWidth();
        int h = this.getHeight();

        Bounds device0 = new Bounds(0.0, w, 0.0, h);
        
        double dx = 8;
        double dy = 8;
        Bounds device1 = new Bounds( 0.0 + dx, w + dx, 0.0 + dy, h + dy );

        CoordinateSystems cs0 = new CoordinateSystems(world, device0);
        CoordinateSystems cs1 = new CoordinateSystems(world, device1);

        SunBurst sunBurst = new SunBurst(96, 0.1, 0.8);

        g2D.setStroke( new BasicStroke(2));
        
        for (Line2D ray : sunBurst.getRays()) {
            g2D.setColor( RAYS_0 );
            g2D.draw(cs0.mapLine(ray));
            g2D.setColor(RAYS_1);
            g2D.draw(cs1.mapLine(ray));
        } // for    
    } // paintComponent( Graphics )
} // SunRaysPanel
