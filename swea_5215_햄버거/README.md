설계: 15:09 ~ 15:21
코딩: 15:21 ~ 16:02

static gradients[맛 점수, 칼로리]
static N
static max_score
static limit_calories
static boolean[] choose

조합개수 N부터 1까지

combination(int M, int depth, int score, int calories)
기저조건
depth == M or calories>limit_calories
score > max_score 이면 갱신
return

for 0~N-1
choose[i]가 false이면
choose[i] true
combination(M, depth+1, score+gradients[i][0], calories+[i][1])
choose[i] false