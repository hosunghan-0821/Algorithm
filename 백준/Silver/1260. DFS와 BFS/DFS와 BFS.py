import sys
from collections import deque

input = sys.stdin.readline


def dfs(visited, node):
    global graph

    if visited[node]:
        return
    visited[node] = True
    print(node, end=" ")

    for next_node in graph[node]:
        dfs(visited, next_node)

def bfs(visited, node):

    queue = deque()
    queue.append(node)

    while queue:
        next_node = queue.popleft()
        if visited[next_node] is True:
            continue
        visited[next_node] = True
        print(next_node, end=" ")
        for linked_node in graph[next_node]:
            queue.append(linked_node)

def solution():
    global graph
    node_num, line_num, start_node = map(int, input().split())

    graph = [[] for _ in range(node_num + 1)]
    for i in range(line_num):
        start, end = map(int, input().split())
        graph[start].append(end)
        graph[end].append(start)
    for i in graph:
        i.sort()
    
    dfs([False] * (node_num + 1), start_node)
    print()
    bfs([False] * (node_num + 1), start_node)

    
if __name__ == "__main__":
    solution()