CREATE OR REPLACE PROCEDURE TransferFunds(
  p_SourceAccount IN NUMBER,
  p_DestinationAccount IN NUMBER,
  p_Amount IN NUMBER
) IS
  v_SourceBalance NUMBER;
BEGIN
  -- Get source balance
  SELECT Balance INTO v_SourceBalance
  FROM Accounts
  WHERE AccountID = p_SourceAccount
  FOR UPDATE;

  -- Check if balance is sufficient
  IF v_SourceBalance < p_Amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance.');
  END IF;

  -- Deduct from source
  UPDATE Accounts
  SET Balance = Balance - p_Amount
  WHERE AccountID = p_SourceAccount;

  -- Add to destination
  UPDATE Accounts
  SET Balance = Balance + p_Amount
  WHERE AccountID = p_DestinationAccount;

  COMMIT;
END;
/
