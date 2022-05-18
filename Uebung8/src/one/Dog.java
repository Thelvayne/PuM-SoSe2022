package one;

public class Dog extends Mammal
{
    public Dog(String name) {

        super(name);
    }

    @Override
    String say() {
        return "woof";
    }
}
