import sys

input = sys.stdin.readline

N, C = map(int, input().split())
data = []

for i in range(N):
    data.append(int(input()))

data.sort()
low = 1
high = data[N - 1] - data[0]
answer = data[N - 1] - data[0]
# lower bound로 풀어볼거야
while low <= high:
    mid = (low + high) // 2

    # 가장 처음 집은 설치한다고 가정하고 스타트
    cnt = 1
    start_x = data[0]
    for i in range(1, N):
        if data[i] - start_x >= mid:
            cnt += 1
            start_x = data[i]

    #print(f"mid = {mid}  cnt = {cnt}")
    if cnt >= C:
        low = mid + 1

    else:
        high = mid - 1

print(high)



