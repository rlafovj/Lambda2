-- Soccer JPA 버전

-- 001. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
select * from team ORDER BY team_name;

-- 002. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오.
SELECT DISTINCT POSITION FROM player;

-- 003.  플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
SELECT DISTINCT
    CASE
        WHEN POSITION IS NULL OR POSITION = '' THEN '신입'
        ELSE POSITION
    END
FROM player;

-- 004. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
SELECT player_name FROM player
WHERE POSITION = 'GK' AND team_id = 'K02';

-- 005. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
SELECT player_name FROM player
WHERE team_id = 'K02' AND player_name LIKE '고%' AND height >= 170;

-- 006. 다음 조건을 만족하는 선수명단을 출력하시오. 소속팀이 삼성블루윙즈이거나 드래곤즈에 소속된 선수들이어야 하고, 포지션이 미드필더(MF:Midfielder)이어야 한다. 키는 170 센티미터 이상이고 180 이하여야 한다.
SELECT p.player_name FROM player AS p JOIN team as t ON p.team_id = t.team_id
WHERE (team_name = '삼성블루윙즈' OR team_name = '드래곤즈')
  AND POSITION = 'MF'
  AND (height >= 170 AND height <= 180);

-- 007. 수원을 연고지로 하는 골키퍼는 누구인가?
SELECT p.player_name FROM player as p JOIN team as t ON p.team_id = t.team_id
WHERE t.region_name = '수원' AND POSITION = 'GK';

-- 008. 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오. 키와 몸무게가 없으면 "0" 으로 표시하시오 키와 몸무게는 내림차순으로 정렬하시오.
SELECT DISTINCT player_name,
    IF(height IS NULL OR height = '', '0', height) AS height,
    IF(weight IS NULL OR weight = '', '0', weight) AS weight
FROM player
where team_id = (select team_id from team where region_name = '서울')
order by height, weight desc;

-- 009. 서울팀 선수들 이름과 포지션과 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오. 단, 키와 몸무게가 없으면 "0" 표시하시오. BMI는 "NONE" 으로 표시하시오(as bmi) 최종 결과는 이름 내림차순으로 정렬하시오
SELECT DISTINCT player_name, POSITION,
                IF(height IS NULL or height = '' , '0', CONCAT(height,'cm')),
                IF(weight IS NULL or weight = '' , '0', CONCAT(weight,'kg')),
                IF(height IS NOT NULL AND weight IS NOT NULL,
                   ROUND(weight/((height/100)*(height/100)), 2), 'NONE') AS bmi
FROM player  AS p JOIN team as t on p.team_id = t.team_id
WHERE region_name = '서울' ORDER BY player_name DESC;
