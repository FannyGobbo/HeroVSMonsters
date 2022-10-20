package Items;

import java.util.Random;

public class Weapon extends Item{
    int updateAtk;
    WeaponType type;


    ///////////////////////////////////////////////////////////
    ////////////////     CONSTRUCTORS     /////////////////////
    ///////////////////////////////////////////////////////////

    public Weapon (String name, int updateAtk, WeaponType type) {
        this.name = name;
        this.updateAtk = updateAtk;
        this.type = type;
    }

    public static Weapon createRandomWeapon (String name, int level, WeaponType type) {
        Random rand = new Random();

        // update attack
        int min = level/2;
        int max = (3 * level) / 2;

        return new Weapon(
                name,
                rand.nextInt(max - min + 1) + min,
                type
        );
    }


    ///////////////////////////////////////////////////////////
    ////////////////     DISPLAY       ////////////////////////
    ///////////////////////////////////////////////////////////

    public void displayWeapon(){
        System.out.println("Item    : WEAPON");
        System.out.println("Name    : " + this.name);
        System.out.println("Type    : " + this.type);
        System.out.println("Attack  : " + this.updateAtk);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////          GETTERS AND SETTERS          ////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

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
