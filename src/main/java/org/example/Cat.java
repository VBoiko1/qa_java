package org.example;

import java.util.List;

public class Cat {

    Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }

    public String getSound() {
        return "Мяy";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
