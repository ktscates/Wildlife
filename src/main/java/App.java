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

        post("/show", (request, response) -> {
            String ranger = request.queryParams("ranger");
            String name = request.queryParams("name");
            String endangered = request.queryParams("endangered");
            String location = request.queryParams("location");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            Animal newAnimal = new Animal(name, endangered, health, age);
            model.put("name", newAnimal.getName());
            model.put("endangered", newAnimal.getEndangered());
            model.put("health", newAnimal.getHealth());
            model.put("age", newAnimal.getAge());
            newAnimal.save();
            Sighting newSighting = new Sighting(ranger, location, newAnimal.getId());
            model.put("ranger", newSighting.getRanger());
            model.put("location", newSighting.getLocation());
            newSighting.save();
            model.put("animals",Animal.all());
            model.put("sightings", Sighting.all());
            model.put("AnimalClass", Animal.class);
            System.out.println(newAnimal);
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());
    }

}