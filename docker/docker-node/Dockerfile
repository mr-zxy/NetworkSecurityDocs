FROM node:16-alpine3.16
RUN mkdir -p /home/node   
WORKDIR /home/node       
COPY . /home/node
RUN npm config set strict-ssl false
RUN npm install 
EXPOSE 8000     
CMD npm start