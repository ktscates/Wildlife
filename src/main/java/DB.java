import org.sql2o.*;

public class DB {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife", "ktscates", "ktscates");
    static String connectionString = "jdbc:postgresql://ec2-54-243-208-234.compute-1.amazonaws.com:5432/dfp2c3nv09p3en";
    static Sql2o sql2o = new Sql2o(connectionString, "fnhbwokxksfcfg", "8119d17f0672f23e9364425b68ca3d5fbf5fcafc40ebcccd1565b6f9ec5b64c5");
}
