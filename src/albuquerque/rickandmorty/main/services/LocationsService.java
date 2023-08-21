package albuquerque.rickandmorty.main.services;

import albuquerque.rickandmorty.main.models.Location;
import java.util.List;

public class LocationsService extends HeadService{
    public List<Location> mountList(String json) {
        return mountList(json, Location.class);
    }
    @Override
    protected void displayDetails(Object item) {
        Location location = (Location) item;
        System.out.println("Nome: " + location.getName());
        System.out.println("Tipo: " + location.getType());
        System.out.println("Dimensao: " + location.getDimension());
        System.out.println("Url: " + location.getUrl());
        System.out.println("#################################");
    }
    @Override
    protected String getFileName() {
        return "listaLocalizacoes.json";
    }
}
