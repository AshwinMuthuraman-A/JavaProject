import { Link } from "react-router-dom";
import styles from "../styles/LessonElement.module.css";
const LessonsSidebar = (props) => {
  let { moduleList, umodulesCompleted } = props;
  umodulesCompleted = umodulesCompleted[0];
  console.log(umodulesCompleted);
  console.log(moduleList);
  const handleLessonChange = (e) => {
window.location.href=`/lesson/${e}`;
  }
 return (
    <div className={styles.lessonContainer}>
      {moduleList.map((ele , idx) => {
        const { moduleId, name } = ele;
        return (
            <div className={styles.lessonComponent}>
              <div onClick={(e) => handleLessonChange(moduleId)}>{name}</div>
              <div>{umodulesCompleted? umodulesCompleted.modulesCompleted[idx]?"true":"false":null}</div>
            </div>
        );
      })}
    </div>
  );
};
export default LessonsSidebar;
