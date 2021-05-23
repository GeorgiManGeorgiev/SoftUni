const router = require('express').Router();
const courseService = require('../services/courseService');
const moment  = require('moment');

router.get('/', (req,
                 res,
                 next) => {


    if (req.user) {

        courseService.getAll()
            .then(courses => {
                courses = courses.map(x => ({...x, createdAt: moment(x.createdAt).format('MM-YYYY, h:mm:ss')}))
                res.render('home', {courses});
            })
            .catch(next);
    }else {
      res.render('home');

    }

});



module.exports = router;