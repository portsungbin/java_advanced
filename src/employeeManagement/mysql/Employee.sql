Create table employee (
                          eno Varchar(10) NOT NULL primary key,
                          name Varchar(20) NOT NULL ,
                          enteryear Integer NOT NULL ,
                          entermonth Integer NOT NULL ,
                          enterday Integer NOT NULL ,
                          role Varchar(20) NOT NULL ,
                          secno Varchar(10)
);
desc employee;

select * from employee;
