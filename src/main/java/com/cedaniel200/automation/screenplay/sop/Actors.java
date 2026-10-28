package com.cedaniel200.automation.screenplay.sop;

import java.util.HashMap;
import java.util.Map;

public class Actors {
    private static Map<String, Actor> actors = new HashMap<>();
    private static String lastNameActor = "anonymous";

    private Actors() {
    }

    public static Actor theActorCalled(String name) {
        Actor actor = new Actor(name);
        registerActor(actor);
        onStage(name);
        return actor;
    }

    public static void onStage(String name) {
        lastNameActor = name;
    }

    public static void registerActor(Actor actor) {
        actors.put(actor.getName(), actor);
    }

    public static Actor theActorInTheSpotlight() {
        return actors.get(lastNameActor);
    }

    public static void reset() {
        actors = new HashMap<>();
        lastNameActor = "anonymous";
    }
}
