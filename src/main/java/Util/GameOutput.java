package Util;

import Capacities.CapacityPool;
import Dungeon.Room;
import Entities.*;
import Items.Armor;
import Items.Item;

import java.io.IOException;

public interface GameOutput {
    /**
     * display the capacity used by the monster
     * @param capacityName the capacity used by the monster
     */
    static void monsterThrowsCapacityLine(String capacityName) {
        System.out.println("Monster attack with " + capacityName + " !");
    }

    /**
     * display the capacity used by the hero
     * @param capacityName the capacity used by the hero
     */
    static void heroThrowsCapacityLine(String capacityName) {
        System.out.println("Hero attack with " + capacityName + " !");
    }

    /**
     * display the amount of damages dealt
     * @param damagesAmount the amount of damages dealt
     */
    static void damagesDealtLine(int damagesAmount) {
        System.out.println(damagesAmount + " damages dealt !");
    }

    /**
     * display the question for the choice of a capacity
     */
    static void capacityChoiceLine (){
        System.out.println("Which capacity do you want to use ?");
    }

    /**
     * display the xp earned by the hero
     * @param xpAmount the amount of xp earned
     */
    static void xpEarnedLine(int xpAmount) {
        System.out.println("You earned "+ xpAmount +" XP !");
    }

    /**
     * display the xp remaining to reach next level
     * @param xpAmount the amount of xp remaining
     */
    static void xpToNextLevelLine(int xpAmount){
        System.out.println("XP to next level : " + xpAmount);
    }

    /**
     * display the level up of the hero
     * @param levelReached the level reached
     */
    static void levelUpLine (int levelReached) {
        System.out.println("Congratulation, you reached level "+ levelReached +" !");
    }

    static void gameOverLine (int currentStage){
        System.out.println("You died ! But you've reached stage " + currentStage);
    }

    static void nextStageLine(int currentStage) {
        System.out.println("You move on to stage " + currentStage);
    }

    static void restRoomLine(){
        System.out.println("You take a nap in this safe room, you restore 10 LP !");
    }

    static void characChoiceLine() {
        System.out.println("Choose the characteristic you want to improve (1-ATK | 2-DEF | 3-SPEED | 4-LP)");
    }

    static void characPointsRemainingLine (int pointsRemaining){
        System.out.println("You have " + pointsRemaining + " points left to add.");
    }

    static void enterAtkLine() {
        System.out.println("Enter Atk points : ");
    }

    static void enterDefLine() {
        System.out.println("Enter def points : ");
    }

    static void enterSpeedLine() {
        System.out.println("Enter Speed points : ");
    }

    static void enterLPLine() {
        System.out.println("Enter LP points : ");
    }

    static void heroCreationScreen (int atk, int def, int speed, int lp) {
        System.out.println("-------------------------------------------------"); // TODO new graphical interface
        System.out.println("   ATK   |   DEF   |   SPEED   |   LP   ");
        System.out.println("    " + atk + "         " + def + "          " + speed + "         " + lp);

    }

    static void newLine(){
        System.out.println("");
    }

    static void enterCharacLine (int inputCharac){
        switch (inputCharac){
            case 1 :
                enterAtkLine();
                break;
            case 2 :
                enterDefLine();
                break;
            case 3 :
                enterSpeedLine();
                break;
            case 4 :
                enterLPLine();
                break;
            default:
                break;
        }
    }

    static void battleInterface (Hero hero, Monster monster) {
        System.out.println("-------------------------------------------------"); // TODO new graphical interface
        System.out.println("   YOU                                                  MONSTER    ");
        System.out.println("LP : " + hero.getCurrentLifePoints() + "/" + hero.getBaseLifePoints() + "                                            " + "LP : " + monster.getCurrentLifePoints() + "/" + monster.getBaseLifePoints());
        newLine();
        newLine();
    }

    static void capacityDisplay(CapacityPool pool){
        System.out.println(pool.getQuick().getName() + "  |  " + pool.getNormal().getName() + "  |  " + pool.getStrong().getName() + "  |  " + pool.getDefense().getName());
    }

    static void newRoomLine(int stageNumber, Room room) {
        System.out.println("You enter stage " + stageNumber + "'s room number " + room.getNumber() + " : " + room.getType() + " room.");
    }

    static void itemDroppedLines(Item item) {
        System.out.println("The monster dropped : ");
        item.displayItem();
    }

    static void heroCurrentItemLine(Hero hero, Item item) {
        System.out.println("You currently have : ");
        if (item instanceof Armor) {
            hero.getArmor().displayItem();
        } else {
            hero.getWeapon().displayItem();
        }
    }

    static void lootChoiceLine () {
        System.out.println("Do you want to loot this item ? (yes / no)");
    }

    static void itemLootedLine(){
        System.out.println("You successfully loot the item !");
    }
}
