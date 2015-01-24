create table TGoodsInfo
(
   ID                   integer not null AUTO_INCREMENT,
   NAME                 varchar(256) not null,
   CODE                 varchar(20) not null,
   COMPANY              varchar(256) not null,
   TRADEMARK            varchar(256) not null,
   TYPE                 integer not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   primary key (ID),
   CONSTRAINT uk_CODE unique(CODE)
);

create index goods_id_index on TGoodsInfo
(
   ID
);

create table TInboundRecord
(
   ID                   integer not null AUTO_INCREMENT,
   GOODS_ID             integer not null,
   PRICE                integer not null,
   COUNT                integer not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   OPERATOR_ID          integer not null,
   primary key (ID)
);

create index in_id_index on TInboundRecord
(
   ID
);

create table TOutboundRecord
(
   ID                   integer not null AUTO_INCREMENT,
   GOODS_ID             integer not null,
   PRICE                integer not null,
   COUNT                integer not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   OPERATOR_ID          integer not null,
   primary key (ID)
);

create index out_id_index on TOutboundRecord
(
   ID
);

create table TShopInfo
(
   ID                   integer not null AUTO_INCREMENT,
   NAME                 varchar(256),
   MOBILE               varchar(25),
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   primary key (ID)
);

create index shop_id_index on TShopInfo
(
   ID
);

create table TShopkeeperInfo
(
   ID                   integer not null AUTO_INCREMENT,
   SHOP_ID              integer not null,
   NAME                 varchar(256),
   PASSWORD             varchar(256),
   MOBILE               varchar(25),
   ROLE                 varchar(100) not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   primary key (ID)
);

create index sk_id_index on TShopkeeperInfo
(
   ID
);

create table TWarehouse
(
   ID                   integer not null AUTO_INCREMENT,
   SHOP_ID              integer not null,
   GOODS_ID             integer not null,
   PURCHASE_PRICE       integer not null,
   PRICE                integer not null,
   COUNT                integer not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   primary key (ID)
);

create index wh_id_index on TWarehouse
(
   ID
);

create table TGoodsParam
(
   ID                   integer not null AUTO_INCREMENT,
   GOODS_ID             integer not null,
   LACK_THRESHOLD      integer not null,
   BACKLOG_THRESHOLD    integer not null,
   COUNT                integer not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   primary key (ID)
);

create index gparam_id_index on TGoodsParam
(
   ID
);
