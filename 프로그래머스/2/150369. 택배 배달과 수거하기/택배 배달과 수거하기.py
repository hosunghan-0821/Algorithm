def solution(cap, n, deliveries, pickups):
    answer = 0
    
    deliveries = deliveries[::-1]
    pickups = pickups[::-1]
    
    delivery_data = 0
    pickup_data = 0
    for i in range(n):
        delivery_data += deliveries[i]
        pickup_data += pickups[i]
        
        while delivery_data > 0 or pickup_data > 0:
            delivery_data -= cap
            pickup_data -= cap
            answer += (n - i) * 2
    return answer