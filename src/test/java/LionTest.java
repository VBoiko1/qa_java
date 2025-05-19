package org.example;

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
    private Feline mockFeline;

    @Test
    void constructor_WithMale_SetsHasManeTrue() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void constructor_WithFemale_SetsHasManeFalse() throws Exception {
        Lion lion = new Lion("Сaмка", mockFeline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void constructor_WithInvalidSex_ThrowsException() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестно", mockFeline));
        assertTrue(exception.getMessage()
                .contains("Используйте допустимые значения пола"));
    }

    @Test
    void getKittens_ReturnsKittensCount() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    void getFood_CallsFelineEatMeat() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Мясо"));
        Lion lion = new Lion("Самка", mockFeline);
        assertEquals(List.of("Мясо"), lion.getFood());
        verify(mockFeline).eatMeat();
    }
}