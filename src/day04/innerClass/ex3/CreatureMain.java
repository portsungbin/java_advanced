package day04.innerClass.ex3;


class Crature{
    int life;

    Crature(Animal animal) {
        Animal animal1 = animal;
    }
    public void method1() {
        //Animal animal = new Animal();
    }
}

class Animal{}


public class CreatureMain {
    Animal animal = new Animal();
    Crature crature = new Crature(animal);


}
