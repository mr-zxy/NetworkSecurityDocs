FROM node:14-alpine3.15
RUN mkdir -p /home/node   
WORKDIR /home/node       
COPY . /home/node
RUN npm install 
EXPOSE 8000     
CMD npm start