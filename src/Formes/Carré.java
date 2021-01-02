package Formes;

import java.util.Objects;

public class Carré extends FormeGéometrique {
    protected double Longueur;

    public Carré() {
        super();
    }

    public Carré(long id, double longueur) {
        super(id);
        Longueur = longueur;
    }

    public double getLongueur() {
        return Longueur;
    }

    public void setLongueur(double longueur) {
        Longueur = longueur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carré)) return false;
        if (!super.equals(o)) return false;
        Carré carré = (Carré) o;
        return Double.compare(carré.Longueur, Longueur) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Longueur);
    }

    @Override
    public String toString() {
        return "Formes.Carré{" +
                super.toString()+
                ", Longueur=" + Longueur +
                '}';
    }
    public double Surface()
    {
        return Longueur*Longueur;
    }
    public double Perimetre()
    {
        return 4*Longueur;
    }

}
