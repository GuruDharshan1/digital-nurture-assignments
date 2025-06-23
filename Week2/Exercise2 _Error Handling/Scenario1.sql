CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_amount          IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    -- Check balance
    SELECT balance INTO v_balance FROM Accounts WHERE account_id = p_from_account_id;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    -- Start transaction
    UPDATE Accounts SET balance = balance - p_amount WHERE account_id = p_from_account_id;
    UPDATE Accounts SET balance = balance + p_amount WHERE account_id = p_to_account_id;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO Error_Log(error_message) VALUES('Transfer Failed: ' || SQLERRM);
END;
