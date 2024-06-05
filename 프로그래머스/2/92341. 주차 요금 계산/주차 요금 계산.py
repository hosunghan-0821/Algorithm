import math

def solution(fees, records):
    answer = []
    standard_time, standard_fee, unitTime ,feePerTime = fees
    
    carInMap = {}
    carOutMap = {}
 
    
    records.sort(key = lambda x: x[0])
    
    for record in records:
        time, car_num, status = record.split(" ")
        #print(f"{time} {car_num} {status}")

        if status == "IN":
            if carInMap.get(car_num) is None:
                carInMap[car_num] = [time]
            else:
                carInMap[car_num].append(time)
        else :
            if carOutMap.get(car_num) is None:
                carOutMap[car_num] = [time]
            else:
                carOutMap[car_num].append(time)

    # print(carInMap)
    # print(carOutMap)
 
    minute_dict = dict()
    answer_dict = dict()
    for car_num, timeList in sorted(carInMap.items()):
        for time in timeList:
            
            carInTime = time
            carOutTime = "23:59"
            if carOutMap.get(car_num) is not None and len(carOutMap.get(car_num)) != 0:
                carOutTime = carOutMap[car_num][0]
                del carOutMap[car_num][0]
            # 계산해서 차곡차곡 더해주면 됨.
           
            inHour = int(carInTime.split(":")[0])
            inMinute = int(carInTime.split(":")[1])
            
            inTotalMinutes = inHour * 60 + inMinute
            
            outHour = int(carOutTime.split(":")[0])
            outMinute = int(carOutTime.split(":")[1])
            
            outTotalMinutes = outHour * 60 + outMinute
            
            usedMinutes = outTotalMinutes - inTotalMinutes
            #print(f"{car_num} | {carInTime} | {carOutTime} | {usedMinutes}")
            price = 0
            
            if minute_dict.get(car_num) is None:
                minute_dict[car_num] = usedMinutes
            else :
                minute_dict[car_num] = minute_dict.get(car_num) + usedMinutes
    # print(minute_dict)
    
    for car_num, usedMinutes in minute_dict.items():
        
        if usedMinutes <= standard_time:
            price = standard_fee
        else:
    
            price = standard_fee + math.ceil((usedMinutes - standard_time) / unitTime) * feePerTime
            
        answer_dict[car_num] = price

    # print(answer_dict)       
    answer = list(answer_dict.values())     
    return answer