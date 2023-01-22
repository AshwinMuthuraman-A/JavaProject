import { ContactSupportOutlined } from "@mui/icons-material";
import { useState,useRef } from "react";
import LessonUploadComponent from "../components/LessonUploadComponent";
const LessonUpload = () => {
  const [Lessons, setLessons] = useState([]);
  const [fileRefs , setFileRefs] = useState([]);
  const handleAddLesson = (e) => {
    e.preventDefault();
    let newLessons = [...Lessons , <LessonUploadComponent fileRefs = {fileRefs} setFileRefs = {setFileRefs} key={Lessons.length} id = {Lessons.length}/>];
    setLessons(newLessons);
    console.log(Lessons);
  };
  const handleUploadLessons = (e) => {
    e.preventDefault();
    // Lessons.map((ele) => console.log(ele));
    fileRefs.map((ele) => console.log(ele));
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
