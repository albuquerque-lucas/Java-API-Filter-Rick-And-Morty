package albuquerque.rickandmorty.main.models;
public class Location {
    private final int id;
    private final String name;
    private final String type;
    private final String dimension;
    private final String url;

    public Location(int id, String name, String type, String dimension, String url){
        this.id = id;
        this.name = name;
        this.type = type;
        this.dimension = dimension;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public String getUrl() {
        return url;
    }
}
