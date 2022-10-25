FROM node:14-alpine3.15
RUN mkdir -p /dockerServer/node   
WORKDIR /dockerServer/node       
COPY . /dockerServer/node
RUN npm install 
EXPOSE 8000     
CMD npm start