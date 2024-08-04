import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Vinod John
 * @Date 03.08.2024
 */
public class AssertJExample {

    @Test
    public void stringTest() {
        String str = "I'm a Java Developer";

        Assertions.assertThat(str)
                .contains("Java")
                .isNotEmpty()
                .doesNotStartWith("A")
                .endsWith("r");
    }
}
