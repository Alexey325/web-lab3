package org.example.web3.entities;

import java.math.BigDecimal;

public class Point {
    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal r;
    private boolean hit;


    public Point(BigDecimal x, BigDecimal y, BigDecimal r,  boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
    }

    public BigDecimal getX() { return x; }
    public void setX(BigDecimal x) { this.x = x; }

    public BigDecimal getY() { return y; }
    public void setY(BigDecimal y) { this.y = y; }

    public BigDecimal getR() { return r; }
    public void setR(BigDecimal r) { this.r = r; }

    public boolean getHit() { return hit; }
    public void setHit(boolean hit) { this.hit = hit; }

}
