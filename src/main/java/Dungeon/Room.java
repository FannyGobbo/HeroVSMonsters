package Dungeon;

import Entities.*;

import static Dungeon.RoomType.*;

public abstract class Room {
    protected int number;
    protected RoomType type;
    protected boolean isFinished;


    // getters and setters

    public int getNumber() {
        return number;
    }

    public RoomType getType() {
        return type;
    }


    // method

    /**
     * finish the current room
     */
    public abstract void finishRoom(Hero hero);


}
