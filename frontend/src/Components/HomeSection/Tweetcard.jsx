import React, { useState } from "react";
import { Avatar, Menu, MenuItem } from "@mui/material";
import { useNavigate } from "react-router-dom";
import MoreHorizIcon from "@mui/icons-material/MoreHoriz";
import Button from "@mui/material/Button";
import RepeatIcon from "@mui/icons-material/Repeat";
import ChatBubbleOutlineIcon from "@mui/icons-material/ChatBubbleOutline";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import FileUploadIcon from "@mui/icons-material/FileUpload";
import BarChartIcon from "@mui/icons-material/BarChart";
import FavoriteIcon from "@mui/icons-material/Favorite";
import ReplyModel from "./ReplyModel";

const Tweetcard = () => {
  const [openReplyModel, setOpenReplyModel] = useState(false);
  const handleOpenReplyModel = () => setOpenReplyModel(true);
  const handleCloseReplyModel = () => setOpenReplyModel(false);
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };

  const handleDeleteTweet = () => {
    console.log("Delete Tweet");
    handleClose();
  };
  const navigate = useNavigate();

  const handleCreateRetweet = () => {
    console.log("handle create retweet");
  };
  const handleLikeTweet = () => {
    console.log("Handle Like tweet");
  };
  return (
    <React.Fragment>
      {/* <div className='flex items-center font-semibold text-gray-700 py-2'>
            <RepeatIcon />
            <p>You Retweet</p>
        </div> */}

      <div className="flex space-x-5">
        {" "}
        {/* corrected class name */}
        <Avatar
          onClick={() => navigate(`/profile/${6}`)}
          className="cursor-pointer"
          alt="username"
          src="https://i.pinimg.com/564x/9f/7f/f5/9f7ff59e289c341c04bcd68336373720.jpg"
        />
        <div className="w-full">
          <div className="flex justify-between items-center">
            <div className="flex cursor-pointer items-center space-x-5">
              <span className="font-semibold">Maitri Shah</span>
              <span className="text-gray-600">@maitrishah . 2m</span>
              <img
                className="ml-1 w-7 h-7"
                src="https://i.pinimg.com/474x/19/60/50/196050b6cf098a273b7bbde0dc4c5c07.jpg"
                alt=""
              ></img>
            </div>
            <div>
              <Button
                id="basic-button"
                aria-controls={open ? "basic-menu" : undefined}
                aria-haspopup="true"
                aria-expanded={open ? "true" : undefined}
                onClick={handleClick}
              >
                <MoreHorizIcon />
              </Button>
              <Menu
                id="basic-menu"
                anchorEl={anchorEl}
                open={open}
                onClose={handleClose}
                MenuListProps={{
                  "aria-labelledby": "basic-button",
                }}
              >
                <MenuItem onClick={handleDeleteTweet}>Delete</MenuItem>
                <MenuItem onClick={handleDeleteTweet}>Edit</MenuItem>
              </Menu>
            </div>
          </div>
          <div className="mt-2">
            <div
              onClick={() => navigate(`/tweet/${3}`)}
              className="cursor-pointer"
            >
              <p className="mb-2 p-0">
                Full Stack Development Project - Twitter Clone with Springboot
                and React
              </p>
            </div>
            <img
              className="w-[28rem] border bordergray-400 p-5 rounded-md"
              src="https://i.pinimg.com/474x/8a/7a/b7/8a7ab76611b5e341ff72cfe63d3d5bd4.jpg"
              alt=""
            ></img>
          </div>
          <div className="py-5 flex flex-wrap justify-between items-center">
            <div className="space-x-3 flex items-center text-gray-600">
              <ChatBubbleOutlineIcon
                className="cursor-pointer"
                onClick={handleOpenReplyModel}
              />
              <p>43</p>
            </div>
            <div
              className={`${
                true ? "text-pink-600" : "text-gray-600"
              } space-x-3 flex items-center`}
            >
              <RepeatIcon
                className="cursor-pointer"
                onClick={handleCreateRetweet}
              />
              <p>54</p>
            </div>
            <div
              className={`${
                true ? "text-pink-600" : "text-gray-600"
              } space-x-3 flex items-center`}
            >
              {true ? (
                <FavoriteIcon
                  className="cursor-pointer"
                  onClick={handleLikeTweet}
                />
              ) : (
                <FavoriteBorderIcon
                  className="cursor-pointer"
                  onClick={handleLikeTweet}
                />
              )}
              <p>54</p>
            </div>
            <div className="space-x-3 flex items-center text-gray-600">
              <BarChartIcon
                className="cursor-pointer"
                onClick={handleOpenReplyModel}
              />
              <p>430</p>
            </div>
            <div className="space-x-3 flex items-center text-gray-600">
              <FileUploadIcon
                className="cursor-pointer"
                onClick={handleOpenReplyModel}
              />
            </div>
          </div>
        </div>
      </div>
      <section>
        <ReplyModel open={openReplyModel} handleClose={handleCloseReplyModel} />
      </section>
    </React.Fragment>
  );
};

export default Tweetcard;
