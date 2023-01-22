import MainCarousel from "../components/MainCarousel";
import styles from "../styles/Home.module.css";
import MultiCarousel from "../components/MultiCarousel";
import LessonVideo from "../components/LessonVideo";
import Fileupload from "../components/Fileupload";
import LessonUpload from "./LessonUpload";
import PdfRenderer from "../components/PdfRenderer";
import {Link} from "react-router-dom"
import { useEffect ,useState} from "react";
import { allCoursesApi } from "../api/coursesApi";
const Home = () => {
  const [courses , setCourses] = useState([]);
  useEffect(()=> {
    const allCourses = allCoursesApi();
    setCourses(allCourses);
  },[])
  console.log(courses);
  return (
    <>
      <MainCarousel />
      <div className={styles.content}>
        <h2 className={styles.heading}>A broad selection of courses</h2>
        <p className={styles.text}>Get job ready for an in-demand career</p>
      </div>
      <div style={{ paddingLeft: "1.5rem" }}>
        <MultiCarousel />
      </div>
      <div className={styles.flexContainer}>
        <img src="/instructor.jpg" className={styles.insImg}></img>
        <div className={styles.insContent}>
          <h2>Become an instructor</h2>
          <p>
            Instructors from around the world teach millions of students on
            Udemy. We provide the tools and skills to teach what you love.
          </p>
          <Link to="/courseRegister">
          <button>Become a instructor</button>
          </Link>
        </div>
      </div>
      <Fileupload/>
      <LessonUpload/>
    </>
  );
};
export default Home;
