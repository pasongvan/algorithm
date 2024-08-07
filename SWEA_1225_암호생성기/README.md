설계: 11:48 ~ 12:00
코딩: 12:27 ~ 12:27, 13:09 ~ 13:14

크기 8의 큐
큐에 초기 입력

rear가 0이 될때까지 while문
poll한거 받아서 -1
그거 add

<큐 구현>
- 초기상태
    rear=-1

- offer
    queue[++rear]에 저장
    꽉 차 있으면 불가

- poll
    queue[rear] 반환
    새로운 배열에 한 칸씩 당겨서 저장
    비어있으면 불가

- Qpeek
    queue[rear] 반환
    비어있으면 불가

- isEmpty
    rear==-1

- isFull 
    rear==queue.length-1