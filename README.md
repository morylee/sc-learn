# sc-learn

> Spring Cloud学习笔记，使用了SpringCloud全家桶、Spring Security、Spring Cloud Oauth2、RabbitMQ、Mybatis、Alibaba Druid等

## 软件

```text
该系统依赖JDK 1.8、Maven、Redis、MySQL、RabbitMQ、Nginx（可选）等
```

## 项目目录结构说明

```text
├─sc-learn────────────────────父项目、公共依赖
│ │
│ ├─basic-plugin──────────────基础插件
│ │ │
│ │ ├─auth-client─────────────认证客户端插件
│ │ │
│ │ └─auth-resource───────────认证资产插件
│ │
│ ├─basic-service─────────────基础服务
│ │
│ ├─common────────────────────公共包
│ │ │
│ │ ├─common-base─────────────公共基础包
│ │ │
│ │ ├─common-model────────────公共Model包
│ │ │
│ │ ├─common-redis────────────公共redis工具包
│ │ │
│ │ └─common-service──────────公共服务包
│ │
│ ├─main-server───────────────核心中心
│ │ │
│ │ ├─auth-server─────────────认证中心
│ │ │
│ │ ├─config-server───────────配置中心
│ │ │
│ │ ├─eureka-server───────────微服务注册中心
│ │ │
│ │ └─gateway-web─────────────网关中心
│ │
│ ├─main-service──────────────核心微服务
│ │ │
│ │ ├─message-service─────────消息微服务
│ │ │
│ │ ├─mq-service──────────────MQ微服务
│ │ │
│ │ └─user-service────────────用户微服务
│ │
│ ├─service-api───────────────微服务API
│ │ │
│ │ ├─message-api─────────────消息微服务API
│ │ │
│ │ ├─mq-api──────────────────MQ微服务API
│ │ │
│ │ ├─mq-model────────────────MQ Model包
│ │ │
│ │ └─user-api────────────────用户微服务API
│ │
│ └─third-service─────────────三方微服务
```

## 项目启动说明

### 软件安装
需先安装JDK、Redis、RabbitMQ、MySQL、Maven等软件。

安装RabbitMQ之后，创建用户与Virtual Host，可参照[CSDN w893932747的文章（倾删）](https://blog.csdn.net/w893932747/article/details/81018591)

### 数据库
项目有两个数据库，业务主数据库（main_db）和认证数据库（oauth_db），数据库名可自行调整。

数据库用户自行创建。

数据库脚本见仓库：[sc-config](https://github.com/morylee/sc-config)。

### 项目配置文件
项目使用本地文件配置，需下载配置文件至本地，且需根据以上RabbitMQ和数据库配置，修改各个配置文件中相关配置。

同时需要修改配置中心的spring.cloud.config.server.native.search-locations配置，修改为本地配置文件位置。

配置文件见仓库：[sc-config](https://github.com/morylee/sc-config)。

### 项目启动顺序

eureka-server（port：12000-12005）

config-server（port：12005-12009）

auth-server（port：12010-12014）

message-service（port：12020-12024）

mq-service（port：12025-12029）

user-service（port：12030-12034）

gateway-web（port：18080）
