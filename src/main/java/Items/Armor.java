package Items;

import java.util.Random;

public class Armor {
    private int updateDef;
    private int updateSpeed;
    private ArmorType type;



    ///////////////////////////////////////////////////////////
    ////////////////     CONSTRUCTORS     /////////////////////
    ///////////////////////////////////////////////////////////

    public Armor (int updateDef, int updateSpeed, ArmorType type) {
        this.updateSpeed = updateSpeed;
        this.updateDef = updateDef;
        this.type = type;
    }

    public static Armor createRandomArmor(int level, ArmorType type) {
        Random rand = new Random();
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
                    rand.nextInt(maxDefHeavy - minDefHeavy + 1) + minDefHeavy,
                    -(rand.nextInt(maxSpeedHeavy - minSpeedHeavy + 1) + minSpeedHeavy),
                    type);
            default -> new Armor(
                    rand.nextInt(maxDefLight - minDefLight + 1) + minDefLight,
                    rand.nextInt(maxSpeedLight - minSpeedLight + 1) + minSpeedLight,
                    type);
        };
    }


    ///////////////////////////////////////////////////////////
    ////////////////     DISPLAY       ////////////////////////
    ///////////////////////////////////////////////////////////

    public void displayArmor(){
        System.out.println("Item    : ARMOR");
        System.out.println("Type    : " + this.type);
        System.out.println("Defense : " + this.updateDef);
        System.out.println("Speed   : " + this.updateSpeed);

    }

    ///////////////////////////////////////////////////////////
    /////////////     GETTERS AND SETTERS     /////////////////
    ///////////////////////////////////////////////////////////
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
