import axios from "axios";
export const userLoginApi = async(userData) => {
    try{
    const response = await(axios.post("http://localhost:1234/user/login" , userData));
    return response;
    }
    catch(err) {
        console.log(err);
        return err;
    }
}
export const userSignupApi = async(userData) => {
    try{
    const response = await(axios.post("http://localhost:1234/user/login" , userData));
    return response;
    }
    catch(err) {
        console.log(err);
        return err;
    }
}