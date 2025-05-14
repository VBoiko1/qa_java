
import org.example.Feline;
import org.example.Lion;
import org.example.Predator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Predator mockPredator;

    @Test
    void constructor_WithMale_SetsHasManeTrue() throws Exception {
        Lion lion = new Lion("Самец", mockPredator);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void constructor_WithFemale_SetsHasManeFalse() throws Exception {
        Lion lion = new Lion("Самка", mockPredator);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void constructor_WithInvalidSex_ThrowsException() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестно", mockPredator));

        assertTrue(exception.getMessage()
                .contains("Используйте допустимые значения пола"));
    }

    @Test
    void getKittens_WithFeline_ReturnsKittensCount() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens()); // Feline возвращает 1 по умолчанию
    }

    @Test
    void getKittens_WithNonFelinePredator_ReturnsZero() throws Exception {
        Lion lion = new Lion("Самка", mockPredator);
        assertEquals(0, lion.getKittens());
    }

    @Test
    void getFood_CallsPredatorEatMeat() throws Exception {
        when(mockPredator.eatMeat()).thenReturn(List.of("Мясо"));
        Lion lion = new Lion("Самец", mockPredator);

        assertEquals(List.of("Мясо"), lion.getFood());
        verify(mockPredator).eatMeat();
    }
}