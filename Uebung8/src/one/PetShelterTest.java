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
    void testAnimal()
    {
        assertEquals("silence",animal.say());
        assertEquals("walk",animal.move());

        assertEquals("silence",animalMammal.say());
        assertEquals("walk",animalMammal.move());

        assertEquals("meow",animalCat.say());
        assertEquals("walk",animalCat.move());

        assertEquals("woof",animalDog.say());
        assertEquals("walk",animalDog.move());

        assertEquals("tweet",animalBird.say());
        assertEquals("fly",animalBird.move());

        assertEquals("ssssssssss",animalLizard.say());
        assertEquals("crawl",animalLizard.move()); // (super)lizard -> crawl

        assertEquals("silence",animalReptile.say());
        assertEquals("crawl",animalReptile.move());

        assertEquals("blub",animalFish.say());
        assertEquals("swim",animalFish.move());

        assertEquals("blub",animalSunfish.say());
        assertEquals("swim",animalSunfish.move());

        assertEquals("noot noot",animalPenguin.say());
        assertEquals("waddle",animalPenguin.move());
    }

    @Test // 3
    void testMammal()
    {

        //mammal hat keine overwriting say(), doch cat ist datentyp cat und überschreibt say() [analog dasselbe wie dog]
        assertEquals("woof",dogMammal.say());
        assertEquals("walk",dogMammal.move());

        assertEquals("meow",catMammal.say());
        assertEquals("walk",catMammal.move());

        //super(mammal) hat kein overwriting say() -> animal -> animal.say() = "silence"
        assertEquals("silence",mammal.say());
        assertEquals("walk",mammal.move());
    }

    @Test // 6
    void testReptile()
    {
        assertEquals("silence",reptile.say());
        assertEquals("crawl",reptile.move());

        assertEquals("ssssssssss",lizardReptile.say());
        assertEquals("crawl",lizardReptile.move());
    }

    void testFish(){

        assertEquals("blub",fish.say());
        assertEquals("swim",fish.move());

        //sunfish hat keine überschreibenden Methoden
        assertEquals("blub",fishSun.say());
        assertEquals("swim",fishSun.move());
    }

    void testBird(){

        assertEquals("tweet",bird.say());
        assertEquals("fly",bird.move());

        assertEquals("noot noot",penguinBird.say());
        assertEquals("waddle",penguinBird.move());

    }

    void testDog(){
        assertEquals("woof",dogDog.say());
        assertEquals("walk",dogDog.move());
    }

    void testCat(){

        assertEquals("meow",catCat.say());
        assertEquals("walk",catCat.move());
    }

    void testLizard(){

        assertEquals("ssssssssss",lizard.say());
        assertEquals("crawl",lizard.move());
    }

    void testPenguin(){
        assertEquals("noot noot",penguin.say());
        assertEquals("waddle",penguin.move());
    }
    void testSunfish(){

        assertEquals("blub",sunfish.say());
        assertEquals("swim",sunfish.move());
    }

    void testPolymorph()
    {
        assertInstanceOf(lizard.getClass(),animalLizard);
        assertInstanceOf(lizard.getClass(),animalLizard);
        assertInstanceOf(lizard.getClass().getSuperclass(),reptile);
        assertInstanceOf(lizard.getClass().getSuperclass().getSuperclass(),animal);
    }
}
