package Dungeon;

import Entities.*;

import static Dungeon.RoomType.BOSS;

public class BossRoom extends MonsterRoom{
    public BossRoom(Hero hero, int roomNumber) {
        super(hero, roomNumber);
        this.type = BOSS;
        this.monster = new Monster(hero.getLevel() +1);
    }

}
