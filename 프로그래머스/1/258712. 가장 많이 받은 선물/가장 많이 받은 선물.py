def solution(friends, gifts):
    answer = 0
    gift_point = dict()
    gift_name_map = dict()
    friend_length = len(friends)
    gift_2D_map = [[0 for _ in range(friend_length)] for _ in range(friend_length)] 
    
    for index , friend in enumerate(friends):
        gift_point[friend] = 0
        gift_name_map[friend] = index
    
    # print(gift_2D_map)
    # print(gift_point)
    # print(gift_name_map)
    for gift in gifts:
        data = gift.split()
        giver_index = gift_name_map.get(data[0])
        receiver_index = gift_name_map.get(data[1])
        gift_point[data[0]] += 1
        gift_point[data[1]] -= 1
        gift_2D_map[giver_index][receiver_index] += 1
    
    for i in range(friend_length):
        present_num = 0
        for j in range(friend_length):
            if (i ==j):
                continue
            if gift_2D_map[i][j] > gift_2D_map[j][i] :
                present_num += 1
            elif gift_2D_map[i][j] == gift_2D_map[j][i] and gift_point[friends[i]] > gift_point[friends[j]]:
                present_num += 1
        
        if present_num > answer:
            answer = present_num
        
    
    return answer