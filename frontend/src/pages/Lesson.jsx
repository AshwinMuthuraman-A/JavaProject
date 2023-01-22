import LessonVideo from "../components/LessonVideo";
import PdfRenderer from "../components/PdfRenderer";
import { useState } from "react";
import styles from "../styles/Lesson.module.css"
const Lesson = ()=> {
    const [videoState , setVideoState] = useState(true);
    const handleVideoClick = (e) => {
        setVideoState(true);
    }
    const handlePdfClick =(e) => {
        if(videoState)
            setVideoState(false);
    }
    return (
        <>
        <div className={styles.header}>Course name : Current Lesson Name</div>
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
         {videoState? <LessonVideo VideoUrl="https://www.youtube.com/watch?v=RW--t4tDSj4&list=RDBfQmmsVkB8w&index=9"/>: <PdfRenderer 
         PdfUrl="http://localhost:6039/file/download/63cd19f3dd35173167d88c54" 
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