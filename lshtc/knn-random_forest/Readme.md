#####globals.py
It contains global variables needed in every file (input_file,knn-neighbours.py, random_forest.py, etc)

#####input_file.py
It has three function, although the two read_file and read_file1 are almost same they only differ in parsing the two different file.

read_file1 is for parsing those file whose lines are of type :
>label_0,label_1,...,label_n  feature_0:val_0  feature_1:val_1  ...  feature_m:val_m

and read_file is for parsing those file whose lines are of type:
>label_0,label_1,...,label_n,  feature_0:val_0  feature_1:val_1  ...  feature_m:val_m

The other function is read_idf, which read the idf file and make a list that stores feature: idf_value

#####knn-classifier.py
Every time you run a code specify the training file name and the function read_file or read_file1. 

Also you have to fix the function for reading cros validation /testing file before running the code.

#####random_forest.py
Same as above.
