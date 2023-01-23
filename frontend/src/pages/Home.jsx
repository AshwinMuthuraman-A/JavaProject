import MainCarousel from "../components/MainCarousel";
import styles from "../styles/Home.module.css";
import MultiCarousel from "../components/MultiCarousel";
import {Link} from "react-router-dom"
import { useEffect ,useState} from "react";
import { allCoursesApi } from "../api/coursesApi";
import { InstructorAlert, LoginAlert } from "../components/Alerts";
const Home = () => {
  const [allCourses , setCourses] = useState([]);
  const [alertState , setAlertState] = useState(false);
  const userType = localStorage.getItem("userType");
  const checkInstructor = (e) => {
    //const userType = localStorage.getItem("userType");
    //console.log(userType);
    const userType = null;
    if (userType == null || userType == "Student") {
      setAlertState(true);
      return;
    }
  }
  useEffect(()=> {
    const fetchFun = async() =>{
      return await allCoursesApi();
    }
    const allCourses = fetchFun();
    console.log("Hell");
    console.log(allCourses.then((resp) => {
      console.log(resp);
    setCourses(resp.data);
    }));
  },[])
  console.log(allCourses);
  return (
    <>
    {alertState?InstructorAlert(setAlertState):null}
      <MainCarousel/>
      <div className={styles.content}>
        <h2 className={styles.heading}>A broad selection of courses</h2>
        <p className={styles.text}>Get job ready for an in-demand career</p>
      </div>
      <div style={{ paddingLeft: "1.5rem" }}>
        <MultiCarousel allCourses = {allCourses} />
      </div>
      <div className={styles.flexContainer}>
        <img src="/instructor.jpg" className={styles.insImg}></img>
        <div className={styles.insContent}>
          <h2>Become an instructor</h2>
          <p>
            Instructors from around the world teach millions of students on
            Udemy. We provide the tools and skills to teach what you love.
          </p>
          {userType ==="Instructor" ? <Link to = "/courseRegister"><button >Upload the course</button></Link> : 
          <button onClick = {e => checkInstructor(e)}>Upload a course</button>
          }
          {/* <Link to="/courseRegister"> */}
          {/* </Link> */}
        </div>
      </div>
      {/* <Fileupload/> */}
      {/* <LessonUpload/> */}
    </>
  );
};
export default Home;
