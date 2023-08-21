package albuquerque.rickandmorty.main.controllers;

import albuquerque.rickandmorty.main.models.Location;
import albuquerque.rickandmorty.main.services.LocationsService;

import java.util.List;

public class LocationsController extends HeadController{
    private final LocationsService locationsService = new LocationsService();
    @Override
    protected String getRequestURL() {
        return "https://rickandmortyapi.com/api/location";
    }

    @Override
    protected List<Location> mountList(String json) {
        return locationsService.mountList(json);
    }

    @Override
    protected void displayAll(List itemList) {
        locationsService.displayAll(itemList);
    }
}
