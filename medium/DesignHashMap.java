public class DesignHashMap {

    private static final int SIZE = 1000001;

    private int[] map;

    public DesignHashMap() {

        map = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            map[i] = -1;
        }
    }

    public void put(int key, int value) {

        map[key] = value;
    }

    public int get(int key) {

        return map[key];
    }

    public void remove(int key) {

        map[key] = -1;
    }

    public static void main(String[] args) {

        DesignHashMap myHashMap =
                new DesignHashMap();

        myHashMap.put(1, 10);
        myHashMap.put(2, 20);

        System.out.println(
                "Get key 1: " +
                myHashMap.get(1)
        );

        System.out.println(
                "Get key 3: " +
                myHashMap.get(3)
        );

        myHashMap.put(2, 30);

        System.out.println(
                "Get key 2 after update: " +
                myHashMap.get(2)
        );

        myHashMap.remove(2);

        System.out.println(
                "Get key 2 after remove: " +
                myHashMap.get(2)
        );
    }
}
