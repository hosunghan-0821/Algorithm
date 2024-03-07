from collections import deque

dx = [1,-1,0,0]
dy = [0,0,1,-1]
total_row = 0
total_column = 0

def bfs(land,row, column, block_number):
    global dx,dy
    global total_row, total_column
    
    queue = deque()
    
    if land[row][column] != 1:
        return -1
    
    count = 1
    land[row][column] = block_number
    
    queue.append((row, column))
    while queue:
        
        now_row, now_column= queue.popleft()
        
        for i in range(4):
            
            check_row = now_row + dy[i]
            check_column = now_column + dx[i]
            
            if check_row < 0 or check_row >=total_row or check_column < 0 or check_column >= total_column:
                continue
            
            if land[check_row][check_column] == 1:
                land[check_row][check_column] = block_number
                count += 1
                queue.append((check_row, check_column))
    
    return count
    

def solution(land):
    global total_row, total_column
    answer = 0
    total_row = len(land)
    total_column = len(land[0])
    data = dict()
    
    block_number = 2
    for i in range(total_row):
        for j in range(total_column):
            result = bfs(land, i, j, block_number)
            if result != -1:
                data[block_number] = result
                block_number += 1
                
    max_value = 0

    for i in range(total_column):
        blocks= set()
        value = 0
        for j in range(total_row):
            blocks.add(land[j][i])
        
        for block in blocks:
            if block != 0:
                value += data.get(block)
        
        if value > max_value:
            max_value = value
    
    return max_value