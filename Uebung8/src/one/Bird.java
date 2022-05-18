package one;

public class Bird extends Animal {

    public Bird(String name) {

        super(name);
    }

    @Override
    String move() {
        return "fly";
    }

    @Override
    String say() {
        return "tweet";
    }


}
