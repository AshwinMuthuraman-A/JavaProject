import { ContactSupportOutlined } from "@mui/icons-material";
import { useState,useRef } from "react";
import LessonUploadComponent from "../components/LessonUploadComponent";
import { uploadModuleApi } from "../api/coursesApi";
const LessonUpload = () => {
  const [Lessons, setLessons] = useState([]);
  const [fileRefs , setFileRefs] = useState([]);
  const handleAddLesson = (e) => {
    e.preventDefault();
    let newLessons = [...Lessons , <LessonUploadComponent fileRefs = {fileRefs} setFileRefs = {setFileRefs} key={Lessons.length} id = {Lessons.length}/>];
    setLessons(newLessons);
    console.log(Lessons);
  };
  const handleUploadLessons = async(e) => {
    e.preventDefault();
    fileRefs.map(async(ele) => {
      const {titleRef , descRef , videoRef , pdfRef} = ele;
      const moduleObj = {
        name:titleRef.current.value,
        desc:descRef.current.value
      }
      const videoFile = videoRef.current.files[0];
      const pdfFile = pdfRef.current.files[0];
      console.log(videoFile);
      console.log(pdfFile);
      let bodyFormData = new FormData();
      bodyFormData.append("courseId" , "63cd8aa89c75d5347d2afd54");
      bodyFormData.append("module" , JSON.stringify(moduleObj));
      bodyFormData.append("pdfFile" , pdfFile);
      bodyFormData.append("videoFile" , videoFile);
      console.log(bodyFormData);
      const response = await uploadModuleApi(bodyFormData);
      console.log(response);
    });
  }
  return (
    <>
    <form onSubmit={ (e) => {handleUploadLessons(e)}}>
      {Lessons.map((Component, i) => {
        return Component;
      })}
      <button onClick={(e) => handleAddLesson(e)}>Add Lessons</button>
      <input type="submit" value="Upload all" />
    </form>
    </>
  );
};
export default LessonUpload;
