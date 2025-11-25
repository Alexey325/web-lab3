package org.example.web3.beans;

import org.example.web3.service.PointService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.math.BigDecimal;

@ManagedBean(name = "pointBean")
@ViewScoped
public class PointBean {

    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal r = BigDecimal.valueOf(1);
    private boolean hit;
    private BigDecimal canvasX;
    private BigDecimal canvasY;

    @EJB
    private PointService pointService;

    public void checkAndSavePoint() {
        hit = pointService.checkAndSaveFromForm(x, y, r);
    }

    public void checkAndSaveFromCanvas() {
        hit = pointService.checkAndSaveFromCanvas(canvasX, canvasY, r);
    }

    public BigDecimal getX() { return x; }
    public void setX(BigDecimal x) { this.x = x; }

    public BigDecimal getY() { return y; }
    public void setY(BigDecimal y) { this.y = y; }

    public BigDecimal getR() { return r; }
    public void setR(BigDecimal r) { this.r = r; }

    public boolean getHit() { return hit; }
    public void setHit(boolean hit) { this.hit = hit; }

    public void setCanvasX(BigDecimal canvasX) { this.canvasX = canvasX; }
    public BigDecimal getCanvasX() { return canvasX; }

    public void setCanvasY(BigDecimal canvasY) { this.canvasY = canvasY; }
    public BigDecimal getCanvasY() { return canvasY; }

}
