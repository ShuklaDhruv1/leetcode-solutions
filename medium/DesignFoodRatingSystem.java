
import java.util.*;

public class DesignFoodRatingSystem {

    private Map<String, String> foodCuisine;
    private Map<String, Integer> foodRating;

    public DesignFoodRatingSystem(
            String[] foods,
            String[] cuisines,
            int[] ratings) {

        foodCuisine = new HashMap<>();
        foodRating = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        String bestFood = "";
        int bestRating = -1;

        for (String food : foodCuisine.keySet()) {
            if (foodCuisine.get(food).equals(cuisine)) {
                int rating = foodRating.get(food);

                if (rating > bestRating ||
                    (rating == bestRating &&
                     food.compareTo(bestFood) < 0)) {

                    bestRating = rating;
                    bestFood = food;
                }
            }
        }

        return bestFood;
    }

    public static void main(String[] args) {

        String[] foods = {
            "pizza", "burger", "pasta", "taco"
        };

        String[] cuisines = {
            "Italian", "American", "Italian", "Mexican"
        };

        int[] ratings = { 8, 7, 9, 6 };

        DesignFoodRatingSystem system =
            new DesignFoodRatingSystem(foods, cuisines, ratings);

        System.out.println(system.highestRated("Italian"));

        system.changeRating("pizza", 10);

        System.out.println(system.highestRated("Italian"));

        system.changeRating("pizza", 9);

        System.out.println(system.highestRated("Italian"));
    }
}
