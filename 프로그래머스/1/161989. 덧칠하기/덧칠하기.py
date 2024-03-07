def solution(n, m, section):
    
    answer = 0
    start = section[0]
    end = start + m - 1
    count = 1
    for i in range(1, len(section)):
        if section[i] > end:
            count += 1
            end = section[i] + m -1
            
    return count