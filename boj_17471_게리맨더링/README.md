설계: 15:16 ~ 15:29
코딩: 15:29 ~ 16:20 실패

구역을 나누는 경우
N개 중에서
1~N/2개 선택

인구수 정수 배열
인구수[N+1]

구역 연결 여부 bool 배열
연결[N+1][N+1]

반복문
1개선택, 2개선택, ..., N/2개 선택 => M개 선택


메소드(int M, int depth, int last)

기저조건
depth == M
배열에 있는 선거구끼리 연결되어 있는지 확인
배열에 없는 선거구끼리 연결되어 있는지 확인
인구 차이 계산 후 최솟값 갱신

재귀
반복문 last+1 ~ N-(M-depth-1)
[depth] = i
method(M, depth+1, i)
