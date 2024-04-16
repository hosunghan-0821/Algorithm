from collections import deque
import sys

sys.setrecursionlimit(1000000000)

row = 0
column = 0
count = 0

def dfsReursive(maps, visited, now_row, now_column):
    global row
    global column
    global count
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    
    if visited[now_row][now_column] != 0:
        return False
    
    visited[now_row][now_column] = 1

    count += int(maps[now_row][now_column])
    for i in range(4):
        new_row = now_row + dx[i]
        new_column = now_column + dy[i]
        
        if new_row < 0 or new_row >= row or new_column < 0 or new_column >= column:
            continue
            
        if maps[new_row][new_column] != 'X' and visited[new_row][new_column] == 0:
            dfsReursive(maps, visited, new_row, new_column)
            
    return True    
    
    

def solution(maps):
    global row
    global column
    global count
    
    answer = []
    row =len(maps)
    column = len(maps[0])
    visited = [[0 for _ in range(column)] for _ in range(row)]
    
    for i in range(row):
        for j in range(column):
            if maps[i][j] != 'X':
                count = 0
                result = dfsReursive(maps, visited, i, j)
                if result is True:
                    answer.append(count)
    
    
    if len(answer) == 0:
        answer.append(-1)
    
    answer.sort()
    
    return answer