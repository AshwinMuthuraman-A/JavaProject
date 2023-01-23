import { Link } from "react-router-dom";
import styles from "../styles/LessonElement.module.css";
const LessonList = (props) => {
  const { moduleList, modulesCompleted } = props;
  console.log(moduleList);
 return (
    <div className={styles.lessonContainer}>
      {moduleList.map((ele) => {
        const { moduleId, name } = ele;
        return (
            <div className={styles.lessonComponent}>
          <Link to = {`/lesson/${moduleId}`} >
              <div>{name}</div>
          </Link>
            </div>
        );
      })}
    </div>
  );
};
export default LessonList;
