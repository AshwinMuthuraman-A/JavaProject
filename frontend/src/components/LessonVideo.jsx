import ReactPlayer from "react-player";
import screenfull from "screenfull";
import { Container } from "@mui/material";
const LessonVideo = () => {
    return (
        <Container maxWidth="md">
    <div style={{width:'100%' , position:'relative'}}>
          <ReactPlayer width={'100%'} height='100%' 
          url="http://localhost:6039/file/download/63c64784b3615d5af1c1c8b4"
          playing={true}
          muted={true}
          controls
          />
    </div>
    </Container>
    )
}
export default LessonVideo;