package Experiments.Exp6;

import java.io.* ;

public class CopyFile {

    public static void main(String [] args) throws Exception {

        FileInputStream in = new FileInputStream("C:/oslabs/tweedle-dum.txt");

        FileOutputStream out = new FileOutputStream("C:/oslabs/tweedle-dee.txt");

        byte[] buffer = new byte [100] ;

        int numBytesRead = in.read(buffer) ;

        while(numBytesRead > 0) {
            out.write(buffer, 0, numBytesRead) ;
            numBytesRead = in.read(buffer) ;
        }

        out.close();
        in.close();
    }
}

// This program copies the contents of tweedle-dum.txt into tweedle-dee.txt