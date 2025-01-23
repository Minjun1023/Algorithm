a = list(input())
b = list(input())
lcs = [[0] * (len(b) + 1) for _ in range(len(a) + 1)]
for i in range(1, len(a) + 1):
    for j in range(1, len(b) + 1):
        if a[i-1] == b[j-1]: #비교하는 글자가 있기 전까지의 LCS와 현재 문자를 비교한 결과가 같을 경우
            lcs[i][j] = lcs[i-1][j-1] + 1
        else: #비교한 문자가 같지 않은 경우
            lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1])
print(max(map(max, lcs)))
