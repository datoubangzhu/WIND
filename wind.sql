CREATE DATABASE IF NOT EXISTS computermanageZGM DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use computermanageZGM;

drop table if exists pcinfo;

/*==============================================================*/
/* Table: pcinfo                                                */
/*==============================================================*/
create table pcinfo
(
   pcid                 varchar(50) not null,
   brand                int not null,
   pcname               varchar(50) not null,
   os                   int not null,
   price                int not null,
   amount               int not null,
   primary key (pcid)
);


drop table if exists purchasedinfo;

/*==============================================================*/
/* Table: purchasedinfo                                         */
/*==============================================================*/
create table purchasedinfo
(
   purchaseid           varchar(50) not null,
   pcid                 varchar(50) not null,
   num                  int not null,
   totalmoney           int not null,
   purchasetime         date not null,
   status               varchar(50) not null,
   primary key (purchaseid)
);

set global time_zone='+8:00';