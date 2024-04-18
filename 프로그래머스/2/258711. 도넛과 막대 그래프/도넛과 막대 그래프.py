def solution(edges):
    answer = []
    edge_in_map = dict()
    edge_out_map = dict()
    edge_out_list_map = dict()
    edge_in_list_map = dict()
    mid_point = -1
    donut = 0
    stick = 0
    eight = 0
    for edge in edges:
        start, end = edge
        if edge_out_map.get(start) is None:
            edge_out_map[start] = 1
            edge_out_list_map[start] = [end]
        else:
            edge_out_map[start] = edge_out_map.get(start) + 1
            edge_out_list_map[start].append(end)
        if edge_in_map.get(end) is None:
            edge_in_map[end] = 1
            edge_in_list_map[end] = [start]
        else :
            edge_in_map[end] = edge_in_map.get(end) + 1
            edge_in_list_map[end].append(start)
    
 
    
    for key, value in edge_out_map.items():
        if value >= 2 and edge_in_map.get(key) is None:
            mid_point = key
            answer.append(key)
    
    for data in edge_out_list_map.get(mid_point):
        
        start_index = data
        while True:
            
            if edge_out_list_map.get(data) is None:
                stick += 1
                break
            
            next_index = edge_out_list_map.get(data)
            if len(next_index) >= 2:
                eight +=1
                break
                
            if next_index[0] == start_index:
                donut += 1
                break
            data = next_index[0]

    answer = [mid_point, donut, stick, eight]
    return answer