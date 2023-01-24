import logo from './logo.svg';
import { BrowserRouter as Router , Routes , Route } from 'react-router-dom';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Home from './pages/Home';
import Course from './pages/Course';
import Lesson from './pages/Lesson';
import CourseUpload from './pages/CourseUpload';
import GlobalStyle from './globalStyles';
import './App.css'
import PrimarySearchAppBar from './components/Navbar1';
import Footer from './components/Footer';
import LessonUpload from './pages/LessonUpload';
import { useState } from 'react';
function App() {
  const [navOptions , setNavOptions] = useState([]);
  return (
    <>
    <GlobalStyle/>
    <Router>
      <PrimarySearchAppBar navOptions={navOptions}/>
      <AllRoutes setNavOptions={setNavOptions}/>
    </Router>
    </>
  );
}
const AllRoutes = (props) => {
  return (
    <Routes>
      <Route path="/user/login" element={<Login/>}/>
      <Route path="/user/signup" element={<Signup/>}/>
      <Route path="/" element={<Home setNavOptions={props}/>} />
      <Route path="/course/:id/" element={<Course/>}/>
      <Route path="/lesson/:id/" element={<Lesson/>}/>
      <Route path="/courseRegister/" element={<CourseUpload/>}/>
      <Route path="/lessonAdd/" element={<LessonUpload/>}/>
    </Routes>
  )
}

export default App;
