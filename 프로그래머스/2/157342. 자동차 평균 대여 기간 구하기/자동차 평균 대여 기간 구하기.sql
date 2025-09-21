select sub.CAR_ID, round(avg(duration), 1) AS AVERAGE_DURATION
from (
    select car_id, DATEDIFF(END_DATE, START_DATE)+1 AS duration
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
) as sub
group by sub.car_id
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC