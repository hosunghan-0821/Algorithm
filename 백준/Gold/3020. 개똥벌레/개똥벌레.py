import sys

input = sys.stdin.readline

N, H = map(int, input().split());


lower_rock = []
upper_rock = []

for i in range(N):
    if i % 2 == 0:
        lower_rock.append(int(input()))
    else:
        upper_rock.append(int(input()))

lower_rock.sort()
upper_rock.sort()


def lower_bound_search(array, target):
    start = 0
    end = len(array)

    while start < end:
        mid = (start + end) // 2

        if target <= array[mid]:
            end = mid
        else:
            start = mid + 1

    return start


result = [0] * H

for i in range(len(result)):
    result[i] = len(lower_rock) - lower_bound_search(lower_rock, i + 1) + len(upper_rock) - lower_bound_search(
        upper_rock, H - i)


print(min(result), result.count(min(result)))
