CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_emp_id      IN NUMBER,
    p_percentage  IN NUMBER
)
IS
BEGIN
    -- Update salary
    UPDATE Employees
    SET salary = salary + (salary * p_percentage / 100)
    WHERE emp_id = p_emp_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID not found.');
    END IF;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO Error_Log(error_message) VALUES('Salary Update Failed: ' || SQLERRM);
END;
