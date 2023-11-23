package Experiments.Exp3;

import java.io.* ;
public class ReadFile {
    public static void main(String [] args) throws Exception {
        FileInputStream in = new FileInputStream("C:/oslabs/tweedle-dum.txt");
        byte buffer [] = new byte [100] ;
        int numBytesRead = in.read(buffer) ;
        System.out.println(new String(buffer)) ;
    }
}
