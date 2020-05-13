-- CREATING USER
CREATE USER vp
IDENTIFIED BY veepatel
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to vp;
GRANT resource to vp;
GRANT create session TO vp;
GRANT create table TO vp;
GRANT create view TO vp;

conn vp/veepatel


--CREATING TABLES

CREATE TABLE USER_INFO(
USER_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
USER_NAME VARCHAR2(50),
USER_PASSWORD VARCHAR2(50),
USER_EMAIL VARCHAR2(50),
USER_PHONE VARCHAR2(15),
USER_TYPE_ID INTEGER);

CREATE TABLE USER_TYPE(
USER_TYPE_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
USER_TYPE_DESC VARCHAR2(50));

CREATE TABLE CUSTOMER(
CUSTOMER_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
FIRST_NAME VARCHAR2(50),
LAST_NAME VARCHAR2(50),
USER_ID INTEGER,
CREDIT_SCORE INTEGER);

CREATE TABLE EMPLOYEE(
EMPLOYEE_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
FIRST_NAME VARCHAR2(50),
LAST_NAME VARCHAR2(50),
DESIGNATION VARCHAR2(50),
USER_ID INTEGER);

CREATE TABLE CAR(
CAR_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
CAR_TYPE_ID INTEGER,
CAR_MAKE VARCHAR2(50),
CAR_MODEL VARCHAR2(50),
CAR_YEAR INTEGER,
CAR_COLOR VARCHAR2(25),
CAR_MILAGE INTEGER,
CAR_PRICE NUMBER(8,2),
CUSTOMER_ID INTEGER,
CAR_STATUS VARCHAR2(10));

CREATE TABLE CAR_TYPE(
CAR_TYPE_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
CAR_TYPE_DESC VARCHAR2(15));

CREATE TABLE CAR_LOT(
CAR_ID INTEGER UNIQUE);

CREATE TABLE OFFERS(
OFFER_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
CAR_ID INTEGER,
CUSTOMER_ID INTEGER,
OFFER_AMOUNT NUMBER(8,2),
DOWN_PAYMENT NUMBER(8,2),
OFFER_STATUS VARCHAR2(10),
LOAN_AMOUNT NUMBER(8,2),
CAR_LOAN_ID NUMBER,
LOAN_MONTHS NUMBER);

CREATE TABLE CAR_LOAN(
CAR_LOAN_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
CAR_ID INTEGER,
CUSTOMER_ID INTEGER,
LOAN_AMOUNT NUMBER(8,2),
LOAN_INTEREST NUMBER(4,2),
LOAN_TOTAL_AMOUNT NUMBER(8,2),
LOAN_MONTHS INTEGER,
LOAN_MONTHLY_PAYMENT NUMBER(6,2),
LOAN_PAID NUMBER(8,2),
LOAN_PAYMENT_LEFT INTEGER,
LOAN_BALANCE NUMBER(8,2));


CREATE TABLE PAYMENTS(
PAYMENT_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
CAR_LOAN_ID INTEGER,
PAYMENT_AMOUNT NUMBER(8,2),
PAYMENT_DATE DATE);

--Insert Car Types

INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Coupe');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Convertible');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Crossover');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Sedan');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('SUV');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Wagon');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Minivan');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Van');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Pickup Truck');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Sports');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Hybrid');
INSERT INTO CAR_TYPE (CAR_TYPE_DESC) VALUES('Luxury');

--Insert User Types

INSERT INTO USER_TYPE (USER_TYPE_DESC) VALUES('Customer');
INSERT INTO USER_TYPE (USER_TYPE_DESC) VALUES('Employee');

-- ADD FOREIGN KEY CONSTRAINT

ALTER TABLE USER_INFO
ADD CONSTRAINT FK_USER_INFO_USER_TYPE
FOREIGN KEY (USER_TYPE_ID) REFERENCES USER_TYPE(USER_TYPE_ID);

ALTER TABLE CAR
ADD CONSTRAINT FK_CAR_CAR_TYPE
FOREIGN KEY (CAR_TYPE_ID) REFERENCES CAR_TYPE(CAR_TYPE_ID);

ALTER TABLE CAR
ADD CONSTRAINT FK_CAR_CUSTOMER
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID);

ALTER TABLE CAR_LOT
ADD CONSTRAINT FK_CAR_LOT_CAR
FOREIGN KEY (CAR_ID) REFERENCES CAR(CAR_ID);

ALTER TABLE CUSTOMER
ADD CONSTRAINT FK_CUSTOMER_USER_INFO
FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID);

ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_EMPLOYEE_USER_INFO
FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID);

ALTER TABLE OFFERS
ADD CONSTRAINT FK_OFFERS_CAR
FOREIGN KEY (CAR_ID) REFERENCES CAR(CAR_ID);

ALTER TABLE OFFERS
ADD CONSTRAINT FK_OFFERS_CUSTOMER
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID);

ALTER TABLE PAYMENTS
ADD CONSTRAINT FK_PAYMENTS_CAR_LOAN
FOREIGN KEY (CAR_LOAN_ID) REFERENCES CAR_LOAN(CAR_LOAN_ID);

ALTER TABLE CAR_LOAN
ADD CONSTRAINT FK_CAR_LOAN_CUSTOMER
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID);

ALTER TABLE CAR_LOAN
ADD CONSTRAINT FK_CAR_LOAN_CAR
FOREIGN KEY (CAR_ID) REFERENCES CAR(CAR_ID);

ALTER TABLE OFFERS
ADD CONSTRAINT FK_OFFERS_CAR_LOAN
FOREIGN KEY (CAR_LOAN_ID) REFERENCES CAR_LOAN(CAR_LOAN_ID);


-- PROCEDURE TO INSERT EMPLOYEE

CREATE OR REPLACE PROCEDURE ADD_EMPLOYEE
(FNAME IN VARCHAR2,LNAME IN VARCHAR2,DESG IN VARCHAR2,
UNAME IN VARCHAR2,UPASSWORD IN VARCHAR2,UEMAIL IN VARCHAR2,UPHONE IN VARCHAR2,UTYPEID IN INTEGER)
AS
USERID INTEGER;
BEGIN

INSERT INTO USER_INFO (USER_NAME,USER_PASSWORD,USER_EMAIL,USER_TYPE_ID,USER_PHONE) 
VALUES (UNAME,UPASSWORD,UEMAIL,UTYPEID,UPHONE);

SELECT USER_ID INTO USERID FROM USER_INFO WHERE USER_NAME = UNAME AND USER_EMAIL = UEMAIL;

INSERT INTO EMPLOYEE (FIRST_NAME,LAST_NAME,DESIGNATION,USER_ID) 
VALUES (FNAME,LNAME,DESG,USERID);

COMMIT;
END;
/

EXECUTE ADD_EMPLOYEE('Matt','Knighten','MANAGER','Admin','Admin@123','MATT@revature.com','(251)351-1234',3);
EXECUTE ADD_EMPLOYEE('Vee','Patel','SALES EXECUTIVE','Veepatel','Vee@1221','VEE.PATEL@revature.com','(443)123-4567',2);
EXECUTE ADD_EMPLOYEE('Kawkab','Abid','SALES EXECUTIVE','kawkababid','abid@1997','kawkab.abid@gmail.com','(718)234-1786',2);

-- PROCEDURE TO INSERT CUSTOMER

CREATE OR REPLACE PROCEDURE ADD_CUSTOMER
(FNAME IN VARCHAR2,LNAME IN VARCHAR2,CSCORE IN INTEGER,
UNAME IN VARCHAR2,UPASSWORD IN VARCHAR2,UEMAIL IN VARCHAR2,UPHONE IN VARCHAR2,UTYPEID IN INTEGER)
AS
USERID INTEGER;
BEGIN

INSERT INTO USER_INFO (USER_NAME,USER_PASSWORD,USER_EMAIL,USER_TYPE_ID,USER_PHONE) 
VALUES (UNAME,UPASSWORD,UEMAIL,UTYPEID,UPHONE);

SELECT USER_ID INTO USERID FROM USER_INFO WHERE USER_NAME = UNAME AND USER_EMAIL = UEMAIL;

INSERT INTO CUSTOMER (FIRST_NAME,LAST_NAME,USER_ID,CREDIT_SCORE) 
VALUES (FNAME,LNAME,USERID,CSCORE);

COMMIT;
END;
/

-- PROCEDURE TO ADDING CAR

CREATE OR REPLACE PROCEDURE ADD_CAR
(CTYPEID IN INTEGER,CMAKE IN VARCHAR2,CMODEL IN VARCHAR2,
CYEAR IN INTEGER,CCOLOR IN VARCHAR2,CMILAGE IN NUMBER,CPRICE IN NUMBER)
AS
CARID NUMBER;
BEGIN

INSERT INTO CAR (CAR_TYPE_ID,CAR_MAKE,CAR_MODEL,CAR_YEAR,CAR_COLOR,CAR_MILAGE,CAR_PRICE) 
VALUES (CTYPEID,CMAKE,CMODEL,CYEAR,CCOLOR,CMILAGE,CPRICE);

SELECT MAX(CAR_ID)INTO CARID FROM CAR;

INSERT INTO CAR_LOT VALUES (CARID);

COMMIT;
END;
/

-- PROCEDURE TO ACCEPT AN OFFER

CREATE OR REPLACE PROCEDURE ACCEPT_OFFER
(OFFERID IN NUMBER,CARID IN NUMBER,CUSTOMERID IN NUMBER, LOANMONTHS IN NUMBER,
OFFERAMOUNT IN NUMBER,DOWNPAYMENT IN NUMBER,LOANAMOUNT IN NUMBER,
RATE IN NUMBER,MPAYMENTS IN NUMBER)
AS
LOANID NUMBER;
TOTALLOAN NUMBER;

BEGIN

TOTALLOAN := ROUND((MPAYMENTS*LOANMONTHS),2);
UPDATE OFFERS SET OFFER_STATUS = 'ACCEPTED' WHERE OFFER_ID = OFFERID;
UPDATE OFFERS SET OFFER_STATUS = 'REJECTED' WHERE OFFER_ID != OFFERID AND CAR_ID = CARID;
UPDATE CAR SET CAR_STATUS = 'OWNED',CUSTOMER_ID = CUSTOMERID WHERE CAR_ID = CARID;

INSERT INTO CAR_LOAN (CAR_ID,CUSTOMER_ID,LOAN_AMOUNT,LOAN_INTEREST,LOAN_TOTAL_AMOUNT,LOAN_MONTHS,LOAN_MONTHLY_PAYMENT,LOAN_PAYMENT_LEFT,LOAN_BALANCE)
VALUES (CARID,CUSTOMERID,LOANAMOUNT,RATE,TOTALLOAN,LOANMONTHS,MPAYMENTS,LOANMONTHS,(MPAYMENTS*LOANMONTHS));

SELECT CAR_LOAN_ID INTO LOANID FROM CAR_LOAN WHERE CAR_ID=CARID;

UPDATE OFFERS SET CAR_LOAN_ID = LOANID WHERE OFFER_ID=OFFERID;

COMMIT;
END;
/



-- PROCEURE TO DO PAYMENT
CREATE OR REPLACE PROCEDURE DO_PAYMENT
(LOANID IN NUMBER,PAYMENT IN NUMBER)
AS
BEGIN

INSERT INTO PAYMENTS (CAR_LOAN_ID,PAYMENT_AMOUNT,PAYMENT_DATE) VALUES (LOANID,PAYMENT,SYSDATE);

UPDATE CAR_LOAN SET LOAN_PAID=(LOAN_PAID+PAYMENT),LOAN_PAYMENT_LEFT=(LOAN_PAYMENT_LEFT-1),LOAN_BALANCE=(LOAN_BALANCE-PAYMENT) 
WHERE CAR_LOAN_ID=LOANID;

COMMIT;
END;
/


