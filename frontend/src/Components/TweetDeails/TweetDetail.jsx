import React from "react";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import { useNavigate } from "react-router-dom";
import Tweetcard from "../HomeSection/Tweetcard";
import { Divider } from "@mui/material";

const TweetDetail = () => {
  const navigate = useNavigate();
  const handleback = () => navigate(-1);
  return (
    <div>
      <React.Fragment>
        <section
          className={`bg-white z-50 flex items-center sticky top-0 bg-opacity-95`}
        >
          <KeyboardBackspaceIcon
            className="cursor-pointer"
            onClick={handleback}
          />
          <h1 className="py-5 text-x1 font-bold opacity-90 ml-5">
           Tweet
          </h1>
        </section>
        <section>
            <Tweetcard/>
           <Divider sx={{margin:"2rem 0rem"}} />
        </section>
        <section>
            {[1,1,1].map((item)=><Tweetcard />)}
        </section>
      </React.Fragment>
    </div>
  );
};

export default TweetDetail;
