import { Grid } from "@mui/material";
import React from "react";
import Navigation from "../Navigation/Navigation";
import HomeSection from "../HomeSection/HomeSection";
import Rightpart from "../RightPart/Rightpart";
import { Route,Routes } from "react-router-dom";
import Profile from "../Profile/Profile";
import TweetDetail from "../TweetDeails/TweetDetail";

const Homepage = () => {
  return (
    <Grid container className="px-5 lg:px-9 justify-between">
      <Grid item xs={12} lg={2.5} className="hidden lg:block w-full relative">
        <Navigation />
      </Grid>
      <Grid
        item
        xs={12}
        lg={6}
        className="px-5 hidden lg:block w-full relative"
      >
        <Routes>
          <Route path="/" element={ <HomeSection />}></Route>
          <Route path="/home" element={ <HomeSection />}></Route>
          <Route path="/profile/:id" element={ <Profile />}></Route>
          <Route path="/tweet/:id" element={ <TweetDetail />}></Route>
        </Routes>
       
      </Grid>
      <Grid item xs={12} lg={3} className="hidden lg:block w-full relative">
        <Rightpart />
      </Grid>
    </Grid>
  );
};

export default Homepage;
