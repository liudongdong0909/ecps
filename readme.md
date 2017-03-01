## ECPS 系统部署配置文档
### 一、各分布式服务器安装及配置
#### 1.1 文件服务器安装
安装步骤：
```$xslt
http://blog.csdn.net/liudongdong0909/article/details/57414892
```
nginx已经安装完成，只需要按需求更换server即可：
```$xslt
  server {
        listen       80;
        server_name  192.168.31.102;

        location /group1/M00 {
            #root   html;
            ngx_fastdfs_module;
        }
    }

```

#### 1.2 文件服务器配置启动脚本
nginx 已经是默认启动：

cd /usr/local/fastdfs

./fastdfs-tracker-storage-start.sh

#### 1.3 系统中需要改变的文件服务器配置路径
修改：ecps-manager/ ecps-manager-web / src/ resources/ properties /fastdfs_client.conf
```$xslt

onnect_timeout = 10
network_timeout = 30
tracker_server=192.168.31.102:22122 #文件服务器地址及端口
```