create table if not exists account
(
    id int auto_increment comment '主键编号'
        primary key,
    user_name varchar(50) null comment '用户账号',
    user_pwd varchar(50) null comment '用户密码',
    user_phone varchar(50) null comment '用户手机号',
    create_time datetime null,
    update_time datetime null
)
comment '后台用户表' charset=utf8;

create table if not exists actor
(
    id int auto_increment comment '主键编号'
        primary key,
    actor_name varchar(50) null comment '演员名称',
    actor_img varchar(200) null comment '演员图片位置',
    create_time datetime null,
    update_time datetime null
)
comment '演员表' charset=utf8;

create table if not exists area_dict
(
    id int auto_increment comment '主键编号'
        primary key,
    show_name varchar(100) null comment '显示名称',
    create_time datetime null,
    update_time datetime null
)
comment '地域信息表' charset=utf8;

create table if not exists banner
(
    id int auto_increment comment '主键编号'
        primary key,
    banner_address varchar(150) null comment 'banner图存放路径',
    banner_url varchar(200) null comment 'banner点击跳转url',
    is_valid int default 0 null comment '是否弃用 0-失效,1-失效',
    create_time datetime null,
    update_time datetime null
)
comment 'banner信息表' charset=utf8;

create table if not exists brand_dict
(
    id int auto_increment comment '主键编号'
        primary key,
    show_name varchar(100) null comment '显示名称',
    create_time datetime null,
    update_time datetime null
)
comment '品牌信息表' charset=utf8;

create table if not exists cat_dict
(
    id int auto_increment comment '主键编号'
        primary key,
    show_name varchar(100) null comment '显示名称',
    create_time datetime null,
    update_time datetime null
)
comment '类型信息表' charset=utf8;

create table if not exists cinema
(
    id int auto_increment comment '主键编号'
        primary key,
    cinema_name varchar(50) null comment '影院名称',
    cinema_phone varchar(50) null comment '影院电话',
    brand_id int null comment '品牌编号',
    area_id int null comment '地域编号',
    hall_ids varchar(200) null comment '包含的影厅类型,以#作为分割',
    img_address varchar(500) null comment '影院图片地址',
    cinema_address varchar(200) null comment '影院地址',
    minimum_price int default 0 null comment '最低票价',
    create_time datetime null,
    update_time datetime null
)
comment '影院信息表' charset=utf8;

create table if not exists field
(
    id int auto_increment comment '主键编号'
        primary key,
    cinema_id int null comment '影院编号',
    film_id int null comment '电影编号',
    begin_time varchar(50) null comment '开始时间',
    end_time varchar(50) null comment '结束时间',
    hall_id int null comment '放映厅类型编号',
    hall_name varchar(200) null comment '放映厅名称',
    price int null comment '票价',
    create_time datetime null,
    update_time datetime null
)
comment '放映场次表' charset=utf8;

create table if not exists film
(
    id int auto_increment comment '主键编号'
        primary key,
    film_name varchar(100) null comment '影片名称',
    film_type int null comment '片源类型: 0-2D,1-3D,2-3DIMAX,4-无',
    img_address varchar(200) null comment '影片主图地址',
    film_score varchar(20) null comment '影片评分',
    film_preSaleNum int null comment '影片预售数量',
    film_box_office int null comment '影片票房：每日更新，以万为单位',
    film_source int null comment '影片片源，参照片源字典表',
    film_cats varchar(50) null comment '影片分类，参照分类表,多个分类以#分割',
    film_area int null comment '影片区域，参照区域表',
    film_date int null comment '影片上映年代，参照年代表',
    film_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '影片上映时间',
    film_status int null comment '影片状态,1-正在热映，2-即将上映，3-经典影片',
    create_time datetime null,
    update_time datetime null
)
comment '影片主表' charset=utf8;

create table if not exists film_actor
(
    id int auto_increment comment '主键编号'
        primary key,
    film_id int null comment '影片编号,对应mooc_film_t',
    actor_id int null comment '演员编号,对应mooc_actor_t',
    role_name varchar(100) null comment '角色名称',
    create_time datetime null,
    update_time datetime null
)
comment '影片与演员映射表' charset=utf8;

create table if not exists film_info
(
    id int auto_increment comment '主键编号'
        primary key,
    film_id varchar(100) null comment '影片编号',
    film_en_name varchar(50) null comment '影片英文名称',
    film_score varchar(20) null comment '影片评分',
    film_score_num int null comment '评分人数,以万为单位',
    film_length int null comment '播放时长，以分钟为单位，不足取整',
    biography text null comment '影片介绍',
    director_id int null comment '导演编号',
    film_imgs text null comment '影片图片集地址,多个图片以逗号分隔',
    create_time datetime null,
    update_time datetime null
)
comment '影片主表' charset=utf8;

create table if not exists hall_dict
(
    id int auto_increment comment '主键编号'
        primary key,
    show_name varchar(100) null comment '显示名称',
    seat_address varchar(200) null comment '座位文件存放地址',
    create_time datetime null,
    update_time datetime null
)
comment '地域信息表' charset=utf8;

create table if not exists hall_film_info
(
    id int auto_increment comment '主键编号'
        primary key,
    film_id int null comment '电影编号',
    film_name varchar(50) null comment '电影名称',
    film_length varchar(50) null comment '电影时长',
    film_cats varchar(200) null comment '电影类型',
    film_language varchar(50) default '国语2D' null comment '电影语言',
    actors varchar(200) null comment '演员列表',
    img_address varchar(500) null comment '图片地址',
    create_time datetime null,
    update_time datetime null
)
comment '影厅电影信息表' charset=utf8;

create table if not exists `order`
(
    id varchar(100) null comment '主键编号',
    cinema_id int null comment '影院编号',
    field_id int null comment '放映场次编号',
    film_id int null comment '电影编号',
    seats_ids varchar(50) null comment '已售座位编号',
    seats_name varchar(200) null comment '已售座位名称',
    film_price double null comment '影片售价',
    order_price double null comment '订单总金额',
    order_time timestamp default CURRENT_TIMESTAMP not null comment '下单时间',
    order_user int null comment '下单人',
    order_status int default 0 null comment '0-待支付,1-已支付,2-已关闭',
    create_time datetime null,
    update_time datetime null
    )
comment '订单信息表' charset=utf8;

create table if not exists order_2017
(
    id varchar(100) null comment '主键编号',
    cinema_id int null comment '影院编号',
    field_id int null comment '放映场次编号',
    film_id int null comment '电影编号',
    seats_ids varchar(50) null comment '已售座位编号',
    seats_name varchar(200) null comment '已售座位名称',
    film_price double null comment '影片售价',
    order_price double null comment '订单总金额',
    order_time timestamp default CURRENT_TIMESTAMP not null comment '下单时间',
    order_user int null comment '下单人',
    order_status int default 0 null comment '0-待支付,1-已支付,2-已关闭',
    create_time datetime null,
    update_time datetime null
)
comment '订单信息表' charset=utf8;

create table if not exists order_2018
(
    id varchar(100) null comment '主键编号',
    cinema_id int null comment '影院编号',
    field_id int null comment '放映场次编号',
    film_id int null comment '电影编号',
    seats_ids varchar(50) null comment '已售座位编号',
    seats_name varchar(200) null comment '已售座位名称',
    film_price double null comment '影片售价',
    order_price double null comment '订单总金额',
    order_time timestamp default CURRENT_TIMESTAMP not null comment '下单时间',
    order_user int null comment '下单人',
    order_status int default 0 null comment '0-待支付,1-已支付,2-已关闭',
    create_time datetime null,
    update_time datetime null
)
comment '订单信息表' charset=utf8;

create table if not exists source_dict
(
    id int auto_increment comment '主键编号'
        primary key,
    show_name varchar(100) null comment '显示名称',
    create_time datetime null,
    update_time datetime null
)
comment '区域信息表' charset=utf8;

create table if not exists user
(
    id int auto_increment comment '主键编号'
        primary key,
    user_name varchar(50) null comment '用户账号',
    user_pwd varchar(50) null comment '用户密码',
    nick_name varchar(50) null comment '用户昵称',
    user_sex int null comment '用户性别 0-男，1-女',
    birthday varchar(50) null comment '出生日期',
    email varchar(50) null comment '用户邮箱',
    user_phone varchar(50) null comment '用户手机号',
    address varchar(50) null comment '用户住址',
    head_url varchar(50) null comment '头像URL',
    biography varchar(200) null comment '个人介绍',
    life_state int null comment '生活状态 0-单身，1-热恋中，2-已婚，3-为人父母',
    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '修改时间',
    create_time datetime null
)
comment '用户表' charset=utf8;

create table if not exists year_dict
(
    id int auto_increment comment '主键编号'
        primary key,
    show_name varchar(100) null comment '显示名称'
)
comment '年代信息表' charset=utf8;

