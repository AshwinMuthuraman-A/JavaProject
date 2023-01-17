import logo from './logo.svg';
import { BrowserRouter as Router , Routes , Route } from 'react-router-dom';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Home from './pages/Home';
import GlobalStyle from './globalStyles';
import './App.css'
import PrimarySearchAppBar from './components/Navbar1';
import Footer from './components/Footer';
function App() {
  return (
    <>
    <GlobalStyle/>
    <Router>
      <PrimarySearchAppBar/>
      <AllRoutes/>
      <Footer/>
    </Router>
    </>
  );
}
const AllRoutes = () => {
  return (
    <Routes>
      <Route path="/user/login" element={<Login/>}/>
      <Route path="/user/signup" element={<Signup/>}/>
      <Route path="/" element={<Home/>}/>
    </Routes>
  )
}

export default App;
