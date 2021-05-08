// const express = require('express');
// const Router = express.Router;
// //OR
// const {Router} = require('express');
// //OR
// const Router = require('express').Router;
const Router = require('express').Router;

const productController = require('./controllers/productController');
const aboutController = require('./controllers/aboutController');
const accessoryController = require('./controllers/accessoryController');

const router = Router();

router.use('/about',aboutController)
router.use('/', productController);
router.use('/accessories',accessoryController)
router.get('*',(req,res)=>{
    res.render('404');
});
module.exports = router;
