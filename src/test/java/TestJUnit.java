import org.example.Calculator;

import org.example.Person;
import org.junit.jupiter.api.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestJUnit {
    private static long startTime;
    private static long testStartTime;

    @BeforeAll
    public static void initSetup() {
        System.out.println("Старт");
        startTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSetup() {
        System.out.println("Проверка строки завершена: " + (System.nanoTime() - startTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Начинаем новое");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalTest() {
        System.out.println("Тест завершон: " + (System.nanoTime() - testStartTime));
    }

    @Test
    public void testCikl() {
        int a = 4;
        int b = 5;
        int result = 9;
        int expi = Calculator.slj(a, b);
        assertThat(result, lessThanOrEqualTo(expi));
        //assertEquals(result, expi);
    }

    @Test
    public void testDev() {
        try {
            int a = 8;
            int b = 0;
            int result = 8;
            int expi = Calculator.dev(a, b);
            assertThat(result, lessThanOrEqualTo(expi));
            assertEquals(result, expi);
        } catch (Exception e) {
            System.out.println("Делить на 0 нелзя!");
        }
    }

    @Test
    public void testString() {
        String a = "Hello";
        String b = "World";
        String expeted = "Hello World";

        String result = Calculator.HeloWorld(a, b);
        assertThat(expeted, equalToIgnoringCase(result));
        //assertEquals(expeted, result);
    }

    @Test
    public void thenCorrect() {
        Person person1 = new Person("Olya", "Ykutsk");
        Person person2 = new Person("Olya", "Ykutsk");
        assertThat(person1, samePropertyValuesAs(person2));
    }
    @Test
    public void strok() {

        assertThat(Calculator.stringCik(), isEmptyOrNullString());
    }
}
