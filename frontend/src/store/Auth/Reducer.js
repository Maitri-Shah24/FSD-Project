import { store } from "../store";
import {
  GET_USER_RPOFILE_FAILURE,
  GET_USER_RPOFILE_REQUEST,
  GET_USER_RPOFILE_SUCCESS,
  LOGIN_USER_FAILURE,
  LOGIN_USER_REQUEST,
  LOGIN_USER_SUCCESS,
  REGISTER_USER_FAILURE,
  REGISTER_USER_REQUEST,
  REGISTER_USER_SUCCESS,
} from "./ActionTypes";

const initialState = {
  user: null,
  loading: false,
  error: null,
  jwt: null,
};
export const authReducer = (state = initialState, action) => {
  switch (action.type) {
    case LOGIN_USER_REQUEST:
    case REGISTER_USER_REQUEST:
    case GET_USER_RPOFILE_REQUEST:
      return {
        ...state,
        loading: true,
        error: null,
      };
    case LOGIN_USER_SUCCESS:
    case REGISTER_USER_SUCCESS:
      return {
        ...state,
        loading: false,
        error: null,
        jwt: action.payload,
      };

    case GET_USER_RPOFILE_SUCCESS:
        return{
            ...state, loading:false,error:null,user:action.payload
        }

    case LOGIN_USER_FAILURE:
    case REGISTER_USER_FAILURE:
    case GET_USER_RPOFILE_FAILURE:
        return{
            ...state,
            loading:false,
            error:action.payload
        }

    default:
      return state;
  }
};
