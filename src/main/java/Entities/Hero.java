package Entities;

import Capacities.Capacity;
import Capacities.CapacityPool;
import Dungeon.MonsterRoom;
import Dungeon.Room;
import Items.Armor;
import static Items.ArmorType.*;

import Items.Item;
import Items.Weapon;

import java.util.Scanner;

import static Items.WeaponType.*;
import static Util.GameOutput.*;

public class Hero  extends Entity {
    private int currentXPPoints;
    private int requiredXpPoints;

    // TODO add "stonks coins" to spend in shops in the dungeon

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////     CONSTRUCTORS     ///////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

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

    public static Hero createHero(){
        int pointsToAttribute = 15;
        Hero hero = new Hero(3,3,1,10);

        hero.improveCharac(pointsToAttribute);

        return hero;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////     DISPLAY       //////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Display Hero's current characteristics
     */
    @Override
    public void displayEntity () {
        System.out.println("HERO");
        System.out.println("Level : " + this.level);
        System.out.println("Life points : " + this.currentLifePoints);
        System.out.println("Attack  : " + (this.baseAtk + this.weapon.getUpdateAtk()));
        System.out.println("Defense : " + (this.baseDef + this.armor.getUpdateDef()));
        System.out.println("Speed   : " + (this.baseSpeed + this.armor.getUpdateSpeed()));
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////          GETTERS AND SETTERS          ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////


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



    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////     METHODS       //////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Capacity useCapacity() {
        Scanner scanner = new Scanner(System.in);

        capacityDisplay(this.capacityPool);
        capacityChoiceLine();

        do {
            String input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "QUICK" :
                    return this.capacityPool.getQuick();
                case "NORMAL" :
                    return this.capacityPool.getNormal();
                case "STRONG" :
                    return this.capacityPool.getStrong();
                case "DEFENSE" :
                    return this.capacityPool.getDefense();
                default:
                    break;
            }
        } while (true);
    }


    /**
     * Make the hero earn experience points
     * @param numberXPpoints : the amount of experience points
     *                       /!\ NEED TO BE POSITIVE
     */
    public void earnXP (int numberXPpoints) {
        this.currentXPPoints = this.currentXPPoints + numberXPpoints;
       xpEarnedLine(numberXPpoints);

        this.levelUp();

        xpToNextLevelLine(requiredXpPoints - currentXPPoints);
    }

    /**
     * Make the hero level up if he reached enough experience points
     */
    public void levelUp() {
        if (this.currentXPPoints >= this.requiredXpPoints) {
            this.level ++;
            this.currentXPPoints = this.currentXPPoints - this.requiredXpPoints;
            levelUpLine(this.level);
            this.requiredXpPoints = level * 10;
            this.improveCharac(1);
        }
    }

    /**
     * Change Hero's current Item with the new one looted
     * @param item : the Item the Hero wants to loot
     */
    private void lootItem (Item item) {
        if (item instanceof Weapon) {
            this.weapon = (Weapon) item;
        } else {
            this.armor = (Armor) item;
        }
    }

    private void improveCharac (int characPoints) {
        Scanner scan = new Scanner(System.in);
        int inputCharac, inputPoints;

        while (characPoints != 0) {
            heroCreationScreen(this.baseAtk, this.baseDef, this.baseSpeed, this.baseLifePoints);
            characPointsRemainingLine(characPoints);
            newLine();
            characChoiceLine();

            inputCharac = scan.nextInt();
            if (inputCharac >=1 && inputCharac <=4) {
                enterCharacLine(inputCharac);
                inputPoints = scan.nextInt();
                if (inputPoints <= characPoints && inputPoints > 0) {
                    switch (inputCharac) {
                        case 1:
                            this.baseAtk += inputPoints;
                            break;
                        case 2:
                            this.baseDef += inputPoints;
                            break;
                        case 3:
                            this.baseSpeed += inputPoints;
                            break;
                        case 4:
                            this.baseLifePoints += inputPoints;
                            break;
                        default:
                            break;
                    }
                    characPoints -= inputPoints;
                }
            }
        }
    }

    public void pickUpLoot(Item item) {
        Scanner scan = new Scanner(System.in);
        if (item != null) {
            itemDroppedLines(item);
            heroCurrentItemLine(this, item);
            lootChoiceLine();
            switch (scan.nextLine().toUpperCase()){
                case "YES" :
                    this.lootItem(item);
                    itemLootedLine();
                    break;
                default:
                    break;
            }
        }
    }
}
