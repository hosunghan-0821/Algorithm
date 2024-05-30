def solution(elements):
    answer = 0
    answer_array = []
    length = len(elements)
    sum_set= set()
    for i in range(length):
        
    
        v = elements[i]
        sum_set.add(v)
        for j in range(i + 1, i + length):
            
            v += elements[j % length]
            sum_set.add(v)
        
    return len(sum_set)