package Experiments.Exp8;

import java.io.RandomAccessFile;

public class RandomAccess {

    public static void main(String [] args) throws Exception {

        RandomAccessFile rand = new RandomAccessFile("C:/oslabs/tweedle-dum.txt", "rw");

        String text = "Shoes and ships and sealing wax." ;

        byte[] buffer = text.getBytes();

        rand.seek(100000);

        rand.write(buffer) ;

        rand.close() ;
    }
}

/*
Surprisingly, writing to a position outside the current file limit
increases the file size to account for the seek command.
The excess bytes are filled with whitespace.
*/