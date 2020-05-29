FROM node:10

WORKDIR /app/usr/src

COPY package*.json ./

RUN npm install

COPY . .

ENTRYPOINT ["node","index.js"]