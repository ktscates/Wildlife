import org.sql2o.*;

import java.util.List;

public class Animal {
    private String name;
    private String endangered;
    private String health;
    private String age;
    private int id;

    public Animal(String name, String endangered, String health, String age){
        this.name = name;
        this.endangered = endangered;
        this.health = health;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getEndangered(){
        return endangered;
    }

    public String getHealth(){
        return health;
    }

    public String getAge(){
        return age;
    }

    public int getId(){
        return id;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals(name, endangered, health, age) VALUES(:name, :endangered, :health, :age)";
            con.createQuery(sql)
                    .addParameter("name", this.name)
                    .addParameter("endangered", this.endangered)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate();
        }
    }

    public static List<Animal> all(){
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Animal.class);
        }
    }

    public static String getNameAnimal(int id) {
        String sql = "SELECT name FROM animals WHERE id = :id;";
        try(Connection con = DB.sql2o.open()) {
            String name = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeScalar(String.class);
            return name;
        }
    }

    public static String getEndangeredAnimal(int id) {
        String sql = "SELECT endangered FROM animals WHERE id = :id;";
        try(Connection con = DB.sql2o.open()) {
            String endangered = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeScalar(String.class);
            return endangered;
        }
    }

    public static String getHealthAnimal(int id) {
        String sql = "SELECT health FROM animals WHERE id = :id;";
        try(Connection con = DB.sql2o.open()) {
            String health = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeScalar(String.class);
            return health;
        }
    }

    public static String getAgeAnimal(int id) {
        String sql = "SELECT age FROM animals WHERE id = :id;";
        try(Connection con = DB.sql2o.open()) {
            String age = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeScalar(String.class);
            return age;
        }
    }
}
