
def solution(n):
    
    answer = ''
    share = n;
    while (share != 0):
        
        print(share)
        remainder = share % 3
        share = share // 3
        
        if remainder == 0:
            share -= 1
            answer = '4'+ answer 
        elif remainder == 1:
            answer = '1'+ answer
        else:
            answer = '2'+answer
            
    return answer