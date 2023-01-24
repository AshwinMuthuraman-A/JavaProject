import {useRef} from "react"
import styles from "../styles/LessonUploadComponent.module.css";
const LessonUploadComponent = (props) => {
    const {id , fileRefs , setFileRefs} = props;
    const videoRef = useRef(0);
    const pdfRef = useRef(0);
    const titleRef = useRef(null);
    const descRef = useRef(null);
    setFileRefs((oldVal) => [...oldVal , {titleRef , descRef , videoRef , pdfRef}]);
    return(
        <div className={styles.formContainer}>
            <div className={styles.row}>
                <label htmlFor="ModuleTitle">Module Title</label>
                <input type="text" name="ModuleTitle" id="ModuleTitle" ref={titleRef} placeholder="Enter the lesson's title"/>
            </div>
            <div className={styles.row}>
                <label htmlFor="ModuleDescription">Module's Description</label>
                <input type="text" name="ModuleDescription" id="ModuleDescription" ref={descRef} placeholder="Enter a short description of the lesson"/>
            </div>
            <div className={styles.row}>
                <label htmlFor="Video">Lesson's Video</label>
                <input type="file" ref={videoRef}name={`video${id}`} id={`video${id}`} placeholder="Upload the Lesson Video"/>
            </div>
            <div className={styles.row}>
                <label htmlFor="Pdf">Lesson's Pdf</label>
                <input type="file" ref={pdfRef }name={`pdf${id}`} id={`pdf${id}`} placeholder="Upload the lesson pdf"/>
            </div>
        </div>
    )
}
export default LessonUploadComponent;