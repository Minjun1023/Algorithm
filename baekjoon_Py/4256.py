# 트리
import sys
input = sys.stdin.readline

# 후위 순회를 만들기 위한 함수
def make_postorder(preorder, inorder):
    # 입력 받은 값이 전위 순회가 아닌 경우
    if not preorder:
        return list()
    # 전위 순회에서 첫 번째 값은 항상 루트임.
    root = preorder[0]
    idx = inorder.index(root)
    # 왼쪽 서브 루트 값
    left = make_postorder(preorder[1:idx+1], inorder[:idx])
    # 오른쪽 서브 루트 값
    right = make_postorder(preorder[idx+1:], inorder[idx+1:])
    # 후위 순회 값 리턴
    return left + right + [root]

# 입력값 받기
t = int(input())
for _ in range(t):
    n = int(input())
    preorder = list(map(int, input().split()))
    inorder = list(map(int, input().split()))
    result = make_postorder(preorder, inorder)
    # 결과를 띄워서 출력하기 위함.
    print(*result)

