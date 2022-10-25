package Dungeon;

import Entities.Hero;

import static Util.GameOutput.gameOverLine;
import static Util.GameOutput.nextStageLine;

public class Dungeon {
    Stage currentStage;

    // TODO add a save between stages

    // constructor
    public Dungeon(Hero hero) {
        this.currentStage = new Stage(1, hero);
    }

    // method
    public void run(Hero hero) {
        Boolean gameOver = false;
        do {
            this.currentStage.runStage(hero);
            if (hero.isStillAlive()) {
                this.currentStage = new Stage(this.currentStage.getStageNumber() + 1, hero);
                nextStageLine(this.currentStage.getStageNumber());
            } else {
                gameOverLine(this.currentStage.getStageNumber());
                gameOver = !hero.isStillAlive();
            }
        } while(!gameOver);
    }
}
