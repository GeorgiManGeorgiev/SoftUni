
const User = require('../models/User');

const register = async (userData) => {
if(userData.password !== userData.repeatPassword){
    return ;
}
    const user = new User({username, password});

    return await user.save();
};


module.exports = {
    register,

};