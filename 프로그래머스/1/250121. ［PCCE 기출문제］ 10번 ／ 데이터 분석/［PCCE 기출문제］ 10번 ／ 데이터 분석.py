def solution(data, ext, val_ext, sort_by):
    answer = []
    name_index = dict()
    name_index['code'] = 0
    name_index['date'] = 1
    name_index['maximum'] = 2
    name_index['remain'] = 3
    
    for row_data in data:
        if row_data[name_index[ext]] < val_ext:
            answer.append(row_data)
    answer.sort(key = lambda x : x[name_index[sort_by]])
    
    

    return answer