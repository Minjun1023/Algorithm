# 첫 번째 시도
# A = {10, 20, 10, 30, 20, 50}
# 가장 긴 증가하는 부분 수열 A = {10, 20, 30, 50}
# sorted(A) = {10, 10, 20, 20, 30 ,50}
# set(A) = {10, 20, 30, 50}

# 두 번째 시도(답 보고)
# 문제의 핵심은 '부분 수열'
# if 수열 = [5,1,6,2,7,3,8] 
# 5: [5,6,7,8]
# 1: [1,2,3]
# if 수열 = [1,3,4,2,3,4]
# 1: [1,3,4],[1,2,3,4]
# DP를 사용해야 한다.
# A배열에서 if A[i]>A[j]: True라면, dp[i] = max(dp[i], dp[j]+1)

import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

dp = [1] * N

for i in range(1, N):
    for j in range(i):
        if A[i] > A[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))
