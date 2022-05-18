package one;

public class Reptile extends Animal
{
    public Reptile(String name) {
        super(name);
    }

    @Override
    String move() {
        return "crawl";
    }
}
