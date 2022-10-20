package Capacities;

public class CapacityPool {
    private static Capacity quick;
    private static Capacity normal;
    private static Capacity strong;
    private static Capacity defense;

    ///////////////////////////////////////////////////////////
    ////////////////     CONSTRUCTORS     /////////////////////
    ///////////////////////////////////////////////////////////

    public CapacityPool () {
        quick = new Capacity(
                "Quick",
                1/2,
                3/4,
                1
        );
        normal = new Capacity(
                "Normal",
                1,
                1,
                1
        );
        strong = new Capacity(
                "Strong",
                1.5f,
                2,
                1
        );
        defense = new Capacity(
                "Defense",
                1,
                1,
                2
        );
    }

    ///////////////////////////////////////////////////////////
    ////////////////     DISPLAY       ////////////////////////
    ///////////////////////////////////////////////////////////

    public void displayCapacityPool () {
        quick.displayCapacity();
        normal.displayCapacity();
        strong.displayCapacity();
        defense.displayCapacity();
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////          GETTERS AND SETTERS          ////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Capacity getQuick() {
        return quick;
    }

    public static Capacity getNormal() {
        return normal;
    }

    public static Capacity getStrong() {
        return strong;
    }

    public static Capacity getDefense() {
        return defense;
    }
}
