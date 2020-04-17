/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/4/17 17:11:22                           */
/*==============================================================*/


drop table if exists book;

drop table if exists function;

drop table if exists role;

drop table if exists role_function_rel;

drop table if exists user;

/*==============================================================*/
/* Table: book                                                  */
/*==============================================================*/
create table book
(
   id                   int not null auto_increment,
   name                 varchar(255) comment '书籍名称',
   num                  int comment '数量',
   image_path           varchar(255) comment '图片路径',
   summary              varchar(500) comment '概要',
   pages                varchar(10) comment '书籍页数',
   author               varchar(255) comment '作者',
   publisher            varchar(255) comment '出版社',
   status               int default 0 comment '状态',
   primary key (id)
);

alter table book comment '书籍';

/*==============================================================*/
/* Table: function                                              */
/*==============================================================*/
create table function
(
   id                   int not null auto_increment comment '主键',
   name                 varchar(100) not null comment '功能名称',
   primary key (id)
);

alter table function comment '菜单';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   int not null comment '主键',
   name                 varchar(255) comment '角色名称',
   primary key (id)
);

alter table role comment '角色';

/*==============================================================*/
/* Table: role_function_rel                                     */
/*==============================================================*/
create table role_function_rel
(
   id                   int not null auto_increment comment '主键',
   role_id              int comment '角色id',
   function_id          int comment '功能id',
   primary key (id)
);

alter table role_function_rel comment '角色功能关系表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null comment '主键',
   username             varchar(100) comment '用户名',
   password             varchar(255) comment '密码',
   role                 int comment '角色',
   last_update_time     datetime comment '最后修改时间',
   primary key (id)
);

alter table user comment '用户';

alter table user add constraint FK_Reference_1 foreign key (role)
      references role (id) on delete restrict on update restrict;

