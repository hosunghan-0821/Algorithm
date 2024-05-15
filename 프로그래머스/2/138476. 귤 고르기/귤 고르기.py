import heapq
def solution(k, tangerine):
    answer = 0
    count_dict = dict()
    data = []
    for tangerine_each in tangerine:
        if count_dict.get(tangerine_each) is not None:
            count_dict[tangerine_each] = count_dict[tangerine_each] + 1
        else :
            count_dict[tangerine_each] = 1
 

    count_dict = dict(sorted(count_dict.items(), key = lambda x: x[1], reverse =True))

    for i in count_dict:
        if k <= 0:
            break
        k -= count_dict[i]
        answer += 1
    
    
    return answer