const Course = require('../models/Course');

const getAll = () => {
    return Course
        .find({})
        .sort({createdAt: -1})
        .lean();
};


const getPopular = (size)=>
     Course
        .find()
        .sort({usersEnrolled: -1})
        .limit(size)
        .lean();

const getOne = (id, userId) =>
    Course
        .findById(id)
        .then(course => {
            course.isEnrolled = course.usersEnrolled.includes(userId);
            course.isOwn = course.creator == userId;
            return course;
        });

const create = (courseData, userId) => {
    let course = new Course({...courseData, createdAt: new Date(), creator: userId})
    return course.save();
};

const enrollUser = (courseId, userId) => {
    return Course.findById(courseId).then(course => {
        course.usersEnrolled.push(userId)
        return course.save();
    })
};

let deleteCourse = (courseId) => {
    return Course.deleteOne({_id: courseId})


};

const updateOne = (courseId, courseData) => {
    return Course.updateOne({_id: courseId}, courseData);

};

module.exports = {
    create,
    getAll,
    getOne,
    enrollUser,
    deleteCourse,
    updateOne,
    getPopular,
}

