+++
title = "使用限制"
weight = 2
+++

## 支持项

* 将外围数据迁移至 Apache ShardingSphere 所管理的数据库；
* 迁移含整型唯一键或字符串唯一键的表；
* 迁移含整型主键或字符串主键的表。

## 不支持项

* 迁移无主键且无唯一键的表；
* 迁移复合主键或复合唯一键的表；
* 不支持在当前存储节点之上做迁移，需要准备一个全新的数据库集群作为迁移目标库。