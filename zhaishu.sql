use f50m_b_rider;
alter table employee modify id int(10)  auto_increment;#设置自增
/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
create table employee
(
    id                   int(10) not null comment '自增id',
    employee_id          int(6) comment '员工ID，6位数？',
    name                 varchar(5),
    id_card              varchar(18) comment '身份证号码',
    phone_num            varchar(11),
    password             varchar(20),
    sex                  tinyint(1),
    avatar               varchar(100) comment '头像照片',
    front_id_card        varchar(100) comment '身份证头像照',
    behind_id_card       varchar(100) comment '身份证国徽照',
    holding_id_card      varchar(100) comment '手持身份证照',
    employee_type        tinyint(1) comment '员工类型',
    sarlary_level        tinyint(2) comment '员工薪酬等级',
    is_delete            tinyint(1),
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table employee comment '员工信息表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on employee
    (
     employee_id
        );

/*==============================================================*/
/* Index: phone_num                                             */
/*==============================================================*/
create unique index phone_num on employee
    (
     phone_num
        );
/*==============================================================*/
/* Table: rider                                                 */
/*==============================================================*/
create table rider
(
    id                   int(10) not null comment '自增id',
    employee_id          int(6)  comment '骑手继承员工，使用员工ID',
    rider_type           tinyint(1) not null comment '骑手类型，未审核成功为0',
    location_id          int(6) comment '学校位置编号',
    regist_time          datetime comment '申请注册时间',
    check_time           datetime comment '审核注册时间',
    hr                   varchar(10) comment '审核人ID',
    invitation_code      int(6) comment '骑手邀请码',
    is_delete            tinyint(1),
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table rider comment '骑手信息表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on rider
    (
     employee_id
        );
/*==============================================================*/
/* Table: in_application                                        */
/*==============================================================*/
create table in_application
(
    id                   int(10) not null comment '递增ID',
    employee_id          int(6) comment '工号',
    apply_rider_type     tinyint(1) comment '申请骑手类型',
    apply_time           datetime comment '申请时间',
    check_content        varchar(500) comment '审核不通过原因',
    check_state          tinyint(1) comment '审核状态',
    is_delete            tinyint(1),
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table in_application comment '入职申请表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on in_application
    (
     employee_id
        );

create table reject_record
(
    goods_order_id       int(19) not null comment '商品订单编号',
    employee_id          int(6) comment '工号',
    record_type          tinyint(1) comment '记录类型:1-拒绝,2-超时',
    feedback             varchar(255) comment '反馈信息',
    record_time          datetime comment '记录时间',
    is_penalty           tinyint(1) comment '是否记录罚款:1-是,0-否',
    check_by             int(6) comment '审核人',
    check_time           datetime comment '审核时间',
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (goods_order_id));

alter table reject_record comment '拒接与超时记录表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/

create unique index employee_id on reject_record
    (
     employee_id
        );
create unique index goods_order_id on reject_record
    (
     goods_order_id
        );
/*==============================================================*/
/* Table: apply_withdraw                                        */
/*==============================================================*/
create table apply_withdraw
(
   id                   int(10) not null comment '自增id',
   employee_id          int(6),
   weixin_id            varchar(20) comment '微信ID,该项根据微信绑定需要变更',
   withdraw_num         decimal(10,2) comment '提现金额',
   withdraw_time        datetime comment '提现时间',
   withdraw_flag        tinyint(1) comment '是否提现完成',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table apply_withdraw comment '申请提现表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on apply_withdraw
(
   employee_id
);

/*==============================================================*/
/* Table: distribute_bill                                       */
/*==============================================================*/
create table distribute_bill
(
   id                   int(10) not null comment '自增id',
   distribute_bill_id   int(19) comment '配送账单编号',
   goods_order_id       int(19) comment '订单ID',
   bill_amount          decimal(10,2) comment '账单金额',
   bill_time            datetime comment '账单生成时间',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table distribute_bill comment '骑手配送账单表';

/*==============================================================*/
/* Index: distribute_bill_id                                    */
/*==============================================================*/
create unique index distribute_bill_id on distribute_bill
(
   distribute_bill_id
);

/*==============================================================*/
/* Index: goods_order_id                                        */
/*==============================================================*/
create unique index goods_order_id on distribute_bill
(
   goods_order_id
);

/*==============================================================*/
/* Table: distribute_order                                      */
/*==============================================================*/
create table distribute_order
(
   id                   int(10) not null comment '自增id',
   distribute_id        int(19) comment '骑手配送订单ID',
   order_id             int(19) comment '商品订单ID',
   employee_id          int(6) comment '骑手ID',
   comment_level        tinyint(1) comment '订单评价等级',
   comment_content      varchar(500) comment '订单评价内容',
   get_order_time       datetime comment '接单时间',
   take_order_time      datetime comment '取货时间',
   distribute_finish_time char(10) comment '配送完成时间',
   order_finish_time    datetime comment '订单完成时间',
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   is_delete            tinyint(1),
   primary key (id)
);

alter table distribute_order comment '骑手配送信息表';

/*==============================================================*/
/* Index: distribute_id                                         */
/*==============================================================*/
create unique index distribute_id on distribute_order
(
   distribute_id
);

/*==============================================================*/
/* Index: order_id                                              */
/*==============================================================*/
create unique index order_id on distribute_order
(
   order_id
);

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on distribute_order
(
   employee_id
);


/*==============================================================*/
/* Table: employee_bonus_penalty_record                         */
/*==============================================================*/
create table employee_bonus_penalty_record
(
   id                   int not null,
   employee_id          int(6),
   start_time           datetime comment '记录结算开始时间',
   end_time             date comment '记录结算结束时间',
   order_commission_num int(5) comment '订单提成数量',
   order_commission_price decimal(5,2) comment '订单提成单价',
   worktime_commission_num int(5) comment '工作时间提成数量',
   worktime_commision_price decimal(5,2) comment '工作时间提成单价',
   festival_commission_num int(5) comment '节假日工作提成数量',
   festival_commission_price decimal(5,2) comment '节假日工作提成单价',
   special_worktime_commision_num int(5) comment '特殊工作日提成数量',
   special_worktime_commission_price decimal(5,2) comment '特殊工作日提成单价',
   invite_user_num      int(6) comment '邀请新用户数量',
   invite_user_price    decimal(5,2) comment '邀请新用户单价',
   positive_comment_bonus decimal(5,2) comment '好评奖金',
   negative_comment_forfeit decimal(5,2) comment '差评罚金',
   overtime_num         int(5) comment '超时配送次数',
   overtime_price       decimal(5,2) comment '超时配送罚款单价',
   other_bonus          decimal(5,2) comment '其他奖金',
   other_forfeit        decimal(5,2) comment '其他罚金',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table employee_bonus_penalty_record comment '奖罚记录表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on employee_bonus_penalty_record
(
   employee_id
);

/*==============================================================*/
/* Table: employee_salary                                       */
/*==============================================================*/
create table employee_salary
(
   id                   int(10) not null comment '自增id',
   employee_salary_id   int(12) comment '员工薪酬信息ID',
   employee_id          int(6),
   base_salary          decimal(5,2) comment '基本工资',
   order_salary         decimal(5,2) comment '订单工资',
   order_royalty        decimal(5,2) comment '订单提成工资',
   attend_bonus         decimal(5,2) comment '出勤奖金',
   invite_rider_bonus   decimal(5,2) comment '邀请骑手奖金',
   positive_comment_bonus decimal(5,2) comment '好评奖金',
   other_bonus          decimal(5,2) comment '其他奖金',
   negative_comment_forfeit decimal(5,2) comment '差评罚金',
   over_time_forfeit    decimal(5,2) comment '超时配送罚金',
   refuse_order_forfeit decimal(5,2) comment '拒绝订单罚金',
   other_forfeit        decimal(5,2) comment '其他罚金',
   start_time           datetime comment '薪酬结算开始时间',
   end_time             datetime comment '薪酬结算结束时间',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table employee_salary comment '员工薪资表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on employee_salary
(
   employee_id
);

/*==============================================================*/
/* Index: employee_salary_id                                    */
/*==============================================================*/
create index employee_salary_id on employee_salary
(
   employee_salary_id
);

/*==============================================================*/
/* Table: employee_salary_bill                                  */
/*==============================================================*/
create table employee_salary_bill
(
   id                   bigint(0) not null comment '自增ID,工资账单ID',
   salary_bill_id       int(19) comment '账单编号',
   salary_bill_name     varchar(30),
   employee_id          int(6) not null,
   employee_salary_id   int(12) comment '员工薪酬信息ID',
   total_money          decimal(6,2) comment '总金额',
   hr_check_state       tinyint(1) comment 'hr审核状态',
   finance_check_state  tinyint(1) comment '财务审核状态',
   pay_state            tinyint(1) comment '打款状态',
   pay_people           int(6) comment '打款人',
   pay_time             datetime comment '支付时间',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on employee_salary_bill
(
   employee_id
);

/*==============================================================*/
/* Index: salary_bill_id                                        */
/*==============================================================*/
create index salary_bill_id on employee_salary_bill
(
   salary_bill_id
);

/*==============================================================*/
/* Table: employee_wallet                                       */
/*==============================================================*/
create table employee_wallet
(
   id                   int(10) not null comment '自增id',
   employee_id          int(6),
   balance              decimal(10,2) not null comment '余额',
   password             varchar(6) comment '单独的6位支付密码',
   weixin_id            varchar(20) comment '微信ID',
   alipay               varchar(20) comment '支付宝ID',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on employee_wallet
(
   employee_id
);


/*==============================================================*/
/* Table: inform                                                */
/*==============================================================*/
create table inform
(
   id                   int(10) not null comment '自增id',
   inform_id            int(19),
   inform_type          tinyint(1) comment '通知类型',
   inform_title         varchar(20) comment '题目',
   inform_content       varchar(255) comment '内容',
   Infrom_time          datetime comment '时间',
   period_validity      int(2) comment '有效期，单位天',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table inform comment '通知公告表';

/*==============================================================*/
/* Index: inform_id                                             */
/*==============================================================*/
create unique index inform_id on inform
(
   inform_id
);

/*==============================================================*/
/* Table: invitate_rider                                        */
/*==============================================================*/
create table invitate_rider
(
   id                   int(10) not null comment '自增id',
   invitate_id          int(6) comment '邀请人',
   invitated_id         int(6) comment '被邀请人',
   is_success           tinyint(1) comment '是否成功邀请',
   invitate_time        datetime comment '发起邀请时间',
   invitate_success_time datetime comment '邀请成功时间',
   check_state          tinyint(1) comment '审核状态',
   check_people         int(6) comment '审核人',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table invitate_rider comment '邀请骑手记录';

/*==============================================================*/
/* Index: invitate_id                                           */
/*==============================================================*/
create index invitate_id on invitate_rider
(
   invitate_id
);

/*==============================================================*/
/* Table: receipt_of_transfer                                   */
/*==============================================================*/
create table receipt_of_transfer
(
   id                   int(10) not null comment '自增id',
   receipt_id           int(19) comment '回执单ID',
   salary_bill_id       int(19) comment '支付工资账单ID',
   finance_id           int(6) comment '财务打款人ID',
   delining_balance_account int(30) comment '扣款账户',
   account_credited     int(30) comment '收款账户',
   transfer_state       tinyint(1) comment '转账状态',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table receipt_of_transfer comment '转账回执单';




/*==============================================================*/
/* Table: salary_level                                          */
/*==============================================================*/
create table salary_level
(
   id                   int(10) not null comment '自增id',
   employee_id          int(6),
   salary_level         tinyint(2) comment '员工工资等级',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table salary_level comment '员工薪酬等级表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on salary_level
(
   employee_id
);

/*==============================================================*/
/* Table: separation_application                                */
/*==============================================================*/
create table separation_application
(
   id                   int(10) not null comment '递增ID',
   employee_id          int(6) comment '工号',
   apply_time           datetime comment '申请时间',
   check_content        varchar(500) comment '审核内容',
   check_state          tinyint(1) comment '审核状态',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table separation_application comment '离职申请表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on separation_application
(
   employee_id
);

/*==============================================================*/
/* Table: work_time                                             */
/*==============================================================*/
create table work_time
(
   id                   int(10) not null comment '自增id',
   worktime_id          int(19) comment '工作时段编号',
   date_id              int(8),
   start_time           datetime comment '时段开始时间',
   end_time             datetime comment '时段结束时间',
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table work_time comment '工作时段表';

/*==============================================================*/
/* Index: worktime_id                                           */
/*==============================================================*/
create unique index worktime_id on work_time
(
   worktime_id
);

/*==============================================================*/
/* Table: rider_calendar                                        */
/*==============================================================*/
create table rider_calendar
(
    id                   int(10) not null comment '自增id',
    date_id              int(8) comment '日期编号',
    date_type            tinyint(1) comment '日期类型',
    is_delete            tinyint(1),
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table rider_calendar comment '骑手日历表';

/*==============================================================*/
/* Index: date_id                                               */
/*==============================================================*/
create index date_id on rider_calendar
    (
     date_id
        );

/*==============================================================*/
/* Table: rider_schedule                                        */
/*==============================================================*/
create table rider_schedule
(
    id                   int(10) not null comment '自增id',
    schedule_id          int(19) comment '排班编号',
    worktime_id          int(19) comment '工作时段编号',
    employee_id          int(6),
    work_start_time      datetime comment '骑手实际上班开始时间',
    work_end_time        datetime comment '骑手实际上班结束时间',
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table rider_schedule comment '骑手排班表';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create index employee_id on rider_schedule
    (
     employee_id
        );

/*==============================================================*/
/* Index: worktime_id                                           */
/*==============================================================*/
create index worktime_id on rider_schedule
    (
     worktime_id
        );

/*==============================================================*/
/* Index: schedule_id                                           */
/*==============================================================*/
create index schedule_id on rider_schedule
    (
     schedule_id
        );