def getType(score_map, key1, key2):
    
    highType = key1
    if score_map.get(key1,0) > score_map.get(key2,0):
        highType = key1
    elif score_map.get(key1,0) < score_map.get(key2,0):
        highType = key2
    else  :
        if key1 > key2:
            highType = key2
        else:
            highType = key1
    
    return highType

def solution(survey, choices):
    answer = ''
    front_type_score = {1 : 3, 2: 2, 3:1,4:0}
    end_type_score = {5 : 1, 6 : 2, 7 : 3}

    score_map = {}
    for i, survey_data in enumerate(survey):
        front_type = survey_data[0]
        end_type = survey_data[1] 
        
        choice = choices[i]
    
        if choice in front_type_score.keys():
            score = front_type_score[choice]
            score_map[front_type] = score_map.get(front_type, 0) + score 
        else:
            score = end_type_score[choice]
            score_map[end_type] = score_map.get(end_type, 0) + score 
    
    answer_list = []
    answer_list.append(getType(score_map,"R","T"))
    answer_list.append(getType(score_map,"C","F"))
    answer_list.append(getType(score_map,"J","M"))
    answer_list.append(getType(score_map,"A","N"))
    

    answer = str.join('',answer_list)
    return answer