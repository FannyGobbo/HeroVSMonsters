import java.util.Random;

public record Armor(int updateDef, int updateSpeed, ArmorType type) {
    static Armor createRandomArmor(int level, ArmorType type) {
        Random rand = new Random();
        return switch (type) {
            case HEAVY -> new Armor(
                    level + rand.nextInt(level / 2 + 1),
                    -(rand.nextInt(level / 2 + 1) + level / 2),
                    type);
            default -> new Armor(
                    rand.nextInt(level / 2 + 1),
                    rand.nextInt(level / 2 + 1) + level / 2,
                    type);
        };
    }
}
