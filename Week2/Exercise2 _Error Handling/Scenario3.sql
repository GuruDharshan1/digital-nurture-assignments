CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id   IN NUMBER,
    p_customer_name IN VARCHAR2
)
IS
BEGIN
    -- Try inserting the new customer
    INSERT INTO Customers(customer_id, customer_name)
    VALUES (p_customer_id, p_customer_name);

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        INSERT INTO Error_Log(error_message)
        VALUES('Add Customer Failed: Duplicate customer ID ' || p_customer_id);
    WHEN OTHERS THEN
        INSERT INTO Error_Log(error_message)
        VALUES('Add Customer Failed: ' || SQLERRM);
END;
