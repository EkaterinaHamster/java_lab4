package kat.hamster.dao;

import kat.hamster.domain.Ellipse;
import org.hibernate.query.Query;

import java.util.List;

public class EllipseDao extends BaseDaoImpl<Ellipse, Integer> {

    public EllipseDao() {
        super(Ellipse.class);
    }

    public List<Ellipse> getAllByBackgroundColor(String color) {
        Query q = getSession().createQuery("FROM Ellipse WHERE Ellipse.backgroundColor = \"" + color + "\"");
        return q.list();
    }
}
