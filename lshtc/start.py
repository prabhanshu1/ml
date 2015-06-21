import csv, sys,datetime
from scipy.sparse import *
from scipy import *
import numpy as np
from collections import OrderedDict
from sklearn.neighbors import KNeighborsClassifier
from sklearn.neighbors import NearestNeighbors
from sklearn.metrics import coverage_error
from sklearn.metrics import accuracy_score
from sklearn.metrics import f1_score
from sklearn.metrics import zero_one_loss
from sklearn.metrics import classification_report

train_label=[]
train_row=[]
train_col=[]
train_data=[]
max_train_col=0;
i=0;
train_filename = 'cros_file.csv'
t1=datetime.datetime.now();
with open(train_filename, newline='') as f:
    reader = csv.reader(f)
    try:
        for ro in reader:
            
            train_label.append(ro)
            x=train_label[i][len(train_label[i])-1].split()
            train_label[i][len(train_label[i])-1]=int(x[0])
           # print(train_label)
            
            #print(x)
            print(i)
            train_label[i]=[int(i) for i in train_label[i]]
            del x[0]
            
            x=[line.split(':',1) for line in x]
            for l in range(len(x)):
               # print(type(train_row),type(i))
                train_row.append(int(i))
                #print(type(train_col),type(x[l][0]))
                train_col.append(int(x[l][0]))
                if max_train_col< int(x[l][0]):
                    max_train_col=int(x[l][0])
                train_data.append(int(x[l][1]))
            i=i+1    
            
            
    except csv.Error as e:
        sys.exit('file {}, line {}: {}'.format(filename, reader.line_num, e))

print(max_train_col)
#train_row=np.array(train_row)
#train_row=[int(i) for i in train_row]
print(type(train_row))
#print (train_row)
#train_col=np.array(train_col)
#train_col=[int(i) for i in train_col]
print(type(train_col))
#print (train_col)
#train_data=np.array(train_data)
#train_data=[int(i) for i in train_data]
#print(train_data)
print (len(train_row), len(train_col), len(train_data))
print(train_row[111],train_col[111],train_data[111])

# print (train_row)

# print(len(train_row))
# print(train_col)
# print(len(train_col))
# print(train_data)
# print(len(train_data))
# print(i,train_row[len(train_row)-1])
max_train_col=2086000

A=csr_matrix( (train_data,(train_row,train_col)), shape=(i,max_train_col+1),dtype=int16 )
train_row=[];train_col=[];train_data=[];
print(type(A),size(A))
print(sys.getsizeof(A))
#a=[0]*(max_train_col+1);
neigh=NearestNeighbors(1)
neigh.fit(A)
print()



cros_label=[]
cros_row=[]
cros_col=[]
cros_data=[]
max_cros_col=0;
i=0;
cros_filename = 'test_file.csv'
t1=datetime.datetime.now();
with open(cros_filename, newline='') as f:
    reader = csv.reader(f)
    try:
        for ro in reader:
            
            cros_label.append(ro)
            x=cros_label[i][len(cros_label[i])-1].split()
            cros_label[i][len(cros_label[i])-1]=int(x[0])
           # print(cros_label)
            
            #print(x)
            print(i)
            cros_label[i]=[int(i) for i in cros_label[i]]
            del x[0]
            
            x=[line.split(':',1) for line in x]
            for l in range(len(x)):
               # print(type(cros_row),type(i))
                cros_row.append(int(i))
                #print(type(cros_col),type(x[l][0]))
                cros_col.append(int(x[l][0]))
                if max_cros_col< int(x[l][0]):
                    max_cros_col=int(x[l][0])
                cros_data.append(int(x[l][1]))
            i=i+1    
            
            
    except csv.Error as e:
        sys.exit('file {}, line {}: {}'.format(filename, reader.line_num, e))

print(max_cros_col)
#cros_row=np.array(cros_row)
#cros_row=[int(i) for i in cros_row]
print(type(cros_row))
#print (cros_row)
#cros_col=np.array(cros_col)
#cros_col=[int(i) for i in cros_col]
print(type(cros_col))
#print (cros_col)
#cros_data=np.array(cros_data)
#cros_data=[int(i) for i in cros_data]
#print(cros_data)
print (len(cros_row), len(cros_col), len(cros_data))
print(cros_row[111],cros_col[111],cros_data[111])

# print (cros_row)

# print(len(cros_row))
# print(cros_col)
# print(len(cros_col))
# print(cros_data)
# print(len(cros_data))
# print(i,cros_row[len(cros_row)-1])

max_cros_col=2086000
C=csr_matrix( (cros_data,(cros_row,cros_col)), shape=(i,max_cros_col+1),dtype=int16 )
cros_row=[];cros_col=[];cros_data=[];
print(type(A),size(A))
print(sys.getsizeof(A))
#a=[0]*(max_cros_col+1);

result=[]
near_neigh=neigh.kneighbors(C,9)
print(near_neigh)
for s in range(len(near_neigh[1])):
    
    dist={}
    l=0;
    for i in range(len(near_neigh[1][s])):
        if i!=0 and near_neigh[0][s][i]!=near_neigh[0][s][i-1]:
            l=l+1
        for j in train_label[near_neigh[1][s][i]]:
            if j in dist:
                dist[j]=dist[j]+1/(l+1)
            else:
                dist[j]=1/(l+1)
    print (s)
    
    result.append([])
    print(result)
    Dist_ordered=OrderedDict(sorted(dist.items(),key=lambda t:-t[1]))
    Dist_list=list(Dist_ordered.items())
    print(Dist_list)
    alpha=1.5;
    for  i in range(len(Dist_list)):
        if Dist_list[i][1] >= alpha:
            result[s].append(Dist_list[i][0])

print(result)
print()
print(cros_label)
print(accuracy_score(cros_label,result))
print(f1_score(cros_label,result))# returns the f1 score total;
print(f1_score(cros_label,result,average=None)) # returns f1 score of all the class
print(f1_score(cros_label,result,average='micro')) #returns average f1 score of all class
print(f1_score(cros_label,result,average='macro')) #same but takes care of imbalance
print(f1_score(cros_label,result,average='weighted')) #average weighted by support.


print(zero_one_loss(cros_label,result))
print(zero_one_loss(cros_label,result,normalize=False))


#print(coverage_error(cros_label,result));

    

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
