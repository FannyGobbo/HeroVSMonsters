package Items;

public enum WeaponType {
    /**
     * Piercing weapon, can go through opponent's armor
     */
    PIECRING,

    /**
     * Blunt weapon, hit without bonus or malus
     * TODO make it stun the enemy
     */
    BLUNT,

    /**
     * Sharp weapon, deal additionnal damages to the opponent
     * TODO add bleeding state
     */
    SHARP
}
