/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pujawadare
 */
@WebServlet(urlPatterns = {"/saveToFile"})
public class saveToFile extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String path = this.getClass().getClassLoader().getResource("").getPath();
        
        int i = path.length()-1;
        String b = "b",  c = path.substring(path.length()-1, path.length());
        while (!b.equals(c)){
            path = path.substring(0, path.length()-1);
            c = path.substring(path.length()-1, path.length());
        }
        path += "/sampleFile.txt";
        
        
        File file = new File(path);
        file.createNewFile();
        file.setWritable(true);
       
        FileOutputStream fileOutputStream = new FileOutputStream(path);
                
        byte[] bArray = request.getParameter("data").getBytes();
        try {
            fileOutputStream.write(bArray);
            fileOutputStream.close();

            request.setAttribute("file", "sampleFile.txt");
            String resultPage = "result.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
            dispatcher.forward(request, response);
        }catch (IOException e) {
            System.out.print(e.getMessage());
        }
        
    }

   
}
