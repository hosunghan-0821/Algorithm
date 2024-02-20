def solution(board, h, w):
    answer = 0
    
    row = h
    column = w
    total_row = len(board)
    total_column = len(board[0])
    
    dx = [1,-1,0,0]
    dy = [0,0,-1,1]
    
    target_color = board[row][column]
    
    for i in range(4):
        
        checked_row = row + dy[i]
        checked_column = column + dx[i]
        
        if checked_row < 0 or checked_row >= total_row or checked_column < 0 or checked_column >= total_column:
            continue
        
        if board[checked_row][checked_column] == target_color:
            answer += 1
    
    return answer