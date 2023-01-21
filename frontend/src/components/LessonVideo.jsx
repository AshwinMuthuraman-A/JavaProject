import ReactPlayer from "react-player";
import screenfull from "screenfull";
import { Container } from "@mui/material";
const LessonVideo = () => {
    return (
        <Container maxWidth="md">
    <div style={{width:'100%' , position:'relative'}}>
          <ReactPlayer width={'100%'} height='100%' 
          url="http://localhost:6039/file/download/63cad2147fb94a32aade13fd"
          playing={true}
          muted={true}
          controls
          />
    </div>
    </Container>
    )
}
export default LessonVideo;