package Experiments.Exp4;

import java.io.FileInputStream;

public class ReadFile {
    public static void main(String [] args) throws Exception {
        FileInputStream in = new FileInputStream("C:/oslabs/tweedle-dum.txt");
        byte[] buffer = new byte [100] ;
        int numBytesRead = in.read(buffer) ;
        while(numBytesRead > 0) {
            System.out.print(new String(buffer, 0, numBytesRead)) ;
            numBytesRead = in.read(buffer) ;
        }
        in.close();
    }
}
