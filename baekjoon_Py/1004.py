import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    cnt = 0
    # 출발점, 도착점 (x1, y1), (x2, y2)
    x1, y1, x2, y2 = map(int ,input().split())
    n = int(input())
    for _ in range(n):
        # 중점과 반지름(cx, cy, cr)
        cx, cy, cr = map(int, input().split())
        # dist = 원의 중심과 점의 거리를 의미
        dist1 = (x1-cx) ** 2 + (y1-cy) ** 2
        dist2 = (x2-cx) ** 2 + (y2-cy) ** 2
        # 원의 내부에 존재할 경우: 원의 중심과 점의 거리가 원의 반지름 보다 짧거나, 반지름보다 클 경우 원의 외부에 존재.
        if (dist1 < cr**2 and dist2 > cr**2) or (dist1 > cr**2 and dist2 < cr **2):
            # 진입 이탈 횟수 추가
            cnt += 1
    print(cnt)
