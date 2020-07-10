create table partner(
	id number(8) not null,
	name varchar2(100) not null,
	ceo varchar2(20),
	contact varchar2(20),
	address varchar2(50),
	registered date default sysdate,
	unregistered date
);

alter table partner add constraint pk_partner
primary key(id);

create sequence partner_seq;