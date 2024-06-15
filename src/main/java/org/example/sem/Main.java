package org.example.sem;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        Person unnamed = new Person();
        Person person = new Person("personame");

        //конструкторы
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class);
        Person personNew = constructor.newInstance("name");
        System.out.println(personNew);

        //методы
        Method getName = Person.class.getMethod("getName");
        System.out.println(getName.invoke(unnamed));

        Method setAge = Person.class.getMethod("setAge", int.class);
        setAge.invoke(unnamed, 10);
        System.out.println(unnamed);

        //методы статические
        System.out.println(Person.getCounter());
        Method counter = Person.class.getMethod("getCounter");
        System.out.println(counter.invoke(null));

        //поля
        Field name = Person.class.getDeclaredField("name");
        //или set(classObj, value)
        System.out.println("name.get(unnamed) = " + name.get(unnamed));

        //получение классов выше
        ExtPerson.class.getSuperclass(); //Person.class
        Class<Person> pc = Person.class;
        Class<? super ExtPerson> extc = ExtPerson.class.getSuperclass();

        System.out.println(pc);
        System.out.println(extc);

        //получение интерфейсов
        Class<?>[] interfaces = ArrayList.class.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

    }

    private static class ExtPerson extends Person{}


    private static class Person{
        public static long counter = 0L;

        private final String name;
        private int age;

        public Person(){
            this("unnamed");
        }

        public Person(String name){
            this.name = name;
            counter++;
        }

        public static long getCounter() {
            return counter;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
