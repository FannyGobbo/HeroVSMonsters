package Entities;

import Capacities.Capacity;
import Capacities.CapacityPool;
import Items.Armor;
import Items.Item;
import Items.Weapon;

import java.util.Random;

import static Items.ArmorType.LIGHT;
import static Items.WeaponType.BLUNT;

public class Monster extends Entity{

    // constructor
    public Monster(int baseAtk, int baseDef, int baseSpeed, int baseLifePoints) {
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpeed = baseSpeed;
        this.baseLifePoints = baseLifePoints;
        this.currentLifePoints = baseLifePoints;
        this.level = 1;
        this.weapon = new Weapon("Fist", 0, BLUNT);
        this.armor = new Armor("Skin",0,0,LIGHT);
        this.capacityPool = new CapacityPool();
    }

    public Monster (int level) {
        Random rand = new Random();
        this.baseAtk = rand.nextInt(level) + level/2;
        this.baseDef = rand.nextInt(level) + level/2;
        this.baseSpeed = rand.nextInt(level) + level/2;
        this.baseLifePoints = rand.nextInt(2*level) + level + 10;
        this.currentLifePoints = baseLifePoints;
        this.level = level;
        this.weapon = Weapon.createRandomWeapon(level);
        this.armor = Armor.createRandomArmor(level);
        this.capacityPool = new CapacityPool();
    }

    // display
    @Override
    public void displayEntity () {
        System.out.println("MONSTER");
        System.out.println("Level : " + this.level);
        System.out.println("Life points : " + this.currentLifePoints);
        System.out.println("Attack  : " + (this.baseAtk + this.weapon.getUpdateAtk()));
        System.out.println("Defense : " + (this.baseDef + this.armor.getUpdateDef()));
        System.out.println("Speed   : " + (this.baseSpeed + this.armor.getUpdateSpeed()));
    }


    // methods

    /**
     * make the Monster drop an item (either armor or weapon) except if both are skin and fists (non droppable)
     * @return the Item dropped by the Monster or null if both its items are not droppable
     */
    public Item dropItem () {
        boolean areBothDroppable = this.weapon.isDroppable() && this.armor.isDroppable();

        if (this.weapon.isDroppable() || this.armor.isDroppable()) {
            if (areBothDroppable) {
                Random rand = new Random();
                if (rand.nextBoolean()) {
                    return this.armor;
                } else {
                    return this.weapon;
                }
            } else {
                if (this.armor.isDroppable()) {
                    return this.armor;
                } else {
                    return this.weapon;
                }
            }
        } else {
            return null;
        }
    }

    @Override
    public Capacity useCapacity(){
        Random rand = new Random();
        switch (rand.nextInt(4-1) + 1) {
            case 1:
                return this.capacityPool.getQuick();
            case 2 :
                return this.capacityPool.getNormal();
            case 3:
                return this.capacityPool.getStrong();
            case 4:
                return this.capacityPool.getDefense();
            default:
                break;
        }
        return null;
    }
}

