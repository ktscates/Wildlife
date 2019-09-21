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

}
