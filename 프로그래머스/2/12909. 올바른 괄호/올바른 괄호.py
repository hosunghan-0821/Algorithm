from collections import deque
def solution(s):
    stack = deque()
    
    for char in s:
        if char == '(':
            stack.append('(')
        else :
            if len(stack) == 0:
                return False
            stack.pop()
    
    if len(stack) != 0:
        return False
    return True