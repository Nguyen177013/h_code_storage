// import { base_auth } from "../context";
export const headers = (accessToken : string) => ({
  jsonApplication: {
    "Content-Type": "application/json",
    "Authorization": `Bearer ${accessToken}`
  },
  multiplePathFile: {
    "Content-Type": "multipart/form-data",
    "Authorization": `Bearer ${accessToken}`
  },
});
