import sys

input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))
target = int(input())

data.sort()
left = 0
right = len(data) - 1
result = 0
    
while left != right:
    if data[left] + data[right] == target:
        result += 1
    if data[left] + data[right] <= target:
        left += 1
    else :
        right -=1
        
print(result)