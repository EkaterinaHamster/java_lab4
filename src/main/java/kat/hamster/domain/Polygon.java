package kat.hamster.domain;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "polygon")
public class Polygon {
    private int id;
    private String backgroundColor;
    private String borderColor;
    private String type;
    private int numberOfVertices;
    private Presentation presentation;

    public Polygon() {

    }

    public Polygon(String[] line) {
        this.backgroundColor = line[1];
        this.borderColor = line[2];
        type = line[3];
        numberOfVertices = Integer.parseInt(line[4]);
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "number_of_Vertices")
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Polygon: ");
        builder.append("Background Color: ").append(backgroundColor).append(" | ");
        builder.append("Border Color: ").append(borderColor).append(" | ");
        builder.append("Type: ").append(type).append(" | ");
        builder.append("Number Of Vertices: ").append(numberOfVertices);
        return builder.toString();
    }

    @Basic
    @Column(name = "background_color")
    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Basic
    @Column(name = "border_color")
    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
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

    @Override
    public int hashCode() {
        return Objects.hash(id, backgroundColor, borderColor, type, numberOfVertices);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "presentation_id")
    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}
