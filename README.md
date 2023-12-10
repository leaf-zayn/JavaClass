# 服务器部署
## 安装Docker
centos:
sudo yum install -y yum-utils</br>
sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo</br>
sudo yum install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin</br>
sudo systemctl start docker</br>
```检测是否安装成功```
sudo docker run hello-world(检测是否安装成功)

## 安装maven
sudo yum install maven

## 打包
sudo mvn package -DskipTests


## 启动环境依赖
sudo docker compose -f docker-compose.env.yml up -d

## 启动服务
sudo docker compose -f docker-compose.service.yml up -d

# 启动单个服务
sudo docker compose -f docker-compose.service.yml up -d [服务名称]
