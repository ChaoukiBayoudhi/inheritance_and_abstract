package Formes;

import java.util.Objects;

public class Rectangle extends Carré {
    private double largeur;

    public Rectangle() {
        super();
    }

    public Rectangle(long id, double longueur, double largeur) {
        super(id, longueur);
        this.largeur = largeur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return super.equals(this) && Double.compare(rectangle.largeur, largeur) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), largeur);
    }

    @Override
    public String toString() {
        return "Formes.Rectangle{" +
                super.toString()+
                ", largeur=" + largeur +
                '}';
    }
    public double Surface()
    {
        return Longueur*largeur;
    }
    public double Perimetre()
    {
        return 2*(Longueur+largeur);
    }
}
