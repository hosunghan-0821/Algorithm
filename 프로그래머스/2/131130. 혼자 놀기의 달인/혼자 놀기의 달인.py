import sys
sys.setrecursionlimit(10000000)

def DFSRecursive(cards,index,data_collection,count,visited):
    
    if visited[index] is True:
        
        return
    
    visited[index] = True
  
    data_collection[count] = data_collection.get(count) + 1
    DFSRecursive(cards, cards[index - 1],data_collection,count,visited)
    

def solution(cards):
    answer = 0
    count = 1
    visited = [False] * (len(cards) + 1)

    data_collection = dict()
    for index,card in enumerate(cards):
        if visited[index + 1] is False:
            
            data_collection[count] = 1
            visited[index + 1] = True
            DFSRecursive(cards, card, data_collection, count, visited)
            count += 1
    
    data_collection = sorted(data_collection.items(), key=lambda item: -item[1])
    print(data_collection)
    if len(data_collection) == 1 or len(data_collection) == 0:
        return 0
    else :
        answer = data_collection[0][1] * data_collection[1][1] 
    return answer