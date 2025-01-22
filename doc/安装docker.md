### 1. 更新系统并安装依赖
首先，更新服务器的软件包索引，并安装 Docker 所需的依赖包。
```shell
# 更新系统软件包
sudo apt-get update

# 安装 Docker 依赖包
sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common \
    lsb-release
```

•	sudo apt-get update：更新包索引，确保系统使用最新的包列表。
•	apt-transport-https：使得系统可以通过 HTTPS 下载 Docker 的软件包。
•	ca-certificates：提供必要的 SSL 根证书，确保 HTTPS 连接的安全性。
•	curl：用于从远程服务器下载 Docker 安装所需的文件。
•	software-properties-common：提供工具来管理软件仓库，方便添加 Docker 官方仓库。
•	lsb-release：提供当前操作系统的版本信息，确保添加正确的 Docker 仓库源

### 2.导入 Docker 官方 GPG 密钥
```shell
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```

### 3. 配置国内 Docker 镜像源
```shell
# 配置阿里云 Docker 镜像源
echo "deb [arch=amd64] https://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list
# 配置网易 Docker 镜像源
echo "deb [arch=amd64] https://mirrors.163.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list
# 配置腾讯云 Docker 镜像源
echo "deb [arch=amd64] https://mirrors.tencent.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list
```
选择其中一个源来配置即可，不需要同时添加多个。

### 4. 更新软件包索引
添加完镜像源后，更新软件包索引：
```shell
sudo apt-get update
```

### 5. 安装 Docker

```shell
sudo apt-get install docker-ce docker-ce-cli containerd.io
```
现在可以安装 Docker 了：
### 6. 启动并设置 Docker 自启动
安装完成后，启动 Docker 服务并设置开机自启：
```shell
# 启动 Docker 服务
sudo systemctl start docker

# 设置 Docker 开机自启
sudo systemctl enable docker
```

### 7. 验证 Docker 安装
使用以下命令验证 Docker 是否已成功安装并启动：
```shell
# 查看 Docker 版本
docker --version

# 查看 Docker 状态
sudo systemctl status docker

```
### 8. 配置 Docker 镜像加速器

#### 1.	创建或编辑 Docker 配置文件：
```shell
sudo mkdir -p /etc/docker
sudo nano /etc/docker/daemon.json
```

#### 	2.	添加以下内容
这里以阿里云加速器为例（你也可以选择其他加速器如网易或腾讯云）：
请将 your-aliyun-id替换为你自己的阿里云加速器地址。你可以登录阿里云 Docker 镜像服务页面获取自己的加速器地址。

```json
{
  "registry-mirrors": ["https://your-aliyun-id.mirror.aliyuncs.com"]
}
```


#### 3. 保存并退出编辑器。
#### 4. 重启 Docker 服务
```shell
sudo systemctl restart docker
```

### 9. 验证加速器配置
```shell
# Registry Mirrors后五行内容
docker info | grep -i -A 5 "Registry Mirrors"
```

如果加速器配置成功，你应该看到类似如下的输出：

```shell
Registry Mirrors:
   https://<your-aliyun-id>.mirror.aliyuncs.com
```

### 10. 测试 Docker 镜像拉取
最后，你可以测试 Docker 是否能够从加速器拉取镜像。比如，拉取一个常见的镜像：
```shell
docker pull mysql:8
```
如果镜像下载速度较快，说明加速器配置成功。
