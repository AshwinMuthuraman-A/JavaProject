import {useRef} from "react"
const LessonUploadComponent = (props) => {
    const {id , fileRefs , setFileRefs} = props;
    const videoRef = useRef(0);
    const pdfRef = useRef(0);
    setFileRefs((oldVal) => [...oldVal , {videoRef , pdfRef}]);
    return(
        <div>
            <input type="file" ref={videoRef}name={`video${id}`} id={`video${id}`} />
            <input type="file" ref={pdfRef }name={`pdf${id}`} id={`pdf${id}`} />
        </div>
    )
}
export default LessonUploadComponent;