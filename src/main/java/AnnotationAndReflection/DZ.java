package AnnotationAndReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Напишите класс, который бы на основе рефлексии создавал новые экземпляры DZ, обращался бы к их методам
 * getSumInteger и  getSumFromList
 * и выводил результаты в консоль
 */

public class DZ {

    private int i;
    private String s;
    private List<Double> list = new ArrayList<>();

    private DZ() {
    }

    public DZ(Integer i, String s) {
        this.i = i;
        this.s = s;
    }

    public DZ(Integer i, String s, List<Double> list) {
        this.i = i;
        this.s = s;
        this.list = list;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public List<Double> getList() {
        return list;
    }

    public void setList(List<Double> list) {
        this.list = list;
    }

    private int getSumInteger(DZ dz1, DZ dz2) {
        return dz1.getI() + dz2.getI();
    }

    private List<Double> getSumFromList(DZ dz1, DZ dz2) {
        return Stream.concat(dz1.getList().stream(), dz2.getList().stream()).collect(Collectors.toList());
    }

}

class ReflectionDZ {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Constructor constructor = DZ.class.getConstructor(Integer.class, String.class); // DZ_Solution(int i, String s)

        DZ builder = (DZ)
                constructor.newInstance(1, "string");
        DZ builder2 = (DZ)
                constructor.newInstance(2, "string");

        // просто получение информации

        Constructor[] constructors = DZ.class.getConstructors();
        Field[] fields = DZ.class.getFields();
        Method[] methods = DZ.class.getDeclaredMethods();

        // просто получение информации


        /**
         * Доступ к закрытым методам осуществляется с помощью методов Class.getDeclaredMethod(String name, Class[] parameterTypes) или Class.getDeclaredMethods().
         */


        Method getSumInteger = DZ.class.
                getDeclaredMethod("getSumInteger", new Class[]{DZ.class, DZ.class});
        getSumInteger.setAccessible(true);
        int sumInteger = (Integer)
                getSumInteger.invoke(builder, builder, builder2);
        System.out.println(sumInteger);


        Constructor constructor2 = DZ.class.getConstructor(Integer.class, String.class, List.class); // DZ_Solution(Integer i, String s, List<Double> list)

        DZ builder3 = (DZ)
                constructor2.newInstance(1, "string", Arrays.asList(1.2, 45.6, 33, 9));
        DZ builder4 = (DZ)
                constructor2.newInstance(1, "string", Arrays.asList(1.2, 45.6, 33, 9));

        Method getSumFromList = DZ.class.
                getDeclaredMethod("getSumFromList", new Class[]{DZ.class, DZ.class});
        getSumFromList.setAccessible(true);
        List<Double> doubles = (List<Double>) getSumFromList.invoke(builder3, builder3, builder4);
        System.out.println(doubles);
    }

}
