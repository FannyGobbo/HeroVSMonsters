package Dungeon;

import Entities.*;

public interface Battle {

    /**
     * run a single duel between the Hero and the Monster
     * @param hero the Hero
     * @param monster the Monster
     */
    void duel(Hero hero, Monster monster);

    /**
     * run the full battle between the Hero and the Monster
     * @param hero the Hero
     * @param monster the Monster
     * @return true if the Hero won the battle and false if the monster did
     */
    void fullBattle (Hero hero, Monster monster);

}
