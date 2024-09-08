import sys

input = sys.stdin.readline

T = int(input())

for t in range(T):
    N = int(input())
    data = []
    for n in range(N):
        value = input().strip()
        data.append(value)

    data.sort()

    length = len(data)
    isDuplicate = False
    for i in range(length - 1):
        if data[i + 1].startswith(data[i]):
            isDuplicate = True
            break
    if(isDuplicate is False):
        print("YES")
    else:
        print("NO")