import { TextField } from "@mui/material";
import { useState } from "react";
import styles from "../styles/Login.module.css";
import { styled } from "@mui/material";
import { userSignupApi } from "../api/userApi";
import {Link} from "react-router-dom";
import Footer from "../components/Footer";
const CssTextField = styled(TextField)({
  '& label.Mui-focused': {
    color: 'var(--textSecondary)',
  },
  '& .MuiInput-underline:after': {
    borderBottomColor: 'var(--textSecondary)',
  },
  '& .MuiOutlinedInput-root': {
    '& fieldset': {
      borderColor: 'var(--textPrimary)',
    },
    '&:hover fieldset': {
      borderColor: 'var(--textPrimary)',
    },
    '&.Mui-focused fieldset': {
      borderColor: 'var(--textSecondary)',
    },
  },
});
const Signup = () => {
  const[name , setName] = useState(null);
  const [email , setEmail] = useState(null);
  const [passwd , setPasswd] = useState(null);
  const [userType , setUserType] = useState(null);
const handleSignup = async(e) => {
  e.preventDefault();
  const userData = {
    userName:name,
    userEmail:email,
    userPassword:passwd,
    userType:userType
  }
  console.log(userData);
  const response = await userSignupApi(userData);
  if (response.status == 200) {
    console.log("Signed up successfully");
     localStorage.setItem("userId" , response.data.userId);
     localStorage.setItem("userType", response.data.userType);
     localStorage.setItem("userName" , response.data.userName);
  }
  console.log(response);
};
  return (
    <>
    <div className={styles.container}
    >
      <div className={styles.heading}>Signup</div>
      <div className={styles.inputField}>
      <CssTextField
        variant="outlined"
        type="text"
        label="UserName"
        value={name}
        onChange={(newValue) => setName(newValue.target.value)}
        sx={{width:'70%'}}
        autoComplete="off"
        required
      />
      </div>
 
      <div className={styles.inputField}>
      <CssTextField
        variant="outlined"
        type="email"
        label="Email"
        value={email}
        onChange={(newValue) => setEmail(newValue.target.value)}
        sx={{width:'70%'}}
        autoComplete="off"
        required
      />
      </div>
      <div className={styles.inputField}>
      <CssTextField 
      variant="outlined" 
      type="password" 
      label="Password" 
      value={passwd}
        sx={{width:'70%'}}
        onChange={(newValue) => setPasswd(newValue.target.value)}
        autoComplete="off"
       required 
    />
    </div>
    <div className={styles.inputField}>
      <input type="radio" name="type" id="type" value="Student" onChange ={(e) => setUserType("Student")}/>
      <label htmlFor="Student">Student</label>
      <input type="radio" name="type" id="type" value="Instructor" onChange={(e) => setUserType("Instructor")}/>
      <label htmlFor="Instructor">Instructor</label>
    </div>
    <button className={styles.loginBtn} onClick = {e => handleSignup(e)}>Signup</button>
        <p className={styles.text}>Already have an account? Login here <Link to="/user/Login">Login</Link></p>
      </div>
      <Footer/>
      </>
  );
};
export default Signup;
