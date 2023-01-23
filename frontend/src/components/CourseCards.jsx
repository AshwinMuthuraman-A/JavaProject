//receive props and get content
import styles from "../styles/CourseCard.module.css";
import { downloadApi } from "../api/fileApi";
const CourseCard = (props) => {
	const {course} = props;
	console.log(course);
  const { courseTitle, courseDesc, courseId, highlightKeyPoints, imageId } =
    course;
	console.log("here");	
	console.log({props});
	const baseUrl = 'http://localhost:6039/file/download/';
	const reqUrl = baseUrl.concat(imageId);
	const courseImg = async(imageId) => {
		return await downloadApi(imageId);
	}
  return (
    <div class="card" className={styles.card}>
      <div class="content" className={styles.content}>
        <div class="front" className={styles.front}>
          <div
            style={{
              backgroundImage: `url(${downloadApi(imageId)})`,
              height: "300px",
              width: "100%",
            }}
          >
            {/* <img src={"http://localhost:6039/file/download/63cd8aa89c75d5347d2afd38"}></img> */}
			<img src={reqUrl} alt="" />
          </div>
          <div className={styles.courseDetails}>
            <h2 className={styles.heading}>{courseTitle}</h2>
            <p>{courseDesc}</p>
            <p>4.5 rating</p>
          </div>
        </div>
        <div class="back" className={styles.back}>
          <h2 className={styles.heading}>
            Java for beginners-Learn Java from scratch
          </h2>
          <p>Updated date</p>
          <p>Java basic programming for beginners , Learn java from scratch</p>
          <ul>
            {/* <li>{highlightKeyPoints[0]}</li>
            <li>{highlightKeyPoints[1]}</li>
            <li>{highlightKeyPoints[2]}</li> */}
          </ul>
          <button className={styles.viewBtn}>View Course Details</button>
        </div>
      </div>
    </div>
  );
};
export default CourseCard;
