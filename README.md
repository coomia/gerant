
📘[介绍](#1.介绍) | [系统架构流程图](#2.架构图流程图) | 🌈[功能](#3.功能介绍) |❓[技术栈QA](#4.技术栈选取)| 💌[交流群](#交流群)

## 1.介绍
#### 1.目前涉及技术栈

**Google Guice, Netty, Guice-servlet, protobuf, gRPC, RocketMQ, zookeeper, nameserver, Redis, Guava, TCP, UDP**


## 2.架构图流程图
<img src="https://blogstatic.fireflyi.com/oneblog/gerantv2.svg">


## 3.功能介绍
* [x] 高性能，轻量级，分布式微服务IM完整架构
* [x] 灵活的水平扩容、缩容，理论上可无限扩展
* [ ] 限流，风控，路由策略
* [ ] 群聊，私聊，分组，消息多端同步，离线消息同步
* [x] 使用Google Protocol Buffer高效快速省流量及粘拆包处理
* [x] 自动断线重连，心跳检查
* [x] 完美便捷迁移
* [ ] 源码扩展性强，轻松打造属于自己企业的IM项目
* [ ] 算法优化
* [x] 等等

## 4.技术栈选取

* ioc框架为什么不用spring的ioc组件，而是用google guice?
* 通讯协议和数据结构序列化方式选择protobuf?
* rpc框架为什么选择grpc?
* 选择netty?

*总思想技术栈已最轻最高效为准，不盲目去选择主流技术栈，编程以底层抽象易扩展为准，最大减少依赖工具栈*

## 交流群

不限语言框架

<img src="https://blogstatic.fireflyi.com/oneblog/20190815152816943.jpeg">
