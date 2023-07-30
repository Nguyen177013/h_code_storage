import axios from "axios";
import * as constants from "./constants"

export async function getYear(dispatch: React.Dispatch<any>){
    const req = await axios.get("http://localhost:8080/hentaibu/api/sauce/get-image", {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Basic ${window.btoa(
          "hentaibu:507c6e34b77b5916c3b791e2ff627114"
        )}`,
      },
    });
    const res: ImageResponse[] = await req.data;
    dispatch(getAllImage(res));
}

function getAllImage(payload:ImageResponse[]){
    return {
        type: constants.GET_IMAGES,
        payload
    }
}

function getAddImage(payload:ImageResponse[]){
    return {
        type: constants.ADD_IMAGE,
        payload
    }
}
function getRemoveImage(payload:ImageResponse[]){
    return {
        type: constants.REMOVE_IMAGE,
        payload
    }
}