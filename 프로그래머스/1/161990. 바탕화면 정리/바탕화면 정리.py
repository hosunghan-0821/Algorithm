def solution(wallpaper):
    answer = []
    total_row = len(wallpaper)
    total_column = len(wallpaper[0])
    is_first = False
    lux = -1
    luy = -1
    rdx = -1
    rdy = -1
    for i in range(total_row):
        
        index = wallpaper[i].find('#')
        if index != -1:
            if is_first is False:
                lux = i
                is_first = True
            
            rdx = i + 1
    
    is_first = False
    
    for j in range(total_column):
        for i in range(total_row):
            if wallpaper[i][j] == '#':
                if is_first is False:
                    is_first = True
                    luy = j
                rdy = j + 1
                break

    
    
    return [lux, luy, rdx, rdy]