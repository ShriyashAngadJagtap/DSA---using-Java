# Write your MySQL query statement below
SELECT e2.name as Employee
FROM employee e1
# TO check Innner joints with in the table   wroted a  Inner join query
INNER JOIN employee e2 ON e1.id = e2.managerID
WHERE
e1.salary < e2.salary