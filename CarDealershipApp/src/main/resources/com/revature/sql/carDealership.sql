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
USER_TYPE_ID INTEGER);

CREATE TABLE USER_TYPE(
USER_TYPE_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
USER_TYPE_DESC VARCHAR2(50));

CREATE TABLE CUSTOMER(
CUSTOMER_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
FIRST_NAME VARCHAR2(50),
LAST_NAME VARCHAR2(50),
STREET VARCHAR2(50),
CITY VARCHAR2(50),
PROVINCE VARCHAR(50),
ZIP_CODE VARCHAR2(50),
PHONE_NUMBER VARCHAR2(15),
USER_ID INTEGER,
CREDIT_SCORE INTEGER);

CREATE TABLE EMPLOYEE(
EMPLOYEE_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
FIRST_NAME VARCHAR2(50),
LAST_NAME VARCHAR2(50),
PHONE_NUMBER VARCHAR2(15),
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
CAR_VALUE NUMBER(8,2),
CAR_STATUS VARCHAR2(10));

CREATE TABLE CAR_TYPE(
CAR_TYPE_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
CAR_TYPE_DESC VARCHAR2(15));

CREATE TABLE OFFERS(
OFFER_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
CAR_ID INTEGER,
CUSTOMER_ID INTEGER,
OFFER_AMOUNT NUMBER(8,2),
OFFER_STATUS VARCHAR2(10));

CREATE TABLE CAR_SOLD(
CAR_SOLD_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
OFFER_ID INTEGER,
CAR_SOLD_AMOUNT NUMBER(8,2),
DOWN_PAYMENT NUMBER(8,2),
LOAN_AMOUNT NUMBER(8,2),
CAR_LOAN_ID INTEGER,
CAR_SOLD_DATE DATE);

CREATE TABLE CAR_LOAN(
CAR_LOAN_ID INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
CAR_ID INTEGER,
CUSTOMER_ID INTEGER,
LOAN_AMOUNT NUMBER(8,2),
LOAN_INTEREST NUMBER(4,2),
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

ALTER TABLE CAR_SOLD
ADD CONSTRAINT FK_CAR_SOLD_OFFERS
FOREIGN KEY (OFFER_ID) REFERENCES OFFERS(OFFER_ID);

ALTER TABLE PAYMENTS
ADD CONSTRAINT FK_PAYMENTS_CAR_LOAN
FOREIGN KEY (CAR_LOAN_ID) REFERENCES CAR_LOAN(CAR_LOAN_ID);

ALTER TABLE CAR_LOAN
ADD CONSTRAINT FK_CAR_LOAN_CUSTOMER
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID);

ALTER TABLE CAR_LOAN
ADD CONSTRAINT FK_CAR_LOAN_CAR
FOREIGN KEY (CAR_ID) REFERENCES CAR(CAR_ID);

ALTER TABLE CAR_SOLD
ADD CONSTRAINT FK_CAR_SOLD_CAR_LOAN
FOREIGN KEY (CAR_LOAN_ID) REFERENCES CAR_LOAN(CAR_LOAN_ID);





