DECLARE
  v_due_date DATE := SYSDATE + 30;
BEGIN
  FOR rec IN (SELECT c.Name, l.DueDate
              FROM Customers c
              JOIN Loans l ON c.CustomerID = l.CustomerID
              WHERE l.DueDate BETWEEN SYSDATE AND v_due_date) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.Name || ', your loan is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/
