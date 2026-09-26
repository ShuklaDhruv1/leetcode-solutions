public class DecodeWays {

    public static int numDecodings(String s) {

        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int previousTwo = 1;
        int previousOne = 1;

        for (int i = 1; i < s.length(); i++) {

            int current = 0;

            // Decode one digit
            if (s.charAt(i) != '0') {
                current += previousOne;
            }

            // Decode two digits
            int twoDigits =
                    Integer.parseInt(s.substring(i - 1, i + 1));

            if (twoDigits >= 10 && twoDigits <= 26) {
                current += previousTwo;
            }

            previousTwo = previousOne;
            previousOne = current;
        }

        return previousOne;
    }

    public static void main(String[] args) {

        String s = "226";

        int result = numDecodings(s);

        System.out.println(
                "Number of Ways: " + result
        );
    }
}
