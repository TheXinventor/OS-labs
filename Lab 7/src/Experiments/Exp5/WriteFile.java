package Experiments.Exp5;

import java.io.* ;

public class WriteFile {

    public static void main(String [] args) throws Exception {

        FileOutputStream out = new FileOutputStream("C:/oslabs/tweedle-dee.txt");

        String text = "Shoes and ships and sealing wax." ;

        byte[] buffer = text.getBytes();

        out.write(buffer) ;

        out.close() ;
    }
}
