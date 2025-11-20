package org.example.web3.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.*;
import java.util.ArrayList;
import org.example.web3.entities.Point;

@ManagedBean(name = "listOfPointsBean")
@ApplicationScoped

public class ListOfPointsBean {

    @PersistenceContext(unitName = "pgPU")
    private EntityManager em;

    private ArrayList<Point> points;

    @PostConstruct
    public void init() {
        loadPointsFromDatabase();
    }

    private void loadPointsFromDatabase() {
        points = new ArrayList<>(em.createQuery("SELECT p FROM Point p", Point.class).getResultList());
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void addPoint(Point p) {
        points.add(p);
    }

}
