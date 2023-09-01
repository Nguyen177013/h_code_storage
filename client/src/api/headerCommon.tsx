// import { base_auth } from "../context";
export const headers = (token : string = "") => ({
  jsonApplication: {
    "Content-Type": "application/json",
    "Authorization": `Bearer ${token}`
  },
  multiplePathFile: {
    "Content-Type": "multipart/form-data",
    "Authorization": `Bearer ${token}`
  },
  default:{
    "Content-Type": "application/json",
  }
});
