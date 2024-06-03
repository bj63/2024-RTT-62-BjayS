public class Array_Delete {
    public static int[] delete(int[] source, int deletePosition, int valueToDelete){
        int[] result = new int [source.length - 1];
        if (pos != deletePosition){
            result[resultPos++]=source[pos];
        }

        }
        return result;
    }

    }

    public static void main(String[] Args){
        int[] array = {1,2,3,4,5}
        int deletedPosition= 4
        array = delete(array, deletedPosition);

        for(int num : array){
            System.out.println(num);
        }
    }
}
