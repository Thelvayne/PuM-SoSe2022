package one;

public class Cat extends Mammal
{
    public Cat(String name) {
        super(name);
    }

    @Override
    String say() {
        return "meow";
    }

    @Override
    void interact() {
        System.out.println("Hello human, my name is "+getName()+
            " and I expect you to give me food so that I can " +
                        move()+" away happily or I'll "+say()+
                        " as loud as I can for the rest of the day");
    }
}

