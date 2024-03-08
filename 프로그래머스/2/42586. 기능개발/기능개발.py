def solution(progresses, speeds):
    answer = []
    check_index = 0
    final_index = len(progresses)
    while True:
        if check_index == final_index:
            break
            
        for index , progress in enumerate(progresses):
            progresses[index] = progress + speeds[index]
        
        temp = 0
        
        while progresses[check_index] >= 100:
            temp +=1
            check_index += 1
            if check_index >= final_index:
                break
        
        
        if temp > 0:
            answer.append(temp)
    return answer