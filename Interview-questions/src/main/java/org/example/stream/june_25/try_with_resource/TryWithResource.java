package org.example.stream.june_25.try_with_resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResource {
    public static void main(String[] args) {

        //Normal approach
        /*Scanner sc = null;
        try{
            sc = new Scanner(new File("test.txt"));
            if(sc.hasNext()){
                System.out.println(sc.nextLine());
            }
        }catch (FileNotFoundException fnfx){
            fnfx.printStackTrace();
        }finally {
            if(sc !=null){
                sc.close();
            }
        }*/

        //try-with-resource
        try(Scanner sc = new Scanner(new File("test.txt"))){   //No need to close, this will close automatically
            if(sc.hasNext()){
                System.out.println(sc.nextLine());
            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
    }
}
