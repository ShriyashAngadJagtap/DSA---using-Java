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
        -- Skip N highest salaries, then take 1 salary (this gives N-th highest)

        LIMIT 1 OFFSET N
    );
END
