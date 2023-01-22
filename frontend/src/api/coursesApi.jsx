import axios from 'axios'
const allCoursesUrl = 'http://localhost:6039/courses/searchall'
const uploadVideoUrl = 'http://localhost:6039/file/upload';
const uploadCourseUrl = 'http://localhost:6039/courses/create';
export const allCoursesApi = async()=> {
    try{
    const response = await axios.get(allCoursesUrl);
    return await response;
    }
    catch(err) {
        console.log(err);
        return err;
    }
}
export const videoUploadApi = async(filedata) => {
    const response = await axios.post(uploadVideoUrl , filedata);
    return await response;
}
export const uploadCourseApi = async(payload) => {
    try {
        const response = await axios.post(uploadCourseUrl , payload);
        return await response;
    }
    catch(err) {
        console.error(err);
        return err;
    }
}
