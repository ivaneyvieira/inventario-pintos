-- apply changes
create table cl (
  id                            bigint auto_increment not null,
  clno                          integer not null,
  departamento                  varchar(255) not null,
  grupo                         varchar(255) not null,
  secao                         varchar(255) not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint uq_cl_clno unique (clno),
  constraint pk_cl primary key (id)
);

create table coleta (
  id                            bigint auto_increment not null,
  num_coleta                    integer not null,
  coletor                       integer not null,
  status                        integer not null,
  loteinv_id                    bigint not null,
  usuario_id                    bigint not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint pk_coleta primary key (id)
);

create table estoque (
  id                            bigint auto_increment not null,
  utmdata                       date not null,
  filtro                        tinyint(1) default 0 not null,
  inv                           tinyint(1) default 0 not null,
  qt_saldo                      integer not null,
  qt_inv                        integer not null,
  transferencia                 tinyint(1) default 0 not null,
  produto_id                    bigint not null,
  inventario_id                 bigint not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint pk_estoque primary key (id)
);

create table fornecedor (
  id                            bigint auto_increment not null,
  codigo                        integer not null,
  fantazia                      varchar(255) not null,
  razao                         varchar(255) not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint uq_fornecedor_codigo unique (codigo),
  constraint pk_fornecedor primary key (id)
);

create table grupo_inventario (
  id                            bigint auto_increment not null,
  nome                          varchar(255) not null,
  descricao                     varchar(255) not null,
  data_inicio                   date not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint pk_grupo_inventario primary key (id)
);

create table inventario (
  id                            bigint auto_increment not null,
  numero                        integer not null,
  data                          date not null,
  observacao                    longtext not null,
  tipo_inventario               integer not null,
  status_inventario             integer not null,
  loja_id                       bigint not null,
  grupo_inventario_id           bigint not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint uq_inventario_numero unique (numero),
  constraint pk_inventario primary key (id)
);

create table inventario_cl (
  inventario_id                 bigint not null,
  cl_id                         bigint not null,
  constraint pk_inventario_cl primary key (inventario_id,cl_id)
);

create table inventario_fornecedor (
  inventario_id                 bigint not null,
  fornecedor_id                 bigint not null,
  constraint pk_inventario_fornecedor primary key (inventario_id,fornecedor_id)
);

create table leitura (
  id                            bigint auto_increment not null,
  data                          date not null,
  hora                          time not null,
  leitura                       varchar(255) not null,
  observacao                    varchar(255) not null,
  quant                         integer not null,
  status                        integer not null,
  coleta_id                     bigint not null,
  produto_id                    bigint not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint pk_leitura primary key (id)
);

create table loja (
  id                            bigint auto_increment not null,
  storeno                       integer not null,
  endereco                      varchar(255) not null,
  nome                          varchar(255) not null,
  sigla                         varchar(255) not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint uq_loja_storeno unique (storeno),
  constraint pk_loja primary key (id)
);

create table lote (
  id                            bigint auto_increment not null,
  numero                        integer not null,
  descricao                     varchar(255) not null,
  loja_id                       bigint not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint pk_lote primary key (id)
);

create table lote_inv (
  id                            bigint auto_increment not null,
  descricao                     varchar(255) not null,
  tipo_lote                     integer not null,
  inventario_id                 bigint not null,
  lote_id                       bigint not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint pk_lote_inv primary key (id)
);

create table produto (
  id                            bigint auto_increment not null,
  barcode                       varchar(255) not null,
  codigo                        varchar(255) not null,
  grade                         varchar(255) not null,
  fora_linha                    tinyint(1) default 0 not null,
  uso_consumo                   tinyint(1) default 0 not null,
  custo                         double not null,
  fornecedor_id                 bigint not null,
  cl_id                         bigint not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint uq_produto_barcode unique (barcode),
  constraint pk_produto primary key (id)
);

create table transferencia (
  id                            bigint auto_increment not null,
  quant                         integer not null,
  loja_o_id                     bigint not null,
  loja_d_id                     bigint not null,
  prd_o_id                      bigint not null,
  prd_d_id                      bigint not null,
  grupo_id                      bigint not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint pk_transferencia primary key (id)
);

create table usuario (
  id                            bigint auto_increment not null,
  matricula                     integer not null,
  nome                          varchar(255) not null,
  senha                         varchar(255) not null,
  apelido                       varchar(255) not null,
  version                       bigint not null,
  when_created                  datetime not null,
  when_modified                 datetime not null,
  constraint uq_usuario_matricula unique (matricula),
  constraint pk_usuario primary key (id)
);

create index ix_estoque_inventario_id_produto_id on estoque (inventario_id,produto_id);
create index ix_grupo_inventario_nome on grupo_inventario (nome);
create index ix_inventario_loja_id_data on inventario (loja_id,data);
create index ix_inventario_data on inventario (data);
create index ix_lote_loja_id_numero on lote (loja_id,numero);
create index ix_lote_inv_inventario_id_lote_id on lote_inv (inventario_id,lote_id);
create index ix_produto_codigo_grade on produto (codigo,grade);
create index ix_coleta_loteinv_id on coleta (loteinv_id);
alter table coleta add constraint fk_coleta_loteinv_id foreign key (loteinv_id) references lote_inv (id) on delete restrict on update restrict;

create index ix_coleta_usuario_id on coleta (usuario_id);
alter table coleta add constraint fk_coleta_usuario_id foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;

create index ix_estoque_produto_id on estoque (produto_id);
alter table estoque add constraint fk_estoque_produto_id foreign key (produto_id) references produto (id) on delete restrict on update restrict;

create index ix_estoque_inventario_id on estoque (inventario_id);
alter table estoque add constraint fk_estoque_inventario_id foreign key (inventario_id) references inventario (id) on delete restrict on update restrict;

create index ix_inventario_loja_id on inventario (loja_id);
alter table inventario add constraint fk_inventario_loja_id foreign key (loja_id) references loja (id) on delete restrict on update restrict;

create index ix_inventario_grupo_inventario_id on inventario (grupo_inventario_id);
alter table inventario add constraint fk_inventario_grupo_inventario_id foreign key (grupo_inventario_id) references grupo_inventario (id) on delete restrict on update restrict;

create index ix_inventario_cl_inventario on inventario_cl (inventario_id);
alter table inventario_cl add constraint fk_inventario_cl_inventario foreign key (inventario_id) references inventario (id) on delete restrict on update restrict;

create index ix_inventario_cl_cl on inventario_cl (cl_id);
alter table inventario_cl add constraint fk_inventario_cl_cl foreign key (cl_id) references cl (id) on delete restrict on update restrict;

create index ix_inventario_fornecedor_inventario on inventario_fornecedor (inventario_id);
alter table inventario_fornecedor add constraint fk_inventario_fornecedor_inventario foreign key (inventario_id) references inventario (id) on delete restrict on update restrict;

create index ix_inventario_fornecedor_fornecedor on inventario_fornecedor (fornecedor_id);
alter table inventario_fornecedor add constraint fk_inventario_fornecedor_fornecedor foreign key (fornecedor_id) references fornecedor (id) on delete restrict on update restrict;

create index ix_leitura_coleta_id on leitura (coleta_id);
alter table leitura add constraint fk_leitura_coleta_id foreign key (coleta_id) references coleta (id) on delete restrict on update restrict;

create index ix_leitura_produto_id on leitura (produto_id);
alter table leitura add constraint fk_leitura_produto_id foreign key (produto_id) references produto (id) on delete restrict on update restrict;

create index ix_lote_loja_id on lote (loja_id);
alter table lote add constraint fk_lote_loja_id foreign key (loja_id) references loja (id) on delete restrict on update restrict;

create index ix_lote_inv_inventario_id on lote_inv (inventario_id);
alter table lote_inv add constraint fk_lote_inv_inventario_id foreign key (inventario_id) references inventario (id) on delete restrict on update restrict;

create index ix_lote_inv_lote_id on lote_inv (lote_id);
alter table lote_inv add constraint fk_lote_inv_lote_id foreign key (lote_id) references lote (id) on delete restrict on update restrict;

create index ix_produto_fornecedor_id on produto (fornecedor_id);
alter table produto add constraint fk_produto_fornecedor_id foreign key (fornecedor_id) references fornecedor (id) on delete restrict on update restrict;

create index ix_produto_cl_id on produto (cl_id);
alter table produto add constraint fk_produto_cl_id foreign key (cl_id) references cl (id) on delete restrict on update restrict;

create index ix_transferencia_loja_o_id on transferencia (loja_o_id);
alter table transferencia add constraint fk_transferencia_loja_o_id foreign key (loja_o_id) references loja (id) on delete restrict on update restrict;

create index ix_transferencia_loja_d_id on transferencia (loja_d_id);
alter table transferencia add constraint fk_transferencia_loja_d_id foreign key (loja_d_id) references loja (id) on delete restrict on update restrict;

create index ix_transferencia_prd_o_id on transferencia (prd_o_id);
alter table transferencia add constraint fk_transferencia_prd_o_id foreign key (prd_o_id) references produto (id) on delete restrict on update restrict;

create index ix_transferencia_prd_d_id on transferencia (prd_d_id);
alter table transferencia add constraint fk_transferencia_prd_d_id foreign key (prd_d_id) references produto (id) on delete restrict on update restrict;

create index ix_transferencia_grupo_id on transferencia (grupo_id);
alter table transferencia add constraint fk_transferencia_grupo_id foreign key (grupo_id) references grupo_inventario (id) on delete restrict on update restrict;

