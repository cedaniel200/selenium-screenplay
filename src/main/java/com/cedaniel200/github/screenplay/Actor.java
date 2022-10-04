package com.cedaniel200.github.screenplay;

import com.cedaniel200.github.util.DriverFactory;

import java.util.Arrays;

public class Actor {
    private final String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void attemptsTo(Action... actions){
        wasAbleTo(actions);
    }

    public void wasAbleTo(Action... actions){
        Actors.onStage(name);
        Arrays.stream(actions).forEach(action -> action.perform(DriverFactory.getDriver()));
    }

}
