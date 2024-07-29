## HW Docker / HW 15

### 1. Explain following concepts 

#### Docker daemon

A background service that manages Docker containers. It is responsible for **building, running, and monitoring containers**. The daemon listens for Docker API requests and can communicate with other Docker daemons.

**Key Points**:

- **Runs on Docker Host**: It runs on the host machine where Docker is installed.
- **API Interaction**: It exposes a REST API for interacting with Docker, either locally or remotely.
- **Manages Containers**: Handles container lifecycle operations such as creation, execution, and management.

**Example**: On Unix-based systems, the Docker Daemon typically runs as `dockerd`. On Windows, it runs as a service.

#### Docker host 

 The machine (physical or virtual) where the Docker Daemon runs. It provides the environment needed for Docker to operate, including the necessary resources such as CPU, memory, and storage.

**Key Points**:

- **Physical/Virtual Machine**: Can be a physical server, a virtual machine, or a cloud instance.
- **Hosts Containers**: Runs Docker containers and provides the underlying infrastructure.

**Example**: A cloud-based VM from AWS or a local server running Docker.

#### Docker Registry 

a storage and distribution system for Docker images. It allows users to upload, store, and download Docker images. Docker Hub is a popular public registry, but private registries can also be set up.

**Key Points**:

- **Image Storage**: Stores Docker images in a repository.
- **Public/Private**: Public registries like Docker Hub, and private registries that you can set up internally.
- **Repository**: Contains multiple tags of Docker images, organized by repositories.

**Example**: Docker Hub (`hub.docker.com`) or a private registry like Harbor.

#### Image/Image Tag 

- **Image**: A Docker Image is a lightweight, standalone, and executable package that includes everything needed to run a piece of software, including code, runtime, libraries, and environment variables. It is the blueprint from which containers are created.
- **Image Tag**: A tag is a label applied to a Docker image, often used to specify a version or variant of the image. It helps in identifying and retrieving different versions of the same image.

**Key Points**:

- **Image**: Immutable and can be shared or versioned.
- **Tag**: Typically in the format `repository:tag` (e.g., `ubuntu:18.04`).

**Example**: The image `nginx:latest` refers to the latest version of the Nginx image.

#### Container Volume

A persistent data storage mechanism that can be used by Docker containers to store data that needs to persist beyond the lifecycle of the container. Volumes are stored on the host filesystem or in a remote storage system.

**Key Points**:

- **Persistence**: Data in volumes persists even if the container is removed.
- **Sharing**: Volumes can be shared among multiple containers.
- **Management**: Managed by Docker and can be backed up or restored independently.

**Example**: Mounting a volume to a container to store logs or application data. 

#### Docker Namespace 

A feature of the Linux kernel that provides isolation between containers. They ensure that containers have their own isolated environments for processes, network interfaces, and file systems.

**Key Points**:

- **Process Isolation**: Each container has its own process space.
- **Network Isolation**: Containers have their own network interfaces and IP addresses.
- **File System Isolation**: Containers operate in their own file system space.

**Example**:

- **PID Namespace**: Isolates process IDs.
- **Network Namespace**: Provides separate network interfaces.
- **Mount Namespace**: Controls access to file systems.



### 2. Dockerize you lastest home work project. 

### 3. Save and build it. 

### 4. If your application depends on more than one docker base image, please make above as a docker compose execution. 

### 5. Try mapping host file path to contain's file path, or vice versa. 

### 6. Test and verify if your app's functionalities remain same after Dockerization.