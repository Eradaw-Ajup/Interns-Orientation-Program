/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pujawadare
 * @date 10th June 2022
 * @Assignment-1 : Input a file using byte array, store it on local system.
 * Create a download link for the file. No Spring Project on Libraries use Core JAVA Only.
 *
 */
import java.io.*;

public class GetByteArrayFromFile {
    public static void main(String args[]) {

        File file = new File("sample-file.txt"); // creating file Object
        FileInputStream fileInputStream = null;  // creating fileInputStream Object

        int fileLength = (int) file.length();    // calculating the length of the file
        byte[] byteArray = new byte[fileLength]; // initializing the byte array
        try {
            fileInputStream = new FileInputStream(file); // input stream linked with the file specified by the file object
            fileInputStream.read(byteArray);             // reading the contents
            fileInputStream.close();                     // closing the FileInputStream

            // Displaying the contents of the byteArray
            for (int i = 0; i < fileLength; i++)
                System.out.print((char)byteArray[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
