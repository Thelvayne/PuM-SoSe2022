package one;

public class Animal {

    private String name;

    public String getName() {
        return name;
    }

    public Animal(String name) {
        this.name = name;
    }

    String move() {
        return "walk";
    }

    String say() {
        return "silence";
    }

    void interact() {
        System.out.println("Hello, my name is " + name +
                ", I usually like to " + move() +
                " around a lot, and when I'm happy, I usually go " + say() +
                "  all over the place");
    }
}
