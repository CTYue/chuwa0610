## 1.  Explain following concepts:
### 1.  Docker daemon
Docker daemon is the core part of the Docker system. It is a background process that usually runs in the background. It exists as a Linux background service and 
is responsible for performing all functions of the Docker system, including creating, running, and monitoring containers, as well as building and storing images.
### 2.  Docker host
In host mode, the Docker container shares its network namespace with the host. A Docker container is usually assigned an independent Network Namespace. However, if you use host mode when starting a container, the container will not get an independent Network Namespace, but will share a Network Namespace with the host.
The container will not virtualize its own network card, configure its own IP, etc., but will use the host's IP and port.
### 3.  Docker Registry
Docker Registry is a repository for images that can easily store, manage, and distribute images. By uploading images to the Registry, users can quickly download and run images in different environments, greatly improving the efficiency of application deployment and management.
For example, if we want to use MySQL, we only need to download its image, run the MySQL container, and finally configure the database connection.
### 4.  Image/Image Tag
Image: A read-only template that contains an application and all its dependencies, which can be used to create a container.
Image Tag: A tag used to identify the image version, used for version management and distinguishing different versions of the same image.
### 5.  Container Volume
Docker container volumes are a way to keep data created and used by Docker containers persistent. Volumes are stored on the host machine's file system, which means the data stays around even if you delete the container. 
Plus, volumes can be shared between multiple containers.
### 6.  Docker Namespace
In Docker, Namespace is used to isolate network, file system, user, process and other resources between containers.
For example, run Java Web applications and MySQL databases in different Docker containers and ensure resource isolation between them.
## 2.  Dockerize you lastest home work project.
  - Save and build it.
  - If your application depends on more than one docker base image, please make above as a docker compose execution.
  - Try mapping host file path to contain's file path, or vice versa.
  - Test and verify if your app's functionalities remain same after Dockerization.
  add dockerfile and docker-compose.yml  to the  root directory of the project