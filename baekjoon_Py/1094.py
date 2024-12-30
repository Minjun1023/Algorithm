# 길이 64cm인 막대 소유
# Xcm를 막대를 구해야함
# 1. 지민이가 가지고 있는 막대의 길이 모두를 더함. 처음에는 64cm 막대 하나만 가지고 있음. 이때 합이 X보다 클 경우 
# 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자름
# 만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같을경우, 위에서 자른 막대의 절반 중 하나를 버림
# 2. 이제 남아있는 모든 막대를 풀로 붙여서 Xcm로 만듬
# input: X output: 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 출력

x = int(input())
lst = [64, 32, 16, 8, 4, 2, 1]
count = 0

for i in range(len(lst)):
    if x >= lst[i]:
        count += 1
        x -= lst[i]
    
    if x == 0:
        break

print(count)