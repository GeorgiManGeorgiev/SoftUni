const router = require('express').Router();
const authService = require('../services/authService');
router.get('/login',(req,res)=>{
    res.render('login');
});

router.get('/register',(req,res)=>{
    res.render('register');
});

router.post('/register',async (req,res)=>{
//     try {
// const
//     }catch (error){


    }


    res.redirect('/auth/register');
});


module.exports = router;
