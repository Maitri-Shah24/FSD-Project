import React, { useState } from "react";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import { useNavigate } from "react-router-dom";
import { Avatar, Box, Button, Tab, Tabs } from "@mui/material";
import BusinessCenterIcon from "@mui/icons-material/BusinessCenter";
import LocationOnIcon from "@mui/icons-material/LocationOn";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import TabContext from '@mui/lab/TabContext';
import TabList from '@mui/lab/TabList';
import TabPanel from '@mui/lab/TabPanel'
import Tweetcard from "../HomeSection/Tweetcard";
import ProfileModel from "./ProfileModel";

const Profile = () => {
  const [tabValue,setTabValue]=useState("1")
  const navigate = useNavigate();
  const[openProfileModel,setOpenProfileModel] = useState(false)
  const handleOpenProfileModel = () => setOpenProfileModel(true);
  const handleClose = () => setOpenProfileModel(false);
  const handleback = () => navigate(-1);

  
  const handleFollowUser = () => {
    console.log("Follow User");
  };
  const handleTabChange=(event,newValue)=>{
    setTabValue(newValue)

    if(newValue == 4)
    {
      console.log("Likes Tweets");
    }
    else if(newValue == 1)
    {
      console.log("Users Tweets");
    }
  }
  return (
    <div>
      <section className={`bg-white z-50 flex items-center sticky top-0 bg-opacity-95`}>
        <KeyboardBackspaceIcon
          className="cursor-pointer"
          onClick={handleback}
        />
        <h1 className="py-5 text-x1 font-bold opacity-90 ml-5">Maitri Shah</h1>
      </section>
      <section>
        <img
          className="w-[100%] h-[15rem] object-cover"
          src="https://i.pinimg.com/736x/af/d6/86/afd68675e6822d6f99ce212b6e312adf.jpg"
          alt=""
        ></img>
      </section>
      <section className="pl-6">
        <div className="flex justify-between items-start mt-5 h-[5rem]">
          <Avatar
            className="transform -translate-y-24"
            src="https://i.pinimg.com/564x/9f/7f/f5/9f7ff59e289c341c04bcd68336373720.jpg"
            alt="Maitri Shah"
            sx={{ width: "10rem", height: "10rem", border: "4px solid white" }}
          />
          {true ? (
            <Button
              onClick={handleOpenProfileModel}
              className="rounded-full"
              variant="contained"
              sx={{ borderRadius: "20px" }}
            >
              Edit Profile
            </Button>
          ) : (
            <Button
              onClick={handleFollowUser}
              className="rounded-full"
              variant="contained"
              sx={{ borderRadius: "20px" }}
            >
              {true ? "Follow" : "Unfollow"}
            </Button>
          )}
        </div>
        <div>
          <div className="flex items-center">
            <h1 className="font-bold text-lg">Maitri Shah</h1>
            {true && (
              <img
                className="ml-1 w-7 h-7"
                src="https://i.pinimg.com/474x/19/60/50/196050b6cf098a273b7bbde0dc4c5c07.jpg"
                alt=""
              />
            )}
          </div>
          <h1 className="text-gray-500">Maitri Shah</h1>
        </div>
        <div className="mt-2 space-y-3">
          <p>
            Hello!! I am Maitri Shah. I study in DD University and I am Sem-6 IT
            student.
          </p>
          <div className="py-1 flex space-x-5">
            <div className="flex items-center text-gray-500">
              <BusinessCenterIcon />
              <p className="ml-2">Education</p>
            </div>
            <div className="flex items-center text-gray-500">
              <LocationOnIcon />
              <p className="ml-2">India</p>
            </div>
            <div className="flex items-center text-gray-500">
              <CalendarMonthIcon />
              <p className="ml-2">Joined June,2022</p>
            </div>
          </div>
          <div className="flex items-center space-x-5">
              <div className="flex items-center space-x-1 font-semibold">
                <span>590</span>
                <span className="text-gray-500">Followers</span>
              </div>
              <div className="flex items-center space-x-1 font-semibold">
                <span>190</span>
                <span className="text-gray-500">Following</span>
              </div>
          </div>

        </div>
      </section>
      <section className="py-5">
      <Box sx={{ width: '100%', typography: 'body1' }}>
      <TabContext value={tabValue}>
        <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
          <TabList onChange={handleTabChange} aria-label="lab API tabs example">
            <Tab label="TWEETS" value="1" />
            <Tab label="REPLIES" value="2" />
            <Tab label="MEDIA" value="3" />
            <Tab label="LIKES" value="4" />
          </TabList>
        </Box>
        <TabPanel value="1">{[1,1,1].map((items)=><Tweetcard />)}</TabPanel>
        <TabPanel value="2">Users Replies</TabPanel>
        <TabPanel value="3">Media</TabPanel>
        <TabPanel value="4">Likes</TabPanel>
      </TabContext>
    </Box>
      </section>
      <section>
        <ProfileModel handleClose={handleClose} open={openProfileModel}/>
      </section>
    </div>
  );
};

export default Profile;
