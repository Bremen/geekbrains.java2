package homework2.myexceptions;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    public MyArraySizeException(String s) {
        super(s);
    }
}
