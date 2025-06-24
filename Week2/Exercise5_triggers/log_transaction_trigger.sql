-- Purpose: Insert a record into AuditLog when a transaction is inserted

-- First, ensure the AuditLog table exists:
-- CREATE TABLE AuditLog (
--     LogID NUMBER PRIMARY KEY,
--     TransactionID NUMBER,
--     Action VARCHAR2(50),
--     LogDate DATE
-- );

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (LogID, TransactionID, Action, LogDate)
    VALUES (AuditLog_seq.NEXTVAL, :NEW.TransactionID, 'INSERT', SYSDATE);
END;
/
