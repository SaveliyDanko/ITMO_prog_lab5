import database.models.Flat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Test {
    public static void main(String[] args) {
        Class<?> clazz = Flat.class;
        Constructor<?>[] clazzConstructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : clazzConstructors){
            for (Parameter parameter : constructor.getParameters()){
                System.out.println(parameter.getType());
            }
        }

    }
}
