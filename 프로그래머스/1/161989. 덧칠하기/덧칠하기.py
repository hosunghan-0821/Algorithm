def solution(n, m, section):
    answer = 0
    
    cnt = 1
    standard = section[0]
    for i in section:
        
        if i > standard + m - 1:
            cnt += 1
            standard = i
    
    return cnt