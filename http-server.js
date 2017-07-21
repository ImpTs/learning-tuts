var http = require('http')
var fs = require('fs')

var server = http.createServer(function(request, response) {
   var filename = process.argv[3];
   var readStream = fs.createReadStream(filename);
   readStream.on('open', function(){
       readStream.pipe(response);
   });
   readStream.on('error', function(err){
       response.end(err);
   });
});
server.listen(process.argv[2]);