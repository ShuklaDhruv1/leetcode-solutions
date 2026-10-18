
public class ParkingSystemPractice {

    private int big;
    private int medium;
    private int small;

    public ParkingSystemPractice(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
        } else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        } else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ParkingSystemPractice parking =
                new ParkingSystemPractice(1, 1, 0);

        System.out.println(parking.addCar(1));
        System.out.println(parking.addCar(2));
        System.out.println(parking.addCar(3));
        System.out.println(parking.addCar(1));
    }
}
