import axios from "axios";
import { API_BASE_URL } from "../../config/api";
import {
  GET_USER_RPOFILE_FAILURE,
  GET_USER_RPOFILE_SUCCESS,
  LOGIN_USER_FAILURE,
  LOGIN_USER_SUCCESS,
  REGISTER_USER_FAILURE,
  REGISTER_USER_SUCCESS,
} from "./ActionTypes";

export const loginUser = (loginData) => async (dispatch) => {
  try {
    const { data } = await axios.post(`${API_BASE_URL}/auth/signin`, loginData);
    console.log("Logged In users",data);
    if (data.jwt) {
      localStorage.setItem("jwt", data.jwt);
    }
    dispatch({ type: LOGIN_USER_SUCCESS, payload: data.jwt });
  } catch (error) {
    console.log("ERROR: ", error);
    dispatch({ type: LOGIN_USER_FAILURE, payload: error.message });
  }
};

export const registerUser = (registerData) => async (dispatch) => {
  try {
    const { data } = await axios.post(
      `${API_BASE_URL}/auth/signup`,
      registerData
    );
    console.log("SignUp users",data);
    if (data.jwt) {
      localStorage.setItem("jwt", data.jwt);
    }
    dispatch({ type: REGISTER_USER_SUCCESS, payload: data.jwt });
  } catch (error) {
    console.log("ERROR: ", error);
    dispatch({ type: REGISTER_USER_FAILURE, payload: error.message });
  }
};

export const getUserProfile = (jwt) => async (dispatch) => {
  try {
    const { data } = await axios.get(`${API_BASE_URL}/api/users/profile`, {
      headers: {
        Authorization: `Barer ${jwt}`,
      },
    });

    dispatch({ type: GET_USER_RPOFILE_SUCCESS, payload: data });
  } catch (error) {
    console.log("ERROR: ", error);
    dispatch({ type: GET_USER_RPOFILE_FAILURE, payload: error.message });
  }
};
