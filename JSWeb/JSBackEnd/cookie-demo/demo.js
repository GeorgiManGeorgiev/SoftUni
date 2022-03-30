/* eslint-disable no-plusplus */
/* eslint-disable linebreak-style */
const express = require('express');
// const cookieParser = require('cookie-parser');
const session = require('express-session');

const app = express();

// Session
app.use(session({
  secret: 'my secret',
  resave: false,
  saveUnitialized: true,
  cookie: { secure: 'auto' },
}));

app.get('/', (req, res) => {
  res.end('<p> Hello </p>');
});

app.get('/login', (req, res) => {
  res.sendFile('./login.html');
});

// // cookieParser
// app.use(cookieParser());
// app.get('/setCookie', (req, res) => {
//   res.cookie('message', 'hello');
//   res.end('Cookie set');
// });
// app.get('/readCookie', (req, res) => {
//   res.json(req.cookies);
// });

app.listen(3000);
