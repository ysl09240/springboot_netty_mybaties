alter table wave_origin_data add file_url varchar(200) not null default "";

ALTER TABLE `seer`.`wave_origin_data`
  CHANGE `create_time` `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NULL   COMMENT '创建时间';