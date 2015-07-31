
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
public class Hashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Hashing hash = new Hashing();
        hash.go();
    }
    
    
    void go() throws FileNotFoundException, IOException
    {
        
       PrintWriter writer = new PrintWriter("/home/vakhil/Desktop/train-number", "UTF-8");
       PrintWriter w1 = new PrintWriter("/home/vakhil/Desktop/freq-hash", "UTF-8");
        
      
            HashMap<String, Double> count = new HashMap<>();
          
           String line;
           
            FileReader kar = new FileReader("/home/vakhil/Desktop/ml/lshtc/Data/train_final.csv");
      
            BufferedReader zar = new BufferedReader(kar);
            
            while((line = zar.readLine()) != null )
            { 
            
                  String[] piece = line.split(", ");
                  
                    int a = piece.length;
                    String[] feature = piece[a-1].split(" ");
                    
                  
                    for(int i=1;i<feature.length;i++)
                    {
                        String[] pic = feature[i].split(":");
                        if(count.containsKey(pic[0]))
                        {
                            count.put(pic[0], 1.0+count.get(pic[0]));
                           
                        }
                        else
                        {
                            count.put(pic[0],1.0);
                        }
                        
                    }
                    
                    
            }
                    
            HashMap<String, Integer> plan = new HashMap<>();
            int u=1;
            for(String key: count.keySet())
            {
                
                if(count.get(key)>3 && count.get(key)<1700)
                {
                    double uiz = 2128890/count.get(key);
                    writer.println(key+" "+uiz);
                    
                    w1.println(key+" "+ u);
                   u++; 
                }
                
            }
             writer.close();
             w1.close();
            
    }
}

