package Items;


import static Items.WeaponType.*;
import static Util.Util.random;

public class Weapon extends Item{
    /**
     * the amount of attack added by the weapon (must be positive)
     */
    int updateAtk;
    /**
     * the type of the weapon (must be in the WeaponType list)
     */
    WeaponType type;


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////     CONSTRUCTORS     /////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Full Constructor for Weapon
     * @param name the name of the weapon
     * @param updateAtk the amount of attack added by the weapon (must be positive)
     * @param type the type of the weapon (among WeaponType list)
     */
    public Weapon (String name, int updateAtk, WeaponType type) {
        this.name = name;
        this.updateAtk = updateAtk;
        this.type = type;
        this.isDroppable = !name.equals("Fist");
    }

    /**
     * Random Constructor for Weapon, knowing the name and the type
     * @param name the name of the weapon
     * @param level the level of the Entity (must be positive)
     * @param type the type of the weapon (must be in WeaponType list)
     * @return the Weapon created
     */
    public static Weapon createRandomWeapon (String name, int level, WeaponType type) {
        // update attack boundaries
        int min = level/2;
        int max = (3 * level) / 2;

        return new Weapon(
                name,
                random(max, min),
                type
        );
    }

    /**
     * Random Constructor for Weapon only knowing level
     * @param level the level of the Entity (must be positive)
     * @return the Weapon created
     */
    public static Weapon createRandomWeapon (int level) {
        return switch (random(3,1)) {
            case 1 -> createRandomWeapon("Sword", level, SHARP);
            case 2 -> createRandomWeapon("Spear", level, PIECRING);
            default -> createRandomWeapon("Bat", level, BLUNT);
        };
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////     DISPLAY       ////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void displayItem(){
        System.out.println("Item    : WEAPON");
        System.out.println("Name    : " + this.name);
        System.out.println("Type    : " + this.type);
        System.out.println("Attack  : " + this.updateAtk);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////          GETTERS AND SETTERS          ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

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
