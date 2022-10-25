package Game;

import Dungeon.Dungeon;
import Entities.*;
import Items.*;
import static Items.ArmorType.*;
import static Items.WeaponType.*;
import static Util.GameOutput.heroCreationScreen;
import static Util.Util.*;

public class Play {
    public static void main(String[] args) {
        // to uncomment to play
        // Hero hero = Hero.createHero();

        // gameplay test
        Hero hero = new Hero(9,9,9,15);

        Dungeon dungeon = new Dungeon(hero);

        dungeon.run(hero);
    }
}
