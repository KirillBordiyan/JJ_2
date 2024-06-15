package org.example.sem.anno;


import org.example.sem.anno.lib.ObjectCreator;
import org.example.sem.anno.lib.Random;

public class AnnotationsMain {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getAge());

        Person personCreator = ObjectCreator.createObj(Person.class);
        System.out.println(personCreator.getAge());

        Person p = new Person();
        ExtPerson extp = new ExtPerson();

        System.out.println(p.getClass().isAssignableFrom(Person.class)); //true
        System.out.println(p.getClass().isAssignableFrom(ExtPerson.class)); //true

        System.out.println(extp.getClass().isAssignableFrom(Person.class)); // false
        System.out.println(extp.getClass().isAssignableFrom(ExtPerson.class)); // true

    }

    private static class ExtPerson extends Person {
    }

    private static class Person {
        @Random(min = 10, max = 40)
        private int age;


        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
