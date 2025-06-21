from typing import List, Dict

VOWELS = ['A', 'E', 'I', 'O', 'U']     # 사전순 기준 문자 집합

def dfs(curr: str, depth: int, bag: List[str]) -> None:
    """
    curr  : 지금까지 만든 접두어
    depth : 재귀 깊이(= 현재 글자 길이)
    bag   : 완성된 단어들을 담을 리스트
    """
    if 0< depth <=5:
        bag.append(curr)
    if depth == 5:
        return
    
    for ch in VOWELS:
        dfs(curr+ch,depth+1,bag)
        


def solution(word: str) -> int:
    words: List[str] = []
    dfs("", 0, words)               # 모든 단어 생성
    return words.index(word) + 1    # 0-based → 1-based