FROM node AS builder
WORKDIR /src
COPY . .
RUN npm install && npm run build

FROM nginx
COPY --from=builder /src/dist/meetPlanner /usr/share/nginx/html