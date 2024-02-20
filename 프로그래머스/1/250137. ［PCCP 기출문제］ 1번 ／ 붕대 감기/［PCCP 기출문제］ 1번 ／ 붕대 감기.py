def solution(bandage, health, attacks):
    answer = health
    time_index = 0
    attacks_length= len(attacks)
    for i in range(attacks_length):
        answer -= attacks[i][1]
        if answer <= 0 :
            return -1
        if i + 1 < attacks_length:
            answer += bandage[1] * (attacks[i + 1][0] - attacks[i][0] - 1)
            answer += ((attacks[i + 1][0] - attacks[i][0] - 1) // bandage[0]) * bandage[2]
            if answer > health:
                answer = health
            
    
    if answer <= 0:
        answer = -1
    
    return answer