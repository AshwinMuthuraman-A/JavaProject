import axios from "axios";
const loginUrl = "http://localhost:6039/user/login"
const signupUrl = "http://localhost:6039/user/signup"
const courseEnrollUrl = "http://localhost:6039/user/register-course"
const getCourseDetailsUrl = "http://localhost:6039/user-course-details/getall"
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
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
export const courseEnrollApi = async(payload) => {
    try {
        const response = await axios.put(courseEnrollUrl , payload);
        return response;
    } catch (error) {
        console.log(error.message);
        return error;
    }
}
export const getCourseDetailsApi = async(payload) => {
    try {
        console.log(payload);
        const response = await axios.post(getCourseDetailsUrl , payload);
        return response;
    } catch (error) {
        console.log(error.message);
        return error;
    }

}