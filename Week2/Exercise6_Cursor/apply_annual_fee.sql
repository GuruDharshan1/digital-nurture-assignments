SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_accounts IS
        SELECT account_id, balance
        FROM Accounts;

    v_account_id  Accounts.account_id%TYPE;
    v_balance     Accounts.balance%TYPE;
    v_fee         CONSTANT NUMBER := 500;  -- Annual fee
BEGIN
    OPEN cur_accounts;
    LOOP
        FETCH cur_accounts INTO v_account_id, v_balance;
        EXIT WHEN cur_accounts%NOTFOUND;

        UPDATE Accounts
        SET balance = balance - v_fee
        WHERE account_id = v_account_id;

        DBMS_OUTPUT.PUT_LINE('Annual fee ₹' || v_fee || ' deducted from Account ID: ' || v_account_id);
    END LOOP;
    CLOSE cur_accounts;

    COMMIT;
END;
/
