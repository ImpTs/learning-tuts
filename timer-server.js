var net = require('net')
function formatDate(date){
    var year    =   date.getFullYear();
    var day     =   date.getDate();
    var month   =   date.getMonth() + 1;
    var hours   =   date.getHours();
    var minutes =   date.getMinutes();

    if (day < 10) {
        day = "0" + day.toString();
    }

    if (month < 10) {
        month = "0" + month.toString();
    }
    return year +  '-' + month + '-' + day + ' ' + hours + ":" + minutes + "\n"
}
var server = net.createServer (function (socket) {
    var date = new Date()
    socket.end(formatDate(date))

});
console.log(process.argv);
server.listen(process.argv[2]);

