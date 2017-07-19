const BufferList = require('bl')
var http = require('http');
var bl = new BufferList()

callback = function(response){
    response.setEncoding('utf8')
    response.on("data", function(data) {
       bl.append(data);

    })
    response.on("end",function(){
        console.log(bl.toString().length);
        console.log(bl.toString());
    })
};
http.get(process.argv[2], callback)