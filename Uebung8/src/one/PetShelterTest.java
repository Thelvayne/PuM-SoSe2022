package one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetShelterTest

{
    static Cat catCat = new Cat("katz");
    static Dog dogDog = new Dog("hund");
    static Mammal catMammal = new Cat("catMammal");
    static Mammal dogMammal = new Dog("dogMammal");
    static Mammal mammal = new Mammal("mam");

    static Bird bird = new Bird("vogel");
    static Bird penguinBird = new Penguin("penguinMammal");
    static Penguin penguin = new Penguin("penguin");

    static Reptile reptile = new Reptile("reptile");
    static Reptile lizardReptile = new Lizard("lizardReptile");
    static Lizard lizard = new Lizard("lizard");

    static Fish fish = new Fish("fisch");
    static Fish fishSun = new Sunfish("sunfisch");
    static Sunfish sunfish = new Sunfish("sun");

    static Animal animal = new Animal("tier");
    static Animal animalBird = new Bird("tiervogel");
    static Animal animalMammal = new Mammal("tiermammel");
    static Animal animalReptile = new Reptile("tierreptil");
    static Animal animalFish = new Fish("tierfish");

    static Animal animalDog = new Dog("tierhund");
    static Animal animalCat = new Cat("tierkatz");
    static Animal animalPenguin = new Penguin("tierguin");
    static Animal animalLizard = new Lizard("tierlurch");
    static Animal animalSunfish = new Sunfish("tiersonne");

    @Test // 1
    void testSay()
    {
        assertEquals("meow",catCat.say());
        assertEquals("woof",dogDog.say());

        //mammal hat keine overwriting say(), doch cat ist datentyp cat und überschreibt say() [analog dasselbe wie dog]
        assertEquals("meow",catMammal.say());
        assertEquals("woof",dogMammal.say());

        //super(mammal) hat kein overwriting say() -> animal -> animal.say() = "silence"
        assertEquals("silence",mammal.say());
        assertEquals("silence",animalMammal.say());
    }

    @Test // 3
    void testMove()
    {
        assertEquals("fly",bird.move());
        assertEquals("fly",animalBird.move());

        assertEquals("waddle",penguinBird.move());
        assertEquals("waddle",penguin.move());
    }

    @Test // 6
    void testPolymorph()
    {
        assertInstanceOf(lizard.getClass(),animalLizard);
        assertInstanceOf(lizard.getClass(),animalLizard);
        assertInstanceOf(lizard.getClass().getSuperclass(),reptile);
        assertInstanceOf(lizard.getClass().getSuperclass().getSuperclass(),animal);
    }


}
