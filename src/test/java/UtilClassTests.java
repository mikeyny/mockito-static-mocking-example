import org.example.Utils;
import org.example.UtilsWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilClassTests {

    @Test
    public void testObjectWrappingTechnique() {
        // Create a mock of WrapperClass
        UtilsWrapper wrapper = Mockito.mock(UtilsWrapper.class);

        // When getCurrentTimeMillis() is called on the mock, return 12345L
        Mockito.when(wrapper.getCurrentTimeMillis()).thenReturn(12345L);

        // Use the mock in the test...
        long time = wrapper.getCurrentTimeMillis();

        // Verify the result and the interaction
        assertEquals(12345L, time);
        Mockito.verify(wrapper).getCurrentTimeMillis();
    }


    @Test
    public void testMockedStaticTechnique() {
        // Create a mock of the static methods of UtilityClass
        try (MockedStatic<Utils> mockedStatic = Mockito.mockStatic(Utils.class)) {

            // When getCurrentTimeMillis() is called, return 12345L
            mockedStatic.when(Utils::getCurrentTimeMillis).thenReturn(12345L);

            // Use the mocked static method in the test...
            long mockedTime = Utils.getCurrentTimeMillis();

            // Verify the result and the interaction
            assertEquals(12345L, mockedTime);
            mockedStatic.verify(Utils::getCurrentTimeMillis);
        }
    }
}
