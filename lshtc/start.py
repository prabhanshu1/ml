import csv, sys,datetime
from scipy.sparse import *
from scipy import *
import numpy as np
from collections import OrderedDict
from sklearn.neighbors import KNeighborsClassifier
from sklearn.neighbors import NearestNeighbors
label=[]
row=[]
col=[]
data=[]
max_col=0;
i=0;
filename = 'trainsub.csv'
t1=datetime.datetime.now();
with open(filename, newline='') as f:
    reader = csv.reader(f)
    try:
        for ro in reader:
            
            label.append(ro)
            x=label[i][len(label[i])-1].split()
            label[i][len(label[i])-1]=int(x[0])
           # print(label)
            
            #print(x)
            print(i)
            label[i]=[int(i) for i in label[i]]
            del x[0]
            
            x=[line.split(':',1) for line in x]
            for l in range(len(x)):
               # print(type(row),type(i))
                row.append(int(i))
                #print(type(col),type(x[l][0]))
                col.append(int(x[l][0]))
                if max_col< int(x[l][0]):
                    max_col=int(x[l][0])
                data.append(int(x[l][1]))
            i=i+1    
            
            
    except csv.Error as e:
        sys.exit('file {}, line {}: {}'.format(filename, reader.line_num, e))

print(max_col)
#row=np.array(row)
#row=[int(i) for i in row]
print(type(row))
#print (row)
#col=np.array(col)
#col=[int(i) for i in col]
print(type(col))
#print (col)
#data=np.array(data)
#data=[int(i) for i in data]
#print(data)
print (len(row), len(col), len(data))
print(row[111],col[111],data[111])

# print (row)

# print(len(row))
# print(col)
# print(len(col))
# print(data)
# print(len(data))
# print(i,row[len(row)-1])

A=csr_matrix( (data,(row,col)), shape=(i,max_col+1),dtype=int16 )
print(type(A),size(A))
print(sys.getsizeof(A))
a=[0]*(max_col+1);
neigh=NearestNeighbors(1)
neigh.fit(A)
print()
near_neigh=neigh.kneighbors([a],9)
dist={}
l=0;
for i in range(len(near_neigh[1][0])):
    if i!=0 and near_neigh[0][0][i]!=near_neigh[0][0][i-1]:
        l=l+1
    for j in label[near_neigh[1][0][i]]:
        if j in dist:
            dist[j]=dist[j]+1/(l+1)
        else:
            dist[j]=1/(l+1)

result=[]    
Dist_ordered=OrderedDict(sorted(dist.items(),key=lambda t:-t[1]))
Dist_list=list(Dist_ordered.items())
alpha=0.5;
for  i in range(len(Dist_list)):
    if Dist_list[i][1] >= alpha:
        result.append(Dist_list[i][0])

        
    

# print()
# t2=datetime.datetime.now()
# print(t2-t1)

# z=A[1].toarray()
# z[0][f]

# length_train=len(label);
# i=0;
# length_feature=5000000;

# features=np.zeros((length_train,length_feature),dtype='int16')

# print()
# while(i<length_train):
#     x=label[i][len(label[i])-1].split()
#     label[i][len(label[i])-1]=int(x[0])
#   #  map(int, label[i])
#     label[i] = [int(i) for i in label[i]] 
#     del x[0]
#     x=[line.split(':',1) for line in x]
#     for f in range(len(x)):
#         features[i][int(x[f][0])]=int(x[f][1])
#     i+=1
# #print(features)
# print (label)
# y=list(range(length_train));
# #knn=KNeighborsClassifier(n_neighbors=1)
# #print (knn)

# #knn.fit(features,y)
# #a=[0,1,1,2,0,1,1,0,1,1,0]
# a=[0]*length_feature;
# #p=knn.predict(a)
# #print(p)
# #print(knn.predict_proba(a))
# #print (knn.get_params([a]));
# #knn.kneighbors([a,2]);
# neigh=NearestNeighbors(1)
# neigh.fit(features)
# print()
# print(neigh.kneighbors([a],2))
# print()
# t2=datetime.datetime.now()
# print(t2-t1)


# # for features=10^6 and m=5 0.205
# # for features=10^7 and m=5 1.505
# # for features=10^7 and m=10 1.65

# 10 lac 2:19 sec. 
