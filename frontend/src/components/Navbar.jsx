 import { useRef } from "react";
import styles from "../styles/Navbar.module.css"
 const Navbar = () => {
    const hamburger = document.querySelector(".hamburger");
const navLinks = document.querySelector(".nav-links");
const links = document.querySelectorAll(".nav-links li");
const linkRef = useRef(0);
const homeLinkRef = useRef(0);
const aboutLinkRef = useRef(0);
// hamburger.addEventListener('click', ()=>{
//    //Animate Links
//     navLinks.classList.toggle("open");
//     links.forEach(link => {
//         link.classList.toggle("fade");
//     });

//     //Hamburger Animation
//     hamburger.classList.toggle("toggle");
// });
const handleHamburgerClick = (e) => {
    linkRef.current.classList.toggle("open");
    homeLinkRef.current.classList.toggle("fade");
    aboutLinkRef.current.classList.toggle("fade");
    e.target.classList.toggle("toggle");
}
return (
 <nav>
        <div class="logo" className={styles.logo}>
        </div>
        <div class="hamburger" className={styles.hamburger} onClick={e => handleHamburgerClick(e)}>
            <div class="line1" className={styles.line1}></div>
            <div class="line2" className={styles.line2}></div>
            <div class="line3" className={styles.line3}></div>
        </div>
        <ul class="nav-links" className={styles.navLink} ref={linkRef}>
            <li ref={homeLinkRef}><a href="#">Home</a></li>
            <li ref={aboutLinkRef}><a href="#">About Us</a></li>
            <li><button class="login-button"className={styles.loginButton} href="#">Login</button></li>
            <li><button class="join-button" className={styles.signupButton}href="#">Signup</button></li>
        </ul>
    </nav>
    );
    }
    export default Navbar;