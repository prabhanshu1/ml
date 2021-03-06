#This file is identifying all top nodes and using them




import static com.sun.org.apache.xerces.internal.util.Status.SET;
import java.io.IOException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.PropertyDescriptor.SET;
import org.jgrapht.Graphs;


import java.net.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jgraph.JGraph;

import org.jgrapht.*;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;



public class Graph
{

    DirectedGraph<String, DefaultEdge> g =
            new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
    
List<String> list = new ArrayList<String>();
    private  DirectedGraph<String, DefaultEdge> createStringGraph() throws FileNotFoundException, IOException
    {
        
        FileReader fr = new FileReader("/home/vakhil/hierarchy.txt");
             BufferedReader tr = new BufferedReader(fr);
             String w = tr.readLine();
              
              while((w = tr.readLine()) != null)
               {
                  String[] hell =  w.split(" ");
                  g.addVertex(hell[0]);
                  g.addVertex(hell[1]);
                  g.addEdge(hell[0], hell[1]);
                                   
                   
              } /*
               g.addVertex("2");
                  g.addVertex("3");
               
                  g.addVertex("1");
                
                  
                  g.addVertex("4");
                  g.addVertex("5");
                   g.addVertex("6");
                  g.addVertex("7");
                  g.addEdge("1", "3");
                   g.addEdge("1", "2");
                  g.addEdge("4", "5");
                 
                   g.addEdge("4", "6");
                 
                  
                  g.addEdge("6", "7");
                  g.addEdge("3", "4");
                  g.addEdge("5", "3");
                  
                  */
                 
        
                 
                  
               return g;
              

       

       
    }
   
    
    public static void main(String[] args) 
    {
        
         Graph X = new Graph();
         X.go();
         
        
        
      
    }
    
    
    void go()
    {
        
       
    
        try {
             
            DirectedGraph<String, DefaultEdge> g= createStringGraph();
            GraphIterator<String, DefaultEdge> it =   new BreadthFirstIterator<String, DefaultEdge>(g);
               // create a JGraphT graph
       
          
             
             while(it.hasNext())
                   {
                       String a = it.next();
                       
                       if(g.inDegreeOf(a)== 0)
                       {
                           System.out.println("-1 "+a);
                           list.add(a);
                       }
                  } 
            g.addVertex("-1");
            
             for(int z=0;z<list.size();z++)
             {
                 g.addEdge("-1",list.get(z) );
             }
                 
            
         int z=-1;
         Hashtable<String,String> kane = new Hashtable<>();
         String per =null;
         AsUndirectedGraph g2 = new AsUndirectedGraph(g);
         GraphIterator<String, DefaultEdge> bt =   new BreadthFirstIterator<>(g2, "112866");
         
         PrintWriter writer = new PrintWriter("/home/vakhil/Desktop/hierarchy_final.txt", "UTF-8");
              while(bt.hasNext())
              {
                  String a = bt.next();
                  kane.put(a, "visit");
                 
                
                
                 
                   Set<DefaultEdge> jim = g2.edgesOf(a);
                   List<DefaultEdge> cum ;
                   cum = new ArrayList<>();
                   for(Iterator<DefaultEdge> iterator = jim.iterator(); iterator.hasNext();)
                   { 
                       
                       DefaultEdge f = iterator.next();
                       
                       if(   !kane.containsKey(g2.getEdgeTarget(f)) && g2.getEdgeSource(f)!="-1"  )
                       {
                       String yak= f.toString().substring(1, f.toString().length()-1);
                       
                        String[] dog = yak.split(":");
                        System.out.println(dog[0]+dog[1]);
                         writer.println(dog[0]+dog[1]);
                       }
                       
                      
                    }
                   
                   
                   
                    }
                      
           writer.close();
                  
              }
        
        catch (IOException ex)
        {
            
        }
            
        }
    
        
    }
    
