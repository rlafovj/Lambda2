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

-- 010. 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인 선수를 출력하시오. 단 , 팀명, 선수명 오름차순 정렬하시오
SELECT * FROM player p
    JOIN team t on p.team_id = t.team_id
         WHERE (t.team_id = 'K10' OR t.team_id = 'K02') AND POSITION = 'GK'
         ORDER BY t.team_name, p.player_name;

--  011. 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장
SELECT CONCAT(t.region_name,' ', t.team_name), s.stadium_name FROM stadium s
JOIN team t on s.stadium_id = t.stadium_id;

-- 012. 수원팀(K02) 과 대전팀(K10) 선수들 중 키가 180 이상 183 이하인 선수들 출력 키, 팀명, 사람명 오름차순
SELECT p.height, team_name, player_name FROM team t
JOIN player p on t.team_id = p.team_id
WHERE p.height >= 180 AND p.height <= 183
ORDER BY p.height, t.team_name, p.player_name;

-- 013. 모든 선수들 중 포지션을 배정 받지 못한 선수들의 팀명과 선수이름 출력 둘다 오름차순
SELECT t.team_name, p.player_name FROM team t
JOIN player p on t.team_id = p.team_id
WHERE POSITION IS NULL or POSITION = ''
ORDER BY t.team_name, p.player_name;

-- 014. 팀과 스타디움, 스케줄을 조인하여 2012년 3월 17일에 열린 각 경기의 팀이름, 스타디움, 어웨이팀 이름 출력 다중테이블 join 을 찾아서 해결하시오.
SELECT
    home_team.team_name AS home_team_name,
    stadium.stadium_name AS stadium_name,
    (SELECT team_name FROM team WHERE team_id = sc.awayteam_id) AS away_team_name
FROM schedule AS sc
JOIN stadium ON stadium.stadium_id = sc.stadium_id
JOIN team AS home_team ON home_team.team_id = sc.hometeam_id
WHERE sc.sche_date = '20120317';

-- 015. 2012년 3월 17일 경기에 포항 스틸러스 소속 골키퍼(GK) 선수, 포지션,팀명 (연고지포함), 스타디움, 경기날짜를 구하시오. 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
SELECT player.player_name,
       player.position,
       CONCAT(team.region_name,' ', team.team_name) AS team_name,
       stadium.stadium_name,
       schedule.sche_date
FROM player
         JOIN team ON player.team_id = team.team_id
         JOIN stadium ON team.stadium_id = stadium.stadium_id
         JOIN schedule ON schedule.hometeam_id = team.team_id OR schedule.awayteam_id = team.team_id
WHERE schedule.sche_date = '20120317'
  AND player.position = 'GK'
  AND team.team_name = '스틸러스';

-- 016. 홈팀이 3점이상 차이로 승리한 경기의 경기장 이름, 경기 일정, 홈팀 이름과 원정팀 이름을 구하시오.
SELECT stadium.stadium_name,
       schedule.sche_date,
       hometeam.team_name AS home_team_name,
       awayteam.team_name AS away_team_name
FROM schedule
         JOIN team hometeam ON schedule.hometeam_id = hometeam.team_id
         JOIN team awayteam ON schedule.awayteam_id = awayteam.team_id
         JOIN stadium ON hometeam.stadium_id = stadium.stadium_id
WHERE schedule.home_score - schedule.away_score >= 3;

-- 017. STADIUM 에 등록된 운동장 중에서 홈팀이 없는 경기장까지 전부 나오도록 카운트 값은 19 힌트 : LEFT JOIN 사용해야함 경기장 이름, 홈 팀 출력
SELECT stadium.stadium_name, team.team_name as home_team
FROM stadium
LEFT JOIN team on stadium.stadium_id = team.stadium_id;
--or
SELECT stadium_name, (SELECT t.team_name FROM team t WHERE t.stadium_id = s.stadium_id) FROM stadium s;

-- 018. 페이지네이션 로직을 위한 플레이어 테이블에서 최상단 5개 로우를 출력
SELECT player_name FROM player LIMIT 5;

-- 019. (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg) 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의 팀ID, 팀명, 평균키 추출 인천 유나이티스팀의 평균키 -- 176.59 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에 포함되지 않도록 하세요.
SELECT t.team_id, t.team_name,
       IFNULL(ROUND(AVG(IFNULL(p.height, 0)), 2), 0) AS average_height
FROM team t
         LEFT JOIN player p ON t.team_id = p.team_id
WHERE t.team_id != 'K04'
GROUP BY t.team_id, t.team_name
HAVING average_height < 176.59;

-- 020. 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
SELECT t.team_name, p.player_name, p.back_no FROM player p
LEFT JOIN team t on p.team_id = t.team_id
WHERE p.POSITION = 'MF'
ORDER BY t.team_name;

-- 021. 가장 키큰 선수 5명 소속팀명 및 선수명, 백넘버 출력, 단 키 값이 없으면 제외
SELECT t.team_name, p.player_name, p.back_no FROM player p
LEFT JOIN team t on p.team_id = t.team_id
ORDER BY p.height DESC LIMIT 5;

-- 022. 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
SELECT DISTINCT p.* FROM player p LEFT JOIN team t on p.team_id = t.team_id
WHERE p.height < (SELECT IFNULL(AVG(p2.height), 0) FROM player p2 WHERE p2.team_id = p.team_id);

-- 023. 2012년 5월 한달간 경기가 있는 경기장  조회
SELECT s.stadium_name FROM stadium s
LEFT JOIN schedule sc ON s.stadium_id = sc.stadium_id
WHERE sc.sche_date LIKE '201205%';