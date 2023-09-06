package shop.taeheoki.inflearnthejavatest;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    public void create_new_study() throws Exception {
        Study study = new Study(10);
        assertNotNull(study);
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
            @Override
            public String get() {
                return "스터디를 처음 만들면 상태값이 " + StudyStatus.DRAFT + "여야 한다.";
            }

            /**
             * 문자열 연산을 람다식으로 만들어 두면 문자열 연산을 최대한 필요한 순간으로 넘길 수 있다.
             * 단순하게 문자열을 집어 넣어두면 무조건 연산이 이루어진다.
             * 이러한 부분에서 성능 개선을 가져갈 수 있다.
             */
        });
        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0 보다 커야 한다.");

        /**
         * 에러가 발생할 때 순차적으로 작동하게 되는데 이를 한번에 에러를 확인하는 방법이 있다.
         */
        assertAll(
                () -> assertNotNull(study),
                () ->  assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다."),
                () ->assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0 보다 커야 한다.")
        );
    }

    @Test
//    @Disabled
    @DisplayName("스터디 만들기 (๓° ˘ °๓)♡")
    public void create_new_study_again() throws Exception {
        System.out.println("create1");
    }

    @Test
    public void studyTest1() throws Exception {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertThat(message).isEqualTo("limit은 0보다 커야 한다.");
    }

    @Test
    @DisplayName("Timeout Test")
    public void studyTest2() throws Exception {
        assertTimeout(Duration.ofSeconds(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    @Test
    @DisplayName("TimeoutPreemptively Test")
    public void studyTest3() throws Exception {
        assertTimeoutPreemptively(Duration.ofSeconds(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
        // TODO ThreadLocal
    }

    @Test
    public void timeOutTest() throws Exception {
        assertTimeout(Duration.ofSeconds(10), () -> new Study(10));
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }
}