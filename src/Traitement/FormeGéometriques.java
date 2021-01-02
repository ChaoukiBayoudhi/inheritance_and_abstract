package Traitement;

import Formes.*;

import java.util.ArrayList;

public class FormeGéometriques {
    private ArrayList<FormeGéometrique> lstFormes=new ArrayList<>();

    public ArrayList<FormeGéometrique> getLstFormes() {
        return lstFormes;
    }

    public void setLstFormes(ArrayList<FormeGéometrique> lstFormes) {
        this.lstFormes = lstFormes;
    }

    public void showFormsByType()
    {
        ArrayList<Carré> lstCarrés=new ArrayList<>();
        ArrayList<Rectangle> lstRectangles=new ArrayList<>();
        ArrayList<Triangle> lstTriangles=new ArrayList<>();
        ArrayList<Cercle> lstCercles=new ArrayList<>();
        for(FormeGéometrique fg:lstFormes)
        {
            if(fg.getClass().equals(Rectangle.class))
                //instance of return true for any Class of the inheritence tree
                //getClass is mutch better in our case
                lstRectangles.add((Rectangle)fg);
            else
                if(fg.getClass().equals(Carré.class))
                    lstCarrés.add((Carré)fg);
                else
                    if(fg.getClass().equals(Triangle.class))
                        lstTriangles.add((Triangle)fg);
                    else
                        lstCercles.add((Cercle)fg);
        }
        if(!lstCarrés.isEmpty()) {
            System.out.println("Les Carrés sont :");
            lstCarrés.forEach(System.out::println);
        }
        if(!lstTriangles.isEmpty()) {
            System.out.println("Les Triangles sont :");
            lstTriangles.forEach(System.out::println);
        }
        if(!lstRectangles.isEmpty()) {
            System.out.println("Les Rectangles sont :");
            lstRectangles.forEach(System.out::println);
        }
        if(!lstCercles.isEmpty()) {
            System.out.println("Les Cercles sont :");
            lstCercles.forEach(System.out::println);
        }
    }
    public int addForm(FormeGéometrique fg)//retourne 1 si l'ajout a été effectué, 0 sinon
    {
        try {
            if(lstFormes.contains(fg))
                throw new Exception("Veuillez verifier l'id. Cette forme existe déjà");
            lstFormes.add(fg);
            return 1;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public int addForm(FormeGéometrique fg, int index)//retourne 1 si l'ajout a été effectué, 0 sinon
    {
        try {
            if(index<0||index>lstFormes.size())
                throw new Exception("Veuillez verifier l'indice");
            if(lstFormes.contains(fg))
                throw new Exception("Veuillez verifier l'id. Cette forme existe déjà");
            lstFormes.add(index,fg);
            return 1;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public int Search(long id)//retourne l'indice de la forme si elle existe, -1 sinon
    {
        int i=0;
        boolean trouve=false;
        int index=-1;
        while(i<lstFormes.size() && !trouve)
        {
            if(lstFormes.get(i).getId()==id)
            {
                trouve=true;
                index=i;
            }
            i++;
        }
        return index;
    }
    public void showSquare(long id)
    {
        try {
            int index=Search(id);
            if(index==-1)
                throw new Exception("Veuillez Verifier l'id. Forme inexistante");
            System.out.println("Surface = "+ lstFormes.get(index).Surface());
            System.out.println("Perimetre = "+ lstFormes.get(index).Perimetre());
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public int compare(long id1,long id2)
    {
        try {
            int index1=Search(id1);
            if(index1==-1)
                throw new Exception("Veuillez Verifier l'id de la 1ère forme. Forme inexistante");
            int index2=Search(id2);
            if(index2==-1)
                throw new Exception("Veuillez Verifier l'id de la 2ème forme. Forme inexistante");
            FormeGéometrique fg1=lstFormes.get(index1);
            FormeGéometrique fg2=lstFormes.get(index2);
            return fg1.Comparer(fg2);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return -2;
        }
    }
public void showFormsSeuil(double seuil)
{
    lstFormes.stream()
            .filter(x->x.Surface()<seuil)
            .forEach(System.out::println);
}
}
