package Entities;

import Capacities.CapacityPool;
import Items.Armor;
import static Items.ArmorType.*;

import Items.Item;
import Items.Weapon;
import static Items.WeaponType.*;

public class Hero  extends Entity {
    private int currentXPPoints;
    private int requiredXpPoints;

    ///////////////////////////////////////////////////////////
    ////////////////     CONSTRUCTORS     /////////////////////
    ///////////////////////////////////////////////////////////

    public Hero (int baseAtk, int baseDef, int baseSpeed, int baseLifePoints) {
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpeed = baseSpeed;
        this.baseLifePoints = baseLifePoints;
        this.currentLifePoints = baseLifePoints;
        this.level = 1;
        this.weapon = new Weapon("Fist", 0, BLUNT);
        this.armor = new Armor("Skin",0,0,LIGHT);
        this.capacityPool = new CapacityPool();
        this.currentXPPoints = 0;
        this.requiredXpPoints = 10;
    }

    ///////////////////////////////////////////////////////////
    ////////////////     DISPLAY       ////////////////////////
    ///////////////////////////////////////////////////////////

    /**
     * Display Hero's current characteristics
     */
    public void displayHero () {
        System.out.println("HERO");
        System.out.println("Level : " + this.level);
        System.out.println("Life points : " + this.currentLifePoints);
        System.out.println("Attack  : " + (this.baseAtk + this.weapon.getUpdateAtk()));
        System.out.println("Defense : " + (this.baseDef + this.armor.getUpdateDef()));
        System.out.println("Speed   : " + (this.baseSpeed + this.armor.getUpdateSpeed()));
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////          GETTERS AND SETTERS          ////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////


    public int getCurrentXPPoints() {
        return currentXPPoints;
    }

    public int getRecquiredXpPoints() {
        return requiredXpPoints;
    }

    public void setCurrentXPPoints(int currentXPPoints) {
        this.currentXPPoints = currentXPPoints;
    }

    public void setRecquiredXpPoints(int requiredXpPoints) {
        this.requiredXpPoints = requiredXpPoints;
    }



    ///////////////////////////////////////////////////////////
    ////////////////     METHODS       ////////////////////////
    ///////////////////////////////////////////////////////////

    /**
     * Make the hero earn experience points
     * @param numberXPpoints : the amount of experience points
     *                       /!\ NEED TO BE POSITIVE
     */
    public void earnXP (int numberXPpoints) {
        this.currentXPPoints = this.currentXPPoints + numberXPpoints;
        System.out.println("You earned "+ numberXPpoints +" XP !");

        this.levelUp();

        System.out.println("XP to next level : " + (requiredXpPoints + currentXPPoints));
    }

    /**
     * Make the hero level up if he reached enough experience points
     */
    public void levelUp() {
        if (this.currentXPPoints >= this.requiredXpPoints) {
            this.level ++;
            this.currentXPPoints = this.currentXPPoints - this.requiredXpPoints;
            System.out.println("Congratulation, you reached level "+ this.level +" !");
            this.requiredXpPoints = level * 10;
        }
    }

    /**
     * Change Hero's current Item with the new one looted
     * @param item : the Item the Hero wants to loot
     */
    public void lootItem (Item item) {
        if (item instanceof Weapon) {
            this.weapon = (Weapon) item;
        } else {
            this.armor = (Armor) item;
        }
    }

}
