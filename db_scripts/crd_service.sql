DROP TABLE card_main;

CREATE SEQUENCE card_main_card_no_seq
  MINVALUE 100000000001
  MAXVALUE 999999999999999
  START WITH 100000000001
  INCREMENT BY 1;

CREATE TABLE card_main (
	card_no int8 default NEXTVAL('card_main_card_no_seq') NOT NULL,
	card_type varchar(10) NULL,
	added_by varchar(30) NULL,
	primary_acc_no varchar(16) NULL,
	name_on_card varchar(50) NULL,
	issue_type varchar(10) NULL,
	modified_by varchar(30) NULL,
	status_code int4 NOT NULL,
	added_date timestamp NULL,
	expire_date timestamp NULL,
	issue_date timestamp NULL,
	modified_date timestamp NULL,
	CONSTRAINT card_main_pkey PRIMARY KEY (card_no)
);
