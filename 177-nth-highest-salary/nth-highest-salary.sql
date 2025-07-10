CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N - 1;
    RETURN (
        -- Select unique salary values
        SELECT DISTINCT salary
         -- From Employee table
        FROM Employee
        -- Order salaries in descending order (highest first)
        ORDER BY salary DESC
        LIMIT 1 OFFSET N
    );
END
