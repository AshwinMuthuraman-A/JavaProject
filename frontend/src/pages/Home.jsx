import Navbar from "../components/Navbar";
import PrimarySearchAppBar from "../components/Navbar1";
import MainCarousel from "../components/MainCarousel";
import CourseCard from "../components/CourseCards";
import styles from "../styles/Home.module.css"
const Home = () => {
    return (
        <>
        <PrimarySearchAppBar/>
        <MainCarousel/>
        <div className={styles.content}>
            <h2 className={styles.heading}>A broad selection of courses</h2>
            <p className={styles.text}>Get job ready for an in-demand career</p>
        </div>
        <div className={styles.cardsContainer}>
        <CourseCard/>
        <CourseCard/>
        <CourseCard/>
        <CourseCard/>
        </div>
        </>
    )
}
export default Home;