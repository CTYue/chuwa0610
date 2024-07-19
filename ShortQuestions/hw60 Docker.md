# hw-docker
1. Explain following concepts:
   1. Docker daemon
      - a critical component of Docker Platform, responsible for managing Docker objects such as images, containers, networks and volumes.
      
   2. Docker host
      - is a machine where the Docker deamon runs and manages Docker containers.
      
   3. Docker Registry 
      - hostname and port where the image is stored
   4. Image/Image Tag 
      - is a lightweight, standalone and executable software package that includes everything needed to run it.
      - includes the application code, runtime, system tools, libraries and settings.
      - Image tag is a specific version of Docker image.
      
   5. Container Volume
      - a storage area that exists outside of the container’s writable layer, making it independent of the container’s filesystem
   6. Docker Namespace
      -  containers to provide lightweight, efficient, and isolated environments for running applications.
2.  Dockerize you lastest home work project.
    add Dockerfile and docker-compose.yml
3.  Save and build it.
4.  If your application depends on more than one docker base image, please make above as a docker
    compose execution.
5.  Try mapping host file path to contain's file path, or vice versa.
6.  Test and verify if your app's functionalities remain same after Dockerization.

