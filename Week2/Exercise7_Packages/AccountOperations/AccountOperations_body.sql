CREATE OR REPLACE PACKAGE BODY AccountOperations IS

  PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_acc_id, p_cust_id, p_type, p_balance, SYSDATE);
  END;

  PROCEDURE CloseAccount(p_acc_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts
    WHERE AccountID = p_acc_id;
  END;

  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
    v_total NUMBER := 0;
  BEGIN
    SELECT NVL(SUM(Balance), 0) INTO v_total
    FROM Accounts
    WHERE CustomerID = p_cust_id;

    RETURN v_total;
  END;

END AccountOperations;
/