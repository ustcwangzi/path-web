# 添加
> curl 'http://127.0.0.1:8080/path/add?sourceCity=1&destinyCity=6&departureTime=100&arriveTime=200' \
-H 'auth_token: token' \
--compressed

# 查询
> curl 'http://127.0.0.1:8080/path/query?sourceCity=1' \
-H 'auth_token: token' \
--compressed


PS: header中的auth_token用来鉴权