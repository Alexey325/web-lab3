package org.example.web3.hitCheck.managers;

import org.example.web3.hitCheck.areas.CircleArea;
import org.example.web3.hitCheck.areas.RectangleArea;
import org.example.web3.hitCheck.areas.TriangleArea;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HitChecker {
    private final BigDecimal x;
    private final BigDecimal y;
    private final BigDecimal r;

    public HitChecker(BigDecimal x, BigDecimal y, BigDecimal r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public boolean check() {

        CircleArea circleArea = new CircleArea(r);
        RectangleArea rectangleArea = new RectangleArea(r.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP), r);
        TriangleArea  triangleArea = new TriangleArea(r.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP).negate(), r.negate() );

        return ( circleArea.contains(x, y) || rectangleArea.contains(x, y) || triangleArea.contains(x, y) );

    }

}
