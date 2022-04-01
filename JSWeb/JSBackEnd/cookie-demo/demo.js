/* eslint-disable linebreak-style */
/* eslint-disable eqeqeq */
/* eslint-disable no-plusplus */
const express = require('express');
// const cookieParser = require('cookie-parser');
const session = require('express-session');

const app = express();

// BodyParser
app.use(express.urlencoded({ extended: true }));

// Session
app.use(session({
  secret: 'my secret',
  resave: false,
  saveUnitialized: true,
  cookie: { secure: 'auto' },
}));

app.get('/', (req, res) => {
  console.log(req.session.user);

  const user = (req.session.user || { username: 'Anonymous' });

  res.send(`<!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
  </head>
  <body>
      <p>
         Hello, ${user.username}
      </p>
      <a href="/login">Login</a>
    <a href="/register">Register</a>
  </body>
  </html>`);
});

app.get('/login', (req, res) => {
  res.sendFile(`${__dirname}/login.html`);
});
app.get('/register', (req, res) => {
  res.sendFile(`${__dirname}/register.html`);
});
app.post('/register', (req, res) => {
  console.log(req.body);

  const user = {
    username: req.body.username,
    password: req.body.password,
  };
  users[req.body.username] = user;
  console.log(`Registered user ${req.body.username}`);
  res.redirect('/');
  res.redirect('/');
});

app.post('/login', (req, res) => {
  const user = users[req.body.username];
  if (user && req.body.password == user.password) {
    console.log('Sucessful login');
    req.session.user = user;
  } else {
    res.status(401).send('Incorrect username or password');
  }

  res.redirect('/');
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
