import csv, sys,datetime,os,time
from scipy.sparse import *
from scipy import *
import numpy as np
from collections import OrderedDict
from sklearn.neighbors import NearestNeighbors
from sklearn import *
#from scipy.spatial.distance import *
import globals


def read_idf(idf_file):
    with open(idf_file,newline='') as f:
        for line in f:
            a,b= line.split()
            a=int(a);
            b=float(b);
            globals.idf[a]=int(b);


def read_file(filename,ids):
    row=[];
    col=[];
    data=[]
    max_col=0;
    label=[]
    i=0;
    
    with open(filename, newline='') as f:
        reader = csv.reader(f)
        try:
            for ro in reader:
                label.append(ro)
                x=label[i][len(label[i])-1].split()
                label[i][len(label[i])-1]=int(x[0])
                label[i]=[int(i) for i in label[i]]
                del x[0]

                x=[line.split(':',1) for line in x]
                for l in range(len(x)):
                    row.append(int(i))
                    col.append(int(x[l][0]))
                    if max_col< int(x[l][0]):
                        max_col=int(x[l][0])
                    asd=int(int(x[l][1])*globals.idf[int(x[l][0])])
                    data.append(asd)
                i=i+1    
            globals.length=i;
            globals.max_col=max_col;
            if ids is 0:
                globals.train_label=label; label=[];
                return csr_matrix( (data,(row,col)), shape=(i,globals.max_col+1),dtype=int16)
                row=[];col=[];data=[];

            else:
                globals.cros_label=label;label=[]
                return csr_matrix( (data,(row,col)), shape=(i,globals.max_col+1),dtype=int16)
                row=[];col=[];data=[];
        except csv.Error as e:
            sys.exit('file {}, line {}: {}'.format(filename, reader.line_num, e))










