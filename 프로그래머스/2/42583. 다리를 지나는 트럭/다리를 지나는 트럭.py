from collections import deque
def solution(bridge_length, weight, truck_weights):
    
    answer = 0
    bridge = [0] * bridge_length
    bridge = deque(bridge)
    truck_weights = deque(truck_weights)
    truck_sum = 0
    while truck_weights:
        
        if truck_sum > weight:
            answer +=1
            continue
        
        truck_sum -= bridge.popleft()
        if truck_sum + truck_weights[0] <= weight:
            next_truck = truck_weights.popleft()
            truck_sum += next_truck
            bridge.append(next_truck)
        else :
            bridge.append(0)
        
        answer +=1
        
    answer += bridge_length
        
    return answer