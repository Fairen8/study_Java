import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    static User user = null;

    @BeforeAll
    public static void setUp() {
        user = new User("login", "example@gmail.com");
    }
    @AfterAll
    public static void tearDown() {
        user = null;
    }

    @Test
    @DisplayName("Проверка создания объекта без параметров")
    public void testEmptyOb() {
        User user1 = new User();
        assertNull(user1.email);
        assertNull(user1.login);
    }

    @Nested
    @DisplayName("Проверка создания объекта с двумя параметрами")
    class testOb {

        @Test
        @DisplayName("Установка login")
        public void inputLogin() {
            assertEquals(user.login, "login");
        }
        @Test
        @DisplayName("Установка email")
        public void inputEmail() {
            assertEquals(user.email, "example@gmail.com");
        }
    }

    @Nested
    @DisplayName("Проверка некорректного ввода")
    class incorrectInput {

        static User user = null;

        @BeforeAll
        public static void setUp() {
            user = new User("log", "examplegmail");
        }
        @AfterAll
        public static void tearDown() {
            user = null;
        }

        @Test
        @DisplayName("Login")
        public void incorrectLogin() {
            assertEquals(user.login, "error");
        }
        @Test
        @DisplayName("Email")
        public void incorrectEmail() {
            assertEquals(user.email, "error");
        }
    }

}
