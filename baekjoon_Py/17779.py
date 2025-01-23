# 87퍼 실패
import sys
input = sys.stdin.readline
def cal(x, y, d1, d2):
    elec = [0 for i in range(5)] #선거구 당 인구수
    temp = [[0] * (N+1) for i in range(N+1)] #선거구

    #경계선을 5번 선거구로 할당
    for i in range(d1+1):
        temp[x+i][y-i] = 5          #1번 조건
        temp[x+i+d2][y-i+d2] = 5    #3번 조건

    for i in range(d2+1):
        temp[x+i][y+i] = 5          #2번 조건
        temp[x+d1+i][y-d1+i] = 5    #4번 조건

    #경계선 내부를 5번 선거구로 할당
    for i in range(x+1, x+d1+d2):
        flag = False
        #행 기준으로 한번 경계구역을 만나면
        for j in range(1, N+1):
            if temp[i][j] == 5:
                flag = not flag #다시 경계구역을 만날때까지
            if flag:
                temp[i][j] = 5  #5번 구역

    for r in range(1, N+1):
        for c in range(1, N+1):
            if r < x+d1 and c <= y:
                elec[0] += graph[r][c]      #1번 선거구
            elif r <= x+d2 and y < c:
                elec[1] += graph[r][c]      #2번 선거구
            elif x+d1 <= r and c < y-d1+d2:
                elec[2] += graph[r][c]      #3번 선거구
            elif x+d2 < r and y-d1+d2 <= c:
                elec[3] += graph[r][c]      #4번 선거구
            elif temp[r][c] == 5:
                elec[4] += graph[r][c]      #5번 선거구
    return max(elec) - min(elec) #선거구의 차이

N = int(input())
result = 1e9
graph = [[]]
for i in range(N):
    graph.append([0] + list(map(int, input().split())))

#완전탐색
for x in range(N+1):
    for y in range(N+1):
        for d1 in range(N+1):
            for d2 in range(N+1):
                if 1 <= x < x+d1+d2 <= N and 1 <= y-d1 < y < y+d2 <= N:
                    result = min(result, cal(x, y, d1, d2))

print(result)