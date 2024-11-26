import org.example.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMainInput() {
        List<BigInteger> result = Main.generateFibonacci(5);
        assertEquals(List.of(BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3)), result);
    }

    @Test
    void testMainSingleElement() {
        List<BigInteger> result = Main.generateFibonacci(1);
        assertEquals(List.of(BigInteger.ZERO), result);
    }

    @Test
    void testMainLargeInput() {
        List<BigInteger> result = Main.generateFibonacci(10);
        assertEquals(List.of(
                BigInteger.ZERO,
                BigInteger.ONE,
                BigInteger.ONE,
                BigInteger.TWO,
                BigInteger.valueOf(3),
                BigInteger.valueOf(5),
                BigInteger.valueOf(8),
                BigInteger.valueOf(13),
                BigInteger.valueOf(21),
                BigInteger.valueOf(34)
        ), result);
    }

    @Test
    void testMainInvalidInputNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Main.generateFibonacci(-5));
        assertEquals("Число должно быть натуральным (n > 0).", exception.getMessage());
    }

    @Test
    void testGMainInvalidInputZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Main.generateFibonacci(0));
        assertEquals("Число должно быть натуральным (n > 0).", exception.getMessage());
    }

    @Test
    void testMainTooLargeValue() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
                Main.generateFibonacci(100));
        assertEquals("Значение числа Фибоначчи слишком велико.", exception.getMessage());
    }
}