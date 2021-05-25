const router = require('express').Router();


const courseService = require('../services/courseService');


router.get('/create', (
    req,
    res) => {

    res.render('createCourse');


})
router.post('/create', (
    req,
    res, next) => {
    let {
        title,
        description,
        imageUrl,
        isPublic
    } = req.body;

    let courseData = {
        title,
        description,
        imageUrl,
        isPublic: Boolean(isPublic),
    }

    courseService.create(courseData , req.user._id)
        .then(createdCourse => {
            res.redirect('/');
        })
        .catch(next);


})


router.get('/:courseId/details', (
    req,
    res,
    next) => {
    courseService
        .getOne(req.params.courseId, req.user._id)
        .then(course => {
            console.log(course)
            console.log(course.isEnrolled)
            res.render('courseDetails', course)
        })
        .catch(next);


})

router.get('/:courseId/enroll', ((req, res, next) => {
    courseService.enrollUser(req.params.courseId, req.user._id)
        .then(() => {
            res.redirect(`/course/${req.params.courseId}/details`)

        }).catch(next);


}))

module.exports = router;