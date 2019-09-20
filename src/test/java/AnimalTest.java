import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {

    @Test
    public void animal_instantiateAnimal_true(){
        Animal testAnimal = new Animal("Lion");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiateWithName_Lion(){
        Animal testAnimal = new Animal("Lion");
        assertEquals("Lion", testAnimal.getName());
    }

    @Test
    public void save_insertIntoDatabase_Animal(){
        Animal testAnimal = new Animal("Lion");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

    public void all_returnAllAnimals_true(){
        Animal firstAnimal = new Animal("Lion");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Tiger");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();
}