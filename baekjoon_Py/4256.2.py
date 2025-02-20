# 풀이 2
import sys
input = sys.stdin.readline

def make_postorder(preorder, pstart, pend, inorder, istart, iend):

    # Base case (자식 노드 없으면 현재 노드 반환)
    if pend - pstart <= 1: return preorder[pstart:pend]

    # Step (루트 / 왼쪽자식 / 오른쪽자식 구분한 뒤 후위순서로 조합해서 반환)
    # 1. preorder 맨 앞이 루트노드
    root = preorder[pstart]
    # 2. inorder에서 루트노드 인덱스 찾기
    iroot = inorder.index(root)
    # 3. preorder도 자식노드 구분하기 위해 중간 인덱스 찾기
    pmid = (pstart + 1) + (iroot - istart)
    # 4. 구분한 루트/왼쪽/오른쪽 노드 후위순서로 조합
    postorder = []
    postorder += make_postorder(preorder, pstart+1, pmid, inorder, istart, iroot)
    postorder += make_postorder(preorder, pmid, pend, inorder, iroot+1, iend)
    postorder += [root]
    return postorder


# 입력값 받기
t = int(input())
for _ in range(t):
    # 변수 초기화
    n = int(input())
    preorder = list(map(int, input().split()))
    inorder = list(map(int, input().split()))
    
    # 후위변환한 결과 출력
    postorder = make_postorder(preorder, 0, len(preorder), inorder, 0, len(inorder))
    print(' '.join(map(str, postorder)))