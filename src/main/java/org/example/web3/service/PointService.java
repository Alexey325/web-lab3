package org.example.web3.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.example.web3.entities.Point;
import org.example.web3.hitCheck.managers.HitChecker;

import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Stateless
public class PointService {

    @PersistenceContext(unitName = "pgPU")
    private EntityManager em;

    public boolean checkAndSaveFromForm(BigDecimal x, BigDecimal y, BigDecimal r) {
        boolean hit = new HitChecker(x, y, r).check();
        Point point = new Point(x.setScale(2, RoundingMode.HALF_UP),
                y.setScale(2, RoundingMode.HALF_UP),
                r, hit);
        em.persist(point);
        return hit;
    }

    public boolean checkAndSaveFromCanvas(BigDecimal canvasX, BigDecimal canvasY, BigDecimal r) {
        boolean hit = new HitChecker(canvasX, canvasY, r).check();
        Point point = new Point(canvasX.setScale(2, RoundingMode.HALF_UP),
                canvasY.setScale(2, RoundingMode.HALF_UP),
                r, hit);
        em.persist(point);
        return hit;
    }

    public List<Point> getAllPoints() {
        return em.createQuery("SELECT p FROM Point p", Point.class).getResultList();
    }
}
