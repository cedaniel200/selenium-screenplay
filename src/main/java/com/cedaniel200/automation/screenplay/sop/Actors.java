package com.cedaniel200.automation.screenplay.sop;

import java.util.HashMap;

public class Actors {
    private static HashMap<String, Actor> actorHashMap;
    private static String lastNameActor = "anonymous";

    private Actors() {
    }

    public static Actor theActorCalled(String name){
        Actor actor = new Actor(name);
        Actors.registerActor(actor);
        return actor;
    }

    public static void onStage(String name) {
        lastNameActor = name;
    }

    public static void registerActor(Actor actor){
        createHashMapIfRequired();
        actorHashMap.put(actor.getName(), actor);
    }

    public static Actor theActorInTheSpotlight(){
        createHashMapIfRequired();
        return actorHashMap.get(lastNameActor);
    }

    private static void createHashMapIfRequired() {
        if(actorHashMap == null){
            actorHashMap = new HashMap<>();
        }
    }

}
