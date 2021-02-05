# Write your MySQL query statement below
SELECT DISTINCT Logs.num AS ConsecutiveNums FROM
Logs
INNER JOIN (SELECT id, num FROM Logs) AS Logs1 ON Logs1.id = Logs.id + 1 AND Logs1.num = Logs.num
INNER JOIN (SELECT id, num FROM Logs) AS Logs2 ON Logs2.id = Logs.id + 2 AND Logs2.num = Logs.num