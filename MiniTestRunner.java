import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class MyTests {

    @Run
    public void testOne() {
        System.out.println("Test One Passed");
    }

    @Run
    public void testTwo() {
        System.out.println("Test Two Passed");
    }

    public void testThree() {
        System.out.println("Test Three");
    }

    @Run
    public void testFour() {
        System.out.println("Test Four Passed");
    }
}

public class MiniTestRunner {

    public static void main(String[] args) {

        MyTests obj = new MyTests();
        int count = 0;

        Method[] methods = MyTests.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Run.class)
                    && method.getParameterCount() == 0) {

                try {
                    method.invoke(obj);
                    count++;
                } catch (Exception e) {
                    System.out.println("Test failed: " + method.getName());
                }
            }
        }

        System.out.println("Total tests ran: " + count);
        System.out.println("25CE057");
    }
}
