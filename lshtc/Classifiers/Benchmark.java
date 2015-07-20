
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;



 public class MAL 
 {
      int[] helm = new int[5];
     public static void main(String[] args) throws IOException
     {
         MAL hell = new MAL();
         hell.go();
         
         
     }
     
     double compare(HashMap<String, Integer> a, HashMap<String, Integer> b)
     {
         double comp=0;
         double a1=0;
       for(String key : a.keySet())
       {
           if(b.containsKey(key))
           {
               comp = comp + b.get(key) * a.get(key);
           }
           a1 = a1 + a.get(key)*a.get(key);
       }
       a1 = Math.sqrt(a1);
       double b1=0;
       for (String key:b.keySet())
       {
           b1 = b1 + b.get(key)*b.get(key);
       }
       b1 = Math.sqrt(b1);
       
       return comp/(a1*b1);
             
         
     }
     
     void go() throws FileNotFoundException, IOException
     {
         
         Hashtable<String, String> vector = new Hashtable<String, String>();
        
         
        
         FileReader fr = new FileReader("/users/btech/vakhil/test_final.csv");
     
            BufferedReader tr = new BufferedReader(fr);
           
         
         String whole;
     
        
   
           while((whole = tr.readLine()) != null)
               {
                  String[] yolk = whole.split(", ");
                 
                  String[] feature = yolk[yolk.length-1].split(" ");
                  String[] pain;
                  for(int z=2;z<feature.length;z++)
                  {
                   pain = feature[z].split(":");
                   vector.put(pain[0], "0");               
                   
                  }
                  
               }
           
           
         FileReader kr = new FileReader("/users/btech/vakhil/train_final.csv");
      
            BufferedReader zr = new BufferedReader(kr);
            
            
         
            String ug;
            while((ug = zr.readLine()) != null)
               {
                    String[] piece = ug.split(", ");
                    int a = piece.length;
                    String[] feature = piece[a-1].split(" ");
                  
                 for(int z=1;z<feature.length;z++)
                 {
                     String[] pork = feature[z].split(":");
                    
                     if(vector.containsKey(pork[0]))
                     {
                         int R =Integer.decode(vector.get(pork[0])) ;
                         R=R+1;
                         vector.put(pork[0], String.valueOf(R));
                         
                     }
                     else
                     {
                         vector.put(pork[0], "1");
                     }
                     
                     
                 }
                   

     }
            /*
            
           PrintWriter writer = new PrintWriter("/home/vakhil/Desktop/pb.txt", "UTF-8");
                            
    for (String key : vector.keySet()) {
        
                   double kl = Double.valueOf(vector.get(key));
                   kl = Math.log10(2365437.0/kl)/Math.log10(2);
                   vector.put(key, String.valueOf(kl));
                   
                      writer.println(key +" "+ kl);
                        }
    
    */
                            
                            
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        FileReader kcr = new FileReader("/users/btech/vakhil/test_final.csv");
     
            BufferedReader jumbo = new BufferedReader(kcr);
            
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
            String line;
            int home=0;
            while(((line = jumbo.readLine()) != null) && home<100)
             {
                 HashMap<String, String> rg = new HashMap<String,String>();  
                 
                 List<Integer> list = new ArrayList<Integer>();
                   
                  
                 String[] pen = line.split(", ");
                 String[] fd = pen[pen.length-1].split(" ");
                 for(int bf=0;bf<pen.length;bf++)
                 {
                     if(bf==pen.length-1)
                     {
                        list.add(Integer.decode(fd[0]));
                        break;
                     }
                    list.add(Integer.decode(pen[bf]));
                 }
                 double[] tf = new double[fd.length-2];
                 for(int z=2;z<fd.length;z++)
                 {
                     String[] pic = fd[z].split(":");
                   
                     double idf = Double.valueOf(vector.get(pic[0]));
                     if(idf==0)
                     {
                         tf[z-2]=0;
                     }
                         else
                     {
                     idf = 1/idf;
                     
                     tf[z-2] = Double.valueOf(pic[1])*idf;
                     }
                       rg.put( pic[0], String.valueOf(tf[z-2]) );
                 }
                
             String a=null ;
                 String b=null ;
                 String c=null ;
                 
                 Arrays.sort(tf);
                 for (Entry<String, String> entry : rg.entrySet())
                 {
                             if (entry.getValue().equals(String.valueOf(tf[tf.length-1])))
                                 a = entry.getKey();
                             
                             if (entry.getValue().equals(String.valueOf(tf[tf.length-2])))
                                 b = entry.getKey();
                             
                             if (tf.length >2 && entry.getValue().equals(String.valueOf(tf[tf.length-3])))
                                 c = entry.getKey();                            
                     
                 }
                 int a1 = Integer.decode(a);
                 int b1 = Integer.decode(b);
                 int c1 = Integer.decode(c);
                 FileReader ppr = new FileReader("/users/btech/vakhil/train_final.csv");
      
            BufferedReader ssh = new BufferedReader(ppr);
           
            String uzb;
            boolean gf=false;
           ArrayList<Integer> pogo = new ArrayList<>();
            int ntpc=1;
            
            HashMap<Integer,Integer> hh = new HashMap<>();
            
            int[] top;
              while((uzb = ssh.readLine()) != null)
              {
                 
          String[] piece = uzb.split(", ");
                    int alrd = piece.length;
                    String[] feature = piece[alrd-1].split(" ");
                  
                 for(int z=1;z<feature.length;z++)
                 {
                     String[] pork = feature[z].split(":");
                     int jam = Integer.decode(pork[0]);
                     
                     if(jam==a1 || jam==b1 || jam ==c1)
                     {
                        
                         pogo.add(ntpc);
                         HashMap<String,Integer> common = new HashMap<>();
                         for(int bf=1;bf<feature.length;bf++)
                         {
                            
                             common.put(feature[bf].split(":")[0], 1);
                         }
                         
                         for(int bf=1;bf<fd.length;bf++)
                         {
                             String uiz = fd[bf].split(":")[0];
                             if(common.containsKey(uiz ))
                             {
                                 common.put(uiz, 5);
                             }
                         }
                         int hell=0;
                         for(String key: common.keySet())
                         {
                             if(common.get(key)!=1)
                                 hell++;
                         }
                         double camel = (double) (feature.length-1+fd.length-1+hell);
                         double fox = (double) hell;
                    double yk = 1 - (fox/camel)   ; 
                    yk=yk*10000000;
                    int fuck = (int) yk;
                             hh.put(ntpc, fuck);
                         break;
                             
                     }
                     
                     
                 }
                 
                 
                 
                 
                 ntpc++;

             }
              top = new int[pogo.size()];
              
              for(int bf=0;bf<pogo.size();bf++)
              {
                  top[bf] = hh.get(pogo.get(bf));
                 
              }
              
              
             
              ValueComparator bvc =  new ValueComparator(hh);
        TreeMap<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>(bvc);
        sorted_map.putAll(hh);
        
        int t=0;
        
    for(int key : sorted_map.keySet() )
    {
        
        if(t>6)
            break;
        
        if(t==0)
        { helm[0]=key;
       
        }
        
        if(t==1)
            helm[1]=key;
        if(t==2)
            helm[2]=key;
        if(t==3)
            helm[3]=key;
        if(t==4)
            helm[4]=key;
        
        t++;
    }
              
    
              
              
              
              
              Arrays.sort(helm);
              HashMap<Integer, Integer> tiger = new HashMap<>();
                FileReader kar = new FileReader("/users/btech/vakhil/train_final.csv");
      
            BufferedReader zar = new BufferedReader(kar);
              
               
              
              
            
              t=1;
              HashMap<String, Integer> bboy = new HashMap<>();
               while((ug = zar.readLine()) != null)
               {
                   if(t==(helm[0]) || t==(helm[1]) || t==(helm[2]) || t==(helm[3]) || t==(helm[4]))
                   {
                          String[] piece = ug.split(", ");
                              
                     for(int bf=0;bf<piece.length;bf++)
                     {
                         if(bf==piece.length-1)
                         {
                            String gaf= piece[bf].split(" ")[0];
                            if(bboy.containsKey(gaf))
                          {
                              bboy.put(gaf, bboy.get(gaf)+1);
                          }
                          else
                          {
                              bboy.put(gaf, 1);
                          }
                         }
                         else
                         {
                          if(bboy.containsKey(piece[bf]))
                          {
                              bboy.put(piece[bf], bboy.get(piece[bf])+1);
                          }
                          else
                          {
                              bboy.put(piece[bf], 1);
                          }
                         }
                     }
                     
                   }
                   
                   t++;
                   
                   
               }
              
               List<Integer> tale = new ArrayList<Integer>();
                for(String key:bboy.keySet())
                 {
                     if(bboy.get(key)>1)
                     {
                         System.out.println(key);
                         tale.add(Integer.decode(key));
                     }
                         
                     
                 }
             int common=0;
              for(int y=0;y<tale.size();y++)
              {
                  if(list.contains(tale.get(y)))
                  {
                      common++;
                  }
              }
              double P = (1.0* common)/tale.size();
              double R = (1.0 *common)/list.size();
              double score = 2*P*R;
             score = score/(P+R);
             System.out.println("Score Is "+ score);
              
             
                 
                 home++;
             }
            
               
           
           
           tr.close();
     }
 }

        
           
     
        
               
               
 
          
                     
                    
            
                
         
   
               
              
         class ValueComparator implements Comparator<Integer> {

    Map<Integer, Integer> base;
    public ValueComparator(Map<Integer, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(Integer a, Integer b) {
        if (base.get(a) >= base.get(b)) {
            return 1;
        } else {
            return -1;
        } // returning 0 would merge keys
    }
}
         
         
         
     
     
 