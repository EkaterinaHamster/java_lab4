package kat.hamster.domain;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ellipse")
public class Ellipse {
    private int id;
    private String backgroundColor;
    private String borderColor;
    private int width;
    private int length;
    private Presentation presentation;

    public Ellipse() {
    }

    public Ellipse(String[] line) {
        this.backgroundColor = line[1];
        this.borderColor = line[2];
        this.width = Integer.parseInt(line[3]);
        this.length = Integer.parseInt(line[4]);
    }

    @Basic
    @Column(name = "length")
    public int getLength() {
        return this.length;
    }

    @Basic
    @Column(name = "width")
    public int getWidth() {
        return this.width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Polygon: ");
        builder.append("Background Color: ").append(backgroundColor).append(" | ");
        builder.append("Border Color: ").append(borderColor).append(" | ");
        builder.append("Width: ").append(width).append(" | ");
        builder.append("Length: ").append(length);
        return builder.toString();
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
    @Column(name = "background_color")
    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
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

    public int hashCode() {
        return Objects.hash(id, backgroundColor, borderColor, width, length);
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
