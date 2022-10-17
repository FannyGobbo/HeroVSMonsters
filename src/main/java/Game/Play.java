package Game;

import Items.*;
import static Items.ArmorType.*;
import static Items.WeaponType.*;

public class Play {
    public static void main(String[] args) {

        // test creation armor
        /*
        Armor armor = Armor.createRandomArmor(5, HEAVY);
        armor.displayArmor();
        */

        // test creation weapon
        Weapon weapon = Weapon.createRandomWeapon(5, SHARP);
        weapon.displayWeapon();


    }
}
