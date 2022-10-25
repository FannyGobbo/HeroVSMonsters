package Capacities;

public class Capacity {
    private String name;
    private float updateSpeed;
    private float updateAtk;
    private float updateDef;

    ///////////////////////////////////////////////////////////
    ////////////////     CONSTRUCTORS     /////////////////////
    ///////////////////////////////////////////////////////////

    public Capacity (String name, float updateSpeed, float updateAtk, float updateDef) {
        this.name = name;
        this.updateSpeed = updateSpeed;
        this.updateAtk = updateAtk;
        this.updateDef = updateDef;
    }

    ///////////////////////////////////////////////////////////
    ////////////////     DISPLAY       ////////////////////////
    ///////////////////////////////////////////////////////////

    public void displayCapacity () {
        System.out.println("Capacity : "+name);
        System.out.println("Speed modifier : " + updateSpeed);
        System.out.println("Attack modifier : "+ updateAtk);
        System.out.println("Defense modifier : " + updateDef);
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////          GETTERS AND SETTERS          ////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public float getUpdateSpeed() {
        return updateSpeed;
    }

    public float getUpdateAtk() {
        return updateAtk;
    }

    public float getUpdateDef() {
        return updateDef;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdateSpeed(float updateSpeed) {
        this.updateSpeed = updateSpeed;
    }

    public void setUpdateAtk(float updateAtk) {
        this.updateAtk = updateAtk;
    }

    public void setUpdateDef(float updateDef) {
        this.updateDef = updateDef;
    }
}
