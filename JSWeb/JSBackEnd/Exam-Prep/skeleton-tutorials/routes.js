const router = require('express').Router();
const isAuth = require('./middlewares/isAuth');


//Controllers
const homeController = require('./controllers/homeController');
const authController = require('./controllers/authController');
const courseController = require('./controllers/courseController');


//Use Controllers
router.use('/',homeController);
router.use('/auth',authController);
router.use('/course',isAuth,courseController);





module.exports = router;