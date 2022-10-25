package Dungeon;

import Entities.Hero;

import java.util.ArrayList;
import java.util.List;

import static Dungeon.RoomType.BOSS;
import static Util.GameOutput.newRoomLine;
import static Util.Util.random;

public class Stage {
    private List<Room> stageMap;
    private int stageNumber;
    private int amountOfRoom;
    private int amountOfRestRoom;
    private int currentRoomNumber;

    // constructor
    public Stage(int stageNumber, Hero hero) {
        this.stageNumber = stageNumber;
        this.amountOfRoom = stageNumber + 6;
        this.amountOfRestRoom = ((int) (10 / amountOfRoom)) + 1;
        this.stageMap = new ArrayList<Room>();
        int restRoomPosition = random(amountOfRoom - 2, 1);

        this.stageMap.add(new FirstRoom(hero));
        for (int i = 0; i < amountOfRoom - 2; i++) {
            if (restRoomPosition != i) {
                this.stageMap.add(new MonsterRoom(hero, i+2));
            } else {
                this.stageMap.add(new RestRoom(hero, i+2));
            }
        }
        this.stageMap.add(new BossRoom(hero, amountOfRoom));
        this.currentRoomNumber = 0;
    }

    // getters and setters
    public int getStageNumber() {
        return stageNumber;
    }

    // method
    public void nextRoom (){
        if (currentRoomNumber < amountOfRoom) {
            this.currentRoomNumber++;
        }
    }

    public void runStage (Hero hero){
        while (this.stageMap.get(this.currentRoomNumber).type != BOSS && hero.isStillAlive()){
            this.stageMap.get(this.currentRoomNumber).finishRoom(hero);
            if (this.stageMap.get(this.currentRoomNumber).isFinished) {
                nextRoom();
                newRoomLine(this.stageNumber, this.stageMap.get(this.currentRoomNumber));
            }
        }
    }
}
