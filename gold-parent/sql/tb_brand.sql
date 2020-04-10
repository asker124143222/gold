create table tb_brand
(
    id     int auto_increment comment '品牌id'
        primary key,
    name   varchar(200) not null,
    image  varchar(500) null comment '品牌图片地址',
    letter char         null comment '品牌的首字母',
    seq    int          null comment '排序'
)
    comment '品牌';
