Drop table User_Detail;
create table User_Detail (
	CUSTOMER_ID integer PRIMARY KEY,
	NAME varchar(30) NOT NULL,
	USERNAME varchar(20) NOT NULL UNIQUE,
	PASSWORD varchar(20) NOT NULL,
	CREATED_TIMESTAMP date DEFAULT  sysdate
);

INSERT into User_Detail (CUSTOMER_ID, NAME, USERNAME, PASSWORD) values (1, 'admin', 'admin', 'admin');

select * from User_Detail;