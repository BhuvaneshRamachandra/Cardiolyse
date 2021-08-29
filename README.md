# Cardiolyse
This is an demo project for Cardiolyse

## Steps to create a docker image from GitHub( You can skip this step and image is present in Docker Hub):

```bash
git clone https://github.com/BhuvaneshRamachandra/Cardiolyse.git 

docker image build -t YOUR_DOCKER_ID/cardiolyse:tag --no-cache .

docker login

docker image push YOUR_DOCKER_ID/cardiolyse:tag

```

## Steps to download and run image as a container:

 1. First make sure git and docker is installed in your windows machine by running following command.
 
	```bash
	git version
    docker --version
	```
	
	Above command should return the version of corresponding softwares.
	
 2. Download the image from docker hub using the below command( Including . at the end)
	```bash
	docker image build -t 040591/cardiolyse:first --no-cache .
	```
	
 3. List the images present in the folder.
 	```bash
	docker image ls
	```
	
 4. Run the docker image as a container using following command either in interative command or as a background procees:
    
	-- used to run in background
	```bash
	docker container run -d --name health -p 8000:8081 040591/cardiolyse:first 
	```
	
	or 
	
	-- used to run in interactive mode:
	```bash
	docker container run -it --name health -p 8000:8081 040591/cardiolyse:first 
	```
		
    Go to Steps to run the application if you want to verify if application is running.

  5. Check if the container is running
  
```bash
docker container ls
```
	 
  6. To stop the container:
```bash
docker container stop health 
```
	 
  7. To start the container :
```bash
docker container start health 
```
   
  8. To remove the container:
```bash
docker container rm health
```
	
	
 ## Steps to run the application:

1. Check if the application is running in local machine(No authentication is added):

```python
http://localhost:8000/api/reverse/test
```
	
2. You will be redirected error page if you enter the wrong URL
```python
http://localhost:8000/api/reverse/
```

