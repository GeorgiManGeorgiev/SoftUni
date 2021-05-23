const Course = require('../models/Course');




const getAll = ()=>{
   return  Course.find({}).lean();
};

const create = (courseData) => {

    let course = new Course(courseData)


    return course.save();
};

module.exports = {

    create,
    getAll,

}

