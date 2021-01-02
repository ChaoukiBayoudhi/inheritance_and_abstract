package Traitement;

import Formes.*;

import java.util.Scanner;

public class Main {
    public static FormeGéometrique saisirForm(int type)
    {
        FormeGéometrique fg=null;
        Scanner sc = new Scanner(System.in);
        System.out.print("id ? ");
        long id=sc.nextLong();
        switch (type)
        {
            case 1 ://carré
                fg=new Carré();
                System.out.print("Longueur ? ");
                double longueur=sc.nextDouble();
                fg.setId(id);
                ((Carré)fg).setLongueur(longueur);
                break;
            case 2://rectangle
                fg=new Rectangle();
                System.out.print("Largeur ? ");
                double largeur=sc.nextDouble();
                System.out.print("Longueur ? ");
                longueur=sc.nextDouble();
                fg.setId(id);
                ((Rectangle)fg).setLargeur(largeur);
                ((Rectangle)fg).setLongueur(longueur);
                break;
            case 3://Cercle
                System.out.print("Rayon ? ");
                double rayon=sc.nextDouble();
                System.out.println("Saisie du centre :");
                System.out.print("abscisse ? ");
                double abscisse=sc.nextDouble();
                System.out.print("ordonnée ? ");
                double ordonée=sc.nextDouble();
                fg=new Cercle(id,rayon,new Point(abscisse,ordonée));
                break;
            case 4://Triangle
                System.out.println("Saisie des points (ABC)[triangle rectangle en B] :");
                Point[] vertex=new Point[3];
                String[] vertexNames={"A","B","C"};
                for (int i=0;i<3;i++) {
                    System.out.println("Saisie du points" + vertexNames[i] + " :");
                    System.out.print("abscisse ? ");
                    abscisse = sc.nextDouble();
                    System.out.print("ordonnée ? ");
                    ordonée = sc.nextDouble();
                    vertex[i]=new Point(abscisse,ordonée);
                }
                fg=new Triangle(id,vertex[0],vertex[1],vertex[2]);
                break;
        }
        return fg;
    }

    public static void main(String[] args)
    {
//        FormeGéometrique fg1=new Rectangle(1,32.5,2.5);
//        FormeGéometrique fg2=new Rectangle(1,19.5,1.2);
//        double res=fg1.Comparer(fg2);
//        if(res>0)
//            System.out.println("le 1er Rectangle est plus grand");
//        else
//            if(res<0)
//            System.out.println("Le 2éme Rectangle est plus grand");
//            else
//                System.out.println("Les deux Rectangles sont égaux");
        FormeGéometriques formsSet=new FormeGéometriques();
        int choix;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Selectionnez un choix :");
            System.out.println("1- Lister les Formes Géometriques");
            System.out.println("2- Ajouter une Forme Géometrique");
            System.out.println("3- Ajouter une Forme Géometrique à un indice");
            System.out.println("4- Afficher Perimètre et Surface d'une Forme");
            System.out.println("5- Comparer deux formes (par surface)");
            System.out.println("6- Liste des formes ayant une surface > seuil");
            System.out.println("7- Quitter l'application");
            do{
                System.out.print("Votre choix : ");
                choix=sc.nextInt();
            }while(choix<1||choix>7);
            switch(choix)
            {
                case 1:
                    System.out.println("Liste des formes par type :");
                    formsSet.showFormsByType();
                    break;
                case 2:
                    System.out.println("Quel est la forme à introduire ?");
                    System.out.println("1- Carré 2-Rectangle 3-Cercle 4-Triangle");
                    int formType=sc.nextInt();
                    FormeGéometrique fg=saisirForm(formType);
                    formsSet.addForm(fg);
                    break;
                case 3:
                    System.out.println("Quel est la forme à introduire ?");
                    System.out.println("1- Carré 2-Rectangle 3-Cercle 4-Triangle");
                    formType=sc.nextInt();
                    fg=saisirForm(formType);
                    System.out.println("Donner l'indice ou ajouter la forme");
                    int index=sc.nextInt();
                    formsSet.addForm(fg,index);
                    break;
                case 4:
                    System.out.print("L'id de la Forme ? ");
                    Long id=sc.nextLong();
                    formsSet.showSquare(id);
                    break;
                case 5:
                    System.out.print("L'id de la Forme 1 ? ");
                    Long id1=sc.nextLong();
                    System.out.print("L'id de la Forme 2 ? ");
                    Long id2=sc.nextLong();
                    int res=formsSet.compare(id1,id2);
                    if(res>0)
                        System.out.println("La 1ère forme est plus grande");
                    else
                        if(res<0)
                            System.out.println("La 2ème est plus grande");
                        else
                            System.out.println("Les deux formes sont identiques");
                    break;
                case 6:
                    System.out.println("Le seuil ? ");
                    double seuil=sc.nextDouble();
                    System.out.println("Listes des formes ayant une surface < "+seuil);
                    formsSet.showFormsSeuil(seuil);
                    break;
            }

        }while(choix!=7);










    }
}
