import axios from 'axios'
const uploadVideoUrl = 'http://localhost:6039/file/upload';
export const videoUploadApi = async(filedata) => {
    const response = axios.post(uploadVideoUrl , filedata);
    return response;
}