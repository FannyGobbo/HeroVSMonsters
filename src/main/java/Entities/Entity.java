package Entities;

import Capacities.Capacity;
import Capacities.CapacityPool;
import Items.Armor;
import Items.Weapon;

import static Util.GameOutput.damagesDealtLine;

public abstract class Entity {
    protected int baseAtk;
    protected int baseDef;
    protected int baseSpeed;
    protected int baseLifePoints;
    protected int currentLifePoints;
    protected int level;
    protected Weapon weapon;
    protected Armor armor;
    protected CapacityPool capacityPool;

    // TODO add status (like stun, bleed, or boosts)
    // TODO add dodge statistic


    /**
     * display Entity's information
     */
    public abstract void displayEntity();


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////          GETTERS AND SETTERS          ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public int getBaseAtk() {
        return baseAtk;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public int getBaseLifePoints() {
        return baseLifePoints;
    }

    public int getCurrentLifePoints() {
        return currentLifePoints;
    }

    public int getLevel() {
        return level;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public CapacityPool getCapacityPool() {
        return capacityPool;
    }

    public void setBaseAtk(int baseAtk) {
        this.baseAtk = baseAtk;
    }

    public void setBaseDef(int baseDef) {
        this.baseDef = baseDef;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public void setBaseLifePoints(int baseLifePoints) {
        this.baseLifePoints = baseLifePoints;
    }

    public void setCurrentLifePoints(int currentLifePoints) {
        this.currentLifePoints = currentLifePoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////     METHODS       ////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Attack with the specified capacity
     * @param capacity : the capacity used (among the Entity's CapacityPool)
     * @return the amount of damages dealt by the attack
     */
    public int getAttackBaseDamage (Capacity capacity) {
        return (int) ((this.baseAtk + this.weapon.getUpdateAtk()) * capacity.getUpdateAtk());
    }

    /**
     * Give the speed of the specified attack
     * @param capacity : the capacity used (among the Entity's CapacityPool)
     * @return the Entity's speed using the capacity
     */
    public int getAttackSpeed (Capacity capacity) {
        return (int) ((this.baseSpeed + this.armor.getUpdateSpeed()) * capacity.getUpdateSpeed());
    }

    /**
     * Give the real damages dealt to the Entity
     * @param opponent : the Entity's opponent
     * @param opponentsAttack : the attack dealt by the opponent using the method attack
     *                        /!\ NEED TO BE POSITIVE
     * @param ownCapacity : the capacity used by the Entity
     * @return the real damages dealt by the opponent's attack to the Entity
     */
    public int damageCalculation (Entity opponent, int opponentsAttack, Capacity ownCapacity) {
        return switch (opponent.getWeapon().getType()) {
            case PIECRING   -> (int)Math.max(opponentsAttack - this.armor.getUpdateDef() * ownCapacity.getUpdateDef() / 2, 0);
            case SHARP      -> (int) Math.max(opponentsAttack - this.armor.getUpdateDef() * ownCapacity.getUpdateDef() + opponent.level,0);
            default         -> (int) Math.max(opponentsAttack - this.armor.getUpdateDef() * ownCapacity.getUpdateDef(),0);
        };
    }

    /**
     * make an Entity use a capacity
     * @return the Capacity used by the Entity or null if an error has occured
     */
    public abstract Capacity useCapacity();

    /**
     * Indicate if the Entity is still alive
     * @return true if the Entity is still alive
     */
    public boolean isStillAlive () {
        return this.currentLifePoints > 0;
    }

    /**
     * Heal the Entity of the number of life points specified but cap to the max amount of life points
     * @param numberLP the amount of life points to get heal
     *                 /!\ NEED TO BE POSITIVE
     */
    public void getHeal (int numberLP) {
        this.currentLifePoints = this.currentLifePoints + numberLP;
        if (currentLifePoints > baseLifePoints) {
            currentLifePoints = baseLifePoints;
        }
    }

    /**
     * Damage the Entity with the specified amount of life points
     * @param numberLP the amount of life points dealt to the entity
     *                 /!\ NEED TO BE POSITIVE
     */
    public void getHurt (int numberLP) {
        this.currentLifePoints = this.currentLifePoints - numberLP;
    }

    /**
     * make the Entity attack its opponent
     * @param attackerCapacity The capacity used by the Entity
     * @param defender  The opponent
     * @param defenderCapacity The capacity used by the opponent
     */
    public void attackOpponent (Capacity attackerCapacity, Entity defender, Capacity defenderCapacity){
        int attackerAtk;

        attackerAtk = defender.damageCalculation(this, this.getAttackBaseDamage(attackerCapacity), defenderCapacity);
        if (attackerAtk > 0) {
            defender.getHurt(attackerAtk);
            damagesDealtLine(attackerAtk);
        } else {
            damagesDealtLine(0);
        }
    }
}
