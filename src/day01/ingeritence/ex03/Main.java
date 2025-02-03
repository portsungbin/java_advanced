package day01.ingeritence.ex03;

public class Main {
    public static void personInfo(Person person) {
        System.out.println("name : " + person.name);
        person.running();
        if (person instanceof Student student) {
            System.out.println("학번은 : " + ((Student) person).studentNo);
            ((Student) person).study();
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("신세계");
        personInfo(p1);

        System.out.println();

        Person p2 = new Student("신동현", 1234567);
        personInfo(p2);

    }
}
