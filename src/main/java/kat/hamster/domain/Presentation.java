package kat.hamster.domain;

import kat.hamster.dao.PresentationDao;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "presentation")
public class Presentation {
    private int id;
    private String backgroundColor;
    private String name;
    private Set<Ellipse> ellipses = new LinkedHashSet<>();
    private Set<Polygon> polygons = new LinkedHashSet<>();

    public Presentation() {
    }

    public Presentation(String[] line) {
        this.backgroundColor = line[1];
        this.name = line[2];
    }

    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "background_color")
    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @OneToMany(mappedBy = "presentation")
    public Set<Ellipse> getEllipses() {
        return ellipses;
    }

    public void setEllipses(Set<Ellipse> ellipses) {
        this.ellipses = ellipses;
    }

    @OneToMany(mappedBy = "presentation")
    public Set<Polygon> getPolygons() {
        return polygons;
    }

    public void setPolygons(Set<Polygon> polygons) {
        this.polygons = polygons;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Presentation: ");
        builder.append("Name: ").append(name);
        builder.append("Background Color: ").append(backgroundColor).append(" | ");
        return builder.toString();
    }
}
