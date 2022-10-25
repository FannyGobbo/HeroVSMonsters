package Dungeon;

import Capacities.Capacity;
import Entities.Entity;
import Entities.Hero;
import Entities.Monster;
import Items.Item;

import java.io.IOException;

import static Dungeon.RoomType.MONSTER;
import static Util.GameOutput.*;
import static Util.Util.random;

public class MonsterRoom extends Room implements Battle{
    protected Monster monster;

    // constructor
    public MonsterRoom (Hero hero, int roomNumber){
        this.monster = new Monster(hero.getLevel());
        this.number = roomNumber;
        this.type = MONSTER;
        this.isFinished = false;
    }


    // implementation of battle
    @Override
    public void duel(Hero hero, Monster monster) {
        battleInterface(hero, monster);
        Capacity heroCapacity = hero.useCapacity();
        Capacity monsterCapacity = monster.useCapacity();
        int heroAttack;
        int monsterAttack;

        // if monster is faster than hero
        if(monster.getAttackSpeed(monsterCapacity) > hero.getAttackSpeed(monsterCapacity)){
            monsterThrowsCapacityLine(monsterCapacity.getName());
            monster.attackOpponent(monsterCapacity, hero, heroCapacity);

            if (hero.isStillAlive()){
                heroThrowsCapacityLine(heroCapacity.getName());
                hero.attackOpponent(heroCapacity, monster, monsterCapacity);
            }

        } else {
            heroThrowsCapacityLine(heroCapacity.getName());
            hero.attackOpponent(heroCapacity, monster, monsterCapacity);

            if (monster.isStillAlive()) {
                monsterThrowsCapacityLine(monsterCapacity.getName());
                monster.attackOpponent(monsterCapacity, hero, heroCapacity);
            }
        }
    }

    @Override
    public void fullBattle(Hero hero, Monster monster) {
        while (hero.isStillAlive() && monster.isStillAlive()) {
            duel(hero, monster);
        }
    }



    // extends Room
    @Override
    public void finishRoom(Hero hero) {
        fullBattle(hero, this.monster);
        if (hero.isStillAlive()) {
            hero.earnXP(random(this.monster.getLevel()+3, this.monster.getLevel()));
            hero.pickUpLoot(this.monster.dropItem());
        }
        this.isFinished = hero.isStillAlive();
    }
}
