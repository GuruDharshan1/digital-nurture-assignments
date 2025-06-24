-- Function to check if account has sufficient balance

-- Assuming this table:
-- CREATE TABLE Accounts (
--     account_id NUMBER PRIMARY KEY,
--     balance NUMBER
-- );

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id NUMBER,
    p_amount NUMBER
)
RETURN BOOLEAN
IS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance
    FROM Accounts
    WHERE account_id = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/
