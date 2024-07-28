import sys

input = sys.stdin.readline

num = int(input())
input_list = list(map(int,input().split()))
input_list.sort()
cnt = 0
for i in range(num):
    target = input_list[i]
    start = 0
    end = len(input_list) - 1
    while start < end:
        if input_list[start] + input_list[end] == target:
            
            if start == i:
                start += 1
                
            elif end == i:
                end -= 1
                
            else :
                cnt += 1
                break
                
        elif input_list[start] + input_list[end] < target:
            
            start += 1
        elif input_list[start] + input_list[end] > target :
            end -= 1
    
print(cnt)
 