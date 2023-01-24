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
              <div onClick={(e) => handleLessonChange(moduleId)} className={umodulesCompleted?umodulesCompleted.modulesCompleted[idx]?styles.completed:styles.pending:null}>{idx+1} .{name}</div>
            </div>
        );
      })}
    </div>
  );
};
export default LessonsSidebar;
