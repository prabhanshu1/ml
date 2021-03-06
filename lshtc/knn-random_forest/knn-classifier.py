import csv, sys,datetime,os,time
from scipy.sparse import *
from scipy import *
import numpy as np
from collections import OrderedDict
from sklearn.neighbors import NearestNeighbors
from sklearn import *
#from scipy.spatial.distance import *
from input_file import read_idf,read_file,read_file1
import globals



def main():
    globals.init()

    idf_file="train-idf"
    read_idf(idf_file)

    train_filename = "train_c"
    A=read_file(train_filename,0,0)

    #NearestNeighbors(n_neighbors = 3, algorithm='ball_tree', metric='pyfunc', func=custom_dist_func)
    #neigh.fit(data)

    ################################################################################
    print(globals.length)
    neigh=NearestNeighbors(n_neighbors=5,algorithm='brute',metric='cosine')
    neigh.fit(A)
    A=[]

    while(1):
        cros_filename = str(input("Enter the file name: / quit to quit: "))

        if cros_filename == 'quit':
            exit(1)
       
        start=time.time()
        globals.offset=0
        while(1):
                        
            C=read_file(cros_filename,1,globals.offset)
            if globals.length == 0:
                break;

            ################################################################################

            near_neigh=neigh.kneighbors(C,5)

            #print(near_neigh)    

            times=1
            while(times):
                times-=1
                #alpha=float(input("alpha:"));
                alpha=0.5
                result=[];
                true_positive=0;
                true_negative=0;
                false_negative=0;
                false_positive=0;
                for s in range(len(near_neigh[1])):
                    dist={}
                    l=1;
                    for i in range(len(near_neigh[1][s])):
                        if i!=0 and near_neigh[0][s][i]!=near_neigh[0][s][i-1]:
                            l=l+1
                        for j in globals.train_label[near_neigh[1][s][i]]:
                            if j in dist:
                                #dist[j]=dist[j]+(near_neigh[0][s][i]+0.00001)
                                dist[j]=dist[j]+1/(l+1)
                            else:
                                #dist[j]=(near_neigh[0][s][i]+0.00001)
                                dist[j]=1/(l+1)

                    result.append([])
                    Dist_ordered=OrderedDict(sorted(dist.items(),key=lambda t:-t[1]))
                    Dist_list=list(Dist_ordered.items())
                    #alpha=2;
                    for  i in range(len(Dist_list)):
                        #if i>3 :
                         #   break;
                        if Dist_list[i][1] >= alpha:
                            result[s].append(Dist_list[i][0])

                    temp2=len(set(result[s])-set(globals.cros_label[s]))
                    true_positive+=len(result[s])-temp2
                    false_positive+=temp2
                    temp3=len(set(globals.cros_label[s])-set(result[s]))
                    false_negative+=temp3
                print(" alpha -> ",alpha)
                #print(result)
                #print(" result  \n ")
                #print(globals.cros_label)
                if true_positive is 0 :
                    continue;
                precision=true_positive/(true_positive+false_positive);
                print("precision -> ",precision)
                recall=true_positive/(true_positive+false_negative);
                print("recall  -> ",recall)
                f1_score=2*precision*recall/(precision+recall)
                print("f1 score  -> ",f1_score)
                globals.true_positive+=true_positive
                globals.false_positive+=false_positive
                globals.true_negative+=true_negative
                globals.false_negative+=false_negative

        end=time.time()
        print("elapsed time")
        print(end-start)
        precision=globals.true_positive/(globals.true_positive+globals.false_positive);
        print("precision -> ",precision)
        recall=globals.true_positive/(globals.true_positive+globals.false_negative);
        print("recall  -> ",recall)
        f1_score=2*precision*recall/(precision+recall)
        print("f1_score -> ",f1_score)

if __name__ == '__main__':
    main()

