const router = require('express').Router();

//Controllers
const homeController = require('./controllers/homeController');
const authController = require('./controllers/authController');

//Use Controllers
router.use('/',homeController);
router.use('/auth',authController);





module.exports = router;