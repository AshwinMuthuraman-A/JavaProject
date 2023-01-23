//receive props and get content
import styles from "../styles/CourseCard.module.css";
import { Link } from "react-router-dom";
const CourseCard = (props) => {
	const {course} = props;
	console.log(course);
  const { courseTitle, courseDesc, courseId, highlightKeyPoints, imageId } =
    course;
	console.log("here");	
	console.log({props});
	const baseUrl1 = 'http://localhost:6039/file/download/';
	const reqUrl = baseUrl1.concat(imageId);
  return (
    <div class="card" className={styles.card}>
      <div class="content" className={styles.content}>
        <div class="front" className={styles.front}>
            {/* <img src={"http://localhost:6039/file/download/63cd8aa89c75d5347d2afd38"}></img> */}
            <div className={styles.imgContainer}>
			<img src={reqUrl} alt="" className={styles.img}/>
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
            <li>{highlightKeyPoints[0]}</li>
            <li>{highlightKeyPoints[1]}</li>
            <li>{highlightKeyPoints[2]}</li>
          </ul>
          <Link to= {`/course/${courseId}`}>
          <button className={styles.viewBtn}>View Course Details</button>
          </Link>
        </div>
      </div>
    </div>
  );
};
export default CourseCard;
