import java.util.List;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {

    public static void main(String[] args){

        Map<String, Object> model = new HashMap<String, Object>();
        String layout = "templates/layout.hbs";

        get("/", (request, response) -> {
            model.put("animals", Animal.all());
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        get("/homepage", (request, response) -> {
            List<Animal> animals = Animal.all();
            model.put("animals", animals);
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        post("/animals", (request, response) -> {
            String ranger = request.queryParams("ranger");
            String name = request.queryParams("name");
            String endangered = request.queryParams("endangered");
            String location = request.queryParams("location");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            Animal newAnimal = new Animal(name, endangered, health, age);
            newAnimal.save();
            Sighting newSighting = new Sighting(ranger, location, newAnimal.getId());
            newSighting.save();
            model.put("sightings", Sighting.all());
            model.put("animals",Animal.all());
            model.put("AnimalClass", Animal.class);
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
