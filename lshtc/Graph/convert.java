#code for creating a file to its parent file using a hierarchy

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
        
        FileReader fr = new FileReader("/home/vakhil/Desktop/hierarchy_final.txt");
             BufferedReader tr = new BufferedReader(fr);
             String w = tr.readLine();
              
              while((w = tr.readLine()) != null)
               {
                  String[] hell =  w.split("  ");
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
   
    
    public static void main(String[] args) throws IOException 
    {
        
        Graph X = new Graph();
         X.go();
         
        
        
      
    }
    
    
    void go() throws FileNotFoundException, IOException
    {
        
       
             
            DirectedGraph<String, DefaultEdge> g= createStringGraph();
            
           FileReader fr = new FileReader("/home/vakhil/Desktop/test_3.csv");
     
            BufferedReader tr = new BufferedReader(fr);
            PrintWriter writer = new PrintWriter("/home/vakhil/Desktop/test_4.csv", "UTF-8");
               // create a JGraphT graph
       
         
         
       String ug;
          while((ug = tr.readLine()) != null)
            {
                  String[] piece = ug.split(", ");
                    int a = piece.length;
                    String[] feature = piece[a-1].split(" ");
                    for(int y=0;y<a-1;y++)
                    {
                       
                      /*  if(y==a-1)
                        {
                            if(feature.length==0)
                                continue;
                            
                            if(g.containsVertex(feature[0]))
                            {
                               
                                Set<DefaultEdge> jim = g.incomingEdgesOf(feature[0]);
                             Iterator iter = jim.iterator();
                             if(jim.size()==0)
                             { writer.print(feature[0]+" ");
                             
                             break;
                             }
                              while (iter.hasNext()) {
                                  DefaultEdge ai = (DefaultEdge) iter.next();
                                
                      writer.print(g.getEdgeSource(ai)+ ", "); 
                                     }
                             
                             break;
                            }
                                
                             
                        }*/
                        if(g.containsVertex(piece[y]))
                        {
                            
                   Set<DefaultEdge> jim = g.incomingEdgesOf(piece[y]);
                        
                 if(feature.length==0)
                     continue;
                   
                            Iterator iter = jim.iterator();
                            if(jim.size()==0)
                            {  writer.print(piece[y]+" ");
                            break;
                            
                            }
                              while (iter.hasNext()) {
                                   DefaultEdge ai = (DefaultEdge) iter.next();
                                   
                     writer.print(g.getEdgeSource(ai)+ ", "); 
                                     }
                        }
                       
                    }
                    
                    for( int y=0;y<feature.length;y++)
                    {
                        writer.print(feature[y]+ " "); 
                    }
                
                
           
         
       writer.println(" "); 
            
         
             
        }
        
       writer.close();
            
        }
    
        
    }
    

