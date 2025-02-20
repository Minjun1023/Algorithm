# 투 포인터
import sys
input = sys.stdin.readline

n = int(input())
nums = [int(input()) for _ in range(n)]
nums.sort()
answer = 4

for i in range(n):
    start = i
    end = n - 1
    while start < end:
        # 투 포인터: 처음 값과 마지막 값의 차가 4초과 시 
        if nums[end]-nums[start] > 4:
            end -= 1
        # 이외의 경우
        else:
            temp_answer = 4 - (end-start)
            # 구한 값들 중에 가장 작은 값
            answer = min(answer, temp_answer)
            break
print(answer)

