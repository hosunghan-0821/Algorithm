def solution(weights):
    answer = 0
    
    data = dict()
    for weight in weights:
        if weight in data :
            data[weight] = data[weight] + 1
        else :
            data[weight] = 1
    
    for key, val in data.items():
        
        if val > 1:
            answer += val * (val - 1) // 2
        if key * 3 % 2  == 0 and (key *3 // 2) in data:
            answer += val * data[key*3 // 2]
        if key * 2 in data:
            answer += val * data[key * 2]
        if key *4%3 == 0 and (key *4 // 3) in data:
            answer += val * data[key *4 // 3]
    
    return answer