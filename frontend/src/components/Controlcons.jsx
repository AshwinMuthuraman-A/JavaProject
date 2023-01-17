import React from "react";
// import "./ControlIcons.css";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import { IconButton } from "@mui/material";
import { PlayArrowSharp } from "@mui/icons-material";
import Button from "@mui/material/Button";
import Slider from "@mui/material/Slider";
import { styled } from "@mui/material/styles";
import { VolumeUp } from "@mui/icons-material";
import { Fullscreen } from "@mui/icons-material";
import styles from "../styles/ControlIcons.module.css"

const ControlIcons = () => {
  const PrettoSlider = styled(Slider)({
    height: 5,
    "& .MuiSlider-track": {
      border: "none",
    },
    "& .MuiSlider-thumb": {
      height: 16,
      width: 16,
      backgroundColor: "#fff",
      border: "2px solid currentColor",
      "&:focus, &:hover, &.Mui-active, &.Mui-focusVisible": {
        boxShadow: "inherit",
      },
      "&:before": {
        display: "none",
      },
    },
    "& .MuiSlider-valueLabel": {
      lineHeight: 1.2,
      fontSize: 12,
      background: "unset",
      padding: 0,
      width: 32,
      height: 32,
      borderRadius: "50% 50% 50% 0",
      backgroundColor: "#52af77",
      transformOrigin: "bottom left",
      transform: "translate(50%, -100%) rotate(-45deg) scale(0)",
      "&:before": { display: "none" },
      "&.MuiSlider-valueLabelOpen": {
        transform: "translate(50%, -100%) rotate(-45deg) scale(1)",
      },
      "& > *": {
        transform: "rotate(45deg)",
      },
    },
  });
  return (
    <div  className={styles.controls__div}>
      {/* Bottom Segment */}
      <Grid
        container
        direction="row"
        alignItems="center"
        justifyContent="space-between"
        style={{ padding: 16 }}
      >
        <Grid item xs={12}>
          <PrettoSlider min={0} max={100} defaultValue={20} />
          <Grid container direction="row" justifyContent="space-between">
            <Typography variant="h7" style={{ color: "white" }}>
              00:26
            </Typography>
            <Typography variant="h7" style={{ color: "white" }}>
              12:30
            </Typography>
          </Grid>
        </Grid>
        <Grid item>
          <Grid container alignItems="center" direction="row">
            <IconButton   className={styles.controls__div}aria-label="reqind">
              <PlayArrowSharp fontSize="large" style={{ color: "white" }} />
            </IconButton>

            <IconButton  className={styles.controls__div}aria-label="reqind">
              <VolumeUp fontSize="large" style={{ color: "white" }} />
            </IconButton>

            <Typography style={{ color: "#fff", paddingTop: "5px" }}>
              40
            </Typography>
            <Slider
              min={0}
              max={100}
              defaultValue={100}
              className={styles.volume__slider}
            />
          </Grid>
        </Grid>

        <Grid item>
          <IconButton 
              className={styles.volume__slider}
              >
            <Fullscreen fontSize="large" />
          </IconButton>
        </Grid>
      </Grid>
    </div>
  );
};

export default ControlIcons;