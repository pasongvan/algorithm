설계: 14:13 ~ 14:20
코딩: 14:20 ~ 16:13

리스트로 스택을 구현하려면
후위변환용 문자형 리스트,
후위계산용 정수형 리스트 2개가 필요하다

=> 기능 메소드도 각각 만들어야...

중위 => 후위
1. 숫자 push
2. 여는 괄호 push
3. 닫는 괄호
    - 여는 괄호 나올 때까지 pop (여는 괄호는 출력x)
4. 연산자
    - top에 연산 우선순위 낮은 연산자 나올 때까지 pop
    - 본인은 push
5. 다 끝나면 pop (괄호제외)

후위 => 계산
1. 숫자 push
2. 연산자 나오면
    - 숫자 두개 pop
    - 계산 결과 push
3. 다 끝나면 pop해서 return