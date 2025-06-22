from collections import deque

def solution(want, number, discount):
    answer = 0
    wantDict ={}
    myQueue = deque()
    for i in range (0,len(want)):
        wantDict[want[i]]= number[i]
    print(wantDict)
    for index in range (0,10):
        myQueue.append(discount[index])
        if wantDict.get(discount[index]) is not None:
            wantDict[discount[index]]= wantDict[discount[index]] - 1
         
    if check_all_product_sales(wantDict):
        answer+=1
    
    
    for index in range(10,len(discount)):
        # 기존에 들어있는거 빼고 새로운거 넣어섯 판별 후 0 이면 return
        key = myQueue.popleft()
        if wantDict.get(key) is not None:
            wantDict[key]= wantDict[key] + 1
            
        myQueue.append(discount[index])
        if wantDict.get(discount[index]) is not None:
            wantDict[discount[index]]= wantDict[discount[index]] - 1
 
        if check_all_product_sales(wantDict):
            answer += 1
    
    return answer
def check_all_product_sales(wantDict):
    for key in wantDict:

        if wantDict[key] > 0:
            return False
        
    return True