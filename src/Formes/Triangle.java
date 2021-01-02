package Formes;

import java.util.Objects;

public class Triangle extends FormeGéometrique {
    private Point A;
    private Point B;
    private Point C;

    public Triangle() {
        super();
    }

    public Triangle(long id, Point a, Point b, Point c) {
        super(id);
        A = a;
        B = b;
        C = c;
    }

    public Point getA() {
        return A;
    }

    public void setA(Point a) {
        A = a;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point c) {
        C = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return A.equals(triangle.A) &&
                B.equals(triangle.B) &&
                C.equals(triangle.C);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), A, B, C);
    }

    @Override
    public String toString() {
        return
                " Formes.Triangle{" +
                        super.toString() +
                ", A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
    @Override
    public double Surface()//triangle rectangle en B
    {
        double base=Math.sqrt(Math.pow(B.getAbscisse()-C.getAbscisse(),2)+Math.pow(B.getOrdonnée()-C.getOrdonnée(),2));
        double hauteur=Math.sqrt(Math.pow(A.getAbscisse()-B.getAbscisse(),2)+Math.pow(A.getOrdonnée()-B.getOrdonnée(),2));
        return (base*hauteur)/2;
    }

    @Override
    public double Perimetre()
    {
        double base=Math.sqrt(Math.pow(B.getAbscisse()-C.getAbscisse(),2)+Math.pow(B.getOrdonnée()-C.getOrdonnée(),2));
        double hauteur=Math.sqrt(Math.pow(A.getAbscisse()-B.getAbscisse(),2)+Math.pow(A.getOrdonnée()-B.getOrdonnée(),2));
        double hypot=Math.sqrt(Math.pow(A.getAbscisse()-C.getAbscisse(),2)+Math.pow(A.getOrdonnée()-C.getOrdonnée(),2));
        return base+hauteur+hypot;
    }

}
