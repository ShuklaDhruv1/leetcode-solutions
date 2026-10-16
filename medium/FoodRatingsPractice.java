
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatingsPractice {

    private static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private Map<String, Food> foods;
    private Map<String, PriorityQueue<Food>> cuisines;

    public FoodRatingsPractice(
            String[] foodNames,
            String[] cuisineNames,
            int[] ratings) {

        foods = new HashMap<>();
        cuisines = new HashMap<>();

        for (int i = 0; i < foodNames.length; i++) {
            Food food = new Food(
                    foodNames[i], cuisineNames[i], ratings[i]);

            foods.put(food.name, food);

            cuisines.computeIfAbsent(
                    food.cuisine,
                    key -> new PriorityQueue<>((a, b) -> {
                        if (a.rating != b.rating) {
                            return Integer.compare(b.rating, a.rating);
                        }
                        return a.name.compareTo(b.name);
                    })
            ).offer(food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        Food food = foods.get(foodName);
        PriorityQueue<Food> heap = cuisines.get(food.cuisine);

        // Remove the old entry before updating the rating
        heap.remove(food);
        food.rating = newRating;
        heap.offer(food);
    }

    public String highestRated(String cuisine) {
        return cuisines.get(cuisine).peek().name;
    }

    public static void main(String[] args) {
        String[] foodNames = {
            "pizza", "burger", "pasta", "taco"
        };

        String[] cuisineNames = {
            "Italian", "American", "Italian", "Mexican"
        };

        int[] ratings = {8, 7, 9, 8};

        FoodRatingsPractice system =
                new FoodRatingsPractice(
                        foodNames, cuisineNames, ratings);

        System.out.println(system.highestRated("Italian"));
        System.out.println(system.highestRated("American"));

        system.changeRating("pizza", 10);

        System.out.println(system.highestRated("Italian"));

        system.changeRating("pizza", 9);

        System.out.println(system.highestRated("Italian"));
    }
}
