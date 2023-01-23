import {useRef} from "react"
const LessonUploadComponent = (props) => {
    const {id , fileRefs , setFileRefs} = props;
    const videoRef = useRef(0);
    const pdfRef = useRef(0);
    const titleRef = useRef(null);
    const descRef = useRef(null);
    setFileRefs((oldVal) => [...oldVal , {titleRef , descRef , videoRef , pdfRef}]);
    return(
        <div>
            <input type="text" name="ModuleTitle" id="ModuleTitle" ref={titleRef} placeholder="Enter the lesson's title"/>
            <input type="text" name="ModuleDescription" id="ModuleDescription" ref={descRef} placeholder="Enter a short description of the lesson"/>
            <input type="file" ref={videoRef}name={`video${id}`} id={`video${id}`} />
            <input type="file" ref={pdfRef }name={`pdf${id}`} id={`pdf${id}`} />
        </div>
    )
}
export default LessonUploadComponent;