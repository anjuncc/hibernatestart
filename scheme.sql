create table STUDENT (
   id INT NOT NULL auto_increment PRIMARY KEY,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   section    VARCHAR(30) NOT NULL
);
post2
create table STUDENT (
   student_id BIGINT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   section    VARCHAR(30) NOT NULL,
   PRIMARY KEY (student_id)
);


create table ADDRESS (
   address_id BIGINT NOT NULL,
   street VARCHAR(30) NOT NULL,
   city  VARCHAR(30) NOT NULL,
   country  VARCHAR(30) NOT NULL,
   PRIMARY KEY (address_id),
   CONSTRAINT student_address FOREIGN KEY (address_id) REFERENCES STUDENT ( student_id) ON DELETE CASCADE
);
onetoone 独立主键
create table ADDRESS (
   address_id BIGINT NOT NULL AUTO_INCREMENT,
   street VARCHAR(30) NOT NULL,
   city  VARCHAR(30) NOT NULL,
   country  VARCHAR(30) NOT NULL,
   PRIMARY KEY (address_id)
);

create table STUDENT (
   student_id BIGINT NOT NULL AUTO_INCREMENT,
   home_address_id BIGINT NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   section    VARCHAR(30) NOT NULL,
   PRIMARY KEY (student_id),
   CONSTRAINT student_address FOREIGN KEY (home_address_id) REFERENCES ADDRESS ( address_id)
);
onetoone bi
create table STUDENT (
   student_id BIGINT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   section    VARCHAR(30) NOT NULL,
   PRIMARY KEY (student_id)
);


create table ADDRESS (
   address_id BIGINT NOT NULL,
   street VARCHAR(30) NOT NULL,
   city  VARCHAR(30) NOT NULL,
   country  VARCHAR(30) NOT NULL,
   PRIMARY KEY (address_id),
   CONSTRAINT student_address FOREIGN KEY (address_id) REFERENCES STUDENT ( student_id) ON DELETE CASCADE
);
manytoone
create table UNIVERSITY (
   university_id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   country  VARCHAR(30) NOT NULL,
   PRIMARY KEY (university_id)
);

create table STUDENT (
   student_id BIGINT NOT NULL AUTO_INCREMENT,
   university_id BIGINT NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   section    VARCHAR(30) NOT NULL,
   PRIMARY KEY (student_id),
   CONSTRAINT student_university FOREIGN KEY (university_id) REFERENCES UNIVERSITY (university_id) ON UPDATE CASCADE ON DELETE CASCADE
);
mony to many
create table STUDENT (
   student_id BIGINT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   PRIMARY KEY (student_id)
);


create table SUBJECT (
   subject_id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   PRIMARY KEY (subject_id)
);


CREATE TABLE STUDENT_SUBJECT (
    student_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    PRIMARY KEY (student_id, subject_id),
    CONSTRAINT FK_STUDENT FOREIGN KEY (student_id) REFERENCES STUDENT (student_id),
    CONSTRAINT FK_SUBJECT FOREIGN KEY (subject_id) REFERENCES SUBJECT (subject_id)
);
