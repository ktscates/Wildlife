import org.sql2o.*;
import java.util.List;

public class Sighting {

    private String ranger;
    private int animals_id;
    private String location;
    private String date;
    private int id;

    public Sighting(String ranger, String location, int animals_id){
        this.ranger = ranger;
        this.location = location;
        this.animals_id = animals_id;
    }

    public String getRanger(){
        return ranger;
    }

    public int getAnimalId(){
        return animals_id;
    }

    public String getLocation(){
        return location;
    }

    public String getDate(){
        return date;
    }

    public int getId(){
        return id;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings(ranger, animals_id, location, date) VALUES(:ranger, :animals_id, :location, now())";
            con.createQuery(sql)
                    .addParameter("ranger", this.ranger)
                    .addParameter("animals_id", this.animals_id)
                    .addParameter("location", this.location)
                    .executeUpdate();
        }
    }

    public static List<Sighting> all(){
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }
    }
}
