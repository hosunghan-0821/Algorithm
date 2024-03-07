from collections import deque

def solution(plans):
    answer = []
    stack = deque()
    plans.sort(key = lambda x: x[1])
    plans_length = len(plans)
    for index, plan  in enumerate(plans):
        name, start, playtime = plan
        
        hour, minute = start.split(":")
        
        hour = int(hour)
        minute = int(minute)
        playtime = int(playtime)
        
        total_time = hour * 60 + minute + playtime
        
        # 끝 인덱스가 아닐 떄
        if index + 1 != plans_length:
            next_start = plans[index + 1][1]
            next_hour,next_minute = next_start.split(":")
            
            next_hour = int(next_hour)
            next_minute = int(next_minute)
            
            next_total_time = next_hour * 60 + next_minute
            print(f"total_time = {total_time} , next_total_time = {next_total_time}")
            if total_time > next_total_time :
                stack.append((name, total_time - next_total_time))
            else :
                answer.append(name)
                remain_time = next_total_time - total_time
                while stack:
                    remain_name, need_time = stack.pop()
                    
                    if need_time <= remain_time:
                        answer.append(remain_name)
                        remain_time -= need_time
                    else :
                        stack.append((remain_name, need_time - remain_time))
                        break
                
        # 끝 인덱스 일떄    
        else :
            answer.append(name)
            while stack:
                reamin_name, need_time = stack.pop()
                answer.append(reamin_name)
            
        
        
    return answer