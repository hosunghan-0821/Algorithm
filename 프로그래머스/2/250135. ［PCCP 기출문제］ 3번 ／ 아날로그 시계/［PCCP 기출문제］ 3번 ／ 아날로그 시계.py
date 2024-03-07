def solution(h1, m1, s1, h2, m2, s2):
    answer = 0
    
    start_time = h1 * 3600 + m1 * 60 + s1
    end_time = h2 * 3600 + m2 * 60 + s2
    
    if start_time == 0 or start_time == 12 * 3600:
        answer += 1

    for i in range (start_time, end_time):
        
        next_time = i + 1
        now_time = i
        
        
        hour_angle = 360 if  next_time * (1 / 120.0) % 360 == 0 else next_time * (1 / 120.0) % 360
        minute_angle = 360 if next_time * (0.1) % 360 == 0 else  next_time * (0.1) % 360
        sec_angle = 360 if next_time * 6.0 % 360 == 0 else next_time * 6.0 % 360
        
        prev_hour_angle = now_time / 120 % 360
        prev_minute_angle = now_time / 10 % 360 
        prev_sec_angle = now_time * 6.0 % 360
        
        if prev_hour_angle > prev_sec_angle and hour_angle <= sec_angle:
            answer += 1
        if prev_minute_angle > prev_sec_angle and minute_angle <= sec_angle:
            answer += 1
        
        if sec_angle == minute_angle and sec_angle == hour_angle :
            answer -= 1
    
    return answer
        
        
        
        
        
        
                
    
    return answer