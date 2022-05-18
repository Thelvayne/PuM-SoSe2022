package one;

public class Penguin extends Bird
{
    public Penguin(String name) {
        super(name);
    }

    @Override
    String say() {
        return "noot noot";
    }

    @Override
    String move() {
        return "waddle";
    }

}
