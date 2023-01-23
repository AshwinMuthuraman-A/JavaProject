import axios from "axios";
const uploadUrl = 'http://localhost:6039/file/upload';
const downloadUrl = 'http://localhost:6039/file/download/';
export const downloadApi = async(fileId) => {
    try {
        const murl = downloadUrl.concat(fileId);
        const response = await axios.get(murl)
        return response;
    } catch (error) {
        console.error(error.message);
        return error;
    }
}