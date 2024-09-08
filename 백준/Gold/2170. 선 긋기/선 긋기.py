import sys

input = sys.stdin.readline

N = int(input())

data = []
for i in range(N):
    x, y = map(int, input().split())
    data.append((x, y))

data.sort(key=lambda x: (x[0],x[1]))

start = data[0][0]
end = data[0][1]

length = end-start
for i in range(1, N):
    x = data[i][0]
    y = data[i][1]

    if x <= end:
        if y >= end:
            length += y - end
            end = y
    else:
        length += y - x
        start = x
        end = y

print(length)
