
import java.util.*;

public class DesignMovieRentalSystem {

    static class Movie {
        int shop;
        int movie;
        int price;

        Movie(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        public String toString() {
            return "[" + shop + ", " + movie + "]";
        }
    }

    private Map<String, Integer> prices;
    private Map<Integer, TreeSet<Movie>> available;
    private TreeSet<Movie> rented;

    private Comparator<Movie> movieOrder = (a, b) -> {
        if (a.price != b.price) {
            return Integer.compare(a.price, b.price);
        }
        if (a.shop != b.shop) {
            return Integer.compare(a.shop, b.shop);
        }
        return Integer.compare(a.movie, b.movie);
    };

    public DesignMovieRentalSystem(int[][] entries) {
        prices = new HashMap<>();
        available = new HashMap<>();
        rented = new TreeSet<>(movieOrder);

        for (int[] entry : entries) {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];

            prices.put(key(shop, movie), price);

            available.putIfAbsent(
                movie, new TreeSet<>(movieOrder)
            );

            available.get(movie).add(
                new Movie(shop, movie, price)
            );
        }
    }

    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();

        if (!available.containsKey(movie)) {
            return result;
        }

        int count = 0;

        for (Movie item : available.get(movie)) {
            result.add(item.shop);
            count++;

            if (count == 5) {
                break;
            }
        }

        return result;
    }

    public void rent(int shop, int movie) {
        int price = prices.get(key(shop, movie));

        Movie item = new Movie(shop, movie, price);
        available.get(movie).remove(item);
        rented.add(item);
    }

    public void drop(int shop, int movie) {
        int price = prices.get(key(shop, movie));

        Movie item = new Movie(shop, movie, price);
        rented.remove(item);
        available.get(movie).add(item);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;

        for (Movie item : rented) {
            result.add(
                Arrays.asList(item.shop, item.movie)
            );

            count++;

            if (count == 5) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] entries = {
            {0, 1, 5},
            {0, 2, 6},
            {1, 1, 4},
            {2, 1, 5}
        };

        DesignMovieRentalSystem system =
            new DesignMovieRentalSystem(entries);

        System.out.println("Search: " + system.search(1));

        system.rent(1, 1);

        System.out.println("Report: " + system.report());

        system.drop(1, 1);

        System.out.println("After return: " + system.report());
    }
}
