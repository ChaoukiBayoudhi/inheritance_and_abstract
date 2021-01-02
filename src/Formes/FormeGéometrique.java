package Formes;

import java.util.Objects;

public abstract class FormeGéometrique {
    private long id;

    public FormeGéometrique() {
    }

    public FormeGéometrique(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormeGéometrique)) return false;
        FormeGéometrique that = (FormeGéometrique) o;
        return Double.compare(that.id, id) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Formes.FormeGéometrique{" +
                "id=" + id +
                '}';
    }

    public abstract double Surface();

    public abstract double Perimetre();

    public int Comparer(FormeGéometrique fg)//compare deux formes en fonction de leurs surfaces
    {
        if(this.Surface()>fg.Surface())
            return 1;
        else
            if(this.Surface()<fg.Surface())
                return -1;
            else
                return 0;
    }

}
