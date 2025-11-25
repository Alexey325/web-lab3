package org.example.web3.beans;

import org.example.web3.entities.Point;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean(name = "jsonPointBean")
@ApplicationScoped
public class JsonPointBean {

    @ManagedProperty(value = "#{listOfPointsBean}")
    private ListOfPointsBean listOfPointsBean;

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

    public ListOfPointsBean getListOfPointsBean() {
        return listOfPointsBean;
    }

    public void setListOfPointsBean(ListOfPointsBean listOfPointsBean) {
        this.listOfPointsBean = listOfPointsBean;
    }
}
