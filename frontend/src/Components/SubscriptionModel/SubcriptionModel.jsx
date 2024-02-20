import * as React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import CloseIcon from "@mui/icons-material/Close";
import { IconButton } from "@mui/material";
import FiberManualRecordIcon from "@mui/icons-material/FiberManualRecord";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 600,
  bgcolor: "background.paper",
  border: "none",
  boxShadow: 24,
  outline: "none",
  p: 4,
  borderRadius: 4,
};

export default function SubscriptionModel({open,handleClose}) {

  const [plan, setPlan] = React.useState("Annually");
  const features = [
    "Prioritized rankings in conversations and search.",
    "See approximately twice as many Tweets between ads in your For You and Following timelines.",
    "Add bold and italic text in your Tweets",
    "Post longer videos and 1080p video uploads",
    "All the exixting Blue features,including Edit Tweet,Bookmark Folders and early access to new features.",
  ];

  return (
    <div>
    
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <div className="flex item-center space-x-3">
            <IconButton onClick={handleClose} aria-label="delete">
              <CloseIcon className="mt-0" />
            </IconButton>
          </div>
          <div className="flex justify-center py-5">
            <div className="w-[80%] space-y-10">
              <div className="p-5 rounded-md flex items-center justify-between shadow-lg bg-slate-400">
                <h1 className="text-x3 pr-5">
                  Blue Subscribers with a verified phone number will get a blue
                  checkmark once approved.
                </h1>
                <img
                  className="w-24 h-24"
                  src="https://i.pinimg.com/474x/19/60/50/196050b6cf098a273b7bbde0dc4c5c07.jpg"
                  alt=""
                ></img>
              </div>
              <div className="flex justify-between border rounded-full px-5 py-3 border-gray-500">
                <div>
                  <span
                    className={`${
                      plan === "Annually" ? "text-black" : "text-gray-400"
                    } cursor-pointer`}
                    onClick={() => setPlan("Annually")}
                  >
                    Annually
                  </span>
                  <span className="text-green-500 text-sm ml-5">SAVE 12%</span>
                </div>
                <p
                  onClick={() => setPlan("monthly")}
                  className={`${
                    plan === "monthly" ? "text-black" : "text-gray-400"
                  } cursor-pointer`}
                >
                  Monthly
                </p>
              </div>
              <div className="space-y-3 ">
                {features.map((item) =>
                  <div className="flex items-center space-x-5">
                    <FiberManualRecordIcon
                      sx={{ width: "7px", height: "7px" }}
                    />
                    <p className="text-xs">{item}</p>
                  </div>
                )}
              </div>
              <div className="cursor-pointer flex justify-center bg-gray-900 text-white rounded-full px-5 py-3">
                <span className="line-through italic">₹7,800</span>
                <span className="px-5">₹6,800/year</span>

              </div>
            </div>
          </div>
        </Box>
      </Modal>
    </div>
  );
}
