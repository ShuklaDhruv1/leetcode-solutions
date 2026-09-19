public class FloodFill {

    public static int[][] floodFill(
            int[][] image,
            int sr,
            int sc,
            int color) {

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        fill(image, sr, sc, originalColor, color);

        return image;
    }

    public static void fill(
            int[][] image,
            int row,
            int col,
            int originalColor,
            int newColor) {

        if (row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length ||
            image[row][col] != originalColor) {
            return;
        }

        image[row][col] = newColor;

        fill(image, row + 1, col, originalColor, newColor);
        fill(image, row - 1, col, originalColor, newColor);
        fill(image, row, col + 1, originalColor, newColor);
        fill(image, row, col - 1, originalColor, newColor);
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        System.out.println("Flood Filled Image:");

        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
