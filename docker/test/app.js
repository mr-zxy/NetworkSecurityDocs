var express = require('express');
var PORT = 8000;       
var app = express();
app.get('/', function (req, res) { 
    res.send('Helloworld\n');
});
app.listen(PORT);
console.log('Running on http://localhost:' + PORT);