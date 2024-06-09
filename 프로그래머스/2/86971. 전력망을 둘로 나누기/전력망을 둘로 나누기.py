from collections import deque 
def bfs(start_node, cut_node):
    global node_data
    visited = [cut_node,start_node]
    queue = deque()
    queue.append(start_node)
    count = 1
    while queue:
        node = queue.popleft()
        node_link_list = node_data.get(node)
        # print(node_link_list)
        # print(f"visited = {visited}")
        for node_link in node_link_list:
            if node_link in visited:
                continue
            queue.append(node_link)
            visited.append(node_link)
            count += 1
            
    #print(count)
    return count
    
def solution(n, wires):
    global node_data
    answer = 101
    node_data = {}
    for wire in wires:
        if node_data.get(wire[0]) is None:
            node_data[wire[0]] = [wire[1]]
        else:
            node_data.get(wire[0]).append(wire[1])
        if node_data.get(wire[1])  is None:
            node_data[wire[1]] = [wire[0]]
        else:
            node_data.get(wire[1]).append(wire[0])
    print(node_data)
    
    total_node = len(node_data)
    for wire in wires:
        node_num_1 = bfs(wire[0],wire[1])
        node_num_2 = total_node - node_num_1
        if answer > abs(node_num_1 - node_num_2):
            answer = abs(node_num_1 - node_num_2)

    return answer