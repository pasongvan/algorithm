설계: 12:59 ~ 13:13
코딩: 13:13 ~ 14:31

LRV

Object[][]
Object[노드번호][필드] 필드 0:데이터, 1:left, 2:right
노드번호 0번은 넘김

입력
배열[0] 데이터
배열[1] left
배열[2] right


연산메소드
inorder(Object root)
if root==null 종료

inorder(tree[root][1])
inorder(tree[root][2])
tree[root][0] = tree[root][1][1] 연산자 tree[root][2]