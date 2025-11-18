package org.example.web3.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.awt.*;
import java.util.ArrayList;
import org.example.web3.entities.Point;

@ManagedBean(name = "listOfPointsBean")
@ApplicationScoped

public class ListOfPointsBean {

    private final ArrayList<Point> points = new ArrayList<>();

//    public ListOfPointsBean() {
//        // тестовые данные
//        points.add(new Point(1, 2, 3));
//        points.add(new Point(-2, 1.5, 2));
//    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void addPoint(Point p) {
        points.add(p);
    }

}
