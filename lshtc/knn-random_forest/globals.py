

def init():
    global train_label
    global cros_label
    global row
    global col
    global data
    global max_col
    global idf
    global length
    global offset
    global true_positive
    global true_negative
    global false_positive
    global false_negative
    true_positive=0
    true_negative=0
    false_positive=0
    false_negative=0
    offset=0
    train_label=[]
    cros_label=[]
    row=[]
    col=[]
    data=[]
    max_col=2086000;
    idf=[0]*2086000
    length=0
