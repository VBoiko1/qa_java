
import org.example.Cat;
import org.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    void setUp() {

        cat = new Cat(feline);
    }

    @Test
    void getSound_ReturnsMeow() {

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFood_CallsEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(feline.eatMeat()).thenReturn(expectedFood);

        assertEquals(expectedFood, cat.getFood());
        verify(feline, times(1)).eatMeat();
    }
}