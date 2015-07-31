// Converting the original train file into compressed file using reducing the feature space and hasing to a smaller set

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vakhil
 */
public class Compress_feature {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Compress_feature hash = new Compress_feature();
        hash.go();
    }
    
    
    void go() throws FileNotFoundException, IOException
    {
        
      
       PrintWriter writer = new PrintWriter("/home/vakhil/Desktop/train_compressed", "UTF-8");
            HashMap<String, String> hash = new HashMap<>();
          
           String line;
           
            FileReader kar = new FileReader("/home/vakhil/ml/lshtc/Data/feature-hash");
      
            BufferedReader zar = new BufferedReader(kar);
            
            while((line = zar.readLine()) != null)
            {
              String[] hell=  line.split(" ");
              hash.put(hell[0], hell[1]);                
                
            }
            
            
            FileReader car = new FileReader("/home/vakhil/Desktop/ml/lshtc/Data/train_final.csv");
      
            BufferedReader par = new BufferedReader(car);
            
            while((line = par.readLine()) != null)
            { 
                String[] piece = line.split(", ");
                    int a = piece.length;
                    String[] feature = piece[a-1].split(" ");
                    
                   for(int i=0;i<a;i++)
                   {
                       if(i==a-1)
                       {writer.print(feature[0]+", ");
                       
                       break;
                       }
                       
                       writer.print(piece[i]+", ");
                       
                   }
                   
                   for(int i=1;i<feature.length;i++)
                   {
                       String[] pork = feature[i].split(":");
                       if(hash.containsKey(pork[0]))
                       {
                           writer.print(hash.get(pork[0])+":"+pork[1]+" ");
                       }
                   }
                   
                   writer.println(" ");
                
            }
            
            writer.close();
            
            }
            
    }


