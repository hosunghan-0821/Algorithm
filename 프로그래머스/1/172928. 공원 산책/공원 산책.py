def check_valid_direction(t_row,t_column,changed_row,changed_column):
    if changed_row < 0 or changed_row >= t_row or changed_column < 0 or changed_column >= t_column:
        return False
    return True

def check_none_disorder(park,now_row,now_column):
    # print(f"now_row = {now_row} now_column = {now_column}")
    if park[now_row][now_column] == 'X':
        return False
    return True

def solution(park, routes):
    answer = []
    t_row = len(park)
    t_column = len(park[0])
    
    now_row = 0
    now_column = 0
    for i in range(t_row):
        for j in range(t_column):
            if park[i][j] == 'S':
                now_row = i
                now_column = j
                
    for route in routes:
        direction, count= route.split()
        count = int(count)
        is_valid = True
        if direction == 'E':
            
            if check_valid_direction(t_row, t_column, now_row, now_column + count):
                for i in range(now_column + 1, now_column + count + 1):
                    if check_none_disorder(park, now_row, i) is False:
                        is_valid = False
                        break
                if is_valid :
                    now_column += count
                
        elif direction == 'W':
            if check_valid_direction(t_row, t_column, now_row, now_column - count):
                
                for i in range(now_column - 1, now_column - count - 1, -1):
                    if check_none_disorder(park,now_row,i) is False:
                        is_valid = False
                        break
                if is_valid:        
                    now_column -= count
                    
        elif direction == 'S':
            if check_valid_direction(t_row, t_column, now_row + count, now_column):
                for i in range(now_row + 1, now_row + count + 1):
                    if check_none_disorder(park,i,now_column) is False:
                        is_valid = False
                        break
                if is_valid:
                    now_row += count
        else:
            if check_valid_direction(t_row, t_column, now_row - count, now_column):
                
                for i in range(now_row - 1, now_row - count - 1, -1):
                    if check_none_disorder(park,i,now_column) is False:
                        is_valid = False
                        break
                if is_valid:
                    now_row -= count
    

    return [now_row, now_column]