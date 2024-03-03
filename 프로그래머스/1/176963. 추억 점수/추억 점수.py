def solution(name, yearning, photo):
    answer = []
    score_map = dict() 
    # 점수 세팅
    for i in range(len(name)):
        score_map[name[i]] = yearning[i]
    
    for i in range(len(photo)):
        sum = 0
        for j in range(len(photo[i])):
            score = score_map.get(photo[i][j])
            if score is not None:
                sum += score
        answer.append(sum)
        
    return answer