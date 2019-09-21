import org.sql2o.*;
import java.util.List;

public class Sighting {

    private String ranger;
    private String location;
    private String date;

    public Sighting(String ranger, String location, String date){
        this.ranger = ranger;
        this.location = location;
        this.date = date;
    }

    public String getRanger(){
        return ranger;
    }

    public String getLocation(){
        return location;
    }

    public String getDate(){
        return date;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings(ranger, location, date) VALUES(:ranger, :location, :date)";
            con.createQuery(sql)
                    .addParameter("ranger", this.ranger)
                    .addParameter("location", this.location)
                    .addParameter("date", this.date)
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
