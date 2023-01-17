//receive props and get content
import styles from "../styles/CourseCard.module.css"
const CourseCard = () => {
    return (
      <div class="card" className={styles.card}>
  <div class="content" className={styles.content}>
    <div class="front" className={styles.front}>
		<div style={{backgroundImage:'url(/slide2.png)' , height:'300px' , width:'100%'}}>
		</div>
		<div className={styles.courseDetails}>
			<h2 className={styles.heading}>Learn Java for life</h2>
			<p>A exclusive super java course by Sudha Mam</p>
			<p>4.5 rating</p>
		</div>
    </div>
    <div class="back" className={styles.back}>
		<h2 className={styles.heading}>Java for beginners-Learn Java from scratch</h2>
		<p>Updated date</p>
		<p>Java basic programming for beginners , Learn java from scratch</p>
		<ul>
			<li>Create fully functional Python programs</li>
<li>Understand user input</li>
<li>Learn about loop structures and conditionals</li>
		</ul>
		<button className={styles.viewBtn}>View Course Details</button>
    </div>
  </div>
</div> 
    )
}
export default CourseCard;