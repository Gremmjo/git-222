package Java_lection_1.ComparableAndComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {

        Student st1 = new Student("Kostya", "Nyamsty", 22, 96);
        Student st2 = new Student("Kostya", "Dobrov", 21, 92);
        Student st3 = new Student("Anna", "Spiridovich", 23, 100);
        Student st4 = new Student("Oleg", "Verbetskiy", 23, 92);

        List<Student> list = Arrays.asList(new Student[]{st1, st2, st3, st4});
        System.out.println("Before sorting : " + list);

        Collections.sort(list, new NameLenghtComparator());
        System.out.println("After sortings : " + list);
    }
public  static class NameLenghtComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().length() - o2.getName().length();
    }
}
    public static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int res = s1.getName().compareTo(s2.getName());
            if (res == 0){
                res = s1.getSurname().compareTo(s2.getSurname());
                return res;
            }
            return res;
        }
    }


    public static class Student implements Comparable<Student>{

        private String name;
        private String Surname;
        private int age;
        private int edPoints;

        public Student(String name, String surname, int age, int edPoints) {
            this.name = name;
            Surname = surname;
            this.age = age;
            this.edPoints = edPoints;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", Surname='" + Surname + '\'' +
                    ", age=" + age +
                    ", edPoints=" + edPoints +
                    '}';
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return Surname;
        }

        public int getAge() {
            return age;
        }

        public int getEdPoints() {
            return edPoints;
        }

        @Override
        public int compareTo(Student that) {
            int res = this.getEdPoints() - that.getEdPoints();
            if(res == 0){
                res =  this.getAge() - that.getAge();
                return res;

            }
            return res;
        }
    }
}
