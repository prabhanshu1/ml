import os, csv, sys,datetime,time
from scipy.sparse import *
from scipy import *
import numpy as np
from collections import OrderedDict
from sklearn.ensemble import RandomForestClassifier
from itertools import repeat
import globals
from input_file import read_idf,read_file,read_file1



def main():
    globals.init()

    idf_file="pb2.txt"
    read_idf(idf_file)

    train_filename = 'cros1000.csv'
    
    A=read_file1(train_filename,0)
    
    clf=RandomForestClassifier(n_estimators=10,min_samples_split=25)
    y=list(range(globals.length));
    clf.fit(A,y)
    row_no=globals.length

    ################################################################################

    while(1):
        cros_filename = str(input("Enter the file name: / quit to quit: "))

        if cros_filename == 'quit':
            exit(1)
       
        start=time.time()
        C=read_file1(cros_filename,1)
        near_neigh=clf.predict_proba(C);
        print(near_neigh)
        print(len(near_neigh[0]))
        if len(near_neigh[0]) != row_no:
            print("col size of predicted value not equal to max_train_size")
            exit(1)

        end=time.time()
        print("elapsed time")
        print(end-start)

        times=15
        while(times):
            times-=1
            alpha=float(input("alpha:"));
            result=[];
            true_positive=0;
            true_negative=0;
            false_negative=0;
            false_positive=0;
            for s in range(len(near_neigh)):
                dist={}
                l=0;
                near=(-np.array(near_neigh[s])).argsort()[:3]
                for t1 in range(len(near)):
                    temp=near[t1]
                    for t2 in globals.train_label[temp]: 
                        if t2 in dist:
                            dist[t2]=dist[t2]+pow(100,near_neigh[s][temp])
                        else:
                            dist[t2]=pow(100,near_neigh[s][temp])

                result.append([])
                Dist_ordered=OrderedDict(sorted(dist.items(),key=lambda t:-t[1]))
                Dist_list=list(Dist_ordered.items())
                print(Dist_ordered)

                for  i in range(len(Dist_list)):
                    if Dist_list[i][1] >= alpha:
                        result[s].append(Dist_list[i][0])
                temp2=len(set(result[s])-set(globals.cros_label[s]))
                true_positive+=len(result[s])-temp2
                false_positive+=temp2
                temp3=len(set(globals.cros_label[s])-set(result[s]))
                false_negative+=temp3

            print(result)
            print()
            print(globals.cros_label)
            if true_positive is 0 :
                continue;
            precision=true_positive/(true_positive+false_positive);
            print("precision -> ",precision)
            recall=true_positive/(true_positive+false_negative);
            print("recall -> ",recall)
            f1_score=2*precision*recall/(precision+recall)
            print("f1 score -> ",f1_score)


if __name__ == '__main__':
    main()
















