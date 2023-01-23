import LessonVideo from "../components/LessonVideo";
import PdfRenderer from "../components/PdfRenderer";
import { useState ,useEffect} from "react";
import styles from "../styles/Lesson.module.css"
import { getModuleApi } from "../api/coursesApi";
const Lesson = ()=> {
    const [videoState , setVideoState] = useState(true);
    let lessonId = window.location.href;
    lessonId = lessonId.split('/');
    lessonId = lessonId[lessonId.length - 1];
    const [lesson , setLessson] = useState({});
    useEffect(() => {
    let lessonId = window.location.href;
    lessonId = lessonId.split('/');
    lessonId = lessonId[lessonId.length - 1];
        console.log(lessonId);
        getModuleApi(lessonId).then((resolve) => {
            setLessson(resolve.data);
        })
    } , [])
   const handleVideoClick = (e) => {
        setVideoState(true);
    }
    const handlePdfClick =(e) => {
        if(videoState)
            setVideoState(false);
    }
    return (
        <>
        <div className={styles.header}>Course name : Current Lesson Name{lesson.name}</div>
        <div className={styles.pageContainer}>
        <div className={styles.sidebar}>
            <ul>
                <li>Lesson1</li>
                <li>Lesson2</li>
                <li>Lesson3</li>
                <li>Lesson4</li> 
            </ul>
        </div>
        <div className={styles.mainContent}>
            <p className={styles.description}>The lesson's description</p>
        <button onClick={ e => handleVideoClick(e)}>Video</button>
        <button onClick = {e =>handlePdfClick(e)}> Pdf Materials</button>
        <div>
         {videoState? 
         <LessonVideo VideoUrl={`http://localhost:6039/file/download/${lesson.videoContent}`}/>:
          <PdfRenderer 
         PdfUrl={`http://localhost:6039/file/download/${lesson.pdfContent}`} 
        //  PdfUrl="file:///C:/Users/Kathir/Documents/2020103016-Record.pdf"
         />}
        </div>
      <button>Mark as Completed</button>
        </div>
       </div>
       </>
    )
}
export default Lesson;