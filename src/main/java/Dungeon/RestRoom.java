package Dungeon;

import Entities.Hero;

import static Dungeon.RoomType.REST;
import static Util.GameOutput.restRoomLine;

public class RestRoom extends Room {
    public RestRoom(Hero hero, int roomNumber) {
        this.number = roomNumber;
        this.type = REST;
        this.isFinished = false;
    }

    // extends Room
    @Override
    public void finishRoom(Hero hero) {
        hero.getHeal(10);
        restRoomLine();
        this.isFinished = true;
    }
}
