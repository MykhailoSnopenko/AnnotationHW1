import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Class<?> cls = Main.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method: methods) {
            if(method.isAnnotationPresent(MethodAnnotation.class)) {
                MethodAnnotation  annot = method.getAnnotation(MethodAnnotation.class);
                try {
                    method.invoke(null, annot.a(), annot.b());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @MethodAnnotation(a = 6, b = 5)
    public static void test(int a, int b) {
        System.out.println("Sum a + b = " + (a + b));
    }
}