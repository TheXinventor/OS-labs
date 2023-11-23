package Experiments.Exp7;

import java.io.* ;

public class RandomAccess {

    public static void main(String [] args) throws Exception {

        RandomAccessFile rand = new RandomAccessFile("C:/oslabs/tweedle-dum.txt", "r");

        byte[] buffer = new byte [100] ;

        rand.seek(100);

        int numBytesRead = rand.read(buffer) ;

        System.out.println(new String(buffer)) ;
    }
}
