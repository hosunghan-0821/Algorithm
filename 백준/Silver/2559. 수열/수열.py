import sys

input = sys.stdin.readline

N, K = map(int, input().split())
data = list(map(int,input().split()))
left = 0
right = K - 1
data_sum = sum(data[left : right + 1])
max_value = data_sum
for i in range(K ,len(data)):
    data_sum += data[i]
    data_sum -= data[left]
    left += 1
    if max_value < data_sum:
        max_value = data_sum

print(max_value)
