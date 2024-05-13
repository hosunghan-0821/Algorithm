import itertools

def solution(users, emoticons):
    answer = []
    pool = [10,20,30,40]

    p = itertools.product(pool, repeat = len(emoticons))
    p = list(p)

    print(len(p))
    result_cnt = 0
    result_price = 0
    for i, data in enumerate(p):
        cnt = 0
        price = 0
        for user in users:
            sum = 0
            for j,emoticon in enumerate(emoticons):
                if data[j] >= user[0]:
                    sum += emoticon * (100 - data[j])//100
                else: 
                    continue
            if sum >= user[1]:
                cnt += 1
            else :
                price += sum
        if cnt > result_cnt:
            result_cnt = cnt
            result_price = price
        if cnt == result_cnt and price > result_price :
            result_price = price
    return [result_cnt, result_price]