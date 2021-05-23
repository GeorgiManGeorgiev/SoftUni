const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const {SALT_ROUNDS, SECRET} = require('../config/config');

const courseSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true,
        unique: true,


    },
    description: {
        type: String,
        required: true,
        maxlength: 50,
    },
    imageUrl: {
        type: String,
        required: true,

    },
    isPublic: {
        type: Boolean,
        default: false,
    },
    createdAt: {
        type: Date,
        required: true,

    },
    usersEnrolled: [{
        type: mongoose.Types.ObjectId,
        ref: 'User',


    }]


});
courseSchema.pre('validate',function (next){

    this.createdAt = new Date();

    next();

});



module.exports = mongoose.model('Course', courseSchema);