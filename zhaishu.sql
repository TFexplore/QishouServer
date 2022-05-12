use f50m_b_rider;
alter table employee modify id int(10)  auto_increment;#��������
/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
create table employee
(
    id                   int(10) not null comment '����id',
    employee_id          int(6) comment 'Ա��ID��6λ����',
    name                 varchar(5),
    id_card              varchar(18) comment '���֤����',
    phone_num            varchar(11),
    password             varchar(20),
    sex                  tinyint(1),
    avatar               varchar(100) comment 'ͷ����Ƭ',
    front_id_card        varchar(100) comment '���֤ͷ����',
    behind_id_card       varchar(100) comment '���֤������',
    holding_id_card      varchar(100) comment '�ֳ����֤��',
    employee_type        tinyint(1) comment 'Ա������',
    sarlary_level        tinyint(2) comment 'Ա��н��ȼ�',
    is_delete            tinyint(1),
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table employee comment 'Ա����Ϣ��';

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
    id                   int(10) not null comment '����id',
    employee_id          int(6)  comment '���ּ̳�Ա����ʹ��Ա��ID',
    rider_type           tinyint(1) not null comment '�������ͣ�δ��˳ɹ�Ϊ0',
    location_id          int(6) comment 'ѧУλ�ñ��',
    regist_time          datetime comment '����ע��ʱ��',
    check_time           datetime comment '���ע��ʱ��',
    hr                   varchar(10) comment '�����ID',
    invitation_code      int(6) comment '����������',
    is_delete            tinyint(1),
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table rider comment '������Ϣ��';

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
    id                   int(10) not null comment '����ID',
    employee_id          int(6) comment '����',
    apply_rider_type     tinyint(1) comment '������������',
    apply_time           datetime comment '����ʱ��',
    check_content        varchar(500) comment '��˲�ͨ��ԭ��',
    check_state          tinyint(1) comment '���״̬',
    is_delete            tinyint(1),
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table in_application comment '��ְ�����';

/*==============================================================*/
/* Index: employee_id                                           */
/*==============================================================*/
create unique index employee_id on in_application
    (
     employee_id
        );

create table reject_record
(
    goods_order_id       int(19) not null comment '��Ʒ�������',
    employee_id          int(6) comment '����',
    record_type          tinyint(1) comment '��¼����:1-�ܾ�,2-��ʱ',
    feedback             varchar(255) comment '������Ϣ',
    record_time          datetime comment '��¼ʱ��',
    is_penalty           tinyint(1) comment '�Ƿ��¼����:1-��,0-��',
    check_by             int(6) comment '�����',
    check_time           datetime comment '���ʱ��',
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (goods_order_id));

alter table reject_record comment '�ܽ��볬ʱ��¼��';

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
   id                   int(10) not null comment '����id',
   employee_id          int(6),
   weixin_id            varchar(20) comment '΢��ID,�������΢�Ű���Ҫ���',
   withdraw_num         decimal(10,2) comment '���ֽ��',
   withdraw_time        datetime comment '����ʱ��',
   withdraw_flag        tinyint(1) comment '�Ƿ��������',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table apply_withdraw comment '�������ֱ�';

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
   id                   int(10) not null comment '����id',
   distribute_bill_id   int(19) comment '�����˵����',
   goods_order_id       int(19) comment '����ID',
   bill_amount          decimal(10,2) comment '�˵����',
   bill_time            datetime comment '�˵�����ʱ��',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table distribute_bill comment '���������˵���';

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
   id                   int(10) not null comment '����id',
   distribute_id        int(19) comment '�������Ͷ���ID',
   order_id             int(19) comment '��Ʒ����ID',
   employee_id          int(6) comment '����ID',
   comment_level        tinyint(1) comment '�������۵ȼ�',
   comment_content      varchar(500) comment '������������',
   get_order_time       datetime comment '�ӵ�ʱ��',
   take_order_time      datetime comment 'ȡ��ʱ��',
   distribute_finish_time char(10) comment '�������ʱ��',
   order_finish_time    datetime comment '�������ʱ��',
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   is_delete            tinyint(1),
   primary key (id)
);

alter table distribute_order comment '����������Ϣ��';

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
   start_time           datetime comment '��¼���㿪ʼʱ��',
   end_time             date comment '��¼�������ʱ��',
   order_commission_num int(5) comment '�����������',
   order_commission_price decimal(5,2) comment '������ɵ���',
   worktime_commission_num int(5) comment '����ʱ���������',
   worktime_commision_price decimal(5,2) comment '����ʱ����ɵ���',
   festival_commission_num int(5) comment '�ڼ��չ����������',
   festival_commission_price decimal(5,2) comment '�ڼ��չ�����ɵ���',
   special_worktime_commision_num int(5) comment '���⹤�����������',
   special_worktime_commission_price decimal(5,2) comment '���⹤������ɵ���',
   invite_user_num      int(6) comment '�������û�����',
   invite_user_price    decimal(5,2) comment '�������û�����',
   positive_comment_bonus decimal(5,2) comment '��������',
   negative_comment_forfeit decimal(5,2) comment '��������',
   overtime_num         int(5) comment '��ʱ���ʹ���',
   overtime_price       decimal(5,2) comment '��ʱ���ͷ����',
   other_bonus          decimal(5,2) comment '��������',
   other_forfeit        decimal(5,2) comment '��������',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table employee_bonus_penalty_record comment '������¼��';

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
   id                   int(10) not null comment '����id',
   employee_salary_id   int(12) comment 'Ա��н����ϢID',
   employee_id          int(6),
   base_salary          decimal(5,2) comment '��������',
   order_salary         decimal(5,2) comment '��������',
   order_royalty        decimal(5,2) comment '������ɹ���',
   attend_bonus         decimal(5,2) comment '���ڽ���',
   invite_rider_bonus   decimal(5,2) comment '�������ֽ���',
   positive_comment_bonus decimal(5,2) comment '��������',
   other_bonus          decimal(5,2) comment '��������',
   negative_comment_forfeit decimal(5,2) comment '��������',
   over_time_forfeit    decimal(5,2) comment '��ʱ���ͷ���',
   refuse_order_forfeit decimal(5,2) comment '�ܾ���������',
   other_forfeit        decimal(5,2) comment '��������',
   start_time           datetime comment 'н����㿪ʼʱ��',
   end_time             datetime comment 'н��������ʱ��',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table employee_salary comment 'Ա��н�ʱ�';

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
   id                   bigint(0) not null comment '����ID,�����˵�ID',
   salary_bill_id       int(19) comment '�˵����',
   salary_bill_name     varchar(30),
   employee_id          int(6) not null,
   employee_salary_id   int(12) comment 'Ա��н����ϢID',
   total_money          decimal(6,2) comment '�ܽ��',
   hr_check_state       tinyint(1) comment 'hr���״̬',
   finance_check_state  tinyint(1) comment '�������״̬',
   pay_state            tinyint(1) comment '���״̬',
   pay_people           int(6) comment '�����',
   pay_time             datetime comment '֧��ʱ��',
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
   id                   int(10) not null comment '����id',
   employee_id          int(6),
   balance              decimal(10,2) not null comment '���',
   password             varchar(6) comment '������6λ֧������',
   weixin_id            varchar(20) comment '΢��ID',
   alipay               varchar(20) comment '֧����ID',
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
   id                   int(10) not null comment '����id',
   inform_id            int(19),
   inform_type          tinyint(1) comment '֪ͨ����',
   inform_title         varchar(20) comment '��Ŀ',
   inform_content       varchar(255) comment '����',
   Infrom_time          datetime comment 'ʱ��',
   period_validity      int(2) comment '��Ч�ڣ���λ��',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table inform comment '֪ͨ�����';

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
   id                   int(10) not null comment '����id',
   invitate_id          int(6) comment '������',
   invitated_id         int(6) comment '��������',
   is_success           tinyint(1) comment '�Ƿ�ɹ�����',
   invitate_time        datetime comment '��������ʱ��',
   invitate_success_time datetime comment '����ɹ�ʱ��',
   check_state          tinyint(1) comment '���״̬',
   check_people         int(6) comment '�����',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table invitate_rider comment '�������ּ�¼';

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
   id                   int(10) not null comment '����id',
   receipt_id           int(19) comment '��ִ��ID',
   salary_bill_id       int(19) comment '֧�������˵�ID',
   finance_id           int(6) comment '��������ID',
   delining_balance_account int(30) comment '�ۿ��˻�',
   account_credited     int(30) comment '�տ��˻�',
   transfer_state       tinyint(1) comment 'ת��״̬',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table receipt_of_transfer comment 'ת�˻�ִ��';




/*==============================================================*/
/* Table: salary_level                                          */
/*==============================================================*/
create table salary_level
(
   id                   int(10) not null comment '����id',
   employee_id          int(6),
   salary_level         tinyint(2) comment 'Ա�����ʵȼ�',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table salary_level comment 'Ա��н��ȼ���';

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
   id                   int(10) not null comment '����ID',
   employee_id          int(6) comment '����',
   apply_time           datetime comment '����ʱ��',
   check_content        varchar(500) comment '�������',
   check_state          tinyint(1) comment '���״̬',
   is_delete            tinyint(1),
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table separation_application comment '��ְ�����';

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
   id                   int(10) not null comment '����id',
   worktime_id          int(19) comment '����ʱ�α��',
   date_id              int(8),
   start_time           datetime comment 'ʱ�ο�ʼʱ��',
   end_time             datetime comment 'ʱ�ν���ʱ��',
   create_time          datetime,
   create_by            int(6),
   update_time          datetime,
   update_by            int(6),
   primary key (id)
);

alter table work_time comment '����ʱ�α�';

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
    id                   int(10) not null comment '����id',
    date_id              int(8) comment '���ڱ��',
    date_type            tinyint(1) comment '��������',
    is_delete            tinyint(1),
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table rider_calendar comment '����������';

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
    id                   int(10) not null comment '����id',
    schedule_id          int(19) comment '�Ű���',
    worktime_id          int(19) comment '����ʱ�α��',
    employee_id          int(6),
    work_start_time      datetime comment '����ʵ���ϰ࿪ʼʱ��',
    work_end_time        datetime comment '����ʵ���ϰ����ʱ��',
    create_time          datetime,
    create_by            int(6),
    update_time          datetime,
    update_by            int(6),
    primary key (id)
);

alter table rider_schedule comment '�����Ű��';

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