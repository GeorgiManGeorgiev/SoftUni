const  bcrypt = require('bcrypt');
const User = require('../models/User');
const {SALT_ROUNDS} = require('../config');

const register = async ({username,password}) => {
    try {

        let salt = await bcrypt.genSalt(SALT_ROUNDS);

        let hash = bcrypt.hash(password,salt);

        const user = new User({username,password: hash});


    }catch (error){


    }



    return await user.save();
};


module.exports = {
    register,
};