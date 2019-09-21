import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {

    @Test
    public void animal_instantiateAnimal_true(){
        Animal testAnimal = new Animal("Lion", "yes", "okay", "newborn");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiateWithName_Lion(){
        Animal testAnimal = new Animal("Lion", "yes", "okay", "newborn");
        assertEquals("Lion", testAnimal.getName());
    }

    @Test
    public void getEndangered_animalInstantiateWithEndangered_yes(){
        Animal testAnimal = new Animal("Lion", "yes", "okay", "newborn");
        assertEquals("yes", testAnimal.getEndangered());
    }

    @Test
    public void getHealth_animalInstantiateWithHealth_okay(){
        Animal testAnimal = new Animal("Lion", "yes", "okay", "newborn");
        assertEquals("okay", testAnimal.getHealth());
    }

    @Test
    public void getAge_animalInstantiateWithAge_newborn(){
        Animal testAnimal = new Animal("Lion", "yes", "okay", "newborn");
        assertEquals("newborn", testAnimal.getAge());
    }

    @Test
    public void save_insertIntoDatabase_True(){
        Animal testAnimal = new Animal("Lion", "yes", "okay", "newborn");
        testAnimal.save();
        assertEquals("Lion", testAnimal.getName());
    }

    @Test
    public void all_returnAllAnimals_true(){
        Animal firstAnimal = new Animal("Lion", "yes", "okay", "newborn");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Tiger", "yes", "okay", "newborn");
        secondAnimal.save();
        assertEquals("Lion", firstAnimal.getName());
        assertEquals("Tiger", secondAnimal.getName());
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

}