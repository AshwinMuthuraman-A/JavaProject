import axios from "axios";
const loginUrl = "http://localhost:6039/user/login"
const signupUrl = "http://localhost:6039/user/signup"
export const userLoginApi = async(userData) => {
    try{
    const response = await(axios.post(loginUrl , userData));
    return response;
    }
    catch(err) {
        console.log(err);
        return err;
    }
}
export const userSignupApi = async(userData) => {
    try{
    const response = await(axios.post(signupUrl, userData));
    return response;
    }
    catch(err) {
        console.log(err);
        return err;
    }
}