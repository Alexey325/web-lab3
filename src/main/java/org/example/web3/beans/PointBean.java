package org.example.web3.beans;

import org.example.web3.entities.Point;
import org.example.web3.hitCheck.managers.HitChecker;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import java.math.BigDecimal;
import java.util.List;

@ManagedBean(name = "pointBean")
@SessionScoped
public class PointBean {

    @ManagedProperty(value = "#{listOfPointsBean}")
    private ListOfPointsBean listOfPointsBean;

    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal r = BigDecimal.valueOf(1);
    private boolean hit;

    private BigDecimal canvasX;
    private BigDecimal canvasY;

    public void checkPoint() {

        HitChecker hitChecker = new HitChecker(x, y, r);
        hit = hitChecker.check();

        Point newPoint = new Point(x, y, r, hit);
        listOfPointsBean.addPoint(newPoint);

    }

    public void checkPointFromCanvas() {

        HitChecker hitChecker = new HitChecker(canvasX, canvasY, r);
        hit = hitChecker.check();

        Point newPoint = new Point(canvasX, canvasY, r, hit);
        listOfPointsBean.addPoint(newPoint);

    }

    public BigDecimal getX() { return x; }
    public void setX(BigDecimal x) { this.x = x; }

    public BigDecimal getY() { return y; }
    public void setY(BigDecimal y) { this.y = y; }

    public BigDecimal getR() { return r; }
    public void setR(BigDecimal r) { this.r = r; }

    public boolean getHit() { return hit; }
    public void setHit(boolean hit) { this.hit = hit; }

    public ListOfPointsBean getListOfPointsBean() {
        return listOfPointsBean;
    }

    public void setListOfPointsBean(ListOfPointsBean listOfPointsBean) {
        this.listOfPointsBean = listOfPointsBean;
    }

    public String getPointsJSON() {
        List<Point> points = listOfPointsBean.getPoints();
        StringBuilder json = new StringBuilder("[");

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            json.append("{")
                    .append("\"x\":").append(p.getX()).append(",")
                    .append("\"y\":").append(p.getY()).append(",")
                    .append("\"r\":").append(p.getR()).append(",")
                    .append("\"hit\":").append(p.getHit())
                    .append("}");
            if (i < points.size() - 1) json.append(",");
        }
        json.append("]");

        return json.toString();
    }

    public void setCanvasX(BigDecimal canvasX) { this.canvasX = canvasX; }
    public BigDecimal getCanvasX() { return canvasX; }

    public void setCanvasY(BigDecimal canvasY) { this.canvasY = canvasY; }
    public BigDecimal getCanvasY() { return canvasY; }


}
