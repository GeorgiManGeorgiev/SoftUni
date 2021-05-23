const Course = require('../models/Course');


const create = (courseData) => {

    let course = new Course(courseData)


    return course.save();
};

module.exports = {

    create,

}

