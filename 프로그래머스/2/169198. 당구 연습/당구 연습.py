import sys
def getShortDistance(m,n,startX,startY,x,y):
    dists = []
    # 윗벽 대칭이동
    if not (startX == x and startY < y):
        pointX = startX
        pointY = (n - startY) * 2 + startY 
        topDistance =  (pointX - x) ** 2 + (pointY - y)** 2
        dists.append(topDistance)
    
    # 왼쪽벽 대칭이동 startY==y 이고 startX > x1 때는 안구해도 됨.
    if not (startY ==y and startX > x):
        pointX = -startX
        pointY = startY
        leftDistance = (pointX - x) ** 2 + (pointY - y)** 2
        dists.append(leftDistance)
    
    # 오른쪽벽 대칭이동 startY==y 이고 startX < x1 때는 안구해도 되네..
    if not(startY ==y and startX < x):
        pointX = (m -startX) * 2 + startX
        pointY = startY
        rightDistance = (pointX - x) ** 2 + (pointY - y)** 2
        dists.append(rightDistance)
    
    # 아랫벽 대칭이동
    
    if not (startX == x and startY > y):

        pointX = startX
        pointY = -startY
        downDistance = (pointX - x) ** 2 + (pointY - y)** 2
        dists.append(downDistance)
    
    return min(dists)

def solution(m, n, startX, startY, balls):
    answer = []

    for ball in balls:
        x, y = ball
        
        answer.append(getShortDistance(m,n,startX,startY,x,y))
    
    
    return answer