package com.cedaniel200.automation.screenplay.sop;

import com.cedaniel200.automation.screenplay.actions.Action;
import com.cedaniel200.automation.screenplay.Question;
import com.cedaniel200.automation.screenplay.utils.DriverFactory;

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

    public void shouldSeeThat(Question question) {
        if(!question.answer(DriverFactory.getDriver()))
            throw new AssertionError();
    }
}
