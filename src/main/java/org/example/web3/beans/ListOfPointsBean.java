package org.example.web3.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import org.example.web3.entities.Point;
import org.example.web3.service.PointService;

@ManagedBean(name = "listOfPointsBean")
@ApplicationScoped

public class ListOfPointsBean {

    @PersistenceContext(unitName = "pgPU")
    private EntityManager em;

    @EJB
    private PointService pointService;

    @PostConstruct
    public void init() {
        getPoints();
    }

    public List<Point> getPoints() {
        return pointService.getAllPoints();
    }

}
