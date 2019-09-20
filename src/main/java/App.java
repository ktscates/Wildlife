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
            String name = request.queryParams("name");
            Animal newAnimal = new Animal(name);
            newAnimal.save();
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
