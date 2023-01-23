import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getModuleApi } from "../api/coursesApi";
import styles from "../styles/LessonElement.module.css";
const LessonList = (props) => {
  const { moduleList, modulesCompleted } = props;
  console.log("Fcuk");
  console.log(moduleList);
  const [lessonDetails, setLessonDetails] = useState([]);
  //     const fetchLessonDets = async(moduleId) => {
  //         const response = await getModuleApi(moduleId);
  //         console.log(response);
  //         setLessonDetails([...lessonDetails , response.data]);
  //     }
  //    useEffect( () => {
  //     console.log(moduleList);
  //     moduleList.forEach((ele) => {
  //         fetchLessonDets(ele);
  //     })
  //    } ,[]);
  return (
    <div className={styles.lessonContainer}>
      {moduleList.map((ele) => {
        const { moduleId, name } = ele;
        return (
          <Link to = {`/lesson/${moduleId}`}>
            <div className={styles.lessonComponent}>
              <div>{name}</div>
              <div>{moduleId}</div>
            </div>
          </Link>
        );
      })}
    </div>
  );
};
export default LessonList;
