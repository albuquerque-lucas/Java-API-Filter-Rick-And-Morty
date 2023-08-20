package albuquerque.rickandmorty.main.models;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private final ResultInfo info;
    List<Character> result;
    public Response(ResultInfo info) {
        this.info = info;
        this.result = new ArrayList<>();
    }

    public ResultInfo getInfo() {
        return info;
    }

    public List<Character> getResult() {
        return result;
    }

}
