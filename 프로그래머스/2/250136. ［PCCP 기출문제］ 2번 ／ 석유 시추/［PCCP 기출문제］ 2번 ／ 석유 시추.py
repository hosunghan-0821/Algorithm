import copy
import sys

sys.setrecursionlimit(10000000)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
    
max_value = 0
frag_info = {}
frag_index = 2
    
def DFSRecursive(land, row, column, total_row, total_column):
    
    global dx, dy
    global max_value
    global frag_index
    
    if row < 0 or row >= total_row or column < 0 or column >= total_column:
        return False
    
    if land[row][column] != 1:
        return False
    
    land[row][column] = frag_index
    max_value += 1
    
    for i in range(4):
        new_row = row + dy[i]
        new_column = column + dx[i]
        DFSRecursive(land, new_row, new_column, total_row, total_column)
    
    
def solution(land):
    global max_value
    global frag_index,frag_info
    answer = 0
    
    row = len(land)
    column = len(land[0])
    
    for j in range(column):
        
        for i in range(row):
            max_value = 0
            DFSRecursive(land, i, j, row, column)
            
            if max_value != 0:
                frag_info[frag_index] = max_value
                frag_index += 1
            
    
    for j in range(column):
        frag_set = set()
        sum = 0
        for i in range(row):
            if land[i][j] != 0:
                frag_set.add(land[i][j])
        
        for data in frag_set:
            sum += frag_info[data]
        
        if  answer < sum:
            answer = sum
            
    return answer