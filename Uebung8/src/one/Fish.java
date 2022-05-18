package one;

public class Fish extends Animal
{
    public Fish(String name) {
        super(name);
    }

    @Override
    String move() {
        return "swim";
    }

    @Override
    String say() {
        return "blub";
    }
}
