import { useState, useRef } from "react";
import DoneIcon from "@mui/icons-material/Done";
import PersonAddAltIcon from "@mui/icons-material/PersonAddAlt";
import styles from "../styles/CourseUpload.module.css";
import zIndex from "@mui/material/styles/zIndex";
import { positions } from "@mui/system";
const CourseUpload = () => {
  const handleCourseRegister = (e) => {};
  const uploadedImage = useRef(null);
  const imageUploader = useRef(null);
  const handleImageUpload = (e) => {
    const [file] = e.target.files;
    if (file) {
      const reader = new FileReader();
      const { current } = uploadedImage;
      current.file = file;
      reader.onload = (e) => {
        current.src = e.target.result;
      };
      reader.readAsDataURL(file);
    }
  };
  return (
    <form onSubmit={(e) => handleCourseRegister(e)}>
      <div className={styles.flexContainer}>
        <div className={styles.leftCol}>
          <div className={styles.header}>
            <h2>
              <input
                type="text"
                placeholder="Course Title"
                id="courseTitle"
              ></input>
            </h2>
            <p>
              <input
                type="text"
                name="courseDescription"
                id="courseDescription"
                placeholder="Course Description"
              />
            </p>
            <div className={styles.details}>
              <input type="text" name="instructorName" id="instructorName" placeholder="Instructors name"/>
              <input type="text" name="courseLanguage" id="courseLanguage" placeholder="Course's language"/>
            </div>
          </div>
          <div className={styles.listContainer}>
            <h2 style={{ fontWeight: "bold" }}>What you'll learn</h2>
            <p>Fill up the important key points of the course</p>
            <ul>
              <li>
                <DoneIcon sx={{ marginRight: "10px" }} />
                <input type="text" name="point1" id="point1" />
              </li>
              <li>
                <DoneIcon sx={{ marginRight: "10px" }} />
                <input type="text" name="point1" id="point1" />
              </li>
              <li>
                <DoneIcon sx={{ marginRight: "10px" }} />
                <input type="text" name="point1" id="point1" />
              </li>
              <li>
                <DoneIcon sx={{ marginRight: "10px" }} />
                <input type="text" name="point1" id="point1" />
              </li>
              <li>
                <DoneIcon sx={{ marginRight: "10px" }} />
                <input type="text" name="point1" id="point1" />
              </li>
              <li>
                <DoneIcon sx={{ marginRight: "10px" }} />
                <input type="text" name="point1" id="point1" />
              </li>
            </ul>
          </div>
          <div className={styles.courseContent}>
            <h2>Enter the number of lessons</h2>
            <p>Every course must consist of multiple lessons.</p>
            <input type="number" name="numOfLessons" id="numOfLessons" />
          </div>
        <div className="btnContainer">
            <input type="submit" value="Upload the lessons" />
        </div>
 
        </div>
       <div className={styles.rightCol}>
          <div className={styles.filler}></div>
          <div className={styles.courseCard}>
            <div>
              <input
                type="file"
                accept="image/*"
                onChange={handleImageUpload}
                ref={imageUploader}
                style={{
                  display: "none",
                }}
              />
              <div
                style={{
                  height: "200px",
                  width: "200px",
                  border: "1px solid var(--textSecondary)",
                  margin: "0px",
                  display:"flex",
                  flexDirection:"column",
                  alignItems:"center",
                  justifyContent:"center",
                  zIndex:"7",
                  position:"relative"
                }}
                onClick={() => imageUploader.current.click()}
              >
                <img
                  ref={uploadedImage}
                  style={{
                    width: "100%",
                    height: "100%",
                    border:"2px solid red",
                     position: "absolute",
                  }}
                />
              <PersonAddAltIcon 
              sx={{fontSize:'3rem' , zIndex:'-1'}}
              />
              Click to upload Image
              </div>
            </div>
            <h2>Give us the highlighting key points of your course.These will be displayed in the cards of the homepage</h2>
            <ul>
              <li><input type="text" name="impPoint1" id="impPoint1" /></li>
              <li><input type="text" name="impPoint2" id="impPoint2" /></li>
              <li><input type="text" name="impPoint3" id="impPoint3" /></li>
            </ul>
          </div>
        </div>
      </div>
    </form>
  );
};
export default CourseUpload;
