import java.util.Arrays;

public class RussianDollEnvelopesPractice {

    public static int maxEnvelopes(int[][] envelopes) {

        // Sort by width ascending.
        // If widths are equal, sort height descending.
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] tails = new int[envelopes.length];
        int size = 0;

        // Find LIS using envelope heights
        for (int[] envelope : envelopes) {
            int height = envelope[1];

            int left = 0;
            int right = size;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (tails[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = height;

            if (left == size) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        int[][] envelopes = {
            {5, 4},
            {6, 4},
            {6, 7},
            {2, 3}
        };

        System.out.println(maxEnvelopes(envelopes));
    }
}
