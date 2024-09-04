설계: 11:28 ~ 11:32
코딩: 11:32 ~ 11:45

DFS

boolean person[N+1][N+1]
boolean visit[N+1]

for (1 ~ N)
!visit[i] 이면
dfs(i)
무리++

dfs(int i)
i 방문처리

for (j: 1 ~ N)
person[i][j] true이고
visit[j] false이면
dfs(j)