import sys

input = sys.stdin.readline

N, M = map(int, input().split())

data = []

for i in range(M):
    data.append(int(input()))

data.sort()
start = 1
end = data[len(data) - 1]

answer = 0
while start <= end:
    mid = (start + end) // 2
    sum = 0
    for element in data:
        sum += element // mid
        if element % mid != 0:
            sum += 1;

    if sum > N:
        start = mid + 1;
    else:
        end = mid - 1;
        answer = mid

print(answer)