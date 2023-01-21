import styles from "../styles/Course.module.css";
import DoneIcon from "@mui/icons-material/Done";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import PersonIcon from "@mui/icons-material/Person";
const Course = () => {
  return (
    <div className={styles.flexContainer}>
      <div className={styles.leftCol}>
        <div className={styles.header}>
          <h2>Course Title</h2>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet
            molestiae ullam animi?
          </p>
          <div className={styles.details}>
            <p>Author</p>
            <p>Last updated date</p>
            <p>Lang</p>
          </div>
        </div>
        <div className={styles.listContainer}>
          <h2 style={{ fontWeight: "bold" }}>What you'll learn</h2>
          <ul>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              Lorem ipsum dolor sit amet.
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              Lorem ipsum dolor sit amet.
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              Lorem ipsum dolor sit amet.
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              Lorem ipsum dolor sit amet.
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              Lorem ipsum dolor sit amet.
            </li>
            <li>
              <DoneIcon sx={{ marginRight: "10px" }} />
              Lorem ipsum dolor sit amet.
            </li>
          </ul>
        </div>
        <div className={styles.courseContent}>
          <h2>Course Content</h2>
          <p>Lesson Names and links</p>
        </div>
        <div>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
            quae rerum eligendi et deleniti, magni error, possimus, cupiditate
            necessitatibus beatae eius. Distinctio maxime qui, repudiandae
            dicta, voluptate laborum quae nulla provident sunt repellendus
            cupiditate similique! Animi quo nisi enim id nemo commodi alias
            culpa voluptatibus, dolores unde officiis delectus accusamus.
          </p>
        </div>
        <div>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
            quae rerum eligendi et deleniti, magni error, possimus, cupiditate
            necessitatibus beatae eius. Distinctio maxime qui, repudiandae
            dicta, voluptate laborum quae nulla provident sunt repellendus
            cupiditate similique! Animi quo nisi enim id nemo commodi alias
            culpa voluptatibus, dolores unde officiis delectus accusamus.
          </p>
        </div>
        <div>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
            quae rerum eligendi et deleniti, magni error, possimus, cupiditate
            necessitatibus beatae eius. Distinctio maxime qui, repudiandae
            dicta, voluptate laborum quae nulla provident sunt repellendus
            cupiditate similique! Animi quo nisi enim id nemo commodi alias
            culpa voluptatibus, dolores unde officiis delectus accusamus.
          </p>
        </div>
        <div>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
            quae rerum eligendi et deleniti, magni error, possimus, cupiditate
            necessitatibus beatae eius. Distinctio maxime qui, repudiandae
            dicta, voluptate laborum quae nulla provident sunt repellendus
            cupiditate similique! Animi quo nisi enim id nemo commodi alias
            culpa voluptatibus, dolores unde officiis delectus accusamus.
          </p>
        </div>
        <div>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
            quae rerum eligendi et deleniti, magni error, possimus, cupiditate
            necessitatibus beatae eius. Distinctio maxime qui, repudiandae
            dicta, voluptate laborum quae nulla provident sunt repellendus
            cupiditate similique! Animi quo nisi enim id nemo commodi alias
            culpa voluptatibus, dolores unde officiis delectus accusamus.
          </p>
        </div>
        <div>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
            quae rerum eligendi et deleniti, magni error, possimus, cupiditate
            necessitatibus beatae eius. Distinctio maxime qui, repudiandae
            dicta, voluptate laborum quae nulla provident sunt repellendus
            cupiditate similique! Animi quo nisi enim id nemo commodi alias
            culpa voluptatibus, dolores unde officiis delectus accusamus.
          </p>
        </div>
        <div>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
            quae rerum eligendi et deleniti, magni error, possimus, cupiditate
            necessitatibus beatae eius. Distinctio maxime qui, repudiandae
            dicta, voluptate laborum quae nulla provident sunt repellendus
            cupiditate similique! Animi quo nisi enim id nemo commodi alias
            culpa voluptatibus, dolores unde officiis delectus accusamus.
          </p>
        </div>
      </div>
      <div className={styles.rightCol}>
        <div className={styles.filler}></div>
        <div className={styles.courseCard}>
          <img src="/slide1.png"></img>
          <h2>Course Title</h2>
          <p>235 Students have enrolled</p>
          <ul>
            <li>Lorem.</li>
            <li>Lorem.</li>
            <li>Lorem.</li>
          </ul>
          <button>Enroll Now / Continue Learning</button>
        </div>
      </div>
    </div>
  );
};
export default Course;
