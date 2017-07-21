var http = require('http');
var url = require('url')
var server = http.createServer(function (request, response) {
    var path = url.parse(request.url, true);
    if (path.pathname == '/api/parsetime') {
        date = new Date
        date.setTime(Date.parse(path.query.iso));
        var obj = {
            "hour": date.getHours(),
            "minute": date.getMinutes(),
            "second": date.getSeconds()
        }
        obj = JSON.stringify(obj);
        response.writeHead(200, {'Content-Type': 'application/json'});
        response.end(obj);
    } else if (path.pathname == '/api/unixtime') {
        date = Date.parse(path.query.iso);
        var obj = {
            "unixtime": date
        }
        obj = JSON.stringify(obj);
        response.writeHead(200, {'Content-Type': 'application/json'});
        response.end(obj);
    }
})

server.listen(process.argv[2]);