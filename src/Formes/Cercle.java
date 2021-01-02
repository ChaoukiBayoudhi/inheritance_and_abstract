package Formes;

import java.util.Objects;

public class Cercle extends Carré {
    private Point centre;

    public Cercle() {
        super();
    }
    public Cercle(long id,double rayon, Point centre)
    {
        super(id,rayon);
        this.centre=centre;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cercle)) return false;
        if (!super.equals(o)) return false;
        Cercle cercle = (Cercle) o;
        return super.equals(this) && centre.equals(cercle.centre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centre);
    }

    @Override
    public String toString() {
        return "Formes.Cercle{" +
                super.toString() +
                ", centre=" + centre +
                '}';
    }
    public double Surface()//redifinition de la méthode Surface de la classe Formes.Carré
    {
        return Math.PI *Longueur*Longueur;
    }
    //2ème solution
//    public double Surface()//redifinition de la méthode Surface de la classe Formes.Carré
//    {
//        return Math.PI *super.Surface();
//    }

    public double Perimetre()//redifinition de la méthode Perimètre de la classe Formes.Carré
    {
        return 2*Math.PI *Longueur;
    }
}
