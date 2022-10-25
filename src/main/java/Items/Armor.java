package Items;

import static Util.Util.random;
import static Items.ArmorType.*;

public class Armor extends Item{
    /**
     * the amount of defense added by the weapon (must be positive)
     */
    private int updateDef;
    /**
     * the amount of speed added by the weapon (can be negative for HEAVY armors)
     */
    private int updateSpeed;
    /**
     * the type of the Armor (must be among ArmorType list)
     */
    private final ArmorType type;



    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////     CONSTRUCTORS     /////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Full Constructor for Armor
     * @param name the name of the armor
     * @param updateDef the amount of defense added by the weapon (must be positive)
     * @param updateSpeed the amount of speed added by the weapon (can be negative for HEAVY armors)
     * @param type the type of the Armor (must be among ArmorType list)
     */
    public Armor (String name, int updateDef, int updateSpeed, ArmorType type) {
        this.name = name;
        this.updateSpeed = updateSpeed;
        this.updateDef = updateDef;
        this.type = type;
        this.isDroppable = !name.equals("Skin");
    }

    /**
     * Random Constructor for Armor knowing the name and the type
     * @param name the name of the armor
     * @param level the level of the Entity
     * @param type the type of the Armor (must be among ArmorType list)
     * @return the Armor created
     */
    public static Armor createRandomArmor(String name, int level, ArmorType type) {
        // update for heavy armor
        int minDefHeavy = level;
        int maxDefHeavy = (3 * level) / 2;
        int minSpeedHeavy = level / 2;
        int maxSpeedHeavy = level;

        // update for light armor
        int minDefLight = 1;
        int maxDefLight = (3 * level) / 4;
        int minSpeedLight = level / 2;
        int maxSpeedLight = level;

        return switch (type) {
            case HEAVY -> new Armor(
                    name,
                    random(maxDefHeavy, minDefHeavy),
                    -random(maxSpeedHeavy, minSpeedHeavy),
                    type);
            default -> new Armor(
                    name,
                    random(maxDefLight, minDefLight),
                    random(maxSpeedLight, minSpeedLight),
                    type);
        };
    }

    public static Armor createRandomArmor(int level){
        return switch (random(2,1)) {
            case 1 -> createRandomArmor("Cuirass", level, HEAVY);
            default -> createRandomArmor("Toga", level, LIGHT);
        };
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////     DISPLAY       //////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void displayItem(){
        System.out.println("Item    : ARMOR");
        System.out.println("Name    : " + this.name);
        System.out.println("Type    : " + this.type);
        System.out.println("Defense : " + this.updateDef);
        System.out.println("Speed   : " + this.updateSpeed);

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////          GETTERS AND SETTERS          ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public int getUpdateDef() {
        return updateDef;
    }

    public int getUpdateSpeed() {
        return updateSpeed;
    }

    public ArmorType getType() {
        return type;
    }

    public void setUpdateDef(int updateDef) {
        this.updateDef = updateDef;
    }

    public void setUpdateSpeed(int updateSpeed) {
        this.updateSpeed = updateSpeed;
    }
}
