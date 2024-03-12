from collections import deque
total_row = 0
total_column = 0
dx = [0,0,-1,1]
dy = [1,-1,0,0]

def solution(board):
    global total_row, total_column
    
    answer = 0
    start_row, start_column = 0, 0
    goal_row, goal_column = 0, 0
    
    total_row =len(board)
    total_column = len(board[0])
    for i in range(total_row):
        for j in range(total_column):
            if board[i][j] == 'R':
                start_row = i
                start_column = j
                continue
            if board[i][j] == 'G':
                goal_row = i
                goal_column = j
    print(start_row, start_column, goal_row, goal_column)
    queue = deque()
    queue.append((start_row,start_column,0))
    visited = [[0 for _ in range (total_column)] for _ in range(total_row)]
    

    while queue:
        original_row, original_column,depth = queue.popleft()
        
        if original_row == goal_row and original_column ==goal_column:
            visited[original_row][original_column] = 1
            answer = depth
            break
            
        if visited[original_row][original_column] == 1:
            continue
            
        visited[original_row][original_column] = 1
        
      
        for i in range(4):
            row = original_row
            column = original_column
            row_direction = dy[i]
            column_direction = dx[i]
            
            while True:
                checked_row = row + row_direction
                checked_column = column + column_direction
    
                if checked_row < 0 or checked_row >= total_row or checked_column < 0 or checked_column >= total_column:
                    if visited[row][column] == 0:
                        queue.append((row, column,depth + 1))
            
                    break
                    
                if board[row + row_direction][column + column_direction] == 'D':
                    queue.append((row, column, depth + 1))
                    break
                    
                row += row_direction
                column += column_direction
    
    if visited[goal_row][goal_column] != 1:
        answer = -1
    
    return answer