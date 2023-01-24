import styles from "../styles/Course.module.css";
import { useEffect , useState } from "react";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import PersonIcon from "@mui/icons-material/Person";
import DoneIcon from "@mui/icons-material/Done";
import { getCourseApi, getModuleApi } from "../api/coursesApi";
import { courseEnrollApi, getCourseDetailsApi } from "../api/userApi";
import LessonList from "../components/LessonsList";
import { LoginAlert } from "../components/Alerts";
import Footer from "../components/Footer";
const Course = () => {
  const [course , setCourse] = useState({});
  const [pointsList , setPointsList] = useState([]);
  const [highPointsList , setHightPointsList] = useState([]);
  const [moduleList , setModuleList] = useState([]);
  const [alertState , setAlertState] = useState(false);
  const [userCourseDetails , setUserCourseDetails] = useState({});
  useEffect (() => {
    let url = window.location.href;
    url = url.split('/');
    url = url[url.length-1];
    console.log(url);
    getCourseApi(url).then((resolve) => {
      console.log(resolve.data);
      setCourse(resolve.data);
      setPointsList(resolve.data.importantKeyPoints);
      setHightPointsList(resolve.data.highlightKeyPoints);
      const modulesList = resolve.data.modulesList;
      modulesList.forEach((ele) => {
        getModuleApi(ele).then((response) => {
          console.log(response);
          setModuleList((oldVal) => [...oldVal , response.data])
        }).catch((err) => {
          console.log(err); 
          console.log("Fetch module failed")
        });
        console.log(ele);
      })
    });
    checkEnrollment();
  }
  ,[]);
  // console.log(course);
  const handleCourseEnrollment = async(e) => {
    e.preventDefault();
    const userId = localStorage.getItem("userId");
    const userType = localStorage.getItem("userType");
    if(userId == null) {
      setAlertState(true);
      return;
    }
    if(userType === "Student") {
        let bodyFormData = new FormData();
     let courseId = window.location.href;
    courseId = courseId.split('/');
    courseId = courseId[courseId.length-1];
        bodyFormData.append('userId' , localStorage.getItem("userId"));
        bodyFormData.append('courseId' ,courseId);
        const response = await courseEnrollApi(bodyFormData);
        console.log(response);
    }
  }
  const checkEnrollment = async() => {
    const userId = localStorage.getItem("userId");
    console.log(`The user id is ${userId}`);
     let course = window.location.href;
    course = course.split('/');
    course = course[course.length-1];
    let bodyFormData = new FormData();
    bodyFormData.append('userId' , userId);
    const response = await getCourseDetailsApi(bodyFormData);
    if(response.status != 200) {
      console.log("User is not logged in");
      return;
    }
    else {
    console.log(response);
    response.data.forEach((courseDetails) => {
      const {courseId} = courseDetails;
      if(courseId == course) {
        //course the user has enrolled
        console.log(courseDetails);
        const {courseCompletedPercentage,modulesCompleted} = courseDetails;
        setUserCourseDetails({courseCompletedPercentage , modulesCompleted});
        console.log("UserCourseDetails");
        console.log(userCourseDetails);
      }
    })
 
    }
 }
  return (
    <>
    {alertState ? LoginAlert(setAlertState) : null}
    <div className={styles.flexContainer}>
      <div className={styles.leftCol}>
        <div className={styles.header}>
          <h2>{course.courseTitle}</h2>
          <p>
            {course.courseDesc}
            {userCourseDetails.courseCompletedPercentage}
          </p>
          <div className={styles.details}>
            <p>Instructor:{course.instructorName}</p>
            <p>Course Language:{course.courseLang}</p>
          </div>
        </div>
        <div className={styles.listContainer}>
          <h2 style={{ fontWeight: "bold" }}>What you'll learn</h2>
          <ul>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              {pointsList[0]}
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              {pointsList[1]}
              {/* {course.importantKeyPoints[1]} */}
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              {pointsList[2]}
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              {pointsList[3]}
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              {pointsList[4]}
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              {pointsList[5]}
            </li>
          </ul>
        </div>
        <div className={styles.courseContent}>
          <h2>Course Content</h2>
        <LessonList setAlertState={setAlertState} moduleList={moduleList} moduleCompleted = {userCourseDetails ? userCourseDetails.modulesCompleted : null}/>
        </div>
     </div>
      <div className={styles.rightCol}>
        <div className={styles.filler}></div>
        <div className={styles.courseCard}>
          <img src={`http://localhost:6039/file/download/${course.imageId}`}></img>
          <h2>{course.courseTitle}</h2>
          <p>Number of Enrollments:{course.numberOfStudentsRegistered}</p>
          <ul>
            <li>{highPointsList[0]}</li>
            <li>{highPointsList[1]}</li>
            <li>{highPointsList[2]}</li>
          </ul>
          <button onClick = {(e) => handleCourseEnrollment(e)}>Enroll Now / Continue Learning</button>
        </div>
      </div>
    </div>
      <Footer/>
    </>
  );
};
export default Course;
