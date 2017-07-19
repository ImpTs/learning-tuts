var fs = require('fs');
var path = require('path');
module.exports = function findExt(dir, ext, callback) {    
    fs.readdir(dir, 'utf8', function (err, list) {
        if (err) return callback(err)
        else {
        var extList = []
        for (i = 0; i < list.length; i++) {
            if (path.extname(list[i]) == "." + ext) {
                extList.push(list[i]);
            }
        }
        return callback(null, extList);
        }
    })
}

