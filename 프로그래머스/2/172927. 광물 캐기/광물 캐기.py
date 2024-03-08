def solution(picks, minerals):
    answer = 0
    dia_num, iron_num, stone_num = picks
    
    index = 0
    check_data = []
    
    dia_result = 0
    iron_result = 0
    stone_result = 0
    minerals_length = len(minerals)
    minerals_allowed_length = dia_num * 5 + iron_num * 5 + stone_num * 5
    
    for i in range(minerals_allowed_length):
        
        if i == minerals_length:
            break
        # 5개 이상 체크시 멈춤
        
        if i % 5 == 0 and i != 0:
            check_data.append((dia_result, iron_result, stone_result))
            dia_result = 0
            iron_result = 0
            stone_result = 0
            
        
        if minerals[i] == "diamond":
            dia_result += 1
        elif minerals[i] == "iron":
            iron_result += 1
        else :
            stone_result += 1
        
    
    check_data.append((dia_result,iron_result,stone_result))
    
    check_data.sort(key = lambda x: [-x[0], -x[1], -x[2]])
    print(check_data)
    for data in check_data:
        
        if dia_num != 0:
            answer += data[0] * 1 + data[1] * 1 + data[2] * 1
            dia_num -= 1
        elif iron_num != 0 :
            answer += data[0] * 5 + data[1] * 1 + data[2] * 1
            iron_num -= 1
        elif stone_num != 0 :
            answer += data[0] * 25 + data[1] * 5 + data[2] * 1
            stone_num -= 1

    return answer