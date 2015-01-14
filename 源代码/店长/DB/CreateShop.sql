/*==============================================================*/
/* Table: TGoodsInfo                                            */
/*==============================================================*/
create table TGoodsInfo
(
   ID                   integer not null,
   NAME                 varchar(256) not null,
   CODE                 varchar(256) not null,
   COMPANY              varchar(256) not null,
   TYPE                 integer not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   primary key (ID)
);

/*==============================================================*/
/* Index: goods_id_index                                        */
/*==============================================================*/
create index goods_id_index on TGoodsInfo
(
   ID
);

/*==============================================================*/
/* Table: TInboundRecord                                        */
/*==============================================================*/
create table TInboundRecord
(
   ID                   integer not null,
   GOODS_ID             integer not null,
   PRICE                integer not null,
   COUNT                integer not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   OPERATOR_ID          integer not null,
   primary key (ID)
);

/*==============================================================*/
/* Index: in_id_index                                           */
/*==============================================================*/
create index in_id_index on TInboundRecord
(
   ID
);

/*==============================================================*/
/* Table: TOutboundRecord                                       */
/*==============================================================*/
create table TOutboundRecord
(
   ID                   integer not null,
   GOODS_ID             integer not null,
   PRICE                integer not null,
   COUNT                integer not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   OPERATOR_ID          integer not null,
   primary key (ID)
);

/*==============================================================*/
/* Index: out_id_index                                          */
/*==============================================================*/
create index out_id_index on TOutboundRecord
(
   ID
);

/*==============================================================*/
/* Table: TShopInfo                                             */
/*==============================================================*/
create table TShopInfo
(
   ID                   integer not null,
   NAME                 varchar(256),
   MOBILE               varchar(25),
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   primary key (ID)
);

/*==============================================================*/
/* Index: shop_id_index                                         */
/*==============================================================*/
create index shop_id_index on TShopInfo
(
   ID
);

/*==============================================================*/
/* Table: TShopkeeperInfo                                       */
/*==============================================================*/
create table TShopkeeperInfo
(
   ID                   integer not null,
   SHOP_ID              integer not null,
   NAME                 varchar(256),
   PASSWORD             varchar(256),
   MOBILE               varchar(25),
   ROLE                 varchar(100) not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   primary key (ID)
);

/*==============================================================*/
/* Index: sk_id_index                                           */
/*==============================================================*/
create index sk_id_index on TShopkeeperInfo
(
   ID
);

/*==============================================================*/
/* Table: TWarehouse                                            */
/*==============================================================*/
create table TWarehouse
(
   ID                   integer not null,
   SHOP_ID              integer not null,
   GOODS_ID             integer not null,
   PURCHASE_PRICE       integer not null,
   PRICE                integer not null,
   COUNT                integer not null,
   CREATE_TIME          timestamp not null,
   MODIFY_TIME          timestamp not null,
   primary key (ID)
);

/*==============================================================*/
/* Index: wh_id_index                                           */
/*==============================================================*/
create index wh_id_index on TWarehouse
(
   ID
);
