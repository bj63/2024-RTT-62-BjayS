public class ArrayDelete {
    {

        int[] array = {1, 2, 3, 4, 5};

        //pos 012345
        // value 12345

        int[] insert = new int[array.length + 1];
        for (int pos = 0; pos < 2; pos++) {
            insert[pos] = array[pos];
        }
        insert[2] = 9;


        for (int value : insert) {
            System.out.println(value);
        }
    }
}
