import org.example.Calculator;
import org.junit.jupiter.api.*;

/**
 * @author Vinod John
 * @Date 03.08.2024
 */
public class CalculatorTest {
    Calculator calculator;

    @BeforeAll //Executed before all the test cases
    public static void globalSetup() {
        System.out.println("Starting all the tests...");
    }

    @BeforeEach //Executed before every test case
    public void setup() {
        System.out.println("Starting tests..");
        calculator = new Calculator();
    }

    @AfterEach //Executed after every test case
    public void finishTest() {
        System.out.println("Finished Test Execution");
    }

    @AfterAll //Executed after all the test cases
    public static void finishAllTests() {
        System.out.println("All tests finished.");
    }

    @DisplayName("Add two numbers test")
    @Test
    public void whenAddTwoNumbersCalled_shouldReturnValue() {
        float result = calculator.addTwoNumbers(1, 2);
        float result2 = calculator.addTwoNumbers(2, 3);
        float result3 = calculator.addTwoNumbers(4, 5);

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, result),
                () -> Assertions.assertEquals(5, result2)
        );

        Assertions.assertEquals(9, result3);
    }

    //@Disabled
    @Test
    public void whenMultiplyTwoNumbersCalled_shouldReturnValue() {
        float result = calculator.multiplyTwoNumbers(1, 2);

        Assertions.assertTrue(result == 2);
        Assertions.assertFalse(result == 4);
        Assertions.assertTrue(result != 0);
    }
}
