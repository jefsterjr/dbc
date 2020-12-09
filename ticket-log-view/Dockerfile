FROM node:12.7-alpine AS build
RUN mkdir -p  /app
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . /app
RUN npm run build --prod

FROM nginx:1.19.5-alpine
COPY --from=build app/dist/ticker-log-front /usr/share/nginx/html

EXPOSE 4200
