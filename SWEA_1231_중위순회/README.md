설계: 11:45 ~ 11:53
코딩: 11:53 ~ 12:24

배열
Object[N+1][3] 0: 데이터, 1: left, 2: right

1~N만큼 for 문
tree[i][0]
tree[i][1]
tree[i][2] 입력

메소드 이용 중위 출력
inorder(Object root)
if root==null 종료
inorder(tree[root][1])
sysout tree[root][0]
inorder(tree[root][2])
