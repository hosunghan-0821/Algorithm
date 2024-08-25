import sys
from decimal import Decimal

input = sys.stdin.readline

lo = 1
hi = int(1e9)

X, Y = map(int, input().split())
origin = int((Decimal(Y) / Decimal(X)) * 100)
result = 0
answer = -1
#print(f"origin = {origin}")
while (lo <= hi):
    mid = (lo + hi) // 2
    result = int (Decimal(Y + mid) / Decimal(X + mid) * 100)
    #print(f"{mid} , {result}")
    if result > origin:
        answer = mid
        hi = mid - 1
    else:
        lo = mid + 1

print(answer)