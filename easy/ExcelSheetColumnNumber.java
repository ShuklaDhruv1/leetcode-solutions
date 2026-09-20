public class ExcelSheetColumnNumber {

    public static int titleToNumber(String columnTitle) {

        int result = 0;

        for (char c : columnTitle.toCharArray()) {

            int value = c - 'A' + 1;

            result = result * 26 + value;
        }

        return result;
    }

    public static void main(String[] args) {

        String column = "AB";

        int result = titleToNumber(column);

        System.out.println("Column Number: " + result);
    }
}
