var fs = require('fs');
var path = require('path');
var module = require('./module');
var callback = function (err, list) {
    if (err) throw err;
    else {
        list.forEach(function(file) {
            console.log(file);
        } )
    }
}
var list = module(process.argv[2], process.argv[3], callback)
