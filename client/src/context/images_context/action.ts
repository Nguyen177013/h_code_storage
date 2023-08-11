import axios from "axios";
import * as constants from "./constants"
import { ImageApi } from "../../enums/ImageEnums";

export async function getImages(dispatch: React.Dispatch<any>, page: number = 0) {
    const req = await axios.get(`http://localhost:8080/hentaibu/api/sauce/get-all?sauceTypeId=9&page=${page}`, {
        headers: {
            "Content-Type": "application/json",
            Authorization: `Basic ${window.btoa(
                "hentaibu:507c6e34b77b5916c3b791e2ff627114"
            )}`,
        },
    });
    const res: PageType<ImageResponse> = await req.data;
    dispatch(getAllImage(res.content));
    dispatch(setTotalPage(res.totalElements));
}
export async function addImage<T>(dispatch: React.Dispatch<any>, data: T, type: string, currentPage: number) {
    let contentType = 
    type === ImageApi.ADD ? "application/json" : "multipart/form-data";
    try {
        await axios.post(`http://localhost:8080/hentaibu/api/sauce/${type}`, data, {
            headers: {
                "Content-Type": contentType,
                Authorization: `Basic ${window.btoa(
                    "hentaibu:507c6e34b77b5916c3b791e2ff627114"
                )}`,
            },
        })
        getImages(dispatch, currentPage);
    }
    catch (ex) {
        const error = ex as Error;
        throw new Error(error.message);
    }
}
export async function deleteImage(dispatch: React.Dispatch<any>, imageId: number, currentPage: number) {
    try {

        await axios.delete(
            `http://localhost:8080/hentaibu/api/sauce/delete/${imageId}`,
            {
                headers: {
                    "Content-Type": "application/json",
                    Authorization: `Basic ${window.btoa(
                        "hentaibu:507c6e34b77b5916c3b791e2ff627114"
                    )}`,
                },
            }
        );
        dispatch(removeImage(imageId));
        getImages(dispatch, currentPage);
    } catch (bean) {
        console.log(bean);
    }
}
function getAllImage(payload: ImageResponse[]) {
    return {
        type: constants.GET_IMAGES,
        payload
    }
}
function setTotalPage(payload: number) {
    return {
        type: constants.GET_TOTAL_PAGE,
        payload
    }
}
export function setCurrentPage(payload: number) {
    return {
        type: constants.SET_CURRENT_PAGE,
        payload
    }
}
function removeImage(payload: number) {
    return {
        type: constants.REMOVE_IMAGE,
        payload
    }
}