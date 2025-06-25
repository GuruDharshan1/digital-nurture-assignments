SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_loans IS
        SELECT loan_id, interest_rate, amount
        FROM Loans;

    v_loan_id       Loans.loan_id%TYPE;
    v_old_rate      Loans.interest_rate%TYPE;
    v_amount        Loans.amount%TYPE;
    v_new_rate      Loans.interest_rate%TYPE;
BEGIN
    OPEN cur_loans;
    LOOP
        FETCH cur_loans INTO v_loan_id, v_old_rate, v_amount;
        EXIT WHEN cur_loans%NOTFOUND;

        -- Example policy: Increase interest by 0.5% if loan amount > ₹5,00,000
        IF v_amount > 500000 THEN
            v_new_rate := v_old_rate + 0.5;
        ELSE
            v_new_rate := v_old_rate;
        END IF;

        UPDATE Loans
        SET interest_rate = v_new_rate
        WHERE loan_id = v_loan_id;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ' | Old Rate: ' || v_old_rate ||
                             ' | New Rate: ' || v_new_rate);
    END LOOP;
    CLOSE cur_loans;

    COMMIT;
END;
/
