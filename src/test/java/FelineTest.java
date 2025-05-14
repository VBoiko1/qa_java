

import org.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    void eatMeat_ReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    void getFamily_ReturnsFelineFamily() {
        assertEquals("Кошaчьи", feline.getFamily());
    }

    @Test
    void getKittens_NoArg_ReturnsOneKitten() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittens_WithArg_ReturnsSpecifiedCount() {
        assertEquals(3, feline.getKittens(3));
    }
}