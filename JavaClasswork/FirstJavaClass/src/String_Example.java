public class String_Example {
}

public static void main( String[] args ) {

    String str = ("The lenght of the string is okay");

    System.out.println("The lenght of the string = " + str.length());

    String str2 = str.toLowerCase(Locale.ROOT);

    System.out.println(str);
    System.out.println(str2);

    //                  0123456789
    String filename = "Hello.java";

    System.out.println(" The file name is" + "and the lenght is " + filename.length() );

    System.out.println("The period is at index" + filename.indexOf('.'));

    System.out.println("The file extension is" + filename.substring( filename.indexOf('.')));

    ystem.out.println("The name of the file is " + filename.substring( filename.indexOf('.')));


}
