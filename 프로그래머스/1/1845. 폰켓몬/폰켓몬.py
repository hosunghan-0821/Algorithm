def solution(nums):
    answer = 0
    result_length= len(nums) / 2
    length = 0
    result = set()
    data = dict()
    keys = set()
    for num in nums:
        if data.get(num) is None:
            data[num] = 1
        else :
            data[num] = data.get(num) + 1
        keys.add(num)
    
    print(data)
    print(keys)
    while True:
        
        if length >= result_length:
            break
            
        for key in keys:
            if data[key] != 0 and length < result_length:
                result.add(key)
                data[key] = data[key] - 1
                length += 1
                

    return len(result)