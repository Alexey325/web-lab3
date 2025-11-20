package org.example.web3.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.example.web3.entities.Point;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PointService {

    @PersistenceContext(unitName = "pgPU")
    private EntityManager em;

    public void addPoint(Point point) {
        em.persist(point);
    }

    public List<Point> getAllPoints() {
        return em.createQuery("SELECT p FROM Point p", Point.class).getResultList();
    }
}
