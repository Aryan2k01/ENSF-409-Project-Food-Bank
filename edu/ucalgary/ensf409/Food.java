
package edu.ucalgary.ensf409;

import java.util.Arrays;

public class Food {
    private final int ITEM_ID;
    private final String NAME;
    private final int GRAIN_CONTENT;
    private final int FV_CONTENT;
    private final int PRO_CONTENT;
    private final int OTHER_CONTENT;
    private final int CALORIES;

    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student",
            "ensf");

    public Food(int ITEM_ID) {

        this.ITEM_ID = ITEM_ID;

        access.initializeConnection();

        String[] tmp = access.getSpecificFood(ITEM_ID).split("/");

        this.NAME = tmp[0];

        this.CALORIES = Integer.parseInt(tmp[5]);

        this.GRAIN_CONTENT = (int) (Integer.parseInt(tmp[1]) / 100.0 * this.CALORIES);

        this.FV_CONTENT = (int) (Integer.parseInt(tmp[2]) / 100.0 * this.CALORIES);

        this.PRO_CONTENT = (int) (Integer.parseInt(tmp[3]) / 100.0 * this.CALORIES);

        this.OTHER_CONTENT = (int) (Integer.parseInt(tmp[4]) / 100.0 * this.CALORIES);

        access.close();
    }


    public int getItemID() {
        return this.ITEM_ID;
    }

    public String getName() {
        return this.NAME;
    }

    public int getGrainContent() {
        return this.GRAIN_CONTENT;
    }

    public int getFVContent() {
        return this.FV_CONTENT;
    }

    public int getProContent() {
        return this.PRO_CONTENT;
    }

    public int getOtherContent() {
        return this.OTHER_CONTENT;
    }

    public int getCalories() {
        return this.CALORIES;
    }

    // extra method added temporarily so availableFood ArrayList can be printed when
    // AvailableFood is called.
    @Override
    public String toString() {
        return (this.getItemID() + " "
                + this.getName() + " "
                + this.getGrainContent() + " "
                + this.getFVContent() + " "
                + this.getProContent() + " "
                + this.getOtherContent() + " "
                + this.getCalories());
    }
}
