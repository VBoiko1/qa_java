
import org.example.Animal;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void getFamily_ReturnsCorrectDescription() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @Test
    void getFood_ForHerbivore_ReturnsPlants() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    void getFood_ForPredator_ReturnsMeat() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test
    void getFood_ForUnknownType_ThrowsException() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () ->
                animal.getFood("Всеядное"));

        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
}