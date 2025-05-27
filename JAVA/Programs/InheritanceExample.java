package Programs;
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class InheritanceExample {

	public static void main(String[] args) {
		Animal genericAnimal = new Animal();
        Dog dog = new Dog();

        System.out.print("Animal sound: ");
        genericAnimal.makeSound();

        System.out.print("Dog sound: ");
        dog.makeSound();

	}

}
