# 평균 일일 대여 요금 구하기
SELECT round(avg(daily_fee), 0) AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
GROUP BY car_type
HAVING car_type = "SUV";

# 흉부외과 또는 일반외과 의사 목록 출력하기
SELECT dr_name, dr_id, mcdp_cd, date_format(hire_ymd, "%Y-%m-%d")
FROM doctor
WHERE mcdp_cd = "CS"
OR mcdp_cd = "GS"
ORDER BY hire_ymd DESC, dr_name;

# 과일로 만든 아이스크림 고르기
SELECT flavor
FROM first_half
WHERE total_order > 3000
AND flavor IN (SELECT flavor
				FROM icecream_info
				WHERE ingredient_type = "fruit_based")
ORDER BY total_order DESC;

# 3월에 태어난 여성 회원 목록 출력하기
SELECT member_id, member_name, gender, date_format(date_of_birth, "%Y-%m-%d")
FROM MEMBER_PROFILE
WHERE gender = "W"
AND month(date_of_birth) = 3
AND tlno IS NOT NULL;





