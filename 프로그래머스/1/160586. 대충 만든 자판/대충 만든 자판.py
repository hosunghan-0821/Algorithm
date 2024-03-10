import sys
def solution(keymap, targets):
    answer = []
    for target in targets:
        target = list(target)
        is_no_word = False
        result = 0
        for i in range(len(target)):
            
            min_value = sys.maxsize
            for key in keymap:
                
                find_index = key.find(target[i])
                if find_index != -1 and find_index < min_value:
                    min_value = find_index
            if min_value == sys.maxsize:
                answer.append(-1)
                is_no_word = True
                break
            result += min_value + 1
        if is_no_word is False:
            answer.append(result)
    return answer