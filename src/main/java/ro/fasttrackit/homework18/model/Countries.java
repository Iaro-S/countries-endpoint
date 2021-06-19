package ro.fasttrackit.homework18.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Countries {
    private final int id;
    private final String name;
    private final String capital;
    private final long population;
    private final long area;
    private final String continent;
    private final List<String> neighbours;

    public Countries(int id, String name, String capital, long population,
                     long area, String continent, List<String> neighbours) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public long getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighbours() {
        return Collections.unmodifiableList(neighbours);
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", continent='" + continent + '\'' +
                ", neighbours=" + neighbours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Countries)) return false;
        Countries countries = (Countries) o;
        return getId() == countries.getId() && getPopulation() == countries.getPopulation()
                && getArea() == countries.getArea() && Objects.equals(getName(), countries.getName())
                && Objects.equals(getCapital(), countries.getCapital()) && Objects.equals(getContinent(),
                countries.getContinent()) && Objects.equals(getNeighbours(), countries.getNeighbours());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCapital(), getPopulation(), getArea(), getContinent(), getNeighbours());
    }
}

