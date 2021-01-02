package Formes;

import java.util.Objects;

public class Point {
    private double abscisse;
    private double ordonnée;

    public Point() {
    }

    public Point(double abscisse, double ordonnée) {
        this.abscisse = abscisse;
        this.ordonnée = ordonnée;
    }

    public double getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(double abscisse) {
        this.abscisse = abscisse;
    }

    public double getOrdonnée() {
        return ordonnée;
    }

    public void setOrdonnée(double ordonnée) {
        this.ordonnée = ordonnée;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.abscisse, abscisse) == 0 &&
                Double.compare(point.ordonnée, ordonnée) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abscisse, ordonnée);
    }

    @Override
    public String toString() {
        return "Formes.Point{" +
                "abscisse=" + abscisse +
                ", ordonnée=" + ordonnée +
                '}';
    }
}
