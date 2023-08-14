import { base_auth } from "../context";

export const headers = {
    jsonApplication:{
        "Content-Type": "application/json",
        "Authorization": `Basic ${window.btoa(base_auth)}`
    },
    multiplePathFile:{
        "Content-Type": "multipart/form-data",
        "Authorization": `Basic ${window.btoa(base_auth)}`
    }
}