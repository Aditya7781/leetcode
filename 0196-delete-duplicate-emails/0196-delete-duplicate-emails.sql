delete P1
FROM Person P1
Left Join(
    SELECT email, MIN(id) AS min_id
    FROM Person
    GROUP BY email
    having count(*) >1) P2
on P1.email = P2.email and P1.id>P2.min_id
WHERE p2.email IS NOT NULL;