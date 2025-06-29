# 카디널리티가 큰 친구들 부터 검색해서 거르고, 근데 탐색은 완전탐색을 해야할거 같은데.. 이걸 줄일 수가 있나.
# 명수를 알아야하기 때문에, 명수에 최적화를 시킬 수 있을까? 미리 DP로 해놓으면 편할거 같긴한데.. 이러면 확장성이 떨어지는데..
#DP할 때, 경우의 수는 3x2x2x2 점수 이상이 안되네.. -> 폐기 
# info의 카디널리티를 구해서 그거 정렬해서 구하는게 나으려나..?
# 일단 무식하게라도 구현하고 개선점을 고민해보자
# 0. 1  2  3  4  5  6  7
# 10 20 30 40 40 60 70 80 
from operator import itemgetter
from typing import Dict, List


def binary_search(scores:List[int],low:int,high:int,score:int) -> int:
    
    while low < high:
        mid = (low + high) // 2
        if scores[mid] < score:     
            low = mid + 1
        else:             
            high = mid
    return low             
    
#DFS 유효한 key 만들기
def make_key_dfs(key:str, query_data_split:List[str], depth:int, key_result:List[str])-> None:
    if depth == 4:
        key_result.append(key)
        return
    if query_data_split[depth] != '-':
        key+=query_data_split[depth]
        make_key_dfs(key, query_data_split, depth+1 ,key_result)
    else:
        if depth == 0:
            make_key_dfs(key+"java", query_data_split, depth+1 ,key_result)
            make_key_dfs(key+"python", query_data_split, depth+1 ,key_result)
            make_key_dfs(key+"cpp", query_data_split, depth+1 ,key_result)
        elif depth ==1:
            make_key_dfs(key+"backend", query_data_split, depth+1 ,key_result)
            make_key_dfs(key+"frontend", query_data_split, depth+1 ,key_result)
        elif depth ==2:
            make_key_dfs(key+"junior", query_data_split, depth+1 ,key_result)
            make_key_dfs(key+"senior", query_data_split, depth+1 ,key_result)
        elif depth ==3:
            make_key_dfs(key+"pizza", query_data_split, depth+1 ,key_result)
            make_key_dfs(key+"chicken", query_data_split, depth+1 ,key_result)
        

def make_key(query_data_split: List[str]) -> List[str]:
    key_result = []
    make_key_dfs("",query_data_split,0,key_result)
    return key_result

def solution(info, query):
    answer = []
    participants = []
    
    key_score_map: Dict[str, List[int]] = {}        # key = str, value = list[int]

    
    for info_data in info:
        info_data_split = info_data.split(" ")
        key = ''.join(info_data_split[:4])
        key_score_map.setdefault(key, []).append(int(info_data_split[4]))
    for score_list in key_score_map.values():   # value만 순회
        score_list.sort()                
        
    
    for query_data in query:
        query_data = query_data.replace(" and ", " ")
        query_data_split = query_data.split(" ")
        valid_key = make_key(query_data_split)
        score = int(query_data_split[4])
        sum = 0
        for key in valid_key:
            score_list = key_score_map.get(key)   # 없으면 None 반환
            if not score_list:                    # None 이거나 [] 빈 리스트면
               continue                            # 이번 루프 건너뛰기
            bs_result = binary_search(score_list,0,len(score_list),score)
            # 0 20 20 30 ( 4 - 1)
            query_result = len(score_list)  - bs_result
            sum += query_result
        answer.append(sum)
    
    
    return answer



    