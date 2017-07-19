var fs = require('fs');
var path = require('path');
fs.readdir(process.argv[2], 'utf8', function(err, list) {
    var extList = ""
    for (i = 0; i < list.length; i++) {
        if (path.extname(list[i]) == "." + process.argv[3]) {
            extList += list[i] + "\n"
        }
    }
    console.log(extList)
})