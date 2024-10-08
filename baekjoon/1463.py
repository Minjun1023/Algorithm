n = int(input())

# dp테이블 초기화
d = [0] * 1000001
# d[1] = 0으로 값 지정
d[1] = 0

# d[2]부터 d[n]까지
for i in range(2, n+1):
    # 점화식: d[i] = min(d[i-1], d[i//2], d[i//3]) + 1)
    # 현재의 수에서 1을 빼는 경우
    d[i] = d[i-1] + 1
    # 현재의 수가 2로 나누어 떨어지는 경우
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
    # 현재의 수가 3으로 나누어 떨어지는 경우
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)
# 결과값 출력
print(d[n])


