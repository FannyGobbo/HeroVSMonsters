package Dungeon;

import Entities.Hero;

import static Dungeon.RoomType.FIRST;

public class FirstRoom extends Room{
    // constructor

    public FirstRoom(Hero hero) {
        this.number = 1;
        this.type = FIRST;
        this.isFinished = true;
    }

    @Override
    public void finishRoom(Hero hero) {
    }
}
