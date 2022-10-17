package Items;

import java.util.Random;

public class Weapon {
    int updateAtk;
    WeaponType type;


    ///////////////////////////////////////////////////////////
    ////////////////     CONSTRUCTORS     /////////////////////
    ///////////////////////////////////////////////////////////

    public Weapon (int updateAtk, WeaponType type) {
        this.updateAtk = updateAtk;
        this.type = type;
    }

    public static Weapon createRandomWeapon (int level, WeaponType type) {
        Random rand = new Random();

        // update attack
        int min = level/2;
        int max = (3 * level) / 2;

        return new Weapon(
                rand.nextInt(max - min + 1) + min,
                type
        );
    }


    ///////////////////////////////////////////////////////////
    ////////////////     DISPLAY       ////////////////////////
    ///////////////////////////////////////////////////////////

    public void displayWeapon(){
        System.out.println("Item    : WEAPON");
        System.out.println("Type    : " + this.type);
        System.out.println("Defense : " + this.updateAtk);
    }


    ///////////////////////////////////////////////////////////
    ////////////     GETTERS AND SETTERS     //////////////////
    ///////////////////////////////////////////////////////////


    public int getUpdateAtk() {
        return updateAtk;
    }

    public WeaponType getType() {
        return type;
    }

    public void setUpdateAtk(int updateAtk) {
        this.updateAtk = updateAtk;
    }
}
