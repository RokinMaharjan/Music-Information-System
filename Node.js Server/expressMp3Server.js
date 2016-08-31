var express = require('express');
var app = express();
var fs = require("fs");

app.get('/listen*', function (req, res) {
	console.log("request",req.url)
   var re =/%20/g;
   var filePath = req.url.replace(re," ").replace("/listen/","./songs/");
	console.log("Now Streaming... : "+ filePath.replace("songs/",""));
	console.log("File Path   : "+ filePath);
   fs.stat(filePath,function(err,stat){
    	if (stat) {
    		res.writeHead(206, {
        'Content-Type': 'audio/mpeg',
        'Content-Length': stat.size
    });
    		  var readStream = fs.createReadStream(filePath);
     		  readStream.pipe(res);
    		
    	}
    	else{
    		console.log("Error in Stream Server")
    	}

    });

})

var server = app.listen(8081, function () {

  var port = server.address().port

  console.log("Stream Server listening at port:",port)

})
