package Experiments.Exp2;
import java.io.*;

public class DeleteFiles {
    public static void main(String args []) throws Exception {
        File dum = new File("C:/oslabs/tweedle-dum.txt");
        File dee = new File("tweedle-dee.txt");
        dum.delete();
        dee.delete();
    }
}
