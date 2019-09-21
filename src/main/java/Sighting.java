import org.sql2o.*;
import java.util.List;

public class Sighting {

    private String ranger;
    private int name_id;
    private String location;
    private String date;
    private int id;

    public Sighting(String ranger, String location, int name_id){
        this.ranger = ranger;
        this.location = location;
        this.name_id = name_id;
    }

    public String getRanger(){
        return ranger;
    }

    public int getAnimalId(){
        return name_id;
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
            String sql = "INSERT INTO sightings(ranger, name_id, location, date) VALUES(:ranger, :name_id, :location, now())";
            con.createQuery(sql)
                    .addParameter("ranger", this.ranger)
                    .addParameter("name_id", this.name_id)
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
