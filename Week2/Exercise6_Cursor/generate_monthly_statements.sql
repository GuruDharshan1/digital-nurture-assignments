SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_transactions IS
        SELECT customer_id, transaction_date, amount, transaction_type
        FROM Transactions
        WHERE EXTRACT(MONTH FROM transaction_date) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM transaction_date) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY customer_id;

    v_customer_id     Transactions.customer_id%TYPE;
    v_date            Transactions.transaction_date%TYPE;
    v_amount          Transactions.amount%TYPE;
    v_type            Transactions.transaction_type%TYPE;
    v_last_customer   Transactions.customer_id%TYPE := NULL;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Monthly Statements for ' || TO_CHAR(SYSDATE, 'Month YYYY') || ':');

    OPEN cur_transactions;
    LOOP
        FETCH cur_transactions INTO v_customer_id, v_date, v_amount, v_type;
        EXIT WHEN cur_transactions%NOTFOUND;

        IF v_last_customer IS NULL OR v_last_customer != v_customer_id THEN
            DBMS_OUTPUT.PUT_LINE('------------------------------');
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id);
        END IF;

        DBMS_OUTPUT.PUT_LINE('  ' || TO_CHAR(v_date, 'DD-MON') || ' | ' || v_type || ' | ₹' || v_amount);

        v_last_customer := v_customer_id;
    END LOOP;
    CLOSE cur_transactions;
END;
/
