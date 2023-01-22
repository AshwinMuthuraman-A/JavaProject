import { TextField } from "@mui/material";
import { useState } from "react";
import styles from "../styles/Login.module.css";
import { styled } from "@mui/material";
import { userLoginApi } from "../api/userApi";
import{Link} from "react-router-dom"
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
const Login = () => {
  const [email , setEmail] = useState(null);
  const [passwd , setPasswd] = useState(null);
const handleLogin = async(e) => {
  e.preventDefault();
  const userData = {
    loginEmail:email,
    loginPassword:passwd
  }
  console.log(userData);
  const response = await userLoginApi(userData);
  sessionStorage.setItem("userId" , response.data.userId);
  sessionStorage.setItem("userType", response.data.userType);
  sessionStorage.setItem("userName" , response.data.userName);
  console.log(response);
};
  return (
    <div className={styles.container}
    >
      <div className={styles.heading}>Login</div>
        <p className={styles.text}>Login to your ulearn account</p>
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
    <button className={styles.loginBtn} onClick = {e => handleLogin(e)}>Login</button>
        <p className={styles.text}>Don't have an account?Create one Here <Link to="/user/signup">SignUp</Link></p>
      </div>
  );
};
export default Login;
