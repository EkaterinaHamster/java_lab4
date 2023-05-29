package kat.hamster.dao;

import kat.hamster.domain.Polygon;

public class PolygonDao extends BaseDaoImpl<Polygon, Integer> {

    public PolygonDao() {
        super(Polygon.class);
    }
}
