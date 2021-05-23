const Course = require('../models/Course');



const getOne = (id)=>{
    return  Course.findById(id).lean();
};



const getAll = ()=>{
   return  Course.find({}).sort({createdAt:-1}).lean();
};

const create = (courseData) => {

    let course = new Course(courseData)


    return course.save();
};

module.exports = {

    create,
    getAll,
    getOne,


}

