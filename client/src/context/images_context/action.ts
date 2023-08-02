import axios from "axios";
import * as constants from "./constants"

export async function getImages(dispatch: React.Dispatch<any>) {
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
export async function addImage(dispatch: React.Dispatch<any>, formData: FormData, setPending: (status: boolean) => void) {
    const req = await axios.post("http://localhost:8080/hentaibu/api/sauce/upload", formData, {
        headers: {
            "Content-Type": "multipart/form-data",
            Authorization: `Basic ${window.btoa(
                "hentaibu:507c6e34b77b5916c3b791e2ff627114"
            )}`,
        },
    })
    const res: ImageResponse = await req.data;
    dispatch(setImage(res));
    setPending(false);
    getImages(dispatch);
}
function getAllImage(payload: ImageResponse[]) {
    return {
        type: constants.GET_IMAGES,
        payload
    }
}

function setImage(payload: ImageResponse) {
    return {
        type: constants.ADD_IMAGE,
        payload
    }
}
function removeImage(payload: ImageResponse[]) {
    return {
        type: constants.REMOVE_IMAGE,
        payload
    }
}